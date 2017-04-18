package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.service;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.domain.Photo;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public interface PhotoService {

    @GET("/photos")
    Observable<List<Photo>> findAllPhoto();

}
