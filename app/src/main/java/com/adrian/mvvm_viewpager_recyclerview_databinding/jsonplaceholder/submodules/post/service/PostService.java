package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.service;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.domain.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public interface PostService {

    @GET("/posts")
    Observable<List<Post>> findAllPost();

}
