package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderRouter;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderViewModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class JsonPlaceholderModule {

    private JsonPlaceholderActivity jsonPlaceholderActivity;

    public JsonPlaceholderModule(JsonPlaceholderActivity jsonPlaceholderActivity) {
        this.jsonPlaceholderActivity = jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderRouter providesJsonPlaceholderRouter() {
        return this.jsonPlaceholderActivity;
    }

    @ActivityScope
    @Provides
    JsonPlaceholderViewModel providesJsonPlaceholderViewModel(JsonPlaceholderRouter jsonPlaceholderRouter) {
        return new JsonPlaceholderViewModel(jsonPlaceholderRouter);
    }

}
