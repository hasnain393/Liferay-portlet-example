package com.register.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.register.constants.RegisterPortletKeys;

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
	       "javax.portlet.name=" + RegisterPortletKeys.REGISTER,
	       "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
)
public class DefaultController implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// TODO Auto-generated method stub
		System.out.println("iin default controller");
		return "/view.jsp";
	}

}
