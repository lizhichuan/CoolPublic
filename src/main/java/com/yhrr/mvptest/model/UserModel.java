package com.yhrr.mvptest.model;

/**
 * Created by lizhichuan on 16/1/21.
 */
public interface UserModel {
    void login(String username, String password, OnLoginListener loginListener);
}
