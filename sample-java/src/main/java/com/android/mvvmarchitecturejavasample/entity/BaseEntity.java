package com.android.mvvmarchitecturejavasample.entity;

import com.imyyq.mvvm.base.IBaseResponse;

import org.jetbrains.annotations.Nullable;

public class BaseEntity<T> implements IBaseResponse<T> {

    public int errorCode;
    public String errorMsg;
    public T data;

    @Nullable
    @Override
    public Integer code() {
        return errorCode;
    }

    @Nullable
    @Override
    public String msg() {
        return errorMsg;
    }

    @Nullable
    @Override
    public T data() {
        return data;
    }

    @Override
    public boolean isSuccess() {
        return errorCode == 0;
    }
}
