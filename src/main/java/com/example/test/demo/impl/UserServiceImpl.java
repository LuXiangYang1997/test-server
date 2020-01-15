package com.example.test.demo.impl;

import com.alibaba.fastjson.JSON;
import com.example.test.demo.evtity.ResultBean;
import com.example.test.demo.evtity.User;
import com.example.test.demo.service.UserService;
import com.example.test.demo.util.MobileUtil;
import com.example.test.demo.util.SqliteHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private SqliteHelper sqliteHelper;

    {
        try {
            sqliteHelper = new SqliteHelper("identifier.sqlite");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getUserInfo() {
        User user = new User();
        String userJsonStr = JSON.toJSONString(user);
        return userJsonStr;
    }

    @Override
    public String register(Map params) {
        ResultBean resultBean = new ResultBean();
        if(params != null){
            String phoneNumberStr = (String) params.get("phoneNumber");
            String passWordStr = (String) params.get("passWord");

            if(StringUtils.isBlank(phoneNumberStr)){
                resultBean.setCode("201");
                resultBean.setMessage("手机号不能为空");
                return JSON.toJSONString(resultBean);
            }
            if(MobileUtil.isMobile(phoneNumberStr)){

            }else{
                resultBean.setCode("201");
                resultBean.setMessage("请添加正确的手机号");
                return JSON.toJSONString(resultBean);
            }

            if(StringUtils.isBlank(passWordStr)){
                resultBean.setCode("201");
                resultBean.setMessage("密码不能为空");
                return JSON.toJSONString(resultBean);
            }else {
                Connection connection = null;
                try {
                    // create a database connection
                    connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
                    Statement statement = connection.createStatement();
                    statement.setQueryTimeout(30);  // set timeout to 30 sec.

                    statement.executeUpdate("insert into user_account values('" + phoneNumberStr + "','" + passWordStr+ "')");
                } catch (SQLException e) {
                    // if the error message is "out of memory",
                    // it probably means no database file is found
                    System.err.println(e.getMessage());
                } finally {
                    try {
                        if (connection != null)
                            connection.close();
                    } catch (SQLException e) {
                        // connection close failed.
                        System.err.println(e);
                    }
                }

                resultBean.setCode("200");
                return JSON.toJSONString(resultBean);
            }
        }else{
            resultBean.setCode("201");
            resultBean.setMessage("缺少参数");
            return JSON.toJSONString(resultBean);
        }
    }
}
