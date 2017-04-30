package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.handler;

import android.util.Log;
import android.view.View;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseHandler;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostItemViewModel;

/**
 * Created by cadri on 2017. 04. 30..
 */

public class PostItemHandler extends BaseHandler {

    private static final String TAG = PostItemViewModel.class.getSimpleName();

    public void onClickItem(View view, PostItemViewModel postItemViewModel) {
        Log.i(TAG, "onItemClick (PostItemHandler)...");
        Log.i(TAG, "postItem: " + postItemViewModel.toString());
    }

}
