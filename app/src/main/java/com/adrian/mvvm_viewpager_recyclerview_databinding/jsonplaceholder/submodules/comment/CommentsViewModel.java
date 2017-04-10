package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentsViewModel extends ViewPagerItemViewModel {

    private CommentsRouter commentsRouter;

    private List<CommentItemViewModel> commentItemViewModels;

    private int itemLayoutId = R.layout.viewpager_layout_comments;

    public CommentsViewModel(CommentsRouter commentsRouter) {
        super(commentsRouter);
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
        return R.layout.activity_comments;
    }

    @Bindable
    @Override
    public int getVariableId() {
        return BR.viewModel;
    }


}
