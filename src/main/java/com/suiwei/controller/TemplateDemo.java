package com.suiwei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @author suiwei
 * @date 2021-09-01 13:49
 */
@Controller
@RequestMapping("/templateDemo")
public class TemplateDemo {
    @GetMapping("/default")
    public  String templateDemo(Map<String,Object> map){
        //默认数据会放到请求域中
        map.put("hello","你好");
        map.put("users",Arrays.asList("zhangsan","lisi"));
        //自动配置的模板引擎，会自动识别templates文件夹与html后缀
        return "templateDemo";
    }
    @PostMapping("/post")
    public  String login(@RequestParam("username") String username){

        return "login";
    }

}
