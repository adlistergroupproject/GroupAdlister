package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User updateUserInfo(String username, String email, long user_id);
    User findUserById(long id);
    User updateUserPassword(String password, long id);
    void deleteUser(User user);
    void deleteUsersAds(User user);
    User findByEmail(String email);
}
