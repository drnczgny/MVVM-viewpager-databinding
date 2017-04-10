package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class CommentsModule {

    @ActivityScope
    @Provides
    CommentsModel providesCommentsModel() {
        return new CommentsModel();
    }

    @ActivityScope
    @Provides
    CommentsViewModel providesCommentsViewModel(CommentsModel commentsModel, CommentsRouter commentsRouter) {
        return new CommentsViewModel(commentsModel, commentsRouter);
    }

}
