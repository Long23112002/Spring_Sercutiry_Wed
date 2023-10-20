package com.example.springsercurity.service;

import com.example.springsercurity.entity.Role;
import com.example.springsercurity.entity.User;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addToUser(String username, String roleName);
}
