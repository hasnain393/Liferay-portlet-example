# Liferay-portlet-example
* Render and Action Phase 
* how to set  value in  in renderRequest Object  ( renderRequest.setAttribute("name", username); )  and get the value on jsp page using ( String fulname=(String)renderRequest.getAttribute("name");) 
* portlet using openweathermap api to  get  current temperature of cities 
* Performing CRUD operation using Portlet (Student) ->Search Container 
* Service Builder (Student)
* register portlet (takes the input from the user through and  registeration form and perform server side validation and send the data to doctor-rest project which is a rest project module by calling this url http://localhost:8080/o/doctor-rest/employee  which returns the status code ->to run this project we have the run register project and doctor rest project

* Student test is a portlet which perform CRUD operation on Student (service.xml has following fields)->
* StudentService porject :
```
<entity name="Student" local-service="true" remote-service="true" table="student">
     	<column name="studentId" type="long" primary="true" />
        <column name="name" type="String" />
        <column name="email" type="String" />
        <column name="education" type="String" />
 </entity>
 ```

* weather project calls the openweathemap api to get temperature of cities

* mvc-portlet-module demonstrate RenderPhase and ACTION phase and  how to set  value in  in renderRequest Object  ( renderRequest.setAttribute("name", username); )  and get the value on jsp page using ( String fulname=(String)renderRequest.getAttribute("name");) 

* fileupload project (in the we upload a image and we get  Image to  Base64ImageString)
