package com.suiwei.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author suiwei
 * @date 2021-09-27 19:17
 */
@Configuration
public class CacheConfig {
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return  new  KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString() +"]";
            }
        };
    }
}
