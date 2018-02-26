package com.biz.std.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.biz.std.model.StudentInformation;
import com.biz.std.repository.StudentInformationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public class StudentInformationRepositoryTest {
	 private ApplicationContext ctx=null;
	 private StudentInformationRepository studentInformationRepository=null;
	    @Before
	    public void step(){
	        ctx=new ClassPathXmlApplicationContext("spring-mybatis.xml");
			studentInformationRepository=ctx.getBean(StudentInformationRepository.class);
	        System.out.println("step");
	    }
	    @After
	    public  void tearDown(){
	        ctx=null;
	        System.out.println("tearDown");
	    }
	    @Test
	    public void testFindByName(){
	    	StudentInformation studentInformation =studentInformationRepository.findByName("lan");
	    	System.out.println(studentInformation);
	    }
	@Test
	public void testgetGradeByMaxId(){
		StudentInformation studentInformation =studentInformationRepository.getGradeByMaxId();
		System.out.println(studentInformation);
	}
	@Test
	public  void  testSave(){
		StudentInformation studentInformation =new StudentInformation(1,"兰","nan",new Date(),1.1,"touxiang","大班");
		studentInformationRepository.save(studentInformation);
	}
	@Test
	public void testFindByPage(){
		Pageable pageable=new PageRequest(0,10);
		Page<StudentInformation> page1=studentInformationRepository.findAll(pageable);
		System.out.println(page1);
		List<StudentInformation> list =page1.getContent();
		System.out.println(list);
		for(StudentInformation studentInformation :list){
			System.out.println("!@@@@"+studentInformation);
		}
	}

}
