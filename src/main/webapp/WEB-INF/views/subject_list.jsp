<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<
<head>
    <title>list</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20 <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">学生管理系统</a>
                </h1>
            </div>
            <div id="navigation"></div>
        </div>
        <div id="content">
            <p id="whereami"></p>
            <h1>学生列表</h1>
            <table class="table">
                <tr class="table_header">
                    <td>序号</td>
                    <td>学科名</td>
                    <td>选修人数</td>
                    <td>平均分</td>
                    <td>学生操作</td>
                    <td>管理操作</td>
                </tr>
                <c:forEach var="subject" items="${subjectList}" varStatus="stu">
                    <tr class="row${stu.index%2+1}">
                        <td>${subject.number}</td>
                        <td>${subject.subjectName}</td>
                        <td>${subject.studyPeople}</td>
                        <td>${subject.subjectAvg}</td>
                        <td><a href="selectSubject.do?subjectName=${subject.subjectName}&stuNumber=${stuNumber}">选修该课程</a></td>
                        <td>修改&nbsp;
                            删除</td>
                    </tr>
                </c:forEach>
            </table>
            <p>
                <input type="button" class="button" value="添加学科"
                       />
                <fmt:parseNumber var="i" type="number" value="${page}" />
                上一页
                下一页
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">jian.lan@qq.com</div>
    </div>
</div>
</body>
</html>