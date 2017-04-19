package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class PostModule {

    @ActivityScope
    @Provides
    PostService providesPostsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PostService postService = retrofit.create(PostService.class);
        return postService;
    }

    @ActivityScope
    @Provides
    PostModel providesPostModel(PostService postService) {
        return new PostModel(postService);
    }

}
