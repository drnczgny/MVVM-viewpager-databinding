package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.RvItemPostBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.handler.PostItemHandler;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.submodules.post.viewmodel.PostItemViewModel;
import com.android.databinding.library.baseAdapters.BR;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/22/2017.
 */

public class RecyclerViewAdapter<T extends ListItemViewModel, H> extends RecyclerView.Adapter<RecyclerViewAdapter.BindingViewHolder> {

    private List<T> items = new ArrayList<>();

    private int itemLayout;

    private int variableId;

    private int handlerId = BR.handler;

    private PostItemHandler postItemHandler;

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
        holder.bind(itemViewModel, variableId);

        if(itemViewModel instanceof PostItemViewModel) {
//            holder.setHandler(postItemHandler, handlerId);

            holder.bindHandler((PostItemHandler) postItemHandler, handlerId);
        }
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

        public void bindHandler(PostItemHandler itemHandler, int handlerId) {
            if(binding instanceof RvItemPostBinding) {
//                ((RvItemPostBinding) binding).setHandler(handlerId);
                binding.setVariable(handlerId, itemHandler);
                binding.executePendingBindings();
            }
        }

        public void setHandler(PostItemHandler postItemHandler, int handlerId) {
            if(binding instanceof RvItemPostBinding) {
                binding.setVariable(handlerId, postItemHandler);
                binding.executePendingBindings();
            }
        }


        public ViewDataBinding getBinding() {
            return this.binding;
        }
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


    public int getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(int handlerId) {
        this.handlerId = handlerId;
    }

    public PostItemHandler getPostItemHandler() {
        return postItemHandler;
    }

    public void setPostItemHandler(PostItemHandler itemHandler) {
        this.postItemHandler = itemHandler;
    }
}
