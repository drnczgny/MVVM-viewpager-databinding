package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.service;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.domain.Album;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Adrian_Czigany on 4/13/2017.
 */

public interface AlbumService {

    @GET("/albums")
    Observable<List<Album>> findAllAlbum();

}
