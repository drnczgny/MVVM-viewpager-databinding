package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.service.AlbumsService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentsService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotosService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostsService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class JsonPlaceholderServiceModule {

    @ActivityScope
    @Provides
    PostsService providesPostsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PostsService postsService = retrofit.create(PostsService.class);
        return postsService;
    }

    @ActivityScope
    @Provides
    CommentsService providesCommentsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        CommentsService commentsService = retrofit.create(CommentsService.class);
        return commentsService;
    }

    @ActivityScope
    @Provides
    AlbumsService providesAlbumsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        AlbumsService albumsService = retrofit.create(AlbumsService.class);
        return albumsService;
    }

    @ActivityScope
    @Provides
    PhotosService providesPhotosService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PhotosService photosService = retrofit.create(PhotosService.class);
        return photosService;
    }
}
