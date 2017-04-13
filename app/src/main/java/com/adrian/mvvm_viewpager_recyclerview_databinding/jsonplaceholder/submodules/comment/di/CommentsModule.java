package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentsService;
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
    CommentsModel providesCommentsModel(CommentsService commentsService) {
        return new CommentsModel(commentsService);
    }

    @ActivityScope
    @Provides
    CommentsViewModel providesCommentsViewModel(CommentsRouter commentsRouter, CommentsModel commentsModel) {
        return new CommentsViewModel(commentsRouter, commentsModel);
    }
}
