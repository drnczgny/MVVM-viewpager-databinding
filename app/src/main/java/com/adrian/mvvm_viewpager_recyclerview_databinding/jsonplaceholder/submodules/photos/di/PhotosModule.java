package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotosModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotosRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotosService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotosViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class PhotosModule {

    @ActivityScope
    @Provides
    PhotosModel providesPhotosModule(PhotosService photosService) {
        return new PhotosModel(photosService);
    }

    @ActivityScope
    @Provides
    PhotosViewModel providesPhotosViewModel(PhotosRouter photosRouter, PhotosModel photosModel) {
        return new PhotosViewModel(photosRouter, photosModel);
    }

}
