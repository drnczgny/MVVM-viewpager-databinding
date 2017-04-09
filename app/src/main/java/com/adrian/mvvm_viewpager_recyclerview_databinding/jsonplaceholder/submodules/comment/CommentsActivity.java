package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di.CommentsComponent;

import javax.inject.Inject;

public class CommentsActivity extends BaseActivity implements CommentsRouter {

    @Inject
    CommentsViewModel commentsViewModel;

    @Override
    public CommentsViewModel onCreate() {
        CommentsComponent.Injector.buildComponent(this).inject(this);
        return commentsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_comments;
    }

}
