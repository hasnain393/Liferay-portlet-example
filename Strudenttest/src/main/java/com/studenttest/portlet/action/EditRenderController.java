package com.studenttest.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.model.Student;
import com.student.service.StudentLocalServiceUtil;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	     immediate = true,
	     property = {
	         "javax.portlet.name=" + StudenttestPortletKeys.STUDENTTEST,
	         "mvc.command.name=editrender"
	     },
	     service = MVCRenderCommand.class
	 )
	 public class EditRenderController implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		 Student student = null;
		long studentId= ParamUtil.getLong(renderRequest, "studentId");
		System.out.println("edit render controlller =======================+++++++++++++++++++++++++++++++++");
	    System.out.println(studentId+"=========================================================>");

	    try {

	        // Call service to delete the assignment.
	    	student =StudentLocalServiceUtil.getStudent(studentId);

	}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    renderRequest.setAttribute("student", student);
        renderRequest.setAttribute("studentClass",Student.class);
		return "/editstudent.jsp";
	}
	
	
}
	    