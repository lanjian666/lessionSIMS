package com.biz.std.service.impl;

import com.biz.std.model.SelectClass;
import com.biz.std.model.Subject;
import com.biz.std.repository.SelectClassRepository;
import com.biz.std.repository.SubjectRepository;
import com.biz.std.service.SubjectManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SubjectManagerImp implements SubjectManager {
    @Resource
    private SubjectRepository subjectRepository;
    @Resource
    private SelectClassRepository selectClassRepository;
    @Override
    public List<Subject> findSubject() {
        List<Subject> list =subjectRepository.findAll();
        return list;
    }

    @Override
    public void saveSelectClass(SelectClass selectClass) {
        selectClassRepository.save(selectClass);
    }
}
