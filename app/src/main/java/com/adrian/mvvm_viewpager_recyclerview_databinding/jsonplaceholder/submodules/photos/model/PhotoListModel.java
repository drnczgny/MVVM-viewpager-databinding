package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model;

import android.util.Log;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service.PhotoService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class PhotoListModel {

    private static final String TAG = PhotoListModel.class.getName();

    private final PhotoService photoService;

    private Observer<List<Photo>> photoListObserver;

    private Observer<Photo> photoObserver;

    private OnPhotoListCallback callback;

    public PhotoListModel(PhotoService photoService) {
        this.photoService = photoService;

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
        photoService.findAllPhoto()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(photoListObserver);
    }

    public void registerCallback(OnPhotoListCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPhotoListCallback {

        void onFindAllPhotoSuccess(List<Photo> photos);

        void onFindAllPhotoError(Throwable t);

    }

}
