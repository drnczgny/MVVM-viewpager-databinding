package com.adrian.mvvm_viewpager_recyclerview_databinding.app;

import android.app.Activity;
import android.app.Application;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;

/**
 * Created by cadri on 2017. 04. 09..
 */

public class MyApplication extends Application {

    private static volatile MyApplication application;

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent.Injector.inject(this);

    }

    public static MyApplication getApplication() {
        return application;
    }
}
