package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.model;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.domain.Comment;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.viewmodel.CommentItemViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cadri on 2017. 04. 11..
 */

public class CommentsModel {

    private static Comment createTestComment(final int id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setPostId(id);
        comment.setName("name" + id);
        comment.setEmail("email" + id);
        comment.setBody("body" + id);
        return comment;
    }

    public static List<CommentItemViewModel> getCommentItemViewModelList(final int num) {
        List<CommentItemViewModel> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Comment comment = createTestComment(i);
            CommentItemViewModel commentItemViewModel = new CommentItemViewModel(comment);
            list.add(commentItemViewModel);
        }
        return list;
    }

}
