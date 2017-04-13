package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotosModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotosRouter;

import android.databinding.Bindable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class PhotosViewModel extends ViewPagerItemViewModel implements PhotosModel.OnPhotosCallback {

    private static final String TAG = PhotosViewModel.class.getName();

    private List<PhotoItemViewModel> photoItemViewModels;

    private PhotosRouter photosRouter;

    private PhotosModel photosModel;

    public PhotosViewModel(PhotosRouter photosRouter, PhotosModel photosModel) {
        this.photosRouter = photosRouter;
        this.photosModel = photosModel;

        photosModel.registerCallback(this);
        photosModel.findAllPhoto();

    }

    @Override
    public void onFindAllPhotoSuccess(List<Photo> photos) {
        setPhotoItemViewModels(convertToViewModel(photos));
    }

    @Override
    public void onFindAllPhotoError(Throwable t) {
        t.printStackTrace();
    }

    private List<PhotoItemViewModel> convertToViewModel(List<Photo> photos) {
        List<PhotoItemViewModel> photoItemViewModels = new ArrayList<>();
        for (Photo p : photos) {
            photoItemViewModels.add(new PhotoItemViewModel(p));
        }
        return photoItemViewModels;
    }

    @Bindable
    public List<PhotoItemViewModel> getPhotoItemViewModels() {
        return photoItemViewModels;
    }

    public void setPhotoItemViewModels(List<PhotoItemViewModel> photoItemViewModels) {
        this.photoItemViewModels = photoItemViewModels;
        notifyPropertyChanged(BR.photoItemViewModels);
    }

    @Bindable
    public int getItemLayoutId() {
        return R.layout.rv_item_photo;
    }

    @Override
    public int getLayoutId() {
        return R.layout.viewpager_layout_photos;
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

}
