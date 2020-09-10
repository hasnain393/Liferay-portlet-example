package com.fileupload.portlet.action;


import com.fileupload.constants.FileuploadPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + FileuploadPortletKeys.FILEUPLOAD,
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
