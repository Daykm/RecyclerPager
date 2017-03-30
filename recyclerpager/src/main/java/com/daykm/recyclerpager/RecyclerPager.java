package com.daykm.recyclerpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class RecyclerPager extends PagerAdapter {

	private Context context;

	private ArrayList<RecyclerView.Adapter> adapters = new ArrayList<>();

	private RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();

	public RecyclerPager(Context context) {
		this.context = context;
		pool.setMaxRecycledViews(0, 16);
	}

	@Override public Object instantiateItem(ViewGroup collection, int position) {
		RecyclerView view = new RecyclerView(context);
		LinearLayoutManager manager = new LinearLayoutManager(collection.getContext());
		manager.setOrientation(LinearLayoutManager.VERTICAL);
		manager.setRecycleChildrenOnDetach(true);
		view.setLayoutManager(manager);
		view.setRecycledViewPool(pool);
		view.setAdapter(adapters.get(position));
		collection.addView(view);
		return view;
	}

	public void add(RecyclerView.Adapter adapter) {
		adapters.add(adapter);
		notifyDataSetChanged();
	}

	@Override public void destroyItem(ViewGroup collection, int position, Object view) {
		collection.removeView((View) view);
	}

	@Override public int getCount() {
		return adapters.size();
	}

	@Override public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}

	@Override public CharSequence getPageTitle(int position) {
		return null;
	}
}
