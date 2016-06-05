package com.egoistk.trends.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.egoistk.trends.R;
import com.egoistk.trends.base.BaseFragment;
import com.egoistk.trends.fragment.AllFragment;


public class PushFragment extends BaseFragment {

	EditText etPush;
	Button btnPush;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fagment_push, null);
		initView(view);
		return view;
	}

	public void initView(View view) {
		etPush = (EditText) view.findViewById(R.id.tv_add);
		btnPush = (Button) view.findViewById(R.id.btn_push);
		btnPush.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getFragmentManager().beginTransaction().replace(R.id.realtabcontent, new AllFragment()).commit();
			}
		});
	}

	@Override
	public void initData() {

	}

}
