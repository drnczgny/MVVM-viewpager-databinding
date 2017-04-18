package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model;

import android.util.Log;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.domain.Comment;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service.CommentService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cadri on 2017. 04. 11..
 */

public class CommentListModel {

    private static final String TAG = CommentListModel.class.getName();

    private final CommentService commentService;

    private Observer<List<Comment>> commentListObserver;

    private Observer<Comment> commentObserver;

    private OnCommentListCallback callback;

    public CommentListModel(CommentService commentService) {
        this.commentService = commentService;

        createCommentListObserver();
        createCommentObserver();

    }

    private void createCommentListObserver() {
        commentListObserver = new Observer<List<Comment>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllCommentError(e);
            }

            @Override
            public void onNext(List<Comment> comments) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comments.toString());
                callback.onFindAllCommentSuccess(comments);
            }
        };
    }

    private void createCommentObserver() {
        commentObserver = new Observer<Comment>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
            }

            @Override
            public void onNext(Comment comment) {
                Log.i(TAG, "onNext");
                Log.i(TAG, comment.toString());
            }
        };
    }

    public void findAllComment() {
        commentService.findAllComment()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commentListObserver);
    }

    public void registerCallback(OnCommentListCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnCommentListCallback {

        void onFindAllCommentSuccess(List<Comment> comments);

        void onFindAllCommentError(Throwable t);

    }
}