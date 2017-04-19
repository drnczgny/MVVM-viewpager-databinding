package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ActivityPostBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di.PostActivityComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostViewModel;

import javax.inject.Inject;

public class PostActivity extends BaseActivity implements PostRouter {

    @Inject
    PostViewModel postViewModel;

    private ActivityPostBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    @Override
    public ViewDataBinding getBinding() {
        return this.binding;
    }

    @Override
    public PostViewModel onCreateViewModel() {
        PostActivityComponent.Injector.buildComponent(this).inject(this);
        return postViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_post;
    }

    private void bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.postViewModel = postViewModel == null ? onCreateViewModel() : postViewModel;
        binding.setVariable(getVariableId(), postViewModel);
        binding.executePendingBindings();
    }
}
