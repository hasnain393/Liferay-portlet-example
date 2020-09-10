
<%@ include file="./init.jsp" %>


<portlet:actionURL name="filedetails" var="imageSubmit" />



<aui:form action="${imageSubmit}" method="post">

 <aui:input type="file" name="sampleFile" />

<aui:button type="submit" value="SUBMIT" />

</aui:form>