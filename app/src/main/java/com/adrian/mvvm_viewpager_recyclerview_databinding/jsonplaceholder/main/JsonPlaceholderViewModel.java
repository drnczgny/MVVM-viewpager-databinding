package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.TestData;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.adapter.ViewPagerWithDifferentLayoutsAdapter;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private TestData testData;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, TestData testData) {
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.testData = testData;
    }

    public void setUpViewPager() {
        this.viewPager = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().viewpager;
        this.tabLayout = ((JsonPlaceholderActivity)jsonPlaceholderRouter).getBinding().tabs;
        viewPager.setAdapter(new ViewPagerWithDifferentLayoutsAdapter((JsonPlaceholderActivity)jsonPlaceholderRouter, testData.getViewPagerDataModel(), testData.getTitleList()));
        tabLayout.setupWithViewPager(viewPager);
    }


}
