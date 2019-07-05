package com.cskaoyan.mapper;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Log;
import com.cskaoyan.bean.Role;
import com.cskaoyan.bean.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemMapper {
    List adminsSearch();

    List rolesSearch();

    void rolesUpdate(Role role);

    void rolesInsert(Role role);

    List rolesSearchByname(@Param("name") String name);

    List rolesOptions(Role role);

    void asminssInsert(Admin admin);

    void asminssUpdate(Admin admin);

    void adminssDelete(Admin admin);

    List adminsSearchByname(String name);

    List storageSearch(@Param("name") String name, @Param("key") String key);

    void storageUpdate(Storage storage);

    void storageDelete(Storage storage);

    List logSearch(@Param("name") String name);

    void logInsert( Log log);
}
