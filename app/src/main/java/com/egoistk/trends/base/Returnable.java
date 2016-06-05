package com.egoistk.trends.base;

/**
 * Created by EGOIST.K on 16/6/4.
 */
public abstract class Returnable extends Thread {
    private String result;
    private String[] results = new String[100];

    public String getResult() {
        return result;
    }

    public String[] getResults() {
        return results;
    }
}
