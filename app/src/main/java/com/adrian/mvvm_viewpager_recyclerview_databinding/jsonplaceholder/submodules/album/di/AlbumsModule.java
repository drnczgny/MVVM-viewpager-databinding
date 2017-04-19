package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.service.AlbumService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumListViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class AlbumsModule {

    @ActivityScope
    @Provides
    AlbumModel providesAlbumModel(AlbumService albumService) {
        return new AlbumModel(albumService);
    }

    @ActivityScope
    @Provides
    AlbumListViewModel providesAlbumsViewModel(AlbumListRouter albumListRouter, AlbumModel albumModel) {
        return new AlbumListViewModel(albumListRouter, albumModel);
    }
}
