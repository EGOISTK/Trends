package com.egoistk.trends;

import android.app.Application;


public class AppContext extends Application {

	private static AppContext instance;
	private static String username;

	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static void setUsername(String username) {
		AppContext.username = username;
	}

	public static String getUsername() {
		return username;
	}

//	public static AppContext getInstance() {
//		return instance;
//	}
}
