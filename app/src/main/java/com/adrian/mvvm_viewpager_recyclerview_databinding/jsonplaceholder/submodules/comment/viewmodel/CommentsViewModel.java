package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentsRouter;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentsViewModel extends ViewPagerItemViewModel {

    private CommentsRouter commentsRouter;

    private CommentsModel commentsModel;

    private List<CommentItemViewModel> commentItemViewModels;

    private int itemLayoutId = R.layout.viewpager_layout_comments;

    public CommentsViewModel(CommentsModel commentsModel, CommentsRouter commentsRouter) {
        super(commentsRouter);
        this.commentsModel = commentsModel;
        this.commentsRouter = commentsRouter;
    }

    @Bindable
    public List<CommentItemViewModel> getCommentItemViewModels() {
        return commentItemViewModels;
    }

    public void setCommentItemViewModels(List<CommentItemViewModel> commentItemViewModels) {
        this.commentItemViewModels = commentItemViewModels;
        notifyPropertyChanged(BR.commentItemViewModels);
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
    @Override
    public int getLayoutId() {
        return R.layout.viewpager_layout_comments;
    }

    @Bindable
    @Override
    public int getVariableId() {
        return BR.viewModel;
    }


}
