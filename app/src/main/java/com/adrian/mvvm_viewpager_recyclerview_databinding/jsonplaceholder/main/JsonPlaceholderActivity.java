package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.AppBaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ActivityJsonPlaceholderBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.TestData;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di.JsonPlaceholderComponent;

import javax.inject.Inject;

public class JsonPlaceholderActivity extends AppBaseActivity implements JsonPlaceholderRouter {

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
        binding.setVariable(getVariable(), jsonPlaceholderViewModel);
        binding.executePendingBindings();
    }

    public JsonPlaceholderViewModel onCreateViewModel() {
        JsonPlaceholderComponent.Injector.buildComponent(this).inject(this);
        return jsonPlaceholderViewModel;
    }

    public @IdRes int getVariable() {
        return BR.viewModel;
    }

    public @LayoutRes int getLayoutId() {
        return R.layout.activity_json_placeholder;
    }

    public ActivityJsonPlaceholderBinding getBinding() {
        return this.binding;
    }
}
