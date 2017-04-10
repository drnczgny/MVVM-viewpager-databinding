package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseRouter;

/**
 * Created by cadri on 2017. 04. 09..
 */

public abstract class ViewPagerItemViewModel<R extends BaseRouter> extends BaseViewModel {

    public ViewPagerItemViewModel(R router) {
        super(router);
    }

    public abstract
    @IdRes
    int getLayoutId();

    public abstract
    @LayoutRes
    int getVariableId();
}
