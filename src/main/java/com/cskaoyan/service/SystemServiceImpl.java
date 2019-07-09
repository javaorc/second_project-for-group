package com.cskaoyan.service;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Log;
import com.cskaoyan.bean.Role;
import com.cskaoyan.bean.Storage;
import com.cskaoyan.mapper.SystemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService{
    @Autowired
    SystemMapper systemMapper;

    @Override
    public List adminsSearch() {
        return systemMapper.adminsSearch();
    }

    @Override
    public List rolesSearch() {
        return systemMapper.rolesSearch();
    }

    @Override
    public void rolesUpdate(Role role) {
        systemMapper.rolesUpdate(role);
    }

    @Override
    public void rolesInsert(Role role) {
        systemMapper.rolesInsert(role);
    }

    @Override
    public void rolesDelete(Role role) {

    }

    @Override
    public List rolesSearchByname(String name) {
        return systemMapper.rolesSearchByname(name);
    }

    @Override
    public List rolesOptions(Role role) {
        return systemMapper.rolesOptions(role);
    }

    @Override
    public int asminssInsert(Admin admin) {
       systemMapper.asminssInsert(admin);
        return admin.getId();
    }

    @Override
    public void adminsUpdate(Admin admin) {
        systemMapper.asminssUpdate(admin);
    }

    @Override
    public void adminssDelete(Admin admin) {
        systemMapper.adminssDelete(admin);
    }

    @Override
    public List adminsSearchByname(String name) {
        return systemMapper.adminsSearchByname(name);
    }

    @Override
    public List storageSearch(String name, String key) {
        return systemMapper.storageSearch(name,key);
    }

    @Override
    public void storageUpdate(Storage storage) {
        systemMapper.storageUpdate(storage);
    }

    @Override
    public void storageDelete(Storage storage) {
        systemMapper.storageDelete(storage);
    }

    @Override
    public List logSearch(String name) {
        return systemMapper.logSearch(name);
    }

    @Override
    public void logInsert(Log log) {
        systemMapper.logInsert(log);
    }

    @Override
    public List assignPermissions(int roleId) {
        return systemMapper.assignPermissions(roleId);
    }

    @Override
    public List systemPermissions() {
        return systemMapper.systemPermissions();
    }

    @Override
    public void permissionsInsert(List permissions, int roleId) {
        systemMapper.permissionsInsert(permissions,roleId);
    }


}
