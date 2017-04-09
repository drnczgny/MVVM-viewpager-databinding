package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseViewModel;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class CommentsViewModel extends BaseViewModel {

    private CommentsRouter commentsRouter;

    public CommentsViewModel(CommentsRouter commentsRouter) {
        super(commentsRouter);
        this.commentsRouter = commentsRouter;
    }


}
