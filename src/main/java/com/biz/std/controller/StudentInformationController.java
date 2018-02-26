package com.biz.std.controller;

import com.aliyun.oss.OSSClient;
import com.biz.std.model.StudentInformation;
import com.biz.std.service.StudentManager;
import com.biz.std.util.OSSClientUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StudentInformationController {
    private static final Logger logger = LogManager.getLogger(StudentManager.class.getName());
    @Resource
    private StudentManager studentManager;
    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public String index() {
        return "add";
    }
    @RequestMapping(value = "/list.do")
    public String listStu(HttpServletRequest request) {
        String pageStr=request.getParameter("page");
        if (pageStr==null){
            pageStr="0";
        }
        int page=Integer.valueOf(pageStr);
        if (page<0){
            page=0;
        }
        List<StudentInformation> list=studentManager.findByPage(page);
        if (list.isEmpty()) {
            page=page-1;
            list=studentManager.findByPage(page);
        }
        request.setAttribute("list",list);
        System.out.println(page);
        request.setAttribute("page",page);
        return "list";
    }
    @RequestMapping(value = "/addStu.do", method = RequestMethod.POST)
    public String addStu(HttpServletRequest request, HttpServletResponse response,StudentInformation studentInformation) {
        studentInformation=OSSClientUtil.getStudentInformation(request,studentInformation);
        studentManager.saveStudent(studentInformation);
        return "forward:list.do";
    }
    @RequestMapping(value = "/stuDel.do")
    public  String delStu(HttpServletRequest request){
        String numberStr=request.getParameter("number");
        int number=Integer.valueOf(numberStr);
        studentManager.byNumberDelStu(number);
        return "forward:list.do";
    }
    @RequestMapping(value = "/stuUpdate.do")
    public String updateStu(HttpServletRequest request){
        String numberStr=request.getParameter("number");
        int number=Integer.valueOf(numberStr);
        StudentInformation studentInformation=studentManager.findByNumber(number);
        request.setAttribute("student",studentInformation);
        return  "update";
    }
    @RequestMapping(value = "/updateStu.do")
    public  String toMysqlUpdate(HttpServletRequest request,StudentInformation studentInformation){
        StudentInformation studentInformation1=OSSClientUtil.getStudentInformation(request,studentInformation);
        studentManager.updateMysqlStudent(studentInformation1);
        return "forward:list.do";
    }

}