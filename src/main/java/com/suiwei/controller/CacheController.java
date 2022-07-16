package com.suiwei.controller;

import com.suiwei.entities.Person;
import com.suiwei.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suiwei
 * @date 2021-09-24 14:27
 * Spring缓存抽象：
 *      默认使用ConcurrentMapCacheManager的ConcurrentMapCache
 *          将数据保存在ConcurrentMap<object,object>中
 *          开发中更多的使用缓存中间件：redis，memcached，ehcache
 *      步骤
 *      1.开启基于注解的缓存@EnableCaching
 *      2.在方法上标注缓存注解
 *          @Cacheable：主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 *          @CacheEvict：清空缓存
 *          @CachePut：更细缓存，保证方法被调用，又希望结果被缓存
 *
 */
@RestController
public class CacheController {
    @Autowired
    CacheService cacheService;
    @GetMapping("/cache/{id}")
    public Person getPersonById(@PathVariable("id") Integer id){
        Person person = cacheService.getPersonById(id);
        return  person;
    }
    @GetMapping("/cache")
    public Person update(Person person){
        Person person1= cacheService.undatePerson(person);
        return  person1;
    }
    @GetMapping("/cache/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
         cacheService.deleteperson(id);
        return  "success";
    }
}
