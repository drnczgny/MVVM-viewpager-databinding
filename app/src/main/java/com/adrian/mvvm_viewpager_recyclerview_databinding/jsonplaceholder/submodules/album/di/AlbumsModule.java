package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumsRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumsViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class AlbumsModule {

    @ActivityScope
    @Provides
    AlbumsModel providesAlbumsModel() {
        return new AlbumsModel();
    }


    @ActivityScope
    @Provides
    AlbumsViewModel providesAlbumsViewModel(AlbumsModel albumsModel, AlbumsRouter albumsRouter) {
        return new AlbumsViewModel(albumsModel, albumsRouter);
    }
}
