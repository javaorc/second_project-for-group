package com.cskaoyan.service;

import com.cskaoyan.bean.Role;

import java.util.List;

public interface SystemService {
    List adminsSearch();

    List rolesSearch();

    void rolesUpdate(Role role);

    void rolesInsert(Role role);

    void rolesDelete(Role role);

    List rolesSearchByname(String name);
}
