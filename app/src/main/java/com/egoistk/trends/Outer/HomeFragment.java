package com.egoistk.trends.outer;

import android.support.v4.app.Fragment;
import android.view.View;

import com.egoistk.trends.inner.AllFragment;
import com.egoistk.trends.inner.FavouriteFragment;
import com.egoistk.trends.inner.MineFragment;
import com.egoistk.trends.adapter.ViewPageFragmentAdapter;
import com.egoistk.trends.base.BaseViewPagerFragment;
import com.egoistk.trends.widget.OnTabReselectListener;

public class HomeFragment extends BaseViewPagerFragment implements
		OnTabReselectListener {

	protected void onSetupTabAdapter(ViewPageFragmentAdapter adapter) {
		String[] title = { "最新动态", "已点赞", "与我相关" };
		adapter.addTab(title[0], "tag_1", AllFragment.class, null);
		adapter.addTab(title[1], "tag_2", FavouriteFragment.class, null);
		adapter.addTab(title[2], "tag_3", MineFragment.class, null);
	}

	@Override
	protected void setScreenPageLimit() {
		// TODO Auto-generated method stub
		mViewPager.setOffscreenPageLimit(2);
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void initView(View view) {

	}

	@Override
	public void initData() {

	}

	@Override
	public void onTabReselect() {
		try {
			int currentIndex = mViewPager.getCurrentItem();
			Fragment currentFragment = getChildFragmentManager().getFragments()
					.get(currentIndex);
			if (currentFragment != null
					&& currentFragment instanceof OnTabReselectListener) {
				OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
				listener.onTabReselect();
			}
		} catch (NullPointerException e) {
		}
	}

}

