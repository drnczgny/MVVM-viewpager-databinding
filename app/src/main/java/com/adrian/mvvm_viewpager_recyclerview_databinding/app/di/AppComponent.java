package com.adrian.mvvm_viewpager_recyclerview_databinding.app.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.adrian.mvvm_viewpager_recyclerview_databinding.app.MyApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by cadri on 2017. 04. 09..
 */

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(MyApplication myApplication);

    SharedPreferences sharedPreferences();

    @Named("jsonplaceholderapi")
    Retrofit retrofitForJsonPlaceholderApi();

    Context context();

    final class Injector {
        private static AppComponent appComponent;

        private Injector() {
        }

        public static void inject(MyApplication myApplication) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(myApplication))
                    .build();
            appComponent.inject(myApplication);
        }

        public static AppComponent getComponent() {
            return appComponent;
        }
    }
}
