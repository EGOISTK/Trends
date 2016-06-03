package com.egoistk.trends;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;


public class ReturnableThread extends Thread {

    private Map<String, String> params = new HashMap<String, String>();
    private String mType, post_result = null;
    private String mUsername, mPassword;

    public ReturnableThread(String type, String username, String password) {
        mType = type;
        mUsername = username;
        mPassword = password;
    }

    @Override
    public void run() {
        params.put("username", mUsername);
        params.put("password", mPassword);
        try {
            post_result = HttpUtils.submitPostData(mType, params, "utf-8");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    String getResult() {
        return post_result;
    }
}
