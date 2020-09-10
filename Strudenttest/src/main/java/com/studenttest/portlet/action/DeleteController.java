package com.studenttest.portlet.action;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.service.StudentLocalServiceUtil;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
	     immediate = true,
	     property = {
	         "javax.portlet.name=" +  StudenttestPortletKeys.STUDENTTEST,
	         "mvc.command.name=delete"
	     },
	     service = MVCActionCommand.class
	 )
	 public class DeleteController implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		
		long studentId= ParamUtil.getLong(actionRequest, "studentId");
	    System.out.println(studentId+"=========================================================>");

	    try {

	        // Call service to delete the assignment.

	        StudentLocalServiceUtil.deleteStudent(studentId);

	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
		return true;
	}
}
	    