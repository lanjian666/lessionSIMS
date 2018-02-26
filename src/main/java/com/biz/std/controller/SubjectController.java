package com.biz.std.controller;

import com.biz.std.model.SelectClass;
import com.biz.std.model.Subject;
import com.biz.std.service.SubjectManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SubjectController {
    @Resource
    private SubjectManager subjectManager;
    @RequestMapping(value = "/subject_list.do")
    public  String subjectList(HttpServletRequest request){
        String numberStr=request.getParameter("number");
        int number=Integer.valueOf(numberStr);
        List<Subject> list = subjectManager.findSubject();
        request.setAttribute("subjectList",list);
        request.setAttribute("stuNumber",number);
        return "subject_list";
    }
    @RequestMapping(value = "/selectSubject.do")
    public  String selectSubject(HttpServletRequest request){
        String numberStr=request.getParameter("stuNumber");
        int stuNumber=Integer.valueOf(numberStr);
        String subjectName=request.getParameter("subjectName");
        String subjectAndNumber=subjectName+stuNumber;
        SelectClass selectClass=new SelectClass(subjectName,stuNumber,subjectAndNumber);
        subjectManager.saveSelectClass(selectClass);
        return  "forward:list.do";
    }
}
