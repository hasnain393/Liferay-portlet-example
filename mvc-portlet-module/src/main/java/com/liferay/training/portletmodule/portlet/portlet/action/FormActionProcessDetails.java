package com.liferay.training.portletmodule.portlet.portlet.action;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.training.portletmodule.portlet.constants.SimpleMVCPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SimpleMVCPortletKeys.SIMPLEMVC,
        "mvc.command.name=handleForm"
    },
    service = MVCActionCommand.class
)
public class FormActionProcessDetails implements MVCActionCommand {
    @Override
    public boolean processAction(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws PortletException {

        _handleActionCommand(actionRequest);

        return true;
    }

    private void _handleActionCommand(ActionRequest actionRequest) {

        System.out.println("HandleFormMVCActionCommand.doProcessAction()");
        String companyname="larsen and turbro lti";
        actionRequest.setAttribute("company", companyname);

        String backgroundColor = actionRequest.getParameter("bg");

        System.out.println("backgroundColor = " + backgroundColor);

    }
}