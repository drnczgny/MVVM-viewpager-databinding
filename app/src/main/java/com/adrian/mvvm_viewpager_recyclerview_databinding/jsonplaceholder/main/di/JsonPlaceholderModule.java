package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotoModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotoListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotoListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostListViewModel;

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
    JsonPlaceholderViewModel providesJsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter, ViewPagerModel viewPagerModel) {
        return new JsonPlaceholderViewModel(jsonPlaceholderRouter, viewPagerModel);
    }

    @ActivityScope
    @Provides
    PostListViewModel providesPostsViewModel(PostListRouter postListRouter, PostModel postModel) {
        return new PostListViewModel(postListRouter, postModel);
    }

    @ActivityScope
    @Provides
    CommentListViewModel providesCommentsViewModel(CommentListRouter commentListRouter, CommentModel commentModel) {
        return new CommentListViewModel(commentListRouter, commentModel);
    }

    @ActivityScope
    @Provides
    AlbumListViewModel providesAlbumsViewModel(AlbumListRouter albumListRouter, AlbumModel albumModel) {
        return new AlbumListViewModel(albumListRouter, albumModel);
    }

    @ActivityScope
    @Provides
    PhotoListViewModel providesPhotosViewModel(PhotoListRouter photoListRouter, PhotoModel photoModel) {
        return new PhotoListViewModel(photoListRouter, photoModel);
    }

    @ActivityScope
    @Provides
    ViewPagerModel providesTestData(PostListViewModel postsViewModel, CommentListViewModel commentListViewModel, AlbumListViewModel albumListViewModel, PhotoListViewModel photosViewModel) {
        return new ViewPagerModel(postsViewModel, commentListViewModel, albumListViewModel, photosViewModel);
    }

}
