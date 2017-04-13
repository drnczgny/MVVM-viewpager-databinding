package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.service;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.domain.Comment;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public interface CommentsService {


    @GET("/comments")
    Observable<List<Comment>> findAllComment();

}
