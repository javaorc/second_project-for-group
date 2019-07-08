package com.cskaoyan.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Md5Util {
    public static String getMD5(String s) {

        String result="" ;

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");



        String input=s+ uuid ;

        //1、获取Java语言提供的MD5算法类
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");


            //2、传入密码，返回一个表示MD5值字节数组(16字节)
            byte[] digest = md5.digest(s.getBytes());

            //3、对结果进行处理： 将MD5值（16个字节的字节数组）还原成字符串

            StringBuffer sb= new StringBuffer();

            // 1110 1011  8bit  11+32 +64 =-107
            // E B

            // 0000 1111

            //0F

            //每次去取出一个字节

            for (byte b: digest) {

                //1000 0000 0000 0000 0000 0000  0110 1011

                int i =b&0x000000FE;
                String s1 = Integer.toHexString(i);

                if (s1.length()==1){
                    sb.append("0");
                }
                sb.append(s1);
            }


            result = sb.toString();


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }



        return  result;




    }
}
