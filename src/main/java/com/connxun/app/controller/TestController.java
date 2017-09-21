package com.connxun.app.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by anna on 2017-09-15.
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value="一个测试API",notes = "第一个测试api")
    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello()
    {
        return "hello";
    }
}
