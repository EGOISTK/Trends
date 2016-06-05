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


public class PushDataThread extends Returnable {

    private String mUsername, mContent;

    public PushDataThread(String username, String content) {
        mUsername = username;
        mContent = content;
    }

    @Override
    public void run() {
        StringBuilder sbRequest = new StringBuilder();
        try {
            sbRequest.append("username=").append(URLEncoder.encode(mUsername, "utf-8")).
                    append("&content=").append(URLEncoder.encode(mContent, "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] request = sbRequest.toString().getBytes();
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL("http://182.254.247.171:8000/content");
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(request.length));
            OutputStream os = new BufferedOutputStream(httpURLConnection.getOutputStream());
            os.write(request);
            os.flush();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                System.out.println(dealResponseResult(inputStream));
            }
            os.close();
//            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                InputStream inputStream = httpURLConnection.getInputStream();
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                byte[] data = new byte[1024];
//                int len = 0;
//                try {
//                    while ((len = inputStream.read(data)) != -1) {
//                        byteArrayOutputStream.write(data, 0, len);
//                    }
//                } catch(IOException e) {
//                    e.printStackTrace();
//                }
//            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            httpURLConnection.disconnect();
        }
    }


    static String dealResponseResult(InputStream inputStream) {
        String resultData = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try {
            while ((len = inputStream.read(data)) != -1) {
                byteArrayOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }

}
