package com.register.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.register.bean.Customer;
import com.register.constants.RegisterPortletKeys;
import com.register.validator.CustomerValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.osgi.service.component.annotations.Component;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author 10664322
 */
@Component(
		immediate = true,
		property = { 
		"javax.portlet.name=" + RegisterPortletKeys.REGISTER,
		"mvc.command.name=regdetails"
		},
		service = MVCActionCommand.class)

public class ProcessDetails implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
	
		Customer customer = getCustomer(actionRequest);
		CustomerValidator cv = new CustomerValidator();
		if (cv.validateCustomer(actionRequest, customer)) {

			try {
				System.out.println("file upload details ");
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

				File file = uploadPortletRequest.getFile("sampleFile");

				System.out.println("file" + file);
				String path = file.toString();
				String base64ImageString = encoder(path);

				System.out.println("=================Encoder Image to Base 64!=================");
				System.out.println("Base64ImageString = " + base64ImageString);

				if (!file.exists()) {
					System.out.println("Empty File");
				}

				String gender = ParamUtil.getString(actionRequest, "gender");
				String name = ParamUtil.getString(actionRequest, "name");
				String surname = ParamUtil.getString(actionRequest, "surname");
				String Locale = ParamUtil.getString(actionRequest, "Locale");
				String Elegible_Concession = ParamUtil.getString(actionRequest, "elegibleConcession");
				String Reseller = ParamUtil.getString(actionRequest, "reseller");

				String Pid = ParamUtil.getString(actionRequest, "PersonalId");
				String Dt = ParamUtil.getString(actionRequest, "DocumentType");

				String Email = ParamUtil.getString(actionRequest, "email");
				String Phone = ParamUtil.getString(actionRequest, "phoneNumber");
				String date = ParamUtil.getString(actionRequest, "datepicker");
				
				// CaseArchive caseC= new CaseArchiveImpl();

				/* String Dob=ParamUtil.getString(actionRequest,"date"); */
				/*
				 * String date=
				 * ParamUtil.getString(actionRequest,"d1")+"/"+ParamUtil.getString(actionRequest
				 * ,"m1") +"/"+ParamUtil.getString(actionRequest,"y1"); SimpleDateFormat
				 * formatter1 = new SimpleDateFormat("dd/MM/yyyy"); Date dateCase =
				 * formatter1.parse(date); System.out.println("date  ========"+dateCase);
				 */
				/* caseC.setDateCase(dateCase); */

				System.out.println("name=" + name);
				System.out.println("surname is " + surname);
				System.out.println("document type =" + Dt);
				System.out.println("personal id =" + Pid);
				System.out.println("Date of birth =" + date);
				System.out.println("phone =" + Phone);
				System.out.println("email =" + Email);
				System.out.println("Gender =" + gender);
				System.out.println("elegible =" + Elegible_Concession);
				System.out.println("resller is" + Reseller);
				System.out.println("loCALE IS=" + Locale);

				JSONObject DeviceData = JSONFactoryUtil.createJSONObject();
				DeviceData.put("type", "M_Portal");
				DeviceData.put("model", "M_DXP-7.2");
				DeviceData.put("osVersion", "M_9");
				DeviceData.put("nfcDevice", "M_NFC");
				DeviceData.put("deviceId", "M_111111");
				DeviceData.put("appVersion", "M_0.4.15.0");

				String jsonText = DeviceData.toString();
				System.out.print("DeviceData" + jsonText);

				System.out.println("direct=" + DeviceData);
				Client( customer);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			// actionRequest.setAttribute("mvcRenderCommandName",
			// MVCActions.ADD_PRODUCT_DETAILS);
			actionResponse.setRenderParameter("mvcPath", "/view.jsp");
		}
		return true;
	}

	private static void Client(Customer customer) {

		HttpPost httpPost = new HttpPost("http://localhost:8080/o/doctor-rest/employee");

		/*
		 * JSONObject json = JSONFactoryUtil.createJSONObject(); json.put("email",
		 * "richa@gmail.com"); json.put("name", "hasnain"); json.put("surnmae",
		 * "shaikh");
		 */
		// String json = "{ n"email": "richa@gmail.com"}";
		 
		JSONObject data = JSONFactoryUtil.createJSONObject();
		
		data.put("name", customer.name);
		
		//for nulll code
		
		  data.put("surname",customer.surname ); System.out.println(
		  "demo surname send to url"+customer.surname);
		  
		  data.put("email", customer.mail);
		  System.out.println("demo mail send to url"+customer.mail);
		 
		
		//for success code
		/*
		 * data.put("surname",customer.surname ); System.out.println(
		 * "demo surname send to url"+customer.surname);
		 * 
		 * data.put("email", customer.mail);
		 * System.out.println("demo mail send to url"+customer.mail);
		 */
		
		//for data email format
		/*
		 * data.put("surname",customer.surname ); System.out.println(
		 * "demo surname send to url"+customer.surname);
		 * 
		 * data.put("email", "tiwari@gmail.com"); //data.put("email", customer.mail);
		 * System.out.println("demo mail send to url"+customer.mail);
		 */
		
		System.out.println("data is "+data);
		StringEntity entity = null;
		try {
			entity = new StringEntity(data.toString());
			System.out.println("entity ===="+entity);
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException" + e.getLocalizedMessage());
		}
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		System.out.println("httppost/////"+httpPost);

		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			System.out.println("REsponse================"+response);
		} catch (ClientProtocolException e) {
			System.out.println("ClientProtocolException" + e.getLocalizedMessage());
		} catch (IOException e) {
			System.out.println("IOException" + e.getLocalizedMessage());
		}
		try {
			System.out.println(response.getStatusLine());
			try {
				System.out.println(EntityUtils.toString(response.getEntity()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			 * EntityUtils.consume(entity);
			 */

		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			httpclient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private Customer getCustomer(ActionRequest actionRequest) {

		Customer customer = new Customer();

		customer.setName(ParamUtil.getString(actionRequest, "name"));
		customer.setSurname(ParamUtil.getString(actionRequest, "surname"));
		customer.setGender(ParamUtil.getString(actionRequest, "gender"));
		customer.setDocumentType(ParamUtil.getString(actionRequest, "DocumentType"));
		customer.setPersonalId(ParamUtil.getString(actionRequest, "PersonalId"));
		customer.setDateOfBirth(ParamUtil.getString(actionRequest, "datepicker"));
		customer.setPhone(ParamUtil.getLong(actionRequest, "phoneNumber"));
		customer.setMail(ParamUtil.getString(actionRequest, "email"));
		customer.setElegibleConcession(ParamUtil.getString(actionRequest, "elegibleConcession"));
		customer.setReseller(ParamUtil.getString(actionRequest, "reseller"));
		customer.setLocale(ParamUtil.getString(actionRequest, "Locale"));
		return customer;
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

	private static final String username = "test@liferay.com";
	private static final String password = "test";
	private static final String host = "localhost";
	private static final int port = 8080;
	private static final String protocol = "https";
	static CloseableHttpClient httpclient = null;
	static HttpHost targetHost = new HttpHost(host, port, protocol);

	static HttpClientContext context = HttpClientContext.create();
	
	public static void CustomHTTPClient() {
		  // Setting Credentials
		  CredentialsProvider credsProvider = new BasicCredentialsProvider();
		  credsProvider.setCredentials(new AuthScope(host, AuthScope.ANY_PORT, AuthScope.ANY_REALM, AuthSchemes.BASIC),
		    new UsernamePasswordCredentials(username, password));

		  // Create AuthCache instance
		  AuthCache authCache = new BasicAuthCache();
		  // Generate BASIC scheme object and add it to the local auth cache
		  BasicScheme basicAuth = new BasicScheme();
		  authCache.put(targetHost, basicAuth);

		  // Add AuthCache to the execution context
		  context = HttpClientContext.create();
		  context.setCredentialsProvider(credsProvider);
		  context.setAuthCache(authCache);

		  httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		 }

		 static {
		   CustomHTTPClient();
		 }
}
