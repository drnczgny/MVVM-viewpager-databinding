package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.service.AlbumService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotoService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostService;

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
    PostService providesPostsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PostService postService = retrofit.create(PostService.class);
        return postService;
    }

    @ActivityScope
    @Provides
    CommentService providesCommentsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        CommentService commentService = retrofit.create(CommentService.class);
        return commentService;
    }

    @ActivityScope
    @Provides
    AlbumService providesAlbumsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        AlbumService albumService = retrofit.create(AlbumService.class);
        return albumService;
    }

    @ActivityScope
    @Provides
    PhotoService providesPhotosService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PhotoService photoService = retrofit.create(PhotoService.class);
        return photoService;
    }
}
