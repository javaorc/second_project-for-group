package com.cskaoyan.controller.wxLoginAndRegister;

import com.cskaoyan.bean.UserInfo;
import com.cskaoyan.bean.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Register {
    @RequestMapping("wx/auth/register")
    @ResponseBody
    public String  register(){
        return "";
    }
}
