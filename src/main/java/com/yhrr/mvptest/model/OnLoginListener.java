package com.yhrr.mvptest.model;

import com.yhrr.mvptest.bean.User;

/**
 * Created by lizhichuan on 16/1/21.
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
