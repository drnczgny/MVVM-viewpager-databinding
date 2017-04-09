package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.di;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.di.AppComponent;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.scope.ActivityScope;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.comment.CommentsActivity;

import dagger.Component;

/**
 * Created by cadri on 2017. 04. 09..
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {CommentsModule.class})
public interface CommentsComponent {

    void inject(CommentsActivity commentsActivity);

    final class Injector {
        private Injector() {
        }

        public static CommentsComponent buildComponent(CommentsActivity activity) {
            return DaggerCommentsComponent.builder()
                    .appComponent(AppComponent.Injector.getComponent())
                    .commentsModule(new CommentsModule(activity))
                    .build();
        }
    }
}
