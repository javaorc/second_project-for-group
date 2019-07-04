package com.cskaoyan.service;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Role;

import java.util.List;

public interface SystemService {
    List adminsSearch();

    List rolesSearch();

    void rolesUpdate(Role role);

    void rolesInsert(Role role);

    void rolesDelete(Role role);

    List rolesSearchByname(String name);

    List rolesOptions(Role role);

    void asminssInsert(Admin admin);

    void adminsUpdate(Admin admin);

    void adminssDelete(Admin admin);

    List adminsSearchByname(String name);

    List storageSearch(String name, String key);
}
