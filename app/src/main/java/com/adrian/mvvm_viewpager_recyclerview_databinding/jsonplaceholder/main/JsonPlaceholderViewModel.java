package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.adapter.ViewPagerWithDifferentLayoutsAdapter;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private ViewPagerModel viewPagerModel;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, ViewPagerModel viewPagerModel) {
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.viewPagerModel = viewPagerModel;
    }

    public void setUpViewPager() {
        this.viewPager = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().viewpager;
        this.tabLayout = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().tabs;
        viewPager.setAdapter(new ViewPagerWithDifferentLayoutsAdapter((JsonPlaceholderActivity)jsonPlaceholderRouter, viewPagerModel.getViewPagerDataModel(), viewPagerModel.getTitleList()));
        tabLayout.setupWithViewPager(viewPager);
    }


}
