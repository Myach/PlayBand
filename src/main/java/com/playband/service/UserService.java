package com.playband.service;

import com.playband.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User findByEmail(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByEmail(String email);

    List<User> findAllUsers();

    boolean isUserEmailUnique(String email);

}