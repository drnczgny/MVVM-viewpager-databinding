package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerBaseViewModel;

import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentsViewModel extends ViewPagerBaseViewModel {

    private CommentsRouter commentsRouter;

    private int itemLayoutId = R.layout.viewpager_layout_comments;

    private List<CommentItemViewModel> commentItemViewModels;

    private int variableId = BR.viewModel;


    public CommentsViewModel(CommentsRouter commentsRouter) {
        super(commentsRouter);
        this.commentsRouter = commentsRouter;
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
    public List<CommentItemViewModel> getCommentItemViewModels() {
        return commentItemViewModels;
    }

    public void setCommentItemViewModels(List<CommentItemViewModel> commentItemViewModels) {
        this.commentItemViewModels = commentItemViewModels;
        notifyPropertyChanged(BR.commentItemViewModels);
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
