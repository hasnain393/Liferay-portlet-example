package com.fileupload.portlet.action;

import com.fileupload.constants.FileuploadPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;	

/**
 * @author 10664322
 */
@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + FileuploadPortletKeys.FILEUPLOAD,
	       "mvc.command.name=filedetails"
	    },
	    service = MVCActionCommand.class
)

public class ProcessFile implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		System.out.println("file upload details ");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest); 
	       
	        File file = uploadPortletRequest.getFile("sampleFile");
	       
	        System.out.println("file"+file);
	        String path=file.toString();
	        String base64ImageString= encoder(path);
	       
	        
	        System.out.println("=================Encoder Image to Base 64!=================");
	        System.out.println("Base64ImageString = " + base64ImageString);
	        
	        
	        
	       
	         
	        
			 
			 if (!file.exists()) {
			   System.out.println("Empty File");
			}
         
     	return true;
     	}
	
	
	
	public static String encoder(String imagePath) {
	    String base64Image = "";
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	      // Reading a Image file from file system
	      byte imageData[] = new byte[(int) file.length()];
	      imageInFile.read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return base64Image;
	  }
	 

			         }
	        
	

	
	
		

	