package com.xie.dao;

import com.xie.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查询所有的学生信息 以及老师的信息
    List<Student> getStudent();

    List<Student> getStudent2();
}
