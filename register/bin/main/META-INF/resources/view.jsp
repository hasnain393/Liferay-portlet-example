<%@ include file="./init.jsp" %>
<portlet:actionURL name="regdetails" var="detailsSubmit" />
<aui:form action="${detailsSubmit}" method="post"> 
<aui:fieldset-group markupView="lexicon">
  <div class="personal-info-wrapper">
 <aui:fieldset label="Personal Information"> 
 <aui:row>
<aui:col width="50">
<liferay-ui:error key="empty-name"  message="Customer name should not be empty"/>
<aui:input type="text" name="name" label=" Name:" >
<aui:validator name="required"></aui:validator>
 <aui:validator name="alphanum"></aui:validator>
 <aui:validator name="maxLength">100</aui:validator>
</aui:input>
</aui:col>
<aui:col width="50">
<liferay-ui:error key="empty-surname"  message="Customer surname should not be empty"/>
<aui:input type="text" name="surname" label="Surname"  >
<aui:validator name="required"></aui:validator>
 <aui:validator name="alphanum"></aui:validator>
 <aui:validator name="maxLength">150</aui:validator>
</aui:input>
</aui:col>
</aui:row>

 <aui:row>
<aui:col width="50">
<liferay-ui:error key="empty-documenttype"  message="Customer documenttype should not be empty"/>
<aui:input type="text" name="DocumentType" label="Document Type"  >
<aui:validator name="alphanum"></aui:validator>
 <aui:validator name="maxLength">50</aui:validator>
</aui:input>
</aui:col>

<aui:col width="50">
<liferay-ui:error key="empty--personalid"  message="Customer personal id should not be empty"/>
<aui:input type="text" name="PersonalId" label="Personal ID"  >
<aui:validator name="alphanum"></aui:validator>
 <aui:validator name="maxLength">100</aui:validator>
</aui:input>
</aui:col>
</aui:row>


<aui:row>
<aui:col width="50">
<%-- <liferay-ui:error key="empty-date"  message="Customer date should not be empty"/>
<liferay-ui:error key="empty-dateformat"  message="Customer date format should not be empty"/> --%>
<%-- <aui:input name="date" value=""  label="Date of Birth" placeholder="dd/mm/yyyy"> --%>
<%--  <liferay-ui:input-date formName="date" yearRangeStart="1970"
            yearRangeEnd="2100" yearValue="2010" monthValue="3" dayValue="21"
            dayParam="d1" monthParam="m1" yearParam="y1" /> --%>
            <!--Date picker code-->

<!-- Custom DatePicker -->
<aui:input type="text" name="datepicker" id="datepicker" placeholder="dd/mm/yyyy" />

<aui:script>
AUI().use('aui-datepicker', function(A) {
new A.DatePicker({
trigger : '#<portlet:namespace/>datepicker', 
mask: '%d/%m/%y',
popover : {
zIndex : 1
}
});
});


var uploadSize=true;
function checkUploadFileSize(fileInput)
{    
    var size=0;
    for(var num1=0;num1<fileInput.files.length;num1++)
    {
          var file=fileInput.files[num1];
          if(file.size>1000000)//  For 5 mb 5242880
          {
        	  alert("File size should not be more than 1Mb")
        	  
            uploadSize=false;
        	  $("#<portlet:namespace />customfile").val('');
          }else{
               uploadSize=true;
               
                var reader = new FileReader();
          	 reader.onload = function()
          	 {
          	  var output = document.getElementById('output_image');
          	  output.src = reader.result;
          	 }
          	 reader.readAsDataURL(event.target.files[0]); 
          }
          size+=file.size;
    }
    
    
   
}    

</aui:script>

	
            
<%--  <aui:validator name="date"></aui:validator>
 <aui:validator name="required"></aui:validator> --%>
</aui:col>

<aui:col width="50">
<liferay-ui:error key="empty-phone"  message="Customer phone should not be empty"/>
<aui:input name="phoneNumber" value=""  label="Phone Number">
 <aui:validator name="digits"></aui:validator>
 <aui:validator name="maxLength">15</aui:validator>
</aui:input>
</aui:col>
</aui:row>
<aui:row>
<aui:col width="50">
<liferay-ui:error key="empty-mail"  message="Customer mail should not be empty"/>
<aui:input name="email" value="" label="Email" >
 <aui:validator name="email"/>
 <aui:validator name="required"></aui:validator>
  <aui:validator name="maxLength">100</aui:validator>
</aui:input>
</aui:col>
<aui:col width="50">
<liferay-ui:error key="empty-gender"  message="Customer gender should not be empty"/>
<aui:field-wrapper>
<label class="radio-label" >Gender</label>
<aui:input  label="Male" name="gender" type="radio" value="male"  checked="true" cssClass="radio-input">
<aui:validator name="required"></aui:validator></aui:input>
<aui:input label="Female" name="gender" type="radio" value="female" cssClass="radio-input"/>
</aui:field-wrapper>
</aui:col>
</aui:row>
</aui:fieldset>
</div>
<div class="other-info-wrapper">
<aui:fieldset label="Other Information"> 
<aui:row>
<aui:col width="33">
<liferay-ui:error key="empty-egelibleConcession"  message="Customer Elegible Concession should not be empty"/>
<aui:field-wrapper>
<label class="radio-label">Eligible Concession</label>
<aui:input  label="Yes" name="elegibleConcession" type="radio" value="true"  checked="true" cssClass="radio-input">
<aui:validator name="required"></aui:validator></aui:input>
<aui:input label="No" name="elegibleConcession" type="radio" value="false" cssClass="radio-input" />
</aui:field-wrapper>
</aui:col>
<aui:col width="33">
<liferay-ui:error key="empty-reseller"  message="Customer Reseller should not be empty"/>
<aui:field-wrapper>
<label class="radio-label">Reseller</label>
<aui:input  label="Yes" name="reseller" type="radio" value="true"  checked="true" cssClass="radio-input">
<aui:validator name="required"></aui:validator></aui:input> 
<aui:input label="No" name="reseller" type="radio" value="false" cssClass="radio-input" />
</aui:field-wrapper>
</aui:col>
<aui:col width="33">
<liferay-ui:error key="empty-locale"  message="Customer locales should not be empty"/>
<aui:select name="Locale">
    <aui:option value="en-GB">English</aui:option>
    <aui:option value="ar-SA">Arabic</aui:option>
    <aui:option value="ur">Urdu</aui:option>
</aui:select>
</aui:col>
</aui:row>
 <aui:row id="tableRow" cssClass="mt-20">
				   <div class="col-md-2">
					<aui-label for="namee" style="padding:-0.7%">FileName</aui-label><br>
					<p style="color: #C67;font-size: 12px; padding-left: 0px;">(accept .png/jpeg format only)</p>
					
					</div>
					<div class="col-md-4">
						<aui:input name="sampleFile" onchange="checkUploadFileSize(this)" type="file" accept=".jpg,.png,.jpeg" value=" " label=" " style="font-family: Verdana,Geneva,sans-serif;width: 100%;color:black;font-size:14px;padding-left: 0%;" id="customfile">
						<aui:validator name="acceptFiles" errorMessage="File format should be .jpg,.png,.jpeg only">'jpg,png,jpeg'</aui:validator>
						<aui:validator name="required" errorMessage="FileName is Required"></aui:validator>
						
		                             
						</aui:input>
					
					   </div>
					<div class="col-md-2">
					<aui-label for="namee" style="padding:1.3%">Preview</aui-label>
					</div>
					
					
					<img Id="output_image" style=" display: inline-block; margin-left: 24%"/>
					
					</aui:row>

</aui:fieldset>
</div>
<div class="reg-btn-wrapper">
	<aui:button type="submit" value="SUBMIT" cssClass="btn-register"/>
</div>
</aui:fieldset-group>
</aui:form>