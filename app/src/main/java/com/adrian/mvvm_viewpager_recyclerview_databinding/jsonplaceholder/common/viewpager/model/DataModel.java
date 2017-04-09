package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerBaseViewModel;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class DataModel {

    private ViewPagerBaseViewModel viewPagerBaseViewModel;

    public DataModel(ViewPagerBaseViewModel viewPagerBaseViewModel) {
        this.viewPagerBaseViewModel = viewPagerBaseViewModel;
    }

    public ViewPagerBaseViewModel getViewPagerBaseViewModel() {
        return viewPagerBaseViewModel;
    }

    public void setViewPagerBaseViewModel(ViewPagerBaseViewModel viewPagerBaseViewModel) {
        this.viewPagerBaseViewModel = viewPagerBaseViewModel;
    }

}
