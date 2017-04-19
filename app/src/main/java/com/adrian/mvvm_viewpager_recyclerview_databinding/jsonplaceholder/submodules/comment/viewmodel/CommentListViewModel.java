package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.domain.Comment;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentListRouter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentListViewModel extends ViewPagerItemViewModel implements CommentModel.OnCommentListCallback {

    private CommentListRouter commentListRouter;

    private CommentModel commentModel;

    private List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();

    public CommentListViewModel(CommentListRouter commentListRouter, CommentModel commentModel) {
        this.commentListRouter = commentListRouter;
        this.commentModel = commentModel;

        commentModel.registerCallback(this);
        commentModel.findAllComment();
    }

    @Override
    public void onFindAllCommentSuccess(List<Comment> comments) {
        setCommentItemViewModels(convertToViewModel(comments));
    }

    @Override
    public void onFindAllCommentError(Throwable t) {
        t.printStackTrace();
    }

    private List<CommentItemViewModel> convertToViewModel(List<Comment> comments) {
        List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();
        for (Comment c : comments) {
            commentItemViewModels.add(new CommentItemViewModel(c));
        }
        return commentItemViewModels;
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
        return R.layout.rv_item_comment;
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
