package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.view.PostActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 4/18/2017.
 */

@Module
public class PostModule {

    private PostActivity postActivity;

    public PostModule(PostActivity postActivity) {
        this.postActivity = postActivity;
    }

    @ActivityScope
    @Provides
    PostRouter providesPostRouter() {
        return this.postActivity;
    }

    @ActivityScope
    @Provides
    PostViewModel providesPostViewModel(PostRouter postRouter) {
        return new PostViewModel(postRouter);
    }
}
