package com.adrian.mvvm_viewpager_recyclerview_databinding.base.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.AppBaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@Module
public class BaseModule {

    private AppBaseActivity appBaseActivity;

    public BaseModule(AppBaseActivity appBaseActivity) {
        this.appBaseActivity = appBaseActivity;
    }

    @ActivityScope
    @Provides
    AppBaseActivity provideBaseActivity() {
        return appBaseActivity;
    }

}
