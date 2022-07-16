package com.suiwei.repository;

import com.suiwei.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author suiwei
 * @date 2021-09-23 13:41
 * 通过继承JpaRepository来完成对数据库的操作
 * 泛型：第一个参数是实体类，第二个参数是实体类的主键
 * 本身自带很多增删改查方法
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
