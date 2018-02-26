package com.biz.std.test;

import com.biz.std.model.SelectClass;
import com.biz.std.repository.SelectClassRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SelectClassRepositoryTest {
    private ApplicationContext ctx=null;
    private SelectClassRepository selectClassRepository=null;
    @Before
    public void step(){
        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        selectClassRepository=ctx.getBean(SelectClassRepository.class);
        System.out.println("step");
    }
    @After
    public  void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }
    @Test
    public  void  testSave(){
        SelectClass selectClass=new SelectClass(2,"数学");
        selectClassRepository.save(selectClass);
    }
    @Test
    public  void  testGetCount(){
        int sum=selectClassRepository.countSubject(2);
        System.out.println(sum);
    }
    @Test
    public  void  testByNumberDelStu(){
        selectClassRepository.byNumberDelStu(2);
    }
}
