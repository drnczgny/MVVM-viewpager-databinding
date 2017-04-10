package com.adrian.mvvm_viewpager_recyclerview_databinding.base;

import android.databinding.BaseObservable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseRouter;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public abstract class BaseViewModel<R extends BaseRouter> extends BaseObservable {

    protected R router;

    public BaseViewModel(R router) {
        this.router = router;
    }

    protected void finish() {
        router.finish();
    }


}
