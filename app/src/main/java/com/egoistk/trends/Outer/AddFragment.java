package com.egoistk.trends.Outer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.egoistk.trends.R;
import com.egoistk.trends.base.BaseFragment;

public class AddFragment extends BaseFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment, null);
		initView(view);
		return view;
	}

	public void initView(View view) {
		TextView tv = (TextView) view.findViewById(R.id.tv_fragment_name);
		tv.setText("AddFragment");
	}

	@Override
	public void initData() {

	}

}
