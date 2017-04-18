package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model;

/**
 * Created by cadri on 2017. 04. 11..
 */

import android.util.Log;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.domain.Post;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class PostListModel {

    private static final String TAG = PostListModel.class.getName();

    private final PostService postService;

    private Observer<List<Post>> postListObserver;

    private Observer<Post> postObserver;

    private OnPostListCallback callback;

    public PostListModel(PostService postService) {
        this.postService = postService;

        createPostListObserver();
        createPostObserver();

    }

    private void createPostListObserver() {
        postListObserver = new Observer<List<Post>>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError");
                e.printStackTrace();
                callback.onFindAllPostError(e);
            }

            @Override
            public void onNext(List<Post> posts) {
                Log.i(TAG, "onNext");
                Log.i(TAG, posts.toString());
                callback.onFindAllPostSuccess(posts);
            }
        };
    }

    private void createPostObserver() {
        postObserver = new Observer<Post>() {
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
            public void onNext(Post post) {
                Log.i(TAG, "onNext");
                Log.i(TAG, post.toString());
            }
        };
    }

    public void findAllPost() {
        postService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListObserver);
    }

    public void registerCallback(OnPostListCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPostListCallback {

        void onFindAllPostSuccess(List<Post> posts);

        void onFindAllPostError(Throwable t);

    }
}
