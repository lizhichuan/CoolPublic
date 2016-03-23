package com.yhrr.mvptest.view;

import com.yhrr.mvptest.bean.User;

/**
 * Created by lizhichuan on 16/1/21.
 */
public interface LoginView {

    String getUserName();
    String getPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();

    void clearUserName();

    void clearPassword();

}
