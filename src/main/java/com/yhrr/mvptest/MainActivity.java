package com.yhrr.mvptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yhrr.mvptest.bean.User;
import com.yhrr.mvptest.presenter.UserLoginPresenter;
import com.yhrr.mvptest.view.LoginView;

public class MainActivity extends Activity implements LoginView {
    private EditText username, password;
    private Button login, clear;
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        username = (EditText) findViewById(R.id.id_username);
        password = (EditText) findViewById(R.id.id_password);

        login = (Button) findViewById(R.id.id_login);
        clear = (Button) findViewById(R.id.id_clear);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.login();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.clear();
            }
        });
    }

    @Override
    public String getUserName() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {
        Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        username.setText("");
    }

    @Override
    public void clearPassword() {
        password.setText("");
    }
}
