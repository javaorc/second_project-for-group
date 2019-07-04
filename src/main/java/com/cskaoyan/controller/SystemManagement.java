package com.cskaoyan.controller;

import com.cskaoyan.bean.Admin;
import com.cskaoyan.bean.Role;
import com.cskaoyan.service.SystemService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class SystemManagement {
    @Autowired
    SystemService systemService;
    @RequestMapping("admin/list")
    @ResponseBody
   public Map adminsSearch(int page,int limit,String username){
        List list;
        if (username==null){
           list=systemService.adminsSearch();
        }else {
            list=systemService.adminsSearchByname(username);
        }

        Map map=new HashMap();
        Map map1=new HashMap();
        map1.put("items",list);
        map.put("data",map1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("admin/create")
    @ResponseBody
    public Map rolesInsert(@RequestBody Admin admin){
        Map map=new HashMap();
        systemService.asminssInsert(admin);
        map.put("data",admin);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("admin/update")
    @ResponseBody
    public Map adminsUpdate(@RequestBody Admin admin){
        Map map=new HashMap();
        systemService.adminsUpdate(admin);
        map.put("data",admin);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("admin/delete")
    @ResponseBody
    public Map adminsDelete(@RequestBody Admin admin){
        Map map=new HashMap();
        systemService.adminssDelete(admin);

        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("role/list")
    @ResponseBody
    public Map rolesSearch(int page,int limit,String name){
        PageHelper.startPage(page,limit);
        List list;
        if (name==null){
            list=systemService.rolesSearch();
        }else {
            list=systemService.rolesSearchByname(name);
        }

        Map map=new HashMap();
        Map map1=new HashMap();
        map1.put("items",list);
        map.put("data",map1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("role/update")
    @ResponseBody
    public Map rolesUpdate(@RequestBody Role role){
        Map map=new HashMap();
        systemService.rolesUpdate(role);
        map.put("data",role);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("role/create")
    @ResponseBody
    public Map rolesInsert(@RequestBody Role role){
        Map map=new HashMap();
        systemService.rolesInsert(role);
        map.put("data",role);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("role/delete")
    @ResponseBody
    public Map rolesDelete(@RequestBody Role role){
        Map map=new HashMap();
        systemService.rolesDelete(role);

        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("role/options")
    @ResponseBody
    public Map rolesOptions(Role role){
        Map map=new HashMap();
         List list=systemService.rolesOptions(role);
        map.put("data",list);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
    @RequestMapping("storage/list")
    @ResponseBody
    public Map storageSearch(int page,int limit,String name,String key) {
        PageHelper.startPage(page, limit);
        List list=systemService.storageSearch(name,key);

        Map map=new HashMap();
        Map map1=new HashMap();
        map1.put("items",list);
        map.put("data",map1);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;

    }
}
