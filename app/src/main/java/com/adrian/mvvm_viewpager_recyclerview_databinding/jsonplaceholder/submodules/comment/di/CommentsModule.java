package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class CommentsModule {

    @ActivityScope
    @Provides
    CommentsViewModel providesCommentsViewModel(JsonPlaceholderRouter jsonPlaceholderRouter) {
        return new CommentsViewModel(jsonPlaceholderRouter);
    }

}
