package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RecyclerViewAdapter<T extends ListItemViewModel> extends RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder> {

    private List<T> items = new ArrayList<>();

    private int itemLayout;

    private int variableId;

    private OnItemClickListener<T> onItemClickListener;

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(List<T> items, int itemLayout, int variableId) {
        this.items = items;
        this.itemLayout = itemLayout;
        this.variableId = variableId;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding dataBinding = DataBindingUtil.inflate(layoutInflater, itemLayout, parent, false);
        return new BindingViewHolder(dataBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, final int position) {
        final T itemViewModel = items.get(position);

//        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (onItemClickListener != null) {
//                    onItemClickListener.onItemClick(position, itemViewModel);
//                }
//            }
//        });

        holder.bind(itemViewModel, variableId);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class BindingViewHolder<T extends ListItemViewModel> extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        public BindingViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(T listItemViewModel, int variableId) {
            binding.setVariable(variableId, listItemViewModel);
            binding.executePendingBindings();
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T item);
    }


    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public int getItemLayout() {
        return itemLayout;
    }

    public void setItemLayout(int itemLayout) {
        this.itemLayout = itemLayout;
    }

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }
}
