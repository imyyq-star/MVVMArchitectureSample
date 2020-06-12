# 基本配置
* 1、在 settings.gradle 中加入 mvvm 的引用

```groovy
include ':mvvm'
```

* 2、项目根目录下的 build.gradle 引用 dependencies.gradle 文件（如下）

```groovy
buildscript {
    apply from: 'mvvm/dependencies.gradle'

    addRepository(repositories)

    dependencies {
        // 根据 AS 的版本而不同
        classpath "com.android.tools.build:gradle:x.x.x"
        classpath Deps.kotlinPlugin
    }
}

allprojects {
    addRepository(repositories)
}

configurations.all {
    resolutionStrategy {
        // 有需要的话，这里可以强制使用某个版本的库
        force 'androidx.annotation:annotation:1.1.0',
            'androidx.arch.core:core-common:2.0.1',
            'androidx.arch.core:core-runtime:2.0.1',
            'androidx.core:core:1.0.1'
    }
}

...

```

* 3、模块（比如 app）目录下的 build.gradle 必须启用如下功能，并引用 mvvm 模块

```groovy
// Kotlin 需要增加 kapt plugin 才可以使用 DataBinding
apply plugin: 'kotlin-kapt'

android {
    // 指定 sdk 相关信息，可配置
    compileSdkVersion SysConfig.compileSdkVersion

    defaultConfig {
        applicationId "com.xxxx.xxxxx"

        minSdkVersion SysConfig.minSdkVersion
        targetSdkVersion SysConfig.targetSdkVersion

        ...
    }

    // AS 4.0 及以上
    buildFeatures{
        dataBinding = true
    }

    // AS 4.0 以下
    dataBinding {
        enabled = true
    }
    
    // 以上 DataBinding 配置二选一

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_1_8}"
    }

    dependencies {
        ...

        // 将 appcompat，core-ktx，constraintlayout，kotlin 等默认添加的去掉，只留下 test 和 mvvm 即可
        implementation project(path: ':mvvm')

        ...
    }
}
```

* 4、生成配置文件，指定 SDK 版本，开启相关需要的库。
拷贝 mvvm/mvvm-config.groovy.template 到项目根目录，重命名为 mvvm-config.groovy。
配置 SDKVersion，include 指定你需要包含哪些库。

* 5、sync
此时基本配置已经完成了，默认拥有的能力详见配置文件中值为 true 的属性，当然你不喜欢某个库也可以设置为 false。

# 基本使用

## 配置 Application
要么继承 BaseApp，要么在调用 BaseApp 的 init 方法：
```kotlin
BaseApp.initApp(this)
```

## 创建 xml
```xml

```

## 创建 View 层
```kotlin
/**
 * View 层需要继承相应的基类：BaseFragment/BaseActivity
 *
 * ActivityMainBinding 是 R.layout.activity_main 生成的 binding 类，DataBinding 相关的知识。
 * MainViewModel 是界面的主 vm，如果你的界面没有 vm，可以用 BaseViewModel。
 *
 * 构造需传入两个参数，一个是界面的 xml 界面，另一个是 vm 在 xml 中的变量，详见 xml 的配置。
 * 如果 xml 没有配置 vm 变量，可不传。
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main, BR.viewModel
) {
    // 是否保持界面常亮。
    override fun isKeepScreenOn(): Boolean {
        return super.isKeepScreenOn()
    }

    /**
     * 打开这个界面时传入的参数可以在这里处理。
     *
     * 此时 mViewModel 和 mBinding 还没有实例化。
     */
    override fun initParam() {
    }

    /**
     * 这个方法是用来绑定 vm 中的响应式变量到界面中的，比如 LiveData。
     *
     * 此时 mViewModel 和 mBinding 已实例化。
     */
    override fun initViewObservable() {
        // mViewModel 是界面关联的主 VM 的实例，有上述的泛型参数决定，这里是 MainViewModel。
        // mBinding 是 layout 文件的绑定类，包含了声明了 id 的所有 view 的引用。
        Log.i("MainActivity", "initViewObservable: $mViewModel, $mBinding")
    }

    /**
     * 这个方法被调用时，此时界面已经初始化完毕了，可以进行获取数据的操作了，比如请求网络。
     */
    override fun initData() {
    }

    /**
     * 如果你的 vm 是通过 自定义 factory 创建的，可复写此方法。
     * 否则将由框架帮你实例化 vm。
     */
    override fun initViewModel(viewModelStoreOwner: ViewModelStoreOwner): MainViewModel {
        return super.initViewModel(viewModelStoreOwner)
    }
}
```

要注意的是，上述方法都不是必须复写的，一切配置都尽量可选。

View 层会持有 ViewModel 层的实例 mViewModel，意味着 View 层的所有操作都可以流向 ViewModel 层。

也会持有 View 层的实例 mBinding。mBinding 就完全可以消灭掉 findViewById 了，虽然 kotlin-android-extensions 也有这样的功能，但是 mBinding 可读性更好。

其他说明都在注释里了。

## 创建 ViewModel 层
```kotlin
/**
 * ViewModel 层需要继承 BaseViewModel。最终继承自 AndroidViewModel，这样可拥有 Application 的实例。
 *
 * 如果没有数据仓库，可以使用 BaseModel 作为 Model 层。
 */
class MainViewModel(app: Application) : BaseViewModel<BaseModel>(app) {
    /**
     * vm 可以感知 v 的生命周期
     */
    override fun onResume() {
        // 注意！！！！！ vm 层绝对不可以引用 v 层的实例，需要 context 要么通过 application，要么通过 AppActivityManager
        val app = getApplication<MyApp>()
        Log.i("MainViewModel", "commonLog - onResume: $app")
    }
}
```

**一定要注意的是：vm 层绝对不可以引用 v 层的实例**，否则会造成内存泄露。

vm 的数据流向 v 层，只能通过 DataBinding 或 LiveData。

## 创建 Model 层
按照 Google 的设计建议，Model 数据层应该是一个仓库 Repository，对外暴露数据接口，使用者无需知道数据是从哪里来的，是本地还是网络还是其他什么的对使用者来说都不重要。



## 数据绑定

