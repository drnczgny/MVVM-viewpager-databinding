package com.adrian.mvvm_viewpager_recyclerview_databinding.app.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public Gson provideGson() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder()
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();
        return client;
    }

    @Singleton
    @Provides
    @Named("jsonplaceholderapi")
    public Retrofit provideRetrofitForJsonPlaceholderApi(Gson gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }


}
