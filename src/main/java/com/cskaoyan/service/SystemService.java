package com.cskaoyan.service;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Log;
import com.cskaoyan.bean.Role;
import com.cskaoyan.bean.Storage;

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

    void storageUpdate(Storage storage);

    void storageDelete(Storage storage);

    List logSearch(String name);

    void logInsert(Log log);
}
