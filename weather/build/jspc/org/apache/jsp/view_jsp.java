package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class view_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1theme_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_portlet_defineObjects_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_liferay$1theme_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_portlet_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_liferay$1theme_defineObjects_nobody.release();
    _jspx_tagPool_portlet_defineObjects_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n");
      //  liferay-theme:defineObjects
      com.liferay.taglib.theme.DefineObjectsTag _jspx_th_liferay$1theme_defineObjects_0 = (com.liferay.taglib.theme.DefineObjectsTag) _jspx_tagPool_liferay$1theme_defineObjects_nobody.get(com.liferay.taglib.theme.DefineObjectsTag.class);
      _jspx_th_liferay$1theme_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1theme_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1theme_defineObjects_0 = _jspx_th_liferay$1theme_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1theme_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1theme_defineObjects_nobody.reuse(_jspx_th_liferay$1theme_defineObjects_0);
      out.write("\r\n\r\n");
      //  portlet:defineObjects
      com.liferay.taglib.portlet.DefineObjectsTag _jspx_th_portlet_defineObjects_0 = (com.liferay.taglib.portlet.DefineObjectsTag) _jspx_tagPool_portlet_defineObjects_nobody.get(com.liferay.taglib.portlet.DefineObjectsTag.class);
      _jspx_th_portlet_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_portlet_defineObjects_0.setParent(null);
      int _jspx_eval_portlet_defineObjects_0 = _jspx_th_portlet_defineObjects_0.doStartTag();
      if (_jspx_th_portlet_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
        return;
      }
      _jspx_tagPool_portlet_defineObjects_nobody.reuse(_jspx_th_portlet_defineObjects_0);
      out.write("\r\n\r\n<h1>Getting weather data throught api</h1>\r\n\r\n");
      out.write(" \r\n <h2>today's tempaeratur is :<p class=\"temp\"></p></h2>\r\n <span>&#176;</span>\r\n <p class=\"cloud\"></p>\r\n <img id=\"myImg\" ><br>\r\n \r\n <select name=\"city\" >\r\n <option value=\"mumbai\">mumbai</option>\r\n <option value=\"riyadh\">riyadh</option>\r\n <option value=\"london\">london</option>\r\n <option value=\"dubai\">dubai</option>\r\n <option value=\"paris\">paris</option>\r\n </select>\r\n <button  onclick=\"myFunction()\">Get Temperature</button>\r\n <!-- <p class=\"title\"></p>\r\n <p class=\"author\"></p> -->\r\n \r\n<!-- <style>\r\n\r\nh3{\r\ndisplay:none;\r\n}\r\n\r\n</style> -->\r\n\r\n <!-- <script>\r\ndocument.querySelector(\"h3\").style.display=\"none\";\r\n var number=document.querySelector(\"p\").innerText;\r\n \r\n \r\n if(number>10)\r\n\t {\r\n\t \r\n\t\r\n\t document.querySelector(\"p\").style.color = \"red\";\r\n\t }\r\n else\r\n\t {\r\n\t \r\n\t document.querySelector(\"p\").style.color = \"green\";\r\n\t\r\n\t }\r\n \r\n \tfunction myFunction(){\r\n \t\t\r\n \t\t\r\n \t\tdocument.querySelector(\"h3\").style.display=\"block\";\r\n \t}\r\n \t<script> -->\r\n \t\r\n \r\n  \t <script>\r\n  \t function myFunction(){\r\n \tvar temp;\r\n \tvar weatherDescription;\r\n");
      out.write(" \tvar xhttp = new XMLHttpRequest();\r\n \t\r\n    xhttp.onreadystatechange = function() {\r\n    \t\r\n        if (this.readyState == 4 && this.status == 200) {\r\n        \r\n        \t\r\n        \t\r\n         var weatherData=  JSON.parse(xhttp.responseText); \r\n         temp =weatherData.main.temp;\r\n\t\t \r\n         weatherDescription  =weatherData.weather[0].description;\r\n         var icon =weatherData.weather[0].icon;\r\n         var imageURL =  \"http://openweathermap.org/img/wn/\" +icon +\"@2x.png\"\r\n         \r\n         //alert(icon);\r\n         //alert(imageURL);\r\n         \r\n       \r\ndocument.querySelector(\"p.temp\").innerText=temp;\r\n         \r\n         document.querySelector(\"p.cloud\").innerText=weatherDescription;\r\n       // document.querySelector(\"img\").setAttribute(\"src\", imageURL);\r\n      document.getElementById(\"myImg\").src = imageURL; \r\n        \tvar bookData=  JSON.parse(xhttp.responseText); \r\n      var title=bookData.title;\r\n      var author=bookData.author;\r\n      \t\t\tconsole.log(bookData.title);\r\n      \t\t\tdocument.querySelector(\"p.title\").innerText=title;\r\n");
      out.write("      \t\t\tdocument.querySelector(\"p.author\").innerText=author;\r\n      \r\n       }\r\n    };\r\n\t//api=\"https://api.openweathermap.org/data/2.5/weather?q=riyadh&appid=e9bdd1d9a0994eddf8b8cdacea5fbc1b&units=metric\"\r\n\t\t\t//http://localhost:8081/spring-mvc-restfull-crud-example/book/101\r\n\t\t\r\n\tvar  url1=\"https://api.openweathermap.org/data/2.5/weather?q=\";\r\n\tvar city=document.querySelector(\"select\").value;\r\n\talert(document.querySelector(\"select\").value);\r\n\tvar url2=\"&appid=e9bdd1d9a0994eddf8b8cdacea5fbc1b&units=metric\";\r\n\tvar url=url1+city+url2;\r\n\talert(url)\r\n    xhttp.open(\"GET\", url, true);\r\n    xhttp.send();\r\n  \t }\r\n</script>  \r\n\r\n\r\n<!-- <script>\r\n\r\n\r\n\r\n//var data = '{\"title\":\"liferay\", \"author\":\"test\"}';\r\n//var jsonData = JSON.parse(data);\r\n\r\n//alert(jsonData);\r\n//alert(\"data testing \"+jsonData.author);\r\n\r\nvar xhr = new XMLHttpRequest();\r\n\r\nxhr.open(\"POST\", \"http://localhost:8081/spring-mvc-restfull-crud-example/book\", true);\r\n\r\nxhr.setRequestHeader(\"Content-Type\",\"json\");\r\n\r\n\r\n\r\nxhr.onload = function () {\r\n    alert(\"post method\");\r\n");
      out.write("    console.log(xhr.responseText);\r\n};\r\nxhr.send('title=liferay&author=test');\r\n\r\n\r\n\r\n\r\n\r\n</script> -->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
