<%@ include file="./init.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<h2>in add form jsp</h2>
<portlet:actionURL name="addstudentaction" var="detailsSubmit" />




<aui:form action="${detailsSubmit}" method="post">



<aui:input type="text" name="name" label="Student Name:" />

<aui:input type="email" name="email" label="Student email:"  placeholder="enter email"  />


<aui:input type="text" name="education" label="Student education:"  />

<aui:button type="submit" value="SUBMIT" />

</aui:form>
</body>
</html>