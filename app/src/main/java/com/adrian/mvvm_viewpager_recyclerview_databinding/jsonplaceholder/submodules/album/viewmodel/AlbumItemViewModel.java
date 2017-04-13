package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.recyclerview.ListItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.domain.Album;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class AlbumItemViewModel extends ListItemViewModel {

    private Album album;

    public AlbumItemViewModel(Album album) {
        this.album = album;
    }

    @Bindable
    public Integer getUserId() {
        return album.getUserId();
    }

    public void setUserId(Integer userId) {
        album.setUserId(userId);
        notifyPropertyChanged(BR.userId);
    }

    @Bindable
    public Integer getId() {
        return album.getId();
    }

    public void setId(Integer id) {
        album.setId(id);
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return album.getTitle();
    }

    public void setTitle(String title) {
        album.setTitle(title);
        notifyPropertyChanged(BR.title);
    }

    @Override
    public String toString() {
        return "AlbumItemViewModel{" +
                "album=" + album +
                '}';
    }
}
