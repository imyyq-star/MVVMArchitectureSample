本项目为 [MVVMArchitecture](https://github.com/imyyq-star/MVVMArchitecture) 框架的例子工程。

## 使用方法

本例子针对框架的不同引入方式分为两种，**根据你的需要任选其一**，如下：

### 1. Download Zip 下载本项目
解压后 MVVMArchitecture 目录将为空目录，因为直接 Download 的话是没有 git 仓库的。

将以下三个文件删除：
```
build.gradle
sample/build.gradle
sample-java/build.gradle
```

将以下三个文件，重命名为 build.gradle，覆盖掉原来的文件。
```
build-for-download.gradle
sample/build-for-download.gradle
sample-java/build-for-download.gradle
```

即可使用 File | Open 打开项目了。**此种方式的话，sample 和 sample-java 项目将以远程仓库的形式引用框架，无法修改框架代码。**

### 2. git clone 命令克隆本项目

引入框架源码，需采用 git submodule 的方式引用 MVVMArchitecture，所以在克隆的时候，需把 MVVMArchitecture 也一起克隆下来：

```shell script
git clone --recursive https://github.com/imyyq-star/MVVMArchitectureSample.git
```

或者是不加 --recursive 选项，直接 clone 克隆后，使用命令行进入到项目根目录，执行：

```shell script
git submodule init
git submodule update
```

例子演示了大体的功能，具体功能详见 [Wiki](https://github.com/imyyq-star/MVVMArchitecture/wiki)
