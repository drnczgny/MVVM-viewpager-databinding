package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerController;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    private ViewPagerController viewPagerController;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, ViewPagerController viewPagerController) {
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
        this.viewPagerController = viewPagerController;
    }

    public List<DataModel> getViewPagerDataModel() {
        return viewPagerController.getViewPagerDataModel();
    }

    public final List<String> getTitleList() {
        return viewPagerController.getTitleList();
    }
}
