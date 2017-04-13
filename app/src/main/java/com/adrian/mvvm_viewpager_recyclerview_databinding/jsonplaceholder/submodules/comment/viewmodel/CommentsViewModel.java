package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel;

import android.databinding.Bindable;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.ViewPagerItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.domain.Comment;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model.CommentsModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.router.CommentsRouter;

import java.util.ArrayList;
import java.util.List;

import static com.adrian.mvvm_viewpager_recyclerview_databinding.R.layout.rv_item_comment;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentsViewModel extends ViewPagerItemViewModel implements CommentsModel.OnCommentCallback {

    private CommentsRouter commentsRouter;

    private CommentsModel commentsModel;

    private List<CommentItemViewModel> commentItemViewModels = new ArrayList<>();

    public CommentsViewModel(CommentsRouter commentsRouter, CommentsModel commentsModel) {
        this.commentsRouter = commentsRouter;
        this.commentsModel = commentsModel;

        commentsModel.registerCallback(this);
        commentsModel.findAllComment();
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
