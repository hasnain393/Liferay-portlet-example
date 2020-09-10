package com.studenttest.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.model.Student;
import com.student.service.StudentLocalServiceUtil;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
	     immediate = true,
	     property = {
	         "javax.portlet.name=" + StudenttestPortletKeys.STUDENTTEST,
	         "mvc.command.name=editAction"
	     },
	     service = MVCActionCommand.class
	 )
	 public class EditActionController implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		
		String name =ParamUtil.getString(actionRequest,"name");
		String email =ParamUtil.getString(actionRequest,"email");
		String education =ParamUtil.getString(actionRequest,"education");
		System.out.println("inside edit action controller ");
		try {
			
			
			Student student=StudentLocalServiceUtil.fetchStudent(studentId);
			student.setName(name);
			student.setEmail(email);
			student.setEducation(education);
			
			StudentLocalServiceUtil.updateStudent(student);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
		
	}

	
}
	    