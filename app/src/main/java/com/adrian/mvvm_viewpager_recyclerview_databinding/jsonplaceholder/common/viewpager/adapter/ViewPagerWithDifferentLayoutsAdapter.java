package com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.adrian.mvvm_viewpager_recyclerview_databinding.jsonplaceholder.common.viewpager.model.DataModel;

import java.util.List;

/**
 * Created by cadri on 2017. 03. 26..
 */

public class ViewPagerWithDifferentLayoutsAdapter extends PagerAdapter {

    private static final String TAG = ViewPagerWithDifferentLayoutsAdapter.class.getName();

    private Context context;

    private List<String> titleList;

    private List<DataModel> itemList;

    private LayoutInflater layoutInflater;

    public ViewPagerWithDifferentLayoutsAdapter(Context context, List<DataModel> itemList, List<String> titleList) {
        this.context = context;
        this.itemList = itemList;
        this.titleList = titleList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {

        DataModel dataModel = itemList.get(position);
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, dataModel.getViewPagerItemViewModel().getLayoutId(), collection, false);

//        if(position == 3)  {
//            ViewpagerItemCommentsLayoutBinding viewpagerItemCommentsLayoutBinding = ViewpagerItemCommentsLayoutBinding.inflate(layoutInflater, collection, false);
//            viewpagerItemCommentsLayoutBinding.rvComments.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//
////            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(TestData.getCommentItemViewModelList(), R.layout.rv_item_comment_layout, BR.viewModel);
////            viewpagerItemCommentsLayoutBinding.rvComments.setAdapter(recyclerViewAdapter);
//
////            viewpagerItemCommentsLayoutBinding.executePendingBindings();
//
//            viewpagerItemCommentsLayoutBinding.setVariable(dataModel.getRvViewModel().getVariableId(), dataModel.getRvViewModel());
//            viewpagerItemCommentsLayoutBinding.setHandler(((CommentsViewModel) dataModel.getRvViewModel()).getCommentsHandler());
//            collection.addView(viewpagerItemCommentsLayoutBinding.getRoot());
//            return viewpagerItemCommentsLayoutBinding.getRoot();
//        }
//
//        if(position == 4)  {
//            ViewpagerItemLayout5RecyclerviewBinding viewpagerItemLayout5RecyclerviewBinding = ViewpagerItemLayout5RecyclerviewBinding.inflate(layoutInflater, collection, false);
//            viewpagerItemLayout5RecyclerviewBinding.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//
//            SimpleRecyclerViewAdapter simpleRecyclerViewAdapter = new SimpleRecyclerViewAdapter(context, Arrays.asList("one", "two", "three"));
//            viewpagerItemLayout5RecyclerviewBinding.recyclerView.setAdapter(simpleRecyclerViewAdapter);
//
//            viewpagerItemLayout5RecyclerviewBinding.setVariable(dataModel.getRvViewModel().getVariableId(), dataModel.getRvViewModel());
//            collection.addView(viewpagerItemLayout5RecyclerviewBinding.getRoot());
//            return viewpagerItemLayout5RecyclerviewBinding.getRoot();
//        }

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
