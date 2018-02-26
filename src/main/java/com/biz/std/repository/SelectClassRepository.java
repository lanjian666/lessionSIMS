package com.biz.std.repository;

import com.biz.std.model.SelectClass;
import org.apache.ibatis.annotations.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SelectClassRepository extends JpaRepository<SelectClass,Integer> {
    @Query(nativeQuery =true,value = "SELECT COUNT(1) from select_class o where o.stu_number=?1")
    public int countSubject(int number);
    @Modifying
    @Transactional
    @Query("delete from SelectClass sc where sc.stuNumber=?1")
    public void  byNumberDelStu(int number);
}
