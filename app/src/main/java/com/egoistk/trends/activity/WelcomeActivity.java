package com.egoistk.trends.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.egoistk.trends.R;


public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        onLoading();
    }

    private void onLoading() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    startActivity(new Intent(WelcomeActivity.this, LoginActivity.class), ActivityOptions.makeCustomAnimation(WelcomeActivity.this, R.anim.fade, R.anim.hold).toBundle());
                    finish();
                } catch( InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}
