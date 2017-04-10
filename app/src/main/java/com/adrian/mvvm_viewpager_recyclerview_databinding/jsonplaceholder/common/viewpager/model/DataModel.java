package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class DataModel {

    private ViewPagerItemViewModel viewPagerItemViewModel;

    public DataModel(ViewPagerItemViewModel viewPagerItemViewModel) {
        this.viewPagerItemViewModel = viewPagerItemViewModel;
    }

    public ViewPagerItemViewModel getViewPagerItemViewModel() {
        return viewPagerItemViewModel;
    }

    public void setViewPagerItemViewModel(ViewPagerItemViewModel viewPagerItemViewModel) {
        this.viewPagerItemViewModel = viewPagerItemViewModel;
    }

}

