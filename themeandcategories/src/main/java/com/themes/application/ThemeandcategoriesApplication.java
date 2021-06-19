package com.themes.application;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFolderService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.omg.CORBA.RepositoryIdHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author 10664322
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/themesandcategoreis",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Greetings.Rest"
	},
	service = Application.class
)
public class ThemeandcategoriesApplication extends Application {
	
	@Reference
	private DLAppService dlAppService;
	
	@Reference
	private DLFolderService dlFOLDERsERVICE;
	
	
	



	
	
	
	@GET
	@Path("/getallfiles")
	@Produces("text/plain")
	public Response getAllFiles() {
		try {
			
			DLFolder folder = dlFOLDERsERVICE.getFolder(20124, 0L, "ThemeandCategories");
			List<FileEntry> fileEntries = dlAppService.getFileEntries(folder.getRepositoryId(), folder.getFolderId());
			List<ThemesandCategoriesObj> responseObj = new ArrayList<ThemesandCategoriesObj>();
			fileEntries.forEach(file -> {
				ThemesandCategoriesObj obj = new ThemesandCategoriesObj();
				obj.setFileName(file.getFileName());
				obj.setFilePath("//documents"+"//"+file.getGroupId()+"//"+file.getFolderId()+"//"+file.getTitle()+"//"+file.getUuid());
				responseObj.add(obj);
			});
			String json = JSONFactoryUtil.looseSerializeDeep(responseObj);
		//throw new PortalException();
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error").build();
		}
		
	}
	
	
	@GET
	@Path("/getallfiles")
	@Produces("text/plain")
	public String getAllBlogs() {
		return "";
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	
	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/morning/{name}")
	@Produces("text/plain")
	public String morning(
		@PathParam("name") String name,
		@QueryParam("drink") String drink) {

		String greeting = "Good Morning " + name;

		if (drink != null) {
			greeting += ". Would you like some " + drink + "?";
		}

		return greeting;
	}

}