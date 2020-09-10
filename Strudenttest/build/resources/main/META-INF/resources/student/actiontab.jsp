
<%@ include file="../init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.student.model.Student"%>


<% 

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Student student = (Student)row.getObject();
 String studId=String.valueOf(student.getStudentId());
 System.out.println(student.getStudentId());


%>

<%-- <portlet:renderURL var="addURL">
<portlet:param name="jspPage" value="/assignment/action.jsp" />
</portlet:renderURL>
<portlet:actionURL name="addEvent" var="addURL" />
<liferay-ui:icon-menu >
<liferay-ui:icon image="page" message="Add" url="${customer.getCustid()} "/>

<portlet:renderURL var="editURL">
<portlet:param name="jspPage" value="/assignment/action.jsp" />
<portlet:param name="evenetid" value="${customer.getCustid()}" />
<portlet:param name="evenetname" value="delete" />
</portlet:renderURL>

<portlet:actionURL name="delete" var="editURL" />
<liferay-ui:icon image="delete" message="Edit" url="${editURL}"/>

<liferay-ui:icon image="close" message="Delete" />
</liferay-ui:icon-menu> --%>
<%-- 
<liferay-ui:icon-menu> --%>

<%-- "${student.studentId}"
"<%String.valueOf(customer.getCustid())%>" 
"<%=currentURL %>"
"${custid}"

final
"<%=custid %>"
--%>


<portlet:renderURL var="editrenderURL">
	<portlet:param name="mvcRenderCommandName" value="editrender" />
	<portlet:param name="studentId" value="<%=studId %>" />
</portlet:renderURL>

<liferay-ui:icon image="edit" message="edit"
	url="<%=editrenderURL.toString()%>" />

<portlet:actionURL name="delete" var="edit">
	<portlet:param name="studentId" value="<%=studId %>" />
</portlet:actionURL>
<liferay-ui:icon image="delete" message="Delete"
	url="<%=edit.toString() %>" />


<%--     </liferay-ui:icon-menu> --%>