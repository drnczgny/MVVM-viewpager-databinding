package com.adrian.mvvm_viewpager_recyclerview_databinding.base.di;


import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.AppBaseActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 3/9/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {BaseModule.class})
public interface BaseComponent {

    void inject(AppBaseActivity AppBaseActivity);

    final class Injector {
        private Injector() {
        }

        public static BaseComponent buildComponent(AppBaseActivity activity) {
            return DaggerBaseComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .baseModule(new BaseModule(activity))
                    .build();
        }
    }

}
