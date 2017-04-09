package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di.JsonPlaceholderComponent;

import javax.inject.Inject;

public class JsonPlaceholderActivity extends BaseActivity implements JsonPlaceholderRouter {

    @Inject
    JsonPlaceholderViewModel jsonPlaceholderViewModel;

    @Override
    public BaseViewModel onCreate() {
        JsonPlaceholderComponent.Injector.buildComponent(this).inject(this);
        return jsonPlaceholderViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_json_placeholder;
    }
}
