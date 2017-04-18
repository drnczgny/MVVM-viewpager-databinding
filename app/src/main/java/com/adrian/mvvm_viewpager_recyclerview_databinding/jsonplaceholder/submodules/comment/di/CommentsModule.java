package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentListModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentListViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class CommentsModule {

    @ActivityScope
    @Provides
    CommentListModel providesCommentsModel(CommentService commentService) {
        return new CommentListModel(commentService);
    }

    @ActivityScope
    @Provides
    CommentListViewModel providesCommentsViewModel(CommentListRouter commentListRouter, CommentListModel commentListModel) {
        return new CommentListViewModel(commentListRouter, commentListModel);
    }
}
