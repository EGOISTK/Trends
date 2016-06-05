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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by EGOIST.K on 16/6/4.
 */
public class PushDataThread extends Returnable {

    private Map<String, String> params = new HashMap<String, String>();

    public PushDataThread(Map<String, String> m) {
        params = m;
    }

    @Override
    public void run() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), "utf-8"))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            byte[] data = stringBuffer.toString().getBytes();
            URL url = new URL("http://182.254.247.171:8000/content");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            OutputStream os = new BufferedOutputStream(httpURLConnection.getOutputStream());
            os.write(data);
            os.flush();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = httpURLConnection.getInputStream();
                System.out.println(dealResponseResult(inputStream));
            }


            os.close();
            httpURLConnection.disconnect();
        } catch(Exception e) {
            e.printStackTrace();
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
