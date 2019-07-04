package com.cskaoyan.controller.system;

import com.cskaoyan.config.SystemConfig;
import com.cskaoyan.service.system.SystemConfigService;
import com.cskaoyan.util.JacksonUtil;
import com.cskaoyan.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SystemController {


    @Autowired
    SystemConfigService service;

    @GetMapping("admin/config/mall")
    public Object listMail(){
        Map<String,Object> data = service.listMail();
        return ResponseUtil.ok(data);
    }
    @PostMapping("admin/config/mall")
    public Object updateMall(@RequestBody String body) {
        Map<String, String> data = JacksonUtil.toMap(body);
        service.updateConfig(data);
        SystemConfig.updateConfigs(data);
        return ResponseUtil.ok();
    }
    @GetMapping("admin/config/express")
    public Object listExpress(){
         Map<String, Object> data = service.listExpress();
         return  ResponseUtil.ok(data);
    }
    @PostMapping("admin/config/express")
    public Object updateExpress(@RequestBody String body) {
        Map<String, String> data = JacksonUtil.toMap(body);
        service.updateConfig(data);
        SystemConfig.updateConfigs(data);
        return ResponseUtil.ok();
    }
    @GetMapping("admin/config/order")
    public Object listOrder(){
         Map<String, Object> data = service.listOrder();
         return ResponseUtil.ok(data);
    }
    @PostMapping("admin/config/order")
    public Object updateOrder(@RequestBody String body) {
        Map<String, String> data = JacksonUtil.toMap(body);
        service.updateConfig(data);
        return ResponseUtil.ok();
    }
    @GetMapping("admin/config/wx")
    public Object listWx(){
        Map<String, Object> data = service.listWx();
        return ResponseUtil.ok(data);
    }
    @PostMapping("admin/config/wx")
    public Object updateWx(@RequestBody String body) {
        Map<String, String> data = JacksonUtil.toMap(body);
        service.updateConfig(data);
        SystemConfig.updateConfigs(data);
        return ResponseUtil.ok();
    }


}
