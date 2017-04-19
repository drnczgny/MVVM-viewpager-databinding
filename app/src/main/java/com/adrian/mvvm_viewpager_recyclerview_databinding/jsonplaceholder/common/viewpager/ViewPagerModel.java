package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotoListViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostListViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 03. 26..
 */

public class ViewPagerModel {

    private PostListViewModel postsViewModel;

    private CommentListViewModel commentListViewModel;

    private AlbumListViewModel albumListViewModel;

    private PhotoListViewModel photosViewModel;

    public ViewPagerModel(PostListViewModel postsViewModel, CommentListViewModel commentListViewModel, AlbumListViewModel albumListViewModel, PhotoListViewModel photosViewModel) {
        this.postsViewModel = postsViewModel;
        this.commentListViewModel = commentListViewModel;
        this.albumListViewModel = albumListViewModel;
        this.photosViewModel = photosViewModel;
    }

    public final List<String> getTitleList() {
        List<String> list = new ArrayList<>();
        list.add("Posts");
        list.add("Comments");
        list.add("Albums");
        list.add("Photos");
        return list;
    }

    public final List<DataModel> getViewPagerDataModel() {
        List<DataModel> list = new ArrayList<>();
        list.add(new DataModel(postsViewModel));
        list.add(new DataModel(commentListViewModel));
        list.add(new DataModel(albumListViewModel));
        list.add(new DataModel(photosViewModel));
        return list;
    }

}
