package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentModel;
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
    CommentModel providesCommentModel(CommentService commentService) {
        return new CommentModel(commentService);
    }

    @ActivityScope
    @Provides
    CommentListViewModel providesCommentsViewModel(CommentListRouter commentListRouter, CommentModel commentModel) {
        return new CommentListViewModel(commentListRouter, commentModel);
    }
}
