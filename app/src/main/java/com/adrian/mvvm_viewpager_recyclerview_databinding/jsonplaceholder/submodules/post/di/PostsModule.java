package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class PostsModule {

    @ActivityScope
    @Provides
    PostsViewModel providesPostsViewModel(JsonPlaceholderRouter jsonPlaceholderRouter) {
        return new PostsViewModel(jsonPlaceholderRouter);
    }
}
