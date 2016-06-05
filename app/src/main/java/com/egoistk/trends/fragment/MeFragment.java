package com.egoistk.trends.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.egoistk.trends.AppContext;
import com.egoistk.trends.R;
import com.egoistk.trends.activity.LoginActivity;
import com.egoistk.trends.base.BaseFragment;

public class MeFragment extends BaseFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_me, null);
		initView(view);
		return view;
	}

	public void initView(View view) {
		((TextView) view.findViewById(R.id.tv_fragment_name)).setText("MeFragment");
		((Button) view.findViewById(R.id.btn_logout)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(getActivity(), LoginActivity.class), ActivityOptions.makeCustomAnimation(getActivity(), R.anim.push_right_in, R.anim.push_rightout).toBundle());
				getActivity().finish();
				((AppContext)getActivity().getApplicationContext()).setUsername(null);
			}
		});
	}

	@Override
	public void initData() {

	}

}
