package com.adrian.mvvm_viewpager_recyclerview_databinding.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adrian.mvvm_viewpager_recyclerview_databinding.R;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseComponent;


public abstract class AppBaseActivity extends AppCompatActivity {

    private static final String TAG = AppBaseActivity.class.getSimpleName();

    private boolean injected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (!injected) {
            inject();
        }

    }

    protected void inject() {
        BaseComponent.Injector.buildComponent(this).inject(this);
        injected = true;
    }

}
