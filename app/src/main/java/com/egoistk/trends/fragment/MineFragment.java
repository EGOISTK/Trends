package com.egoistk.trends.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.egoistk.trends.R;
import com.egoistk.trends.base.BaseFragment;

public class MineFragment extends BaseFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_mine, null);
		initView(view);
		return view;
	}

	public void initView(View view) {

	}

	@Override
	public void initData() {

	}

}
