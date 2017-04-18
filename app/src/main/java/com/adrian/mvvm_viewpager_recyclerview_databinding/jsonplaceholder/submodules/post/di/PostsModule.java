package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostListModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostListViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class PostsModule {

    @ActivityScope
    @Provides
    PostListModel providesPostsModel(PostService postService) {
        return new PostListModel(postService);
    }

    @ActivityScope
    @Provides
    PostListViewModel providesPostsViewModel(PostListRouter postListRouter, PostListModel postListModel) {
        return new PostListViewModel(postListRouter, postListModel);
    }
}
