<%@ include file="./init.jsp" %>

<p>
	<h2>Welcome to Student Management System</h2>
</p>

<portlet:renderURL var="studentAddURL" >
  <portlet:param name="mvcRenderCommandName" value="addrender" /> 
 
 <%--  <portlet:param name="mvcPath" value="/addform.jsp"></portlet:param> --%>
  </portlet:renderURL>





<aui:button type="submit" cssClass="btn btn-primary" value="ADD STUDENT" onClick="${studentAddURL}" />



<liferay-ui:search-container  searchContainer="${searchContainer}">
 <liferay-ui:search-container-results results="${searchContainer.results}" />
 
  <liferay-ui:search-container-row className="com.student.model.Student" modelVar="student" keyProperty="studentId" >
   <liferay-ui:search-container-column-text name="Student Id" property="studentId" />
   <liferay-ui:search-container-column-text name="Student Name" property="name" />
   <liferay-ui:search-container-column-text name="Student email" property="email" />
  <liferay-ui:search-container-column-text name="Stduent Education" property="education" />
  <liferay-ui:search-container-column-jsp name="Actions"
  path="/student/actiontab.jsp" />
  </liferay-ui:search-container-row>
  
  
 <liferay-ui:search-iterator />

</liferay-ui:search-container>