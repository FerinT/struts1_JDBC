<%--
  Created by IntelliJ IDEA.
  User: tayfer01
  Date: 10/18/2016
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <html:form action="/departmentform">
        Department Number: <html:text property="departmentNumber"/></br>
        Department Name: <html:text property="departmentName"/></br>
        Location: <html:text property="location"/> </br>
        <html:submit value="Add Department" />
    </html:form>

</body>
</html>
