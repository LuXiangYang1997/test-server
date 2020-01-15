package com.example.test.demo.controller;

import com.example.test.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(){
        String userJson = service.getUserInfo();
        return userJson;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestParam Map params){
        System.out.print("register" + params.toString());
        String registerResult = service.register(params);
        return registerResult;
    }


}
