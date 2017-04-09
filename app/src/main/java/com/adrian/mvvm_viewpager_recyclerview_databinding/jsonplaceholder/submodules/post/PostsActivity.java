package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di.PostsComponent;

import javax.inject.Inject;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class PostsActivity extends BaseActivity implements PostsRouter {

    @Inject
    PostsViewModel postsViewModel;

    @Override
    public BaseViewModel onCreate() {
        PostsComponent.Injector.buildComponent(this).inject(this);
        return postsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_posts;
    }
}
