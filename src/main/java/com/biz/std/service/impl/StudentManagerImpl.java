package com.biz.std.service.impl;

import com.biz.std.model.StudentInformation;
import com.biz.std.repository.SelectClassRepository;
import com.biz.std.repository.StudentInformationRepository;
import com.biz.std.service.StudentManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentManagerImpl implements StudentManager {
    @Resource
    private StudentInformationRepository studentInformationRepository;
    @Resource
    private SelectClassRepository selectClassRepository;
    @Override
    public void saveStudent(StudentInformation studentInformation) {
        studentInformationRepository.save(studentInformation);
    }

    @Override
    public List<StudentInformation> findByPage(int page) {
        Pageable pageable=new PageRequest(page,5);
        Page<StudentInformation> page1=  studentInformationRepository.findAll(pageable);
        List<StudentInformation> list = page1.getContent();
        List<StudentInformation> addList=new ArrayList<StudentInformation>();
        for (StudentInformation studentInformation:list){
            int countSubject=selectClassRepository.countSubject(studentInformation.getNumber());
            studentInformation.setSubjectNumber(countSubject);
            addList.add(studentInformation);
        }
        return addList;
    }

    @Override
    public void byNumberDelStu(int number) {
        studentInformationRepository.delete(number);
        selectClassRepository.byNumberDelStu(number);
    }

    @Override
    public StudentInformation findByNumber(int number) {
        StudentInformation studentInformation=studentInformationRepository.findOne(number);
        return studentInformation;
    }

    @Override
    public void updateMysqlStudent(StudentInformation studentInformation) {
        System.out.println(studentInformation.getNumber());
        studentInformationRepository.save(studentInformation);
    }
}
