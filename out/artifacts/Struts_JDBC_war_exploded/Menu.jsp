<%--
  Created by IntelliJ IDEA.
  User: tayfer01
  Date: 10/18/2016
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Struts JDBC</title>
</head>
<body>

<p><button onclick="window.open('pages/department/Department.jsp',null,'height=600,width=400,status=yes,toolbar=no,menubar=no,location=no')"> Add a Department </button></p>
<p><button onclick="window.open('/departmentformList.do',null,'height=600,width=800,status=yes,toolbar=no,menubar=no,location=no')"> View all Departments </button></p>
<p><button onclick="window.open('/departmentNumberList.do',null,'height=600,width=400,status=yes,toolbar=no,menubar=no,location=no')"> Update a Department </button></p>
</body>
</html>
