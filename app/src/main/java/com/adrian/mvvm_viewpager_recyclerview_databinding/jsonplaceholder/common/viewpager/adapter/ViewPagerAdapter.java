package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ViewpagerLayoutAlbumsBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ViewpagerLayoutCommentsBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ViewpagerLayoutPhotosBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.databinding.ViewpagerLayoutPostsBinding;
import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;

import java.util.List;

/**
 * Created by cadri on 2017. 03. 26..
 */

public class ViewPagerAdapter extends PagerAdapter {

    private static final String TAG = ViewPagerAdapter.class.getName();

    private Context context;

    private List<String> titleList;

    private List<DataModel> itemList;

    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, List<DataModel> itemList, List<String> titleList) {
        this.context = context;
        this.itemList = itemList;
        this.titleList = titleList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        DataModel dataModel = itemList.get(position);
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, dataModel.getViewPagerItemViewModel().getLayoutId(), collection, false);

        if (position == 0) {
            ViewpagerLayoutPostsBinding viewpagerLayoutPostsBinding = ViewpagerLayoutPostsBinding.inflate(layoutInflater, collection, false);
            viewpagerLayoutPostsBinding.rvPosts.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

            viewpagerLayoutPostsBinding.setVariable(dataModel.getViewPagerItemViewModel().getVariableId(), dataModel.getViewPagerItemViewModel());
            // viewpagerLayoutPostsBinding.setHandler(((CommentListViewModel) dataModel.getViewPagerItemViewModel()).getCommentsHandler());
            collection.addView(viewpagerLayoutPostsBinding.getRoot());
            return viewpagerLayoutPostsBinding.getRoot();
        }

        if (position == 1) {
            ViewpagerLayoutCommentsBinding viewpagerLayoutCommentsBinding = ViewpagerLayoutCommentsBinding.inflate(layoutInflater, collection, false);
            viewpagerLayoutCommentsBinding.rvComments.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

            viewpagerLayoutCommentsBinding.setVariable(dataModel.getViewPagerItemViewModel().getVariableId(), dataModel.getViewPagerItemViewModel());
            collection.addView(viewpagerLayoutCommentsBinding.getRoot());
            return viewpagerLayoutCommentsBinding.getRoot();
        }
        if (position == 2) {
            ViewpagerLayoutAlbumsBinding viewpagerLayoutAlbumsBinding = ViewpagerLayoutAlbumsBinding.inflate(layoutInflater, collection, false);
            viewpagerLayoutAlbumsBinding.rvAlbums.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

            viewpagerLayoutAlbumsBinding.setVariable(dataModel.getViewPagerItemViewModel().getVariableId(), dataModel.getViewPagerItemViewModel());
            collection.addView(viewpagerLayoutAlbumsBinding.getRoot());
            return viewpagerLayoutAlbumsBinding.getRoot();
        }

        if (position == 3) {
            ViewpagerLayoutPhotosBinding viewpagerLayoutPhotosBinding = ViewpagerLayoutPhotosBinding.inflate(layoutInflater, collection, false);
            viewpagerLayoutPhotosBinding.rvPhotos.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

            viewpagerLayoutPhotosBinding.setVariable(dataModel.getViewPagerItemViewModel().getVariableId(), dataModel.getViewPagerItemViewModel());
            collection.addView(viewpagerLayoutPhotosBinding.getRoot());
            return viewpagerLayoutPhotosBinding.getRoot();
        }

        binding.setVariable(dataModel.getViewPagerItemViewModel().getVariableId(), dataModel.getViewPagerItemViewModel());
        collection.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}
