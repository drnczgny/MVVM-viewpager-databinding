package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main;

import javax.inject.Inject;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ActivityJsonPlaceholderBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di.JsonPlaceholderComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotoListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostListRouter;
import com.android.databinding.library.baseAdapters.BR;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

public class JsonPlaceholderActivity extends BaseActivity implements JsonPlaceholderRouter, PostListRouter, CommentListRouter, AlbumListRouter, PhotoListRouter {

    @Inject
    JsonPlaceholderViewModel jsonPlaceholderViewModel;

    private ActivityJsonPlaceholderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
        setSupportActionBar(binding.toolbar);

        jsonPlaceholderViewModel.setUpViewPager();
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

    private void bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.jsonPlaceholderViewModel = jsonPlaceholderViewModel == null ? onCreateViewModel() : jsonPlaceholderViewModel;
        binding.setVariable(getVariableId(), jsonPlaceholderViewModel);
        binding.executePendingBindings();
    }

    @Override
    public ActivityJsonPlaceholderBinding getBinding() {
        return this.binding;
    }
}
