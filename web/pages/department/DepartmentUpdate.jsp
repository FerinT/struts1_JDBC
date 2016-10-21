<%--
  Created by IntelliJ IDEA.
  User: tayfer01
  Date: 10/21/2016
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Department</title>
</head>
<body>

    <%-- populate the drop dowm on page load with department ids --%>
   <html:form action="/departmentInformation">
        <html:select property="departmentNumber">
            <option value="" disabled selected>Please select a department number...</option>
            <logic:iterate id="department" name="departmentformList" property="departmentList">
                <bean:define id="deptNum" name="department" property="departmentNumber"/>
                 <html:option value="${deptNum}"> </html:option>
            </logic:iterate>
        </html:select>
       <html:submit value="Edit this department" />
   </html:form>


    <%-- displays only when department number is selcted --%>
    <logic:notEmpty name="departmentInformation" property="departmentName">
        <html:form action="/departmentUpdate">

            <bean:define id="deptName" name="departmentInformation" property="departmentName"/>
            <bean:define id="location" name="departmentInformation" property="location"/>
            <bean:define id="deptId" name="departmentInformation" property="departmentNumber"/>

            Department Number: <html:text property="departmentNumber" value="${deptId}" readonly="true"/> </br>
            Department Name: <html:text property="departmentName" value="${deptName}"/> </br>
            Location: <html:text property="location" value="${location}"/> </br>

            <html:submit value="Save Changes" />

        </html:form>
    </logic:notEmpty>

</body>
</html>
