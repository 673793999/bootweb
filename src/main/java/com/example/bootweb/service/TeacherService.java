package com.example.bootweb.service;

import com.jtl.pojo.Teacher;

/**
 * Created by jiangtenglong no 2018/1/7 .
 */
public interface TeacherService {


    Teacher addTeacher(Teacher teacher);

    int deleteTeacher(Teacher teacher);

    void deleteTeacher(String name);

    Teacher getTeacher(Teacher teache);
}
