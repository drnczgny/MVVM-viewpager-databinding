package com.adrian.mvvm_viewpager_recyclerview_databinding.base.di;

import android.databinding.ViewDataBinding;

/**
 * Created by cadri on 2017. 04. 09..
 */

public interface BaseRouter<B extends ViewDataBinding> {

    public void finish();

    B getBinding();


}
