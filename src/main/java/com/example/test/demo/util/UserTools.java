package com.example.test.demo.util;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * 用户工具
 */
public class UserTools {

    private final Logger logger;

    public UserTools(){
        logger = Logger.getLogger("com.example.test.demo");
    }
    /**
     * 用户注册时生成用户唯一的id 前六位是日期 后八位是随机数
     */
    public String getNewUserId(){
        String ipAddress = "";
        try{
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        }catch (Exception e){
            logger.severe(e.getMessage());
        }
        //获取UUID
        String uuid = ipAddress +"$" + UUID.randomUUID().toString().replaceAll("-","").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀
        long prefix = Long.parseLong(time) * 100000000;
        String userId = String.valueOf(prefix + suffix);
        return  userId;
    }

}
