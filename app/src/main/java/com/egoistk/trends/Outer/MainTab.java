package com.egoistk.trends.Outer;

import com.egoistk.trends.R;


public enum MainTab {

	HOME(0, R.string.home, R.drawable.tab_home_icon,
	        HomeFragment.class),

	ADD(1, R.string.add, R.drawable.tab_add_icon,
	        AddFragment.class),

	ME(3, R.string.me, R.drawable.tab_person_icon,
	        MeFragment.class);

	private int idx;
	private int resName;
	private int resIcon;
	private Class<?> clz;

	private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
		this.idx = idx;
		this.resName = resName;
		this.resIcon = resIcon;
		this.clz = clz;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getResName() {
		return resName;
	}

	public void setResName(int resName) {
		this.resName = resName;
	}

	public int getResIcon() {
		return resIcon;
	}

	public void setResIcon(int resIcon) {
		this.resIcon = resIcon;
	}

	public Class<?> getClz() {
		return clz;
	}

	public void setClz(Class<?> clz) {
		this.clz = clz;
	}
}
