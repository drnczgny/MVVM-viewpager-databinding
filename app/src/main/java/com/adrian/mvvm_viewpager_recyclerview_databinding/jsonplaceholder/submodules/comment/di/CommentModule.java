package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class CommentModule {

    @ActivityScope
    @Provides
    CommentService providesCommentsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        CommentService commentService = retrofit.create(CommentService.class);
        return commentService;
    }

    @ActivityScope
    @Provides
    CommentModel providesCommentModel(CommentService commentService) {
        return new CommentModel(commentService);
    }

}
