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
        Map map=new HashMap();
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String headPortrait=null;

        // 在解析请求之前先判断请求类型是否为文件上传类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String status = "not OK";
        // 文件上传处理工厂
        FileItemFactory factory = new DiskFileItemFactory();
        // 创建文件上传处理器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置编码，获取的FileItem时，还需要转码,(经测试只需在获取时设置就行）
        //upload.setHeaderEncoding("utf-8");
        // 开始解析请求信息
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        // 对所有请求信息进行判断
        Iterator iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            // 信息为普通的格式
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                logger.info("转码前文件名"+item.getString());
                //获取的FileItem执行如下转码方式
                String value = null;
                try {
                    value = item.getString("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                logger.info("转码后文件名"+value);
                map.put(fieldName,value);
            }

            // 信息为文件格式
            else if(item.getName().length()>0){
                String fileName = item.getName();
                InputStream inputStream = null;
                try {
                    inputStream = item.getInputStream();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 将文件写入
                String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
                // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
                // ht tps://ram.console.aliyun.com 创建
                String accessKeyId = "LTAIvTthEd7SfAPh";
                String accessKeySecret = "1MbHX744NDwFfW7yEptCEvurdGgq73";
                // 创建OSSClient实例
                OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
                // 上传文件
                headPortrait=fileName;
                ossClient.putObject("lanjian666", headPortrait, inputStream);
                // 关闭client
                ossClient.shutdown();
            }
        }
        studentInformation.setStudentID(Integer.valueOf((String)(map.get("studentID"))));
        studentInformation.setName((String)map.get("name"));
        studentInformation.setAvg(Double.valueOf((String)(map.get("avg"))));
        studentInformation.setGender((String)(map.get("gender")));

        OSSClientUtil ossClientUtil=new OSSClientUtil();
        String url = ossClientUtil.getImgUrl(headPortrait);
        studentInformation.setHeadPortrait(url);

        studentInformation.setGrade((String)(map.get("grade")));
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        try {
            studentInformation.setBirthday(sdf.parse((String)map.get("birthday")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        System.out.println("-------------"+studentInformation1.getNumber());
        studentManager.updateMysqlStudent(studentInformation1);
        return "forward:list.do";
    }

}