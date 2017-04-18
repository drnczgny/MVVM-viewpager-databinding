package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.TestData;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotoListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotoListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostListViewModel;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class JsonPlaceholderModule {

    private JsonPlaceholderActivity jsonPlaceholderActivity;

    public JsonPlaceholderModule(JsonPlaceholderActivity jsonPlaceholderActivity) {
        this.jsonPlaceholderActivity = jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderRouter providesJsonPlaceholderRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    PostListRouter providesPostsRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    CommentListRouter providesCommentsRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    AlbumListRouter providesAlbumsRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    PhotoListRouter providesPhotoRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    TestData providesTestData(PostListViewModel postsViewModel, CommentListViewModel commentListViewModel, AlbumListViewModel albumListViewModel, PhotoListViewModel photosViewModel) {
        return new TestData(postsViewModel, commentListViewModel, albumListViewModel, photosViewModel);
    }

    @ActivityScope
    @Provides
    JsonPlaceholderViewModel providesJsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, TestData testData) {
        return new JsonPlaceholderViewModel(jsonPlaceholderRouter, testData);
    }

    @ActivityScope
    @Provides
    @Named("postsDataModel")
    DataModel providesPostsDataModel(PostListViewModel postsViewModel) {
        return new DataModel(postsViewModel);
    }

    @ActivityScope
    @Provides
    @Named("commentsDataModel")
    DataModel providesCommentsDataModel(CommentListViewModel commentListViewModel) {
        return new DataModel(commentListViewModel);
    }


}
