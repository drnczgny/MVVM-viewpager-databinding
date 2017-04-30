package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerHelper;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.adapter.ViewPagerAdapter;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private ViewPagerHelper viewPagerHelper;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, ViewPagerHelper viewPagerHelper) {
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.viewPagerHelper = viewPagerHelper;
    }

    public void setUpViewPager() {
        this.viewPager = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().viewpager;
        this.tabLayout = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().tabs;
        viewPager.setAdapter(new ViewPagerAdapter((JsonPlaceholderActivity)jsonPlaceholderRouter, viewPagerHelper.getViewPagerDataModel(), viewPagerHelper.getTitleList()));
        tabLayout.setupWithViewPager(viewPager);
    }


}
