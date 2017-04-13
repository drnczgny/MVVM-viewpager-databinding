package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel;

import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.domain.Album;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumsRouter;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class AlbumsViewModel extends ViewPagerItemViewModel implements AlbumsModel.OnAlbumCallback {

    private AlbumsModel albumsModel;

    private AlbumsRouter albumsRouter;

    private List<AlbumItemViewModel> albumItemViewModels = new ArrayList<>();

    public AlbumsViewModel(AlbumsModel albumsModel, AlbumsRouter albumsRouter) {
        this.albumsModel = albumsModel;
        this.albumsRouter = albumsRouter;

        albumsModel.registerCallback(this);
        albumsModel.findAllAlbum();
    }

    public int getItemLayoutId() {
        return R.layout.rv_item_album;
    }

    @Override
    public void onFindAllAlbumSuccess(List<Album> albums) {
        setAlbumItemViewModels(convertToViewModel(albums));
    }

    @Override
    public void onFindAllAlbumError(Throwable t) {
        t.printStackTrace();
    }

    private List<AlbumItemViewModel> convertToViewModel(List<Album> albums) {
        List<AlbumItemViewModel> albumItemViewModels = new ArrayList<>();
        for (Album a : albums) {
            albumItemViewModels.add(new AlbumItemViewModel(a));
        }
        return albumItemViewModels;
    }

    @Override
    public int getLayoutId() {
        return R.layout.viewpager_layout_albums;
    }

    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

    @Bindable
    public List<AlbumItemViewModel> getAlbumItemViewModels() {
        return albumItemViewModels;
    }

    public void setAlbumItemViewModels(List<AlbumItemViewModel> albumItemViewModels) {
        this.albumItemViewModels = albumItemViewModels;
        notifyPropertyChanged(BR.albumItemViewModels);
    }

}
