package com.biz.std.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SpringDataTest {
    private ApplicationContext ctx=null;
    @Before
    public void step(){
        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        System.out.println("step");
    }
    @After
    public  void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }
    @Test
    public void testEntityManagerFactory(){

    }
    @Test
    public void  tt(){
        DataSource d=ctx.getBean("dataSource", DataSource.class);
        System.out.println("%%%%%%%%%%%%%%"+d.toString());
    }

}
