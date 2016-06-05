package com.egoistk.trends.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.egoistk.trends.AppContext;
import com.egoistk.trends.R;
import com.egoistk.trends.network.LoginThread;
import com.readystatesoftware.systembartint.SystemBarTintManager;


public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnSignup, btnLogin;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_login);
        initView();

    }

    private void initView() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH) {
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(this);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintDrawable(getResources().getDrawable(R.color.transparent));
        }

        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);

        btnSignup = (Button) findViewById(R.id.btn_sign_up);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg = signup(etUsername.getText().toString(), etPassword.getText().toString());
                if (msg.equals("ok")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppContext)getApplicationContext()).setUsername(etUsername.getText().toString());
                msg = login(etUsername.getText().toString(), etPassword.getText().toString());
                if (msg.equals("ok")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class), ActivityOptions.makeCustomAnimation(LoginActivity.this, R.anim.push_left_in, R.anim.push_left_out).toBundle());
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String signup( String username, String password) {
        LoginThread loginThread = new LoginThread("signup", username, password);
        loginThread.start();
        try {
            loginThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loginThread.getResult();
    }

    private String login(String username, String password) {
        LoginThread loginThread = new LoginThread("login", username, password);
        loginThread.start();
        try {
            loginThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loginThread.getResult();
    }
}
