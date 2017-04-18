package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.view.PostActivity;

import dagger.Component;

/**
 * Created by Adrian_Czigany on 4/18/2017.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PostModule.class})
public interface PostComponent {

    void inject(PostActivity postActivity);

    final class Injector {
        private Injector() {
        }

        public static PostComponent buildComponent(PostActivity activity) {
            return DaggerPostComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .postModule(new PostModule(activity))
                    .build();
        }
    }
}
