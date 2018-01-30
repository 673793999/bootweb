package com.example.bootweb.service.impl;

import com.example.bootweb.service.TeacherService;
import com.jtl.pojo.Teacher;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

/**
 * Created by jiangtenglong no 2018/1/7 .
 */
@Service
public class TeacherServiceImpl implements TeacherService {



    @Override
    @CachePut(value = "teacher",key = "#teacher.name")
    public Teacher addTeacher(Teacher teacher) {
        System.out.println("缓存teacher:"+teacher.getName());
        return teacher;
    }

    @Override
    @CacheEvict(value = "teacher",key = "#teacher.name")
    public int deleteTeacher(Teacher teacher) {
        System.out.println("删除缓存teacher:"+teacher.getName());
        return 0;
    }

    @Override
    @CacheEvict(value = "teacher")
    public void deleteTeacher(String name) {
        System.out.println("删除缓存teacher:"+name);
    }

    @Override
    @Cacheable(value = "teacher",key = "#teacher.name")
    public Teacher getTeacher(Teacher teacher) {
        Teacher teacher1 = new Teacher();
        teacher1.setName("张三");
        teacher1.setAge(30);
        return teacher1;
    }
}
