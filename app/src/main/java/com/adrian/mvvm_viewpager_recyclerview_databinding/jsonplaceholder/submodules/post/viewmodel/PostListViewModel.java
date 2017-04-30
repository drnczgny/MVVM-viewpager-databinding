package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.domain.Post;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.handler.PostItemHandler;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostListRouter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class PostListViewModel extends ViewPagerItemViewModel implements PostModel.OnPostListCallback {

    private PostListRouter postListRouter;

    private PostModel postModel;

    private List<PostItemViewModel> postItemViewModels = new ArrayList<>();

    public PostListViewModel(PostListRouter postListRouter, PostModel postModel) {
        this.postListRouter = postListRouter;
        this.postModel = postModel;

        postModel.registerPostListCallback(this);
        postModel.findAllPost();
    }

    @Override
    public void onFindAllPostSuccess(List<Post> posts) {
        setPostItemViewModels(convertToViewModel(posts));
    }

    @Override
    public void onFindAllPostError(Throwable t) {
        t.printStackTrace();
    }

    private List<PostItemViewModel> convertToViewModel(List<Post> posts) {
        List<PostItemViewModel> postItemViewModels = new ArrayList<>();
        for (Post p : posts) {
            postItemViewModels.add(new PostItemViewModel(p));
        }
        return postItemViewModels;
    }

    @Bindable
    public List<PostItemViewModel> getPostItemViewModels() {
        return postItemViewModels;
    }

    public void setPostItemViewModels(List<PostItemViewModel> postItemViewModels) {
        this.postItemViewModels = postItemViewModels;
        notifyPropertyChanged(BR.postItemViewModels);
    }

    @Bindable
    public int getItemLayoutId() {
        return R.layout.rv_item_post;
    }

    @Bindable
    @Override
    public int getLayoutId() {
        return R.layout.viewpager_layout_posts;
    }

    @Bindable
    @Override
    public int getVariableId() {
        return BR.viewModel;
    }


    @Bindable
    public int getHandlerId() {
        return BR.handler;
    }

}
