package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class PostsViewModel extends ViewPagerItemViewModel {

    private PostsRouter postsRouter;

    private List<PostItemViewModel> postItemViewModels;

    private int itemLayoutId = R.layout.viewpager_layout_posts;

    public PostsViewModel(PostsRouter postsRouter) {
        super(postsRouter);
        this.postsRouter = postsRouter;
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
        return this.itemLayoutId;
    }

    public void setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        notifyPropertyChanged(BR.itemLayoutId);
    }


    @Bindable
    @Override
    public int getLayoutId() {
        return R.layout.activity_posts;
    }

    @Bindable
    @Override
    public int getVariableId() {
        return BR.viewModel;
    }

}
