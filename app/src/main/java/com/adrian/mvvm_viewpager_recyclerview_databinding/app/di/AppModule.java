package com.adrian.mvvm_viewpager_recyclerview_databinding.app.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Module
public class AppModule {

    private MyApplication myApplication;

    public AppModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    public Context providesApplicationContext() {
        return this.myApplication;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences(Context app) {
        return app.getSharedPreferences("PREFS", Context.MODE_PRIVATE);
    }
}
