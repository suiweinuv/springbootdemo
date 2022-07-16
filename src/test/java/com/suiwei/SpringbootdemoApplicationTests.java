package com.suiwei;

import com.suiwei.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
@RabbitListener
class SpringbootdemoApplicationTests {
    @Autowired
    Person person;
    @Value("${person.name}")
    private  String name;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作字符串的
    @Autowired
    RedisTemplate redisTemplate;//操作对象的

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    void contextLoads() {


        rabbitTemplate.convertAndSend("exchange.direct");

    }

}
