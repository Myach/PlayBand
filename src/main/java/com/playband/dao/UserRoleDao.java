package com.playband.dao;

import com.playband.model.Role;

import java.util.List;


public interface UserRoleDao {

    List<Role> findAll();

    Role findByType(String type);

    Role findById(int id);
}
