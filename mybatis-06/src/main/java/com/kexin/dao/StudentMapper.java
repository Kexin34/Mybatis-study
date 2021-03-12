package com.kexin.dao;

import com.kexin.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //获取所有学生信息，以及及对应老师的信息
    public List<Student> getStudents();

    //获取所有学生信息，以及及对应老师的信息
    public List<Student> getStudents2();

}
