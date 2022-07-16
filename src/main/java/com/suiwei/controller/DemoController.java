package com.suiwei.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.suiwei.entities.Person;
import com.suiwei.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

/**
 * @author suiwei
 * @date 2021-08-24 15:23
 * @Slf4j lombok提供的log类
 */
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {
    @Value("${person2.name}")
    private String  name;
    @Value("${person2.age}")
    private Integer  age;
    @Value("${person2.hello}")
    private String  hello;
    @Autowired
    PersonService personService;

    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/getRequest/{id}")
    public Person getRequest(@PathVariable Integer id){
        //日志级别，trace<debug<info<warn<error
        //springboot默认使用的是info
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        //lombok提供的log类
        log.info("log日志");
        Person result = null;
        try {
            result = personService.getPersonById(id);
        } catch (Exception e) {
            log.error("",e);
        }

        return  result;
    }
    @PostMapping("postRequest")
    public  String postRequest(@RequestBody JsonNode param ){
        //0话务1多媒体
        JsonNode opt = param.get("opt");
        return  opt.toString();
    }
}
