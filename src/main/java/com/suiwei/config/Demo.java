package com.suiwei.config;

import com.suiwei.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author suiwei
 * @date 2021-08-25 16:54
 * 指明当前类是一个配置类，替代以前的xml配置文件*/
@Configuration
public class Demo {
    /**将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
    *相当于xml中的<bean></bean>
    *springboot推荐该方式给容器添加组件*/
    @Bean
    public DemoService demoService(){
        return new DemoService();
    }
}
