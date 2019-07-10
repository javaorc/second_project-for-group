package com.cskaoyan.shiro;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Permission;
import com.cskaoyan.mapper.SystemMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AdminRealm")
public class AdminRealm extends AuthorizingRealm {
@Autowired
    SystemMapper systemMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Admin admin=systemMapper.queryPasswordFromDb(primaryPrincipal);
        int[] roleIds=admin.getRoleIds();
        List<Permission> list=systemMapper.permissionsSearch(roleIds);
        for (Permission permission:list){
            info.addStringPermission(permission.getPermission());
        }
        return info;
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        String passwordFromDb = queryPasswordFromDb(principal);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,passwordFromDb, "realm");
        return info;
    }
    private String queryPasswordFromDb(String principal) {
        Admin admin=systemMapper.queryPasswordFromDb(principal);
        return admin.getPassword();
    }
}
