package com.adrian.mvvm_viewpager_recyclerview_databinding.base;

import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.Menu;
import android.view.MenuItem;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseRouter;

/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public abstract class BaseViewModel extends BaseObservable {

    protected BaseRouter router;

    public BaseViewModel(BaseRouter router) {
        this.router = router;
    }

    public abstract BaseRouter getRouter();

    public void finish() {
        router.finish();
    }

    /*
     * Activity lifecycle
     */

    public boolean onBackKeyPress() {
        return false;
    }

    public void onStart() {
        //Override me!
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Override me!
    }

    public void onPause() {
        //Override me!
    }

    public void onResume() {
        //Override me!
    }

    public void onStop() {
        //Override me!
    }

    public void onDestroy() {
        //Override me!
    }

    public void onCreateOptionsMenu(Menu menu) {
        //Override me!
    }

    public void onOptionsItemSelected(MenuItem item) {
        //Override me!
    }

}
