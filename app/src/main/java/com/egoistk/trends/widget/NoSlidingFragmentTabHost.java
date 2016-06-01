package com.egoistk.trends.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.egoistk.trends.base.BaseFragmentTabHost;

/**
 * tabhost
 * 
 * @author FireAnt（http://my.oschina.net/LittleDY）
 * @version 创建时间：2014年9月28日 下午2:27:51
 * 
 */

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
