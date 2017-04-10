package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class PostsModule {

    @ActivityScope
    @Provides
    PostsModel providesPostsModel() {
        return new PostsModel();
    }


    @ActivityScope
    @Provides
    PostsViewModel providesPostsViewModel(PostsModel postsModel, PostsRouter postsRouter) {
        return new PostsViewModel(postsModel, postsRouter);
    }
}
