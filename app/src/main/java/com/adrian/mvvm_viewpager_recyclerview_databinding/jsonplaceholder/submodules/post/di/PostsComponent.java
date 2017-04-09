package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.PostsActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 04. 09..
 */


@ActivityScope
@Component(dependencies = AppComponent.class, modules = {PostsModule.class})
public interface PostsComponent {

    void inject(PostsActivity postsActivity);

    final class Injector {
        private Injector() {
        }

        public static PostsComponent buildComponent(PostsActivity activity) {
            return DaggerPostsComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .postsModule(new PostsModule(activity))
                    .build();
        }
    }

}
