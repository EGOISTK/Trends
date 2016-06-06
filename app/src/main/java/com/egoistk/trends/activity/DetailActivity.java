package com.egoistk.trends.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.TextView;

import com.egoistk.trends.R;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ((TextView)findViewById(R.id.tv_username_in_detail)).setText(getIntent().getStringExtra("username"));
        ((TextView)findViewById(R.id.tv_content_in_detail)).setText(getIntent().getStringExtra("content"));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        finish();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        return super.onKeyDown(keyCode, event);
    }
}
