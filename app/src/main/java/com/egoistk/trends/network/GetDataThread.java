package com.egoistk.trends.network;

import com.egoistk.trends.base.Returnable;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by EGOIST.K on 16/6/4.
 */
public class GetDataThread extends Returnable {

    private String[] results = new String[100];

    @Override
    public void run() {
        int i = 0;
        try {
            URL url = new URL("http://182.254.247.171:8000/content");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setDoInput(true);
            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                results[i++] = line;
//                System.out.println(line);
            }
            br.close();
            isr.close();
            is.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String[] getData() {
        return results;
    }
}
