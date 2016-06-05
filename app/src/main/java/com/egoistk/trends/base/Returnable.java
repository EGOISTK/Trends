package com.egoistk.trends.base;

public abstract class Returnable extends Thread {

    private String result = "";
    private String[] results = new String[100];

    public String getResult() {
        return result;
    }

    public String[] getResults() {
        return results;
    }
}
