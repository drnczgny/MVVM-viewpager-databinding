package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 04. 09..
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {JsonPlaceholderModule.class})
public interface JsonPlaceholderComponent {

    void inject(JsonPlaceholderActivity jsonPlaceholderActivity);

    final class Injector {
        private Injector() {
        }

        public static JsonPlaceholderComponent buildComponent(JsonPlaceholderActivity activity) {
            return DaggerJsonPlaceholderComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .jsonPlaceholderModule(new JsonPlaceholderModule(activity))
                    .build();
        }
    }
}
