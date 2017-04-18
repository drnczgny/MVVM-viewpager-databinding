package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostListModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostRouter;

/**
 * Created by Adrian_Czigany on 4/18/2017.
 */

public class PostViewModel extends BaseViewModel {

    private PostRouter postRouter;

    private PostListModel postListModel;

    public PostViewModel(PostRouter postRouter) {
        this.postRouter = postRouter;
    }

}
