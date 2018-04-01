<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="deptOut" class="com.java.demo.bo.DepartmentDO"
	scope="request"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">DepartmentOutput</h1>
	<div align="center">
		<label>DepartmentName:</label><jsp:getProperty property="deptName"
			name="deptOut" /><br> <label>DepartmentId:</label><jsp:getProperty
			property="deptId" name="deptOut" /><br> <label>managerId:</label><jsp:getProperty
			property="mgrId" name="deptOut" /><br> <label>locationId:</label><jsp:getProperty
			property="locId" name="deptOut" /><br> <a
			href="Edit.jsp">Edit Department  </a> 
			 <a
			href="Home.jsp">New Employee</a>
	</div>

</body>
</html>