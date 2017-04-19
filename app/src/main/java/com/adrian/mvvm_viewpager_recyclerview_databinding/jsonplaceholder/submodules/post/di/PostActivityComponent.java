package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.view.PostActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 4/18/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PostActivityModule.class})
public interface PostActivityComponent {

    void inject(PostActivity postActivity);

    final class Injector {
        private Injector() {
        }

        public static PostActivityComponent buildComponent(PostActivity activity) {
            return DaggerPostActivityComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .postActivityModule(new PostActivityModule(activity))
                    .build();
        }
    }
}
