package com.suiwei.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author suiwei
 * @date 2021-08-25 13:20
 * 告诉springboot将本类中的所有属性和配置文件中相关的配置进行绑定
 */
@Component
@Data
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;


}
