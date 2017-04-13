package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.domain.Post;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 04. 11..
 */

public class PostsModel {

    private static Post createTestPost(int id) {
        Post post = new Post();
        post.setId(id);
        post.setUserId(id);
        post.setTitle("title" + id);
        post.setBody("body" + id);
        return post;
    }

    public static List<PostItemViewModel> getPostItemViewModelList(final int num) {
        List<PostItemViewModel> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Post post = createTestPost(i);
            PostItemViewModel postItemViewModel = new PostItemViewModel(post);
            list.add(postItemViewModel);
        }
        return list;
    }

}
