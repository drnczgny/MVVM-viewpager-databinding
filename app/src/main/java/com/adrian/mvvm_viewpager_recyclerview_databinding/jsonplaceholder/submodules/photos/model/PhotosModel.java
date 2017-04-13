package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model;

import android.util.Log;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotosService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class PhotosModel {

    private static final String TAG = PhotosModel.class.getName();

    private final PhotosService photosService;

    private Observer<List<Photo>> photoListObserver;

    private Observer<Photo> photoObserver;

    private OnPhotosCallback callback;

    public PhotosModel(PhotosService photosService) {
        this.photosService = photosService;

        createPhotoListObserver();
        createPhotoObserver();

    }

    private void createPhotoListObserver() {
        photoListObserver = new Observer<List<Photo>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllPhotoError(e);
            }

            @Override
            public void onNext(List<Photo> photos) {
                Log.i(TAG, "onNext");
                Log.i(TAG, photos.toString());
                callback.onFindAllPhotoSuccess(photos);
            }
        };
    }

    private void createPhotoObserver() {
        photoObserver = new Observer<Photo>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Photo photo) {
                Log.i(TAG, "onNext");
                Log.i(TAG, photo.toString());
            }
        };
    }

    public void findAllPhoto() {
        photosService.findAllPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoListObserver);
    }

    public void registerCallback(OnPhotosCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPhotosCallback {

        void onFindAllPhotoSuccess(List<Photo> photos);

        void onFindAllPhotoError(Throwable t);

    }

}
