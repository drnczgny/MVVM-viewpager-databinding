package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotoModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotoService;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class PhotoModule {

    @ActivityScope
    @Provides
    PhotoService providesPhotosService(@Named("jsonplaceholderapi") Retrofit retrofit) {
        PhotoService photoService = retrofit.create(PhotoService.class);
        return photoService;
    }

    @ActivityScope
    @Provides
    PhotoModel providesPhotoModule(PhotoService photoService) {
        return new PhotoModel(photoService);
    }

}
