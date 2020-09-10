<%@ include file="/init.jsp" %>

<h1>Getting weather data throught api</h1>

<%--  <h3>the value coming  from controller is : <p> ${aditi}</p></h3>  --%> 
 <h2>today's tempaeratur is :<p class="temp"></p></h2>
 <span>&#176;</span>
 <p class="cloud"></p>
 <img id="myImg" ><br>
 
 <select name="city" >
 <option value="mumbai">mumbai</option>
 <option value="riyadh">riyadh</option>
 <option value="london">london</option>
 <option value="dubai">dubai</option>
 <option value="paris">paris</option>
 </select>
 <button  onclick="myFunction()">Get Temperature</button>
 <!-- <p class="title"></p>
 <p class="author"></p> -->
 
<!-- <style>

h3{
display:none;
}

</style> -->

 <!-- <script>
document.querySelector("h3").style.display="none";
 var number=document.querySelector("p").innerText;
 
 
 if(number>10)
	 {
	 
	
	 document.querySelector("p").style.color = "red";
	 }
 else
	 {
	 
	 document.querySelector("p").style.color = "green";
	
	 }
 
 	function myFunction(){
 		
 		
 		document.querySelector("h3").style.display="block";
 	}
 	<script> -->
 	
 
  	 <script>
  	 function myFunction(){
 	var temp;
 	var weatherDescription;
 	var xhttp = new XMLHttpRequest();
 	
    xhttp.onreadystatechange = function() {
    	
        if (this.readyState == 4 && this.status == 200) {
        
        	
        	
         var weatherData=  JSON.parse(xhttp.responseText); 
         temp =weatherData.main.temp;
		 
         weatherDescription  =weatherData.weather[0].description;
         var icon =weatherData.weather[0].icon;
         var imageURL =  "http://openweathermap.org/img/wn/" +icon +"@2x.png"
         
         //alert(icon);
         //alert(imageURL);
         
       
document.querySelector("p.temp").innerText=temp;
         
         document.querySelector("p.cloud").innerText=weatherDescription;
       // document.querySelector("img").setAttribute("src", imageURL);
      document.getElementById("myImg").src = imageURL; 
        	var bookData=  JSON.parse(xhttp.responseText); 
      var title=bookData.title;
      var author=bookData.author;
      			console.log(bookData.title);
      			document.querySelector("p.title").innerText=title;
      			document.querySelector("p.author").innerText=author;
      
       }
    };
	//api="https://api.openweathermap.org/data/2.5/weather?q=riyadh&appid=e9bdd1d9a0994eddf8b8cdacea5fbc1b&units=metric"
			//http://localhost:8081/spring-mvc-restfull-crud-example/book/101
		
	var  url1="https://api.openweathermap.org/data/2.5/weather?q=";
	var city=document.querySelector("select").value;
	alert(document.querySelector("select").value);
	var url2="&appid=e9bdd1d9a0994eddf8b8cdacea5fbc1b&units=metric";
	var url=url1+city+url2;
	alert(url)
    xhttp.open("GET", url, true);
    xhttp.send();
  	 }
</script>  


<!-- <script>



//var data = '{"title":"liferay", "author":"test"}';
//var jsonData = JSON.parse(data);

//alert(jsonData);
//alert("data testing "+jsonData.author);

var xhr = new XMLHttpRequest();

xhr.open("POST", "http://localhost:8081/spring-mvc-restfull-crud-example/book", true);

xhr.setRequestHeader("Content-Type","json");



xhr.onload = function () {
    alert("post method");
    console.log(xhr.responseText);
};
xhr.send('title=liferay&author=test');





</script> -->