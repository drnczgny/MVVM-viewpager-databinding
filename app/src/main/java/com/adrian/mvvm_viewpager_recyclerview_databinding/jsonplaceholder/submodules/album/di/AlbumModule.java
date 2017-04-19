package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.service.AlbumService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class AlbumModule {

    @ActivityScope
    @Provides
    AlbumService providesAlbumsService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        AlbumService albumService = retrofit.create(AlbumService.class);
        return albumService;
    }

    @ActivityScope
    @Provides
    AlbumModel providesAlbumModel(AlbumService albumService) {
        return new AlbumModel(albumService);
    }

}
