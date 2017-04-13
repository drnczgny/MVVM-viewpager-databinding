package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.recyclerview.ListItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class PhotoItemViewModel extends ListItemViewModel {

    private Photo photo;

    public PhotoItemViewModel(Photo photo) {
        this.photo = photo;
    }

    @Bindable
    public Integer getAlbumId() {
        return photo.getAlbumId();
    }

    public void setAlbumId(Integer albumId) {
        photo.setAlbumId(albumId);
        notifyPropertyChanged(BR.albumId);
    }

    @Bindable
    public Integer getId() {
        return photo.getId();
    }

    public void setId(Integer id) {
        photo.setId(id);
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return photo.getTitle();
    }

    public void setTitle(String title) {
        photo.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getUrl() {
        return photo.getUrl();
    }

    public void setUrl(String url) {
        photo.setUrl(url);
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getThumbnailUrl() {
        return photo.getThumbnailUrl();
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        photo.setThumbnailUrl(thumbnailUrl);
        notifyPropertyChanged(BR.thumbnailUrl);
    }

    @Override
    public String toString() {
        return "PhotoItemViewModel{" +
                "photo=" + photo +
                '}';
    }
}
