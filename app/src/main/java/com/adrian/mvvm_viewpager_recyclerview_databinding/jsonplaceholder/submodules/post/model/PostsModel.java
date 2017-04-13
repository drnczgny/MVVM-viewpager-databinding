package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model;

/**
 * Created by cadri on 2017. 04. 11..
 */

import android.util.Log;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.domain.Post;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service.PostsService;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class PostsModel {

    private static final String TAG = PostsModel.class.getName();

    private final PostsService postsService;

    private Observer<List<Post>> postListObserver;

    private Observer<Post> postObserver;

    private OnPostsCallback callback;

    public PostsModel(PostsService postsService) {
        this.postsService = postsService;

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
        postsService.findAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postListObserver);
    }

    public void registerCallback(OnPostsCallback callback) {
        this.callback = callback;
    }

    public void unRegisterCallback() {
        this.callback = null;
    }

    public interface OnPostsCallback {

        void onFindAllPostSuccess(List<Post> posts);

        void onFindAllPostError(Throwable t);

    }
}

//public class PostsModel {
//
//    private static Post createTestPost(int id) {
//        Post post = new Post();
//        post.setId(id);
//        post.setUserId(id);
//        post.setTitle("title" + id);
//        post.setBody("body" + id);
//        return post;
//    }
//
//    public static List<PostItemViewModel> getPostItemViewModelList(final int num) {
//        List<PostItemViewModel> list = new ArrayList<>();
//        for (int i = 1; i <= num; i++) {
//            Post post = createTestPost(i);
//            PostItemViewModel postItemViewModel = new PostItemViewModel(post);
//            list.add(postItemViewModel);
//        }
//        return list;
//    }
//
//}
