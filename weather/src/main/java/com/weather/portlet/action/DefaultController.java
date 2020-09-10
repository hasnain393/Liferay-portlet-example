package com.weather.portlet.action;





import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.weather.constants.WeatherPortletKeys;



import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + WeatherPortletKeys.WEATHER,
	       "mvc.command.name=/"
	    },
	    service = MVCRenderCommand.class
	)
	
public class DefaultController implements MVCRenderCommand {


	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		int number=7;
		renderRequest.setAttribute("aditi",number );
		System.out.println("in default controller");
		return "/view.jsp";
	}

}