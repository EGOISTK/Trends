package com.egoistk.trends.Inner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.egoistk.trends.R;
import com.egoistk.trends.base.BaseFragment;

public class AllFragment extends BaseFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.child_fragment, null);
		initView(view);
		return view;
	}

	public void initView(View view) {
		TextView tv = (TextView) view.findViewById(R.id.tv_childfragment_name);
		tv.setText("Child_Fragment1");
	}

	@Override
	public void initData() {

	}

}
