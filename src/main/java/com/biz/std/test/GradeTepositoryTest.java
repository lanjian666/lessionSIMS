package com.biz.std.test;

import com.biz.std.model.Grade;
import com.biz.std.repository.GradeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GradeTepositoryTest {
    private ApplicationContext ctx=null;
    private GradeRepository gradeRepository=null;
    @Before
    public void step(){
        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        gradeRepository=ctx.getBean(GradeRepository.class);
        System.out.println("step");
    }
    @After
    public  void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }
    @Test
    public  void  testSaveGrade(){
        Grade grade=new Grade("一年级一班",30,80.00);
        gradeRepository.save(grade);
    }
}
