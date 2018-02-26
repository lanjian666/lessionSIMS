package com.biz.std.test;

import com.biz.std.model.Subject;
import com.biz.std.repository.SubjectRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SubjectRepositoryTest {
    private ApplicationContext ctx=null;
    private SubjectRepository subjectRepository=null;
    @Before
    public void step(){
        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        subjectRepository=ctx.getBean(SubjectRepository.class);
        System.out.println("step");
    }
    @After
    public  void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }
    @Test
    public  void  testSaveSubject(){
        Subject subject=new Subject("外语",80,90.00);
        subjectRepository.save(subject);
    }
    @Test
    public  void  testFindAll(){

        List<Subject> list=subjectRepository.findAll();
        for (Subject subject:list){
            System.out.println(subject.getSubjectName());
        }
        System.out.println(list);
    }
}
