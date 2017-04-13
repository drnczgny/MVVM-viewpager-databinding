package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.viewmodel.AlbumsViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentsViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.viewmodel.PhotosViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostsViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 03. 26..
 */

public class TestData {

    private PostsViewModel postsViewModel;

    private CommentsViewModel commentsViewModel;

    private AlbumsViewModel albumsViewModel;

    private PhotosViewModel photosViewModel;

    public TestData(PostsViewModel postsViewModel, CommentsViewModel commentsViewModel, AlbumsViewModel albumsViewModel, PhotosViewModel photosViewModel) {
        this.postsViewModel = postsViewModel;
        this.commentsViewModel = commentsViewModel;
        this.albumsViewModel = albumsViewModel;
        this.photosViewModel = photosViewModel;
    }

    public final List<String> getTitleList() {
        String title1 = "Posts";
        String title2 = "Comments";
        String title3 = "Albums";
        String title4 = "Photos";
        String title5 = "title5";
        List<String> list = new ArrayList<>();
        list.add(title1);
        list.add(title2);
        list.add(title3);
        list.add(title4);
        //        list.add(title5);
        return list;
    }

    public final List<DataModel> getViewPagerDataModel() {
        List<DataModel> list = new ArrayList<>();
        DataModel dataModel1 = new DataModel(postsViewModel);
        DataModel dataModel2 = new DataModel(commentsViewModel);
        DataModel dataModel3 = new DataModel(albumsViewModel);
        DataModel dataModel4 = new DataModel(photosViewModel);
        list.add(dataModel1);
        list.add(dataModel2);
        list.add(dataModel3);
        list.add(dataModel4);
        return list;
    }

}
