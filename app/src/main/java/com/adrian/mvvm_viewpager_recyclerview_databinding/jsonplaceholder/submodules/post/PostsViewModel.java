package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerBaseViewModel;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class PostsViewModel extends ViewPagerBaseViewModel {

    private PostsRouter postsRouter;

    private int itemLayoutId = R.layout.viewpager_layout_posts;

    private List<PostItemViewModel> postItemViewModels;

    private int variableId = BR.viewModel;

    public PostsViewModel(PostsRouter postsRouter) {
        super(postsRouter);
        this.postsRouter = postsRouter;
    }

    @Bindable
    public int getItemLayoutId() {
        return itemLayoutId;
    }

    public void setItemLayoutId(int itemLayoutId) {
        this.itemLayoutId = itemLayoutId;
        notifyPropertyChanged(BR.itemLayoutId);
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
    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
        notifyPropertyChanged(BR.variableId);
    }
}
