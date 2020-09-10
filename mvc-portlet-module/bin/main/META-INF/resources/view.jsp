<%@page import="javax.portlet.ActionRequest"%>
<%@ include file="/init.jsp" %>

 <%
     String cssStyle = "";
 
 String com=(String)renderRequest.getAttribute("company");
 String fulname=(String)renderRequest.getAttribute("name");
 String bgColor = renderRequest.getParameter("bg");
     String backgroundColor = renderRequest.getParameter("backgroundColor");
     if (backgroundColor != null && !backgroundColor.isEmpty()) {
             cssStyle = "background-color: " + backgroundColor + ";";
     }
 %>

<%=com %>

<%=fulname %> 
<%=bgColor %>
 <div style="<%= cssStyle %>;">
     <p class="caption">
         <liferay-ui:message key="simplemvc.caption" />
     </p>
 </div>

 <portlet:renderURL var="viewRedURL">
     <portlet:param name="backgroundColor" value="red"/>
 </portlet:renderURL>
 <portlet:renderURL var="viewYellowURL">
     <portlet:param name="backgroundColor" value="yellow"/>
 </portlet:renderURL>
 
 

 <div class="btn-group">
     <a class="btn btn-default" href="<%= viewRedURL %>">Set red</a>
     <a class="btn btn-default" href="<%= viewYellowURL %>">Set yellow</a>
 
  </div>
 
 
 <portlet:actionURL name="handleForm" var="actionURL"/>

<aui:form action="<%= actionURL %>" style="margin-top: 2rem;">
    <aui:select name="bg">
        <aui:option label="aqua"/>
        <aui:option label="gray"/>
        <aui:option label="lime" />
        <aui:option label="olive" />
        <aui:option label="silver" />
    </aui:select>
    <aui:button-row>
        <aui:button type="submit" value="send"/>
    </aui:button-row>
</aui:form>