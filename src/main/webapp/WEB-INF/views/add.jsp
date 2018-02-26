<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
    <head>
		<title>add</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>  
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <a href="list.do?page=0">学生列表</a>
                    <br />
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">添加学生</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                信息
            </h1>
            <form action="addStu.do" method="post" enctype="multipart/form-data">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                     <tr>
                        <td valign="middle" align="right">
                            学号:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="studentID" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            姓名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="name" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            姓别:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="gender" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            所在班级:
                        </td>
                        <td valign="middle" align="left">
                            <select name="grade"  value="${grade}">
                                <option value="0">-请选择-</option>
                                <option value="大班" <c:if test="${'1' eq grade}">selected</c:if> >大班</option>
                                <option value="小班" <c:if test="${'2' eq grade}">selected</c:if> >小班</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            出生日期:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" name="birthday" class="inputgri" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            头像上传:
                        </td>
                        <td valign="middle" align="left">
                            <input type="file" name="fileupload" value="头像上传" accept="image/*"><br>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            平均分:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="avg" />
                        </td>
                    </tr>

                </table>
                <p>
                    <input type="submit" class="button" value=" 提交 &raquo;" />
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
           jian.lan@qq.com
        </div>
    </div>
</div>
</body>
</html>
