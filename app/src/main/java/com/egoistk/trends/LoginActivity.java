package com.egoistk.trends;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private String logMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        Button btnSignin = (Button) findViewById(R.id.btn_sign_up);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logMsg = signup(username.getText().toString(), password.getText().toString());
                if (logMsg.equals("ok")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, logMsg, Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logMsg = login(username.getText().toString(), password.getText().toString());
                if (logMsg.equals("ok")) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, logMsg, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String signup( String username, String password) {
        ReturnableThread returnableThread = new ReturnableThread("signup", username, password);
        returnableThread.start();
        try {
            returnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnableThread.getResult();
    }

    private String login(String username, String password) {
        ReturnableThread returnableThread = new ReturnableThread("login", username, password);
        returnableThread.start();
        try {
            returnableThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return returnableThread.getResult();
    }
}
