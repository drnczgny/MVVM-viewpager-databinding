package com.adrian.mvvm_viewpager_recyclerview_databinding.base;

import android.databinding.ViewDataBinding;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;

import com.adrian.mvvm_viewpager_recyclerview_databinding.BR;


/**
 * Created by Adrian_Czigany on 3/20/2017.
 */

public abstract class BaseActivity<T extends ViewDataBinding, VM extends BaseViewModel> extends AppBaseActivity {

    /**
     * Override for building component and set a ViewModel
     *
     * @return the corresponding ViewModel
     */
    public abstract T getBinding ();

    /**
     * Override for building component and set a ViewModel
     *
     * @return the corresponding ViewModel
     */
    public abstract VM onCreateViewModel();

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public
    @IdRes
    int getVariableId() {
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


