package com.studenttest.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.studenttest.constants.StudenttestPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + StudenttestPortletKeys.STUDENTTEST,
	       "mvc.command.name=addrender"
	    },
	    service = MVCRenderCommand.class
)
public class AddRenderController implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		System.out.println("///////////////////////AAAADDDDDDD///////////////////");
		
		return "/addform.jsp";
	}


	
	

}
