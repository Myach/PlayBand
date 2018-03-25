package com.playband.service;

import com.playband.model.Role;

import java.util.List;


public interface UserRoleService {

    Role findById(int id);

    Role findByType(String type);

    List<Role> findAll();

}
