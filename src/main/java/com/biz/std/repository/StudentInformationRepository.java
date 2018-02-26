package com.biz.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biz.std.model.StudentInformation;

public interface StudentInformationRepository extends JpaRepository<StudentInformation, Integer> {
    public StudentInformation findByName(String name);
    @Query("select g from StudentInformation g where g.avg=(select max(g.avg) from StudentInformation g)")
    public StudentInformation getGradeByMaxId();
}
