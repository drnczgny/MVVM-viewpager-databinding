package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ActivityJsonPlaceholderBinding;
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
        super(jsonPlaceholderRouter);
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.testData = testData;

        init();
    }

    private void init() {
        this.viewPager = ((ActivityJsonPlaceholderBinding)jsonPlaceholderRouter.getBinding()).viewpager;
        this.tabLayout = ((ActivityJsonPlaceholderBinding)jsonPlaceholderRouter.getBinding()).tabs;
        viewPager.setAdapter(new ViewPagerWithDifferentLayoutsAdapter((JsonPlaceholderActivity)jsonPlaceholderRouter, testData.getRVDataModelForDifferentLayoutsList(), testData.getTitleList()));
        tabLayout.setupWithViewPager(viewPager);
    }


}
