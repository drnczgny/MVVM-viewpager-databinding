package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.model.PostModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.router.PostRouter;

/**
 * Created by Adrian_Czigany on 4/18/2017.
 */

public class PostViewModel extends BaseViewModel {

    private PostRouter postRouter;

    private PostModel postModel;

    public PostViewModel(PostRouter postRouter) {
        this.postRouter = postRouter;
    }

}
