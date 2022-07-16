package com.suiwei.dao;

import com.suiwei.entities.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author suiwei
 * @date 2021-09-17 17:31
 *配置文件版mybatis，需要写配置文件，并且修改yml
 */
@Repository
public interface PersonMapper2 {
    Person getPersonById(@Param("id")Integer id);
}
