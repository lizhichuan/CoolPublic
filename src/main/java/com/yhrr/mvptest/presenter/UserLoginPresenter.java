package com.yhrr.mvptest.presenter;

import android.os.Handler;

import com.yhrr.mvptest.bean.User;
import com.yhrr.mvptest.model.ImUserModel;
import com.yhrr.mvptest.model.OnLoginListener;
import com.yhrr.mvptest.view.LoginView;

/**
 * Created by lizhichuan on 16/1/21.
 */
public class UserLoginPresenter {
    private ImUserModel imUserModel;
    private LoginView loginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        this.imUserModel = new ImUserModel();
    }

    public void login() {
        loginView.showLoading();
        imUserModel.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActivity(user);
                        loginView.hideLoading();
                    }
                });

            }
            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError();
                        loginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }


}
