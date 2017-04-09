package com.adrian.mvvm_viewpager_recyclerview_databinding.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.Menu;
import android.view.MenuItem;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;
import com.adrian.mvvm_viewpager_recyclerview_databinding.base.di.BaseRouter;


/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends AppBaseActivity implements BaseRouter {

    private B binding;
    private VM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    public void bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null ? onCreate() : viewModel;
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
    }

    public void resetViewModel() {
        viewModel = null;
        viewModel = onCreate();
        getBinding().setVariable(getVariable(), viewModel);
    }

    public B getBinding() {
        return binding;
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        viewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        viewModel.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onBackPressed() {
        if (!viewModel.onBackKeyPress()) {
            super.onBackPressed();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        viewModel.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        viewModel.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    public VM getViewModel() {
        return viewModel;
    }

    public void finish() {
        this.finish();
    }

    /**
     * Override for building component and set a ViewModel
     *
     * @return the corresponding ViewModel
     */
    public abstract VM onCreate();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public
    @IdRes
    int getVariable() {
        return BR.viewModel;
    }

    /**
     * Override for set layout resource
     *
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();
}


