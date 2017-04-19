package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.main.JsonPlaceholderActivity;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.album.di.AlbumModule;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di.CommentModule;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.photos.di.PhotoModule;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.di.PostModule;

import dagger.Component;

/**
 * Created by cadri on 2017. 04. 09..
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {
        JsonPlaceholderModule.class,
        PostModule.class,
        CommentModule.class,
        AlbumModule.class,
        PhotoModule.class
})
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
