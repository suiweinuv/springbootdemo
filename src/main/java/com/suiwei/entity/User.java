package com.suiwei.entity;

import lombok.Data;

import javax.persistence.*;


/**
 * @author suiwei
 * @date 2021-09-16 17:01
 * @Entity  告诉jpa这是一个实体类（和数据表映射的类）
 * @Table 指定和哪个数据表对应，如果省略默认表名就是类名
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "name",length = 50)//省略的情况下，默认列名就是属性名
    private String name;
    private Integer age;

}
