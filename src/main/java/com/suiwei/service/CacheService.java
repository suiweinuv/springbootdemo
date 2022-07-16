package com.suiwei.service;

import com.suiwei.entities.Person;
import com.suiwei.mapper.PersonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author suiwei
 * @date 2021-09-24 14:21
 * CacheConfig:抽取缓存的公共配置，在这里配置了，就不需要在每个方法再配置了
 */
@CacheConfig(cacheNames = "person")
@Service
@Slf4j
public class CacheService {
    @Autowired
    PersonMapper personMapper;

    /**
     * 将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不调用方法
     * 属性
     *      cacheNames/value：指定缓存组件的名字
     *      keyGenerator:key的生成策略，可以自己编写自己指定，与key二选一
     *      key：缓存数据使用的key，不指定默认使用方法参数的值
     *          无参：key=new simpleKey（）
     *          一个参数：key =参数的值
     *          多个参数：key = new SimpleKey（params）
     *          编写SpEl：#id，#a0，#root.args[0]
     *      cacheManager:指定缓存管理器
     *      condition：指定符合条件的情况下才缓存
     *      unless：与condition相反，表示否定
     *      sync：是否使用异步，异步的时候unless就不支持了
     *
     * @cacheable标注的方法执行之前，先来检查缓存中有没有这个数据，用key去查询缓存
     * 如果没有就运行方法并把结果放入缓存，以后再调用就直接使用缓存中的数据
     *
     */
    @Cacheable(cacheNames = {"person"})
    public Person getPersonById(Integer id){
        log.info("查询"+id+"号员工");
        Person person = personMapper.getPersonById(id);
        return  person;
    }


    /**
     * @CachePut:每次即调用方法，又更新缓存，
     * 先调用方法，再更新缓存
     * 因为缓存是key，value存储数据，所以使用@CachePut时需要注意指定key（value就是返回值）
     *
     */
    @CachePut(value = "person",key = "#person.id")
    public  Person undatePerson(Person person){
        personMapper.updatePerson(person);
        return  person;
    }

    /**
     *缓存清除，删掉key为
     * id的person中的缓存
     *,allEntries :是否删掉所有，默认是false，如果指定为true的话，就删掉整个person
     * beforeInvocation:是否在方法执行之前清除，默认是false，方法执行之后执行缓存清除
     *      如果是false：如果方法出现异常，缓存就不会清除
     *      如果是true：无论方法是否出现异常，缓存都会清除
     */
    @CacheEvict(value = "person" )
    public void  deleteperson(Integer id){
        //personMapper.deletePerson(id);
    }


}
