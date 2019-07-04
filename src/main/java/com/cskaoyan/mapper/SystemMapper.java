package com.cskaoyan.mapper;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Role;
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

    List storageSearch(String name, String key);
}
