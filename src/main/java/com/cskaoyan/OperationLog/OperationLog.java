package com.cskaoyan.OperationLog;

import com.cskaoyan.bean.Log;
import com.cskaoyan.service.SystemService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
@Component
@EnableTransactionManagement
public class OperationLog {
    InetAddress address;
    {
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    int id=1;
    int type=1;
    boolean status=true;
    boolean deleted=true;

    String ip=address.getHostAddress();
    Date date=new Date();

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
public void logInsert(SystemService systemService,String action,String name){
    Log log=new Log(id,name,ip,type,action,status,date,date,deleted);
    systemService.logInsert(log);
}
}
