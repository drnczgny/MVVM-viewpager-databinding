package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class PostsModule {

    private PostsActivity postsActivity;

    public PostsModule(PostsActivity postsActivity) {
        this.postsActivity = postsActivity;
    }

    @ActivityScope
    @Provides
    PostsRouter providesPostsRouter() {
        return this.postsActivity;
    }

    @ActivityScope
    @Provides
    PostsViewModel providesPostsViewModel(PostsRouter postsRouter) {
        return new PostsViewModel(postsRouter);
    }
}
