package com.studenttest.portlet.action;




import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.StringPool;
import com.student.model.Student;
import com.student.service.StudentLocalService;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + StudenttestPortletKeys.STUDENTTEST,
	       "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
)
public class DefaultController implements MVCRenderCommand{
	
	@Reference
	private StudentLocalService studentLocalService;
	
	


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("---------------------111111111111hello is STUDENT DEFAULT CONTROLLER ------------------");
		
	
		PortletURL iteratorURL = renderResponse.createRenderURL();
		SearchContainer<Student> searchContainer = new SearchContainer<Student>(renderRequest, null, null, "view_employee_detail", SearchContainer.DEFAULT_DELTA, iteratorURL, null, StringPool.BLANK);
		searchContainer.setEmptyResultsMessage("No Data Found");        
		searchContainer.setResults(studentLocalService.getStudents(searchContainer.getStart(), searchContainer.getEnd()));
		searchContainer.setTotal(studentLocalService.getStudentsCount());
		renderRequest.setAttribute("searchContainer", searchContainer);
		System.out.println("Test"+ studentLocalService.getStudentsCount());
		
		
		return "/view.jsp";
	
	}

}

