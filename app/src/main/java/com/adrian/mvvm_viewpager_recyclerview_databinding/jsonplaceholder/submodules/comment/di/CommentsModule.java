package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class CommentsModule {

    private CommentsActivity commentsActivity;

    public CommentsModule(CommentsActivity commentsActivity) {
        this.commentsActivity = commentsActivity;
    }

    @ActivityScope
    @Provides
    CommentsRouter providesCommentsRouter() {
        return this.commentsActivity;
    }

    @ActivityScope
    @Provides
    CommentsViewModel providesCommentsViewModel(CommentsRouter commentsRouter) {
        return new CommentsViewModel(commentsRouter);
    }

}
