package com.studenttest.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.student.model.Student;
import com.student.service.StudentLocalService;
import com.student.service.StudentLocalServiceUtil;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + StudenttestPortletKeys.STUDENTTEST,
	       "mvc.command.name=addstudentaction"
	    },
	    service = MVCActionCommand.class
)
public class AddActionController implements MVCActionCommand{
	
	@Reference
	private StudentLocalService studentLocalService;

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		// TODO Auto-generated method stub
		
		System.out.println("in action addd ");
		
		

		//long empid = ParamUtil.getLong(actionRequest, "empid");
		String name =ParamUtil.getString(actionRequest,"name");
		String email =ParamUtil.getString(actionRequest,"email");

		String education =ParamUtil.getString(actionRequest,"education");
		
		try {
			long studentId = CounterLocalServiceUtil.increment(Student.class.getName());
			Student student=studentLocalService.createStudent(studentId);
			student.setName(name);
			student.setEmail(email);
			student.setEducation(education);
			
			System.out.println("saving object in database ");
			studentLocalService.addStudent(student);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	
	}
	
	
	

}
