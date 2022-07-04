<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save" method="post">
	<table>
		<c:choose>
    		<c:when test="${stud.studId == 0}">
       			<tr style="display:none;"><td>Student ID : </td><td><input type="text" value="${stud.studId}" name="studId" readonly/></td></tr>
  			</c:when>
   			<c:otherwise>
        		<tr><td>Student ID : </td><td><input type="text" value="${stud.studId}" name="studId" readonly/></td></tr>
    		</c:otherwise>      
		</c:choose>
		
		<tr><td>First Name : </td><td><input type="text" value="${stud.firstName}" name="fName"/></td></tr>
		<tr><td>Last Name : </td><td><input type="text" value="${stud.lastName}" name="lName"/></td></tr>
		<tr><td>Country : </td><td><input type="text" value="${stud.country}" name="country"/></td></tr>
		<tr><td colspan="2"><input type="submit"></td></tr>
		
	</table>
</form>
</body>
</html>