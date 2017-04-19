package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotoModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotoListRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotoService;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotoListViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

@Module
public class PhotosModule {

    @ActivityScope
    @Provides
    PhotoModel providesPhotoModule(PhotoService photoService) {
        return new PhotoModel(photoService);
    }

    @ActivityScope
    @Provides
    PhotoListViewModel providesPhotosViewModel(PhotoListRouter photoListRouter, PhotoModel photoModel) {
        return new PhotoListViewModel(photoListRouter, photoModel);
    }

}
