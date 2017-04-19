package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.model.PhotoModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.router.PhotoListRouter;

import android.databinding.Bindable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class PhotoListViewModel extends ViewPagerItemViewModel implements PhotoModel.OnPhotoListCallback {

    private static final String TAG = PhotoListViewModel.class.getName();

    private List<PhotoItemViewModel> photoItemViewModels;

    private PhotoListRouter photoListRouter;

    private PhotoModel photoModel;

    public PhotoListViewModel(PhotoListRouter photoListRouter, PhotoModel photoModel) {
        this.photoListRouter = photoListRouter;
        this.photoModel = photoModel;

        photoModel.registerCallback(this);
        photoModel.findAllPhoto();

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
