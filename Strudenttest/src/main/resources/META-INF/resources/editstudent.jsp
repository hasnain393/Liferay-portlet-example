
<%@ include file="./init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@page import="com.student.model.Student"%>

<portlet:actionURL var="EditActionURL" name="editAction">
         </portlet:actionURL>

<div class="container-fluid-1280 ">

 <aui:model-context bean="${student}" model="${studentClass}" />
 
  <aui:form action="${EditActionURL}" name="fm">

         <aui:input name="studentId" field="studentId" type="hidden" />

         <aui:fieldset-group markupView="lexicon">

             <aui:fieldset>

                 <%-- Title field. --%>

                 <aui:input name="name">
                 <aui:validator name="required" />
				 </aui:input>

                 <%-- Description field. --%>

                 <aui:input name="email">
                     <aui:validator name="required" />
                 </aui:input>

                 <%-- Due date field. --%>

                 <aui:input name="education">
                     <aui:validator name="required" />
                 </aui:input>
             </aui:fieldset>
         </aui:fieldset-group>

         <%--Buttons. --%>

         <aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
           
         </aui:button-row>
     </aui:form>

 </div>