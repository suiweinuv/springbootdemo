package com.suiwei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author suiwei
 * @date 2021-08-25 16:57
 * MapperScan扫描mybatis所有的业务Mapper接口,就不用写Mapper注解了
 * @MapperScan({"com.suiwei.mapper"})扫描注解版Mapper
 */

@MapperScan({"com.suiwei.dao","com.suiwei.mapper"})
@SpringBootApplication
@EnableCaching
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

}
