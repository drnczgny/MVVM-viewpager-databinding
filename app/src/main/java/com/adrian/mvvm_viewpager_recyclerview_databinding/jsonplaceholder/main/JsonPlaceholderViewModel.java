package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class JsonPlaceholderViewModel extends BaseViewModel {

    private JsonPlaceholderRouter jsonPlaceholderRouter;

    public JsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter) {
        super(jsonPlaceholderRouter);
        this.jsonPlaceholderRouter = jsonPlaceholderRouter;
    }
}
