package com.egoistk.trends.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.egoistk.trends.base.BaseFragmentTabHost;


public class NoSlidingFragmentTabHost extends BaseFragmentTabHost {

	private String mCurrentTag;

	private String mNoTabChangedTag;

	public NoSlidingFragmentTabHost(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onTabChanged(String tag) {

		if (tag.equals(mNoTabChangedTag)) {
			setCurrentTabByTag(mCurrentTag);
		} else {
			super.onTabChanged(tag);
			mCurrentTag = tag;
		}
	}

	public void setNoTabChangedTag(String tag) {
		this.mNoTabChangedTag = tag;
	}
}
