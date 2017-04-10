package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseRouter;

/**
 * Created by cadri on 2017. 04. 09..
 */

public abstract class ViewPagerItemViewModel extends BaseViewModel {

    public ViewPagerItemViewModel(BaseRouter router) {
        super(router);
    }

    public abstract int getLayoutId();

    public abstract void setLayoutId(int layoutId);

    public abstract int getVariableId();
}
