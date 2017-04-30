package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerController;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private ViewPagerController viewPagerController;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, ViewPagerController viewPagerController) {
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.viewPagerController = viewPagerController;
    }

    public ViewPagerController getViewPagerController() {
        return viewPagerController;
    }
}
