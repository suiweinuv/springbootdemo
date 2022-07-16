package com.suiwei.mapper;

import com.suiwei.entities.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * @author suiwei
 * @date 2021-09-16 17:15 注解版的mybatis，不需要写配置文件
 */
@Repository
public interface PersonMapper {
    @Select("select * from person where id =#{id}")
    Person getPersonById(Integer id);
    @Update("update person set name =#{name},age =#{age} where id =#{id} ")
    void updatePerson(Person person);
    @Delete("delete from person where id =#{id}")
    void  deletePerson(Integer id);
    @Insert("insert into person(name,age) values(#{name},#{age})")
    void  insertPerson(Person person);
}
