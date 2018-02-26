package com.biz.std.service;

import com.biz.std.model.SelectClass;
import com.biz.std.model.Subject;

import java.util.List;

public interface SubjectManager {
    List<Subject> findSubject();
    void  saveSelectClass(SelectClass selectClass);
}
