<%--
  Created by IntelliJ IDEA.
  User: tayfer01
  Date: 10/19/2016
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body >

<table style="background-color: gainsboro; border: 1px solid black" >

    <tr style="border: 1px solid black">
        <th> Department Name </th>
        <th> location </th>
    </tr>

    <logic:iterate id="department" name="departmentformList" property="departmentList">
        <tr style="border: 1px solid black">
            <td style="border: 1px solid black"> <bean:write name="department" property="departmentName"/> </td>
            <td style="border: 1px solid black"> <bean:write name="department" property="location"/> </td>
        </tr>
    </logic:iterate>

</table>


</body>
</html>
