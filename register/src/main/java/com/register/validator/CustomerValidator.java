package com.register.validator;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.register.bean.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;

public class CustomerValidator {
	


	
public boolean validateCustomer(ActionRequest request, Customer customer) {
		
		boolean valid = Boolean.TRUE;
		
		 SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		    sdfrmt.setLenient(false);
		    String strDate1=customer.getDateOfBirth();
		      String strDate=strDate1.trim();
		
		if(Validator.isNull(customer.getName())) {
			valid=Boolean.FALSE;
			System.out.println("Customer Name should not be null");
			SessionErrors.add(request,"empty-name");
		}
		
		if(Validator.isNull(customer.getSurname())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-surname");
		}
		
		if(Validator.isNull(customer.getGender())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-gender");
		}
		
		if(Validator.isNull(customer.getDocumentType())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-documenttype");
			
		}
		
		if(Validator.isNull(customer.getPersonalId())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-personalid");
		}
		
		if(Validator.isNull(customer.getDateOfBirth())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-date");
		}
		if(Validator.isNull(customer.getPhone())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-phone");
		}
		if(Validator.isNull(customer.getMail())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-mail");
		}
		
		if(Validator.isNull(customer.getElegibleConcession())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-egelibleConcession");
		}
		if(Validator.isNull(customer.getReseller())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-reseller");
		}
		if(Validator.isNull(customer.getLocale())) {
			valid=Boolean.FALSE;
			SessionErrors.add(request,"empty-locale");
		}
		
		
		try
	    {
			
	        Date javaDate = sdfrmt.parse(strDate); 
	        System.out.println(strDate+" is valid date format");
	    }
	    /* Date format is invalid */
	    catch (ParseException e)
	    {
	        System.out.println(strDate+" is Invalid Date format");
	        valid=Boolean.FALSE;
	        SessionErrors.add(request,"empty-dateformat");
	    }
		
		
		
		
		return valid;
	}
}





	