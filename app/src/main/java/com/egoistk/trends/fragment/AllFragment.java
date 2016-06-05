package com.egoistk.trends.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.egoistk.trends.R;
import com.egoistk.trends.adapter.RecyclerAdapter;
import com.egoistk.trends.base.BaseFragment;
import com.egoistk.trends.network.GetDataThread;

public class AllFragment extends BaseFragment {

	private RecyclerView mRecyclerView;
	private RecyclerAdapter mRecyclerAdapter;
	private RecyclerView.LayoutManager mLayoutManager;
	private String[] mData = new String[100];

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_all, null);
		getData();
		initView(view);
		getActivity().findViewById(R.id.toolbar).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				freshData();
			}
		});
		return view;
	}

	public void initView(View view) {

		mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_container);
		mLayoutManager = new LinearLayoutManager(this.getContext());
		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setHasFixedSize(true);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerAdapter = new RecyclerAdapter(mData);
		mRecyclerView.setAdapter(mRecyclerAdapter);
		mRecyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(final View view, int position) {
				System.out.println(position + " is clicked!");
				Toast.makeText(getActivity(), "详情页面暂未完成", Toast.LENGTH_SHORT).show();
//				DetailFragment detailFragment = new DetailFragment();
//				detailFragment.setData(mData[position]);
//				getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.base_fragment, detailFragment).commit();
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					view.animate().translationZ(15f).setDuration(300).setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationCancel(Animator animation) {
							super.onAnimationCancel(animation);
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
								view.animate().translationZ(1f).setDuration(500).start();
							}
						}
					}).start();
				}
			}
		});
	}

	private void getData() {
		GetDataThread getDataThread = new GetDataThread();
		getDataThread.start();
		mData = getDataThread.getResults();
		try {
			getDataThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void freshData() {
		getData();
		mRecyclerAdapter = new RecyclerAdapter(mData);
		mRecyclerView.setAdapter(mRecyclerAdapter);
		mRecyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(final View view, int position) {
				System.out.println(position + " is clicked!");
				Toast.makeText(getActivity(), "详情页面暂未完成", Toast.LENGTH_SHORT).show();
//				DetailFragment detailFragment = new DetailFragment();
//				detailFragment.setData(mData[position]);
//				getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.base_fragment, detailFragment).commit();
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
					view.animate().translationZ(15f).setDuration(300).setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationCancel(Animator animation) {
							super.onAnimationCancel(animation);
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
								view.animate().translationZ(1f).setDuration(500).start();
							}
						}
					}).start();
				}
			}
		});
	}
}
