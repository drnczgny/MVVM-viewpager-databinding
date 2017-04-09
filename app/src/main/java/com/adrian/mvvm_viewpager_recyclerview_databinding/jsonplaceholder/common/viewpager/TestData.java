package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager;


import android.app.Activity;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.Comment;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.Post;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostItemViewModel;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by cadri on 2017. 03. 26..
 */

public class TestData {

    private CommentsViewModel commentsViewModel;

    private PostsViewModel postsViewModel;

    public TestData(PostsViewModel postsViewModel, CommentsViewModel commentsViewModel) {
        this.postsViewModel = postsViewModel;
        this.commentsViewModel = commentsViewModel;
    }

    public static final List<String> getTitleList() {
        String title1 = "title1";
        String title2 = "title2";
        String title3 = "title3";
        String title4 = "title4";
        String title5 = "title5";
        List<String> list = new ArrayList<>();
        list.add(title1);
        list.add(title2);
//        list.add(title3);
//        list.add(title4);
//        list.add(title5);
        return list;
    }

    public static List<CommentItemViewModel> getCommentItemViewModelList() {
        List<CommentItemViewModel> list = new ArrayList<>();
        for(int i=1; i<=6; i++) {
            Comment comment = createTestComment(i);
            CommentItemViewModel commentItemViewModel = new CommentItemViewModel(comment);
            list.add(commentItemViewModel);
        }
        return list;
    }

    public static List<PostItemViewModel> getPostItemViewModelList() {
        List<PostItemViewModel> list = new ArrayList<>();
        for(int i=1; i<=6; i++) {
            Post post = createTestPost(i);
            PostItemViewModel postItemViewModel = new PostItemViewModel(post);
            list.add(postItemViewModel);
        }
        return list;
    }

    public final List<DataModel> getRVDataModelForDifferentLayoutsList(Activity activity) {
        List<DataModel> list = new ArrayList<>();
        DataModel dataModel1 = new DataModel(postsViewModel);
        DataModel dataModel2 = new DataModel(commentsViewModel);
        list.add(dataModel1);
        list.add(dataModel2);
        return list;
    }

    private static Post createTestPost(int id) {
        Post post = new Post();
        post.setId(id);
        post.setUserId(id);
        post.setTitle("title" + id);
        post.setBody("body" + id);
        return post;
    }

    private static Comment createTestComment(final int id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setPostId(id);
        comment.setName("name" + id);
        comment.setEmail("email" + id);
        comment.setBody("body" +id);
        return comment;
    }
}
