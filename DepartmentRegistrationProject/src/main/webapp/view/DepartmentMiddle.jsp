

<jsp:useBean id="deptIn" class="com.java.demo.bo.DepartmentDO"
	scope="request"></jsp:useBean>
<jsp:setProperty property="deptId" name="deptIn" />
<jsp:setProperty property="deptName" name="deptIn" />
<jsp:setProperty property="mgrId" name="deptIn" />
<jsp:setProperty property="locId" name="deptIn" />
<jsp:forward page="../DepartmentProcessor"></jsp:forward>