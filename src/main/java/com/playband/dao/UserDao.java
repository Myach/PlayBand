package com.playband.dao;

import com.playband.model.User;

import java.util.List;


public interface UserDao {

    User findById(int id);

    User findByEmail(String email);

    void save(User user);

    void deleteByEmail(String email);

    List<User> findAllUsers();

}

