package com.kexin.dao;

import com.kexin.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取所有老师
    List<Teacher> getTeacher();

    //获取指定老师，及老师下的所有学生
    public Teacher getTeacher1(@Param("id") int id);

    public Teacher getTeacher3(@Param("id") int id);

}
