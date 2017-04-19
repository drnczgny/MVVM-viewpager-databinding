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

public class PostModel {

    private static final String TAG = PostModel.class.getName();

    private final PostService postService;

    private Observer<List<Post>> postListObserver;

    private Observer<Post> postObserver;

    private OnPostListCallback onPostListCallback;

    private OnPostCallback onPostCallback;

    public PostModel(PostService postService) {
        this.postService = postService;

        createPostListObserver();
        createPostObserver();

    }

    public void findAllPost() {
        postService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListObserver);
    }

    public void findPostById(final int id) {
        postService.findPostById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postObserver);
    }

    public void registerPostListCallback(OnPostListCallback callback) {
        this.onPostListCallback = callback;
    }

    public void unRegisterPostListCallback() {
        this.onPostListCallback = null;
    }

    public void registerPostCallback(OnPostCallback callback) {
        this.onPostCallback = callback;
    }

    public void unRegisterPostCallback() {
        this.onPostCallback = null;
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
                onPostListCallback.onFindAllPostError(e);
            }

            @Override
            public void onNext(List<Post> posts) {
                Log.i(TAG, "onNext");
                Log.i(TAG, posts.toString());
                onPostListCallback.onFindAllPostSuccess(posts);
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
                onPostCallback.onFindPostByIdError(e);
            }

            @Override
            public void onNext(Post post) {
                Log.i(TAG, "onNext");
                Log.i(TAG, post.toString());
                onPostCallback.onFindPostByIdSuccess(post);
            }
        };
    }

    public interface OnPostListCallback {

        void onFindAllPostSuccess(List<Post> posts);

        void onFindAllPostError(Throwable t);

    }

    public interface OnPostCallback {

        void onFindPostByIdSuccess(Post post);

        void onFindPostByIdError(Throwable t);

    }
}
