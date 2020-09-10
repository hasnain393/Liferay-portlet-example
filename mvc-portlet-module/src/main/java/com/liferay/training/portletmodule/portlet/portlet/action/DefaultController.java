package com.liferay.training.portletmodule.portlet.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.portletmodule.portlet.constants.SimpleMVCPortletKeys;

import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	    		"javax.portlet.name=" + SimpleMVCPortletKeys.SIMPLEMVC,
	       "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
)
public class DefaultController implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("iin default controller");
		String username ="hasnian ahmed shaikh";
		 renderRequest.setAttribute("name", username);
		return "/view.jsp";
	}

}

