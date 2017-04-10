package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ActivityJsonPlaceholderBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.TestData;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di.JsonPlaceholderComponent;
import com.android.databinding.library.baseAdapters.BR;

import javax.inject.Inject;

public class JsonPlaceholderActivity extends BaseActivity implements JsonPlaceholderRouter {

    @Inject
    JsonPlaceholderViewModel jsonPlaceholderViewModel;

    @Inject
    TestData testData;

    private ActivityJsonPlaceholderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
        setSupportActionBar(binding.toolbar);
    }

    private void bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.jsonPlaceholderViewModel = jsonPlaceholderViewModel == null ? onCreateViewModel() : jsonPlaceholderViewModel;
        binding.setVariable(getVariableId(), jsonPlaceholderViewModel);
        binding.executePendingBindings();
    }

    @Override
    public JsonPlaceholderViewModel onCreateViewModel() {
        JsonPlaceholderComponent.Injector.buildComponent(this).inject(this);
        return jsonPlaceholderViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_json_placeholder;
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Override
    public ActivityJsonPlaceholderBinding getBinding() {
        return this.binding;
    }
}
