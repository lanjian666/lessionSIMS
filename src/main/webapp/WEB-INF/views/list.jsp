<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
						<td>学号</td>
						<td>姓名</td>
						<td>头像</td>
						<td>生日</td>
						<td>性别</td>
						<td>班级</td>
						<td>选修科目数</td>
						<td>平均分</td>
						<td>操作</td>
					</tr>
					<c:forEach var="student" items="${list}" varStatus="stu">
						<tr class="row${stu.index%2+1}">
							<td>${student.studentID}</td>
							<td>${student.name}</td>
							<td><img src="${student.headPortrait}" width="50" height="50 "> </td>
							<td><fmt:formatDate value="${student.birthday}" pattern="yyyy-MM-dd"/></td>
							<td>${student.gender}</td>
							<td>${student.grade}</td>
							<td>${student.subjectNumber}</td>
							<td>${student.avg}</td>
							<td>
								<a href="subject_list.do?number=${student.number}">选课</a>&nbsp;
								<a href="stuDel.do?number=${student.number}">删除</a>&nbsp;
								<a href="stuUpdate.do?number=${student.number}">修改</a></td>
						</tr>
					</c:forEach>
				</table>
				<p>
					<input type="button" class="button" value="添加学生"
						onclick="location='add.do'" />
					<fmt:parseNumber var="i" type="number" value="${page}" />
					<a href="list.do?page=${i-1}">上一页</a>
					<a href="list.do?page=${i+1}">下一页</a>
					当前第${page+1}页
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">jian.lan@qq.com</div>
		</div>
	</div>
</body>
</html>