package com.suiwei.service.impl;

import com.suiwei.dao.PersonMapper2;
import com.suiwei.entities.Person;
import com.suiwei.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suiwei
 * @date 2021-09-16 17:35
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper2 personMapper;


    @Override
    public Person getPersonById(Integer id) {
        return personMapper.getPersonById(id);
    }
}
