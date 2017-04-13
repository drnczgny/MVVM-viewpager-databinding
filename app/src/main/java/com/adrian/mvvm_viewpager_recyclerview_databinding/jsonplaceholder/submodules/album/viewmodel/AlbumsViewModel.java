package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel;

import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.model.AlbumsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.router.AlbumsRouter;
import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public class AlbumsViewModel extends ViewPagerItemViewModel {

    private AlbumsModel albumsModel;

    private AlbumsRouter albumsRouter;

    private List<AlbumItemViewModel> albumItemViewModels = new ArrayList<>();

    public AlbumsViewModel(AlbumsModel albumsModel, AlbumsRouter albumsRouter) {
        this.albumsModel = albumsModel;
        this.albumsRouter = albumsRouter;
    }

    public int getItemLayoutId() {
        return R.layout.rv_item_album;
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
