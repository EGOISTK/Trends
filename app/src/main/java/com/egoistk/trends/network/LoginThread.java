package com.egoistk.trends.network;

import com.egoistk.trends.base.Returnable;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;


public class LoginThread extends Returnable {

    private Map<String, String> params = new HashMap<String, String>();
    private String mType, post_result = null;
    private String mUsername, mPassword;

    public LoginThread(String type, String username, String password) {
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

    @Override
    public String getResult() {
        return post_result;
    }
}
