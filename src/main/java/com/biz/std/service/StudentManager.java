package com.biz.std.service;

import com.biz.std.model.StudentInformation;

import java.util.List;

public interface StudentManager {
    void saveStudent(StudentInformation studentInformation);
    List<StudentInformation> findByPage(int page);
    void  byNumberDelStu(int number);
    StudentInformation findByNumber(int number);
    void  updateMysqlStudent(StudentInformation studentInformation);
}
