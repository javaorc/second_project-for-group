package com.cskaoyan.typeHandler;

import com.cskaoyan.bean.Admin;

public class IntArrayToString {
    public static String intArrayToString(Admin admin){
        int[] ids= admin.getRoleIds();
        StringBuffer sb = new StringBuffer();
        String substring = null;
        sb.append("[");
        for (int id : ids) {
            sb.append(id).append(",");
        }
        if (sb.length() > 1) {
            substring = sb.substring(0, sb.length() - 1);
        }
        String roleIds=substring+"]";
        return roleIds;
    }
    public static String stringArrayToString(String[] strings){

        StringBuffer sb = new StringBuffer();
        String substring = null;
        sb.append("[");
        for (String id : strings) {
            sb.append(id).append(",");
        }
        if (sb.length() > 1) {
            substring = sb.substring(0, sb.length() - 1);
        }
        String roleIds=substring+"]";
        return roleIds;
    }
}
