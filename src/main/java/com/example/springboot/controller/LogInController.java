package com.example.springboot.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LogInController {
    @RequestMapping("/test")
    public JSONObject login(@RequestParam("fileName") String fileName,@RequestParam("name") String name) {
        JSONObject res = new JSONObject();
        res.put("retCode",0);
        res.put("retMsg","登录成功");
        return res;
    }

}
