package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.recyclerview;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.adrian.mvvm_viewpager_recyclerview_databinding.base.BaseHandler;

import java.util.List;

/**
 * Created by Adrian_Czigany on 3/23/2017.
 */

public final class CustomBindingAttributes {

    private static final String TAG = CustomBindingAttributes.class.getSimpleName();

    private CustomBindingAttributes() {
    }

    @BindingAdapter(value = {"listItems", "listItemLayout", "variableId"}, requireAll = true)
    public static void setupRecyclerViewAdapter(RecyclerView recyclerView, List<? extends ListItemViewModel> items, int itemLayout, int variableId) {
        RecyclerViewAdapter recyclerViewAdapter = getAdapter(recyclerView);
        recyclerViewAdapter.setItems(items);
        recyclerViewAdapter.setItemLayout(itemLayout);
        recyclerViewAdapter.setVariableId(variableId);
    }

    @BindingAdapter(value = {"handler", "listItemHandlerId"}, requireAll = true)
    public static void setupRecyclerViewAdapterHandler(RecyclerView recyclerView, BaseHandler handler, int handlerId) {
        RecyclerViewAdapter recyclerViewAdapter = getAdapter(recyclerView);
        recyclerViewAdapter.setItemHandler(handler);
        recyclerViewAdapter.setItemHandlerId(handlerId);
    }

    private static RecyclerViewAdapter getAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = (RecyclerViewAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new RecyclerViewAdapter();
            recyclerView.setAdapter(adapter);
        }
        return adapter;
    }

}
