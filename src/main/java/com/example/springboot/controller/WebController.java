package com.example.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengwei he
 */

@RestController
@RequestMapping("/springboot")
class WebController {
    private final Logger logger = LoggerFactory.getLogger(WebController.class);

    @RequestMapping("/methA")
    public String a() {
        logger.info("/test/a");
        return "a";
    }

    @RequestMapping("/methB")
    public String b() {
        logger.info("/test/methB");
        return "b";
    }

    @RequestMapping("/methC")
    public String c() {
        logger.info("/test/methB");
        return "c";
    }
}
