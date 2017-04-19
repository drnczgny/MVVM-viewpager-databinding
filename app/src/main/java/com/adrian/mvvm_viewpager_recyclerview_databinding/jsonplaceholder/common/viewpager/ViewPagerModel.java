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
        String title1 = "Posts";
        String title2 = "Comments";
        String title3 = "Albums";
        String title4 = "Photos";
        List<String> list = new ArrayList<>();
        list.add(title1);
        list.add(title2);
        list.add(title3);
        list.add(title4);
        return list;
    }

    public final List<DataModel> getViewPagerDataModel() {
        List<DataModel> list = new ArrayList<>();
        DataModel dataModel1 = new DataModel(postsViewModel);
        DataModel dataModel2 = new DataModel(commentListViewModel);
        DataModel dataModel3 = new DataModel(albumListViewModel);
        DataModel dataModel4 = new DataModel(photosViewModel);
        list.add(dataModel1);
        list.add(dataModel2);
        list.add(dataModel3);
        list.add(dataModel4);
        return list;
    }

}
