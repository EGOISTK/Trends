package com.egoistk.trends.network;

import com.egoistk.trends.base.Returnable;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class LoginThread extends Returnable {

    private String mType, result = "Network timeout!";
    private String mUsername, mPassword;

    public LoginThread(String type, String username, String password) {
        mType = type;
        mUsername = username;
        mPassword = password;
    }

    @Override
    public void run() {
        StringBuilder sbRequest = new StringBuilder();//存储封装好的请求体信息
        try {
            sbRequest.append("username=").append(URLEncoder.encode(mUsername, "utf-8")).
                    append("&password=").append(URLEncoder.encode(mPassword, "utf-8"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        byte[] request = sbRequest.toString().getBytes();
        HttpURLConnection httpURLConnection = null;
        try{
            httpURLConnection = (HttpURLConnection) new URL("http://182.254.247.171:8000/" + mType).openConnection();
            httpURLConnection.setConnectTimeout(3000);  // 设置连接超时时间
            httpURLConnection.setRequestMethod("POST"); // 设置以POST方式提交数据
            httpURLConnection.setUseCaches(false);      // 使用POST方式不能使用缓存
            httpURLConnection.setDoInput(true);         // 打开输入流，以便从服务器获取数据
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");// 设置请求体的类型是文本类型
            httpURLConnection.setDoOutput(true);// 打开输出流，以便向服务器提交数据
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(request.length));// 设置请求体的长度
            OutputStream os = new BufferedOutputStream(httpURLConnection.getOutputStream());// 获得输入流，向服务器写入数据
            os.write(request);
            os.flush();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] data = new byte[1024];
                int len = 0;
                try {
                    while ((len = inputStream.read(data)) != -1) {
                        byteArrayOutputStream.write(data, 0, len);
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
                result = new String(byteArrayOutputStream.toByteArray());
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }
    }

    @Override
    public String getResult() {
        return result;
    }
}
