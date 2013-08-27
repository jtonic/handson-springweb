### Simple Spring 3.2 WebMVC: ###

The intention of the project is to learn:

1. Servlet 3  (xml free)
1. maven 3.0 build tool
1. Jetty 8 Servlet container
1. jetty cargo maven plugin
1. spring webmvc xml-free
1. and more (i.e.: spring security)

How to test application:

1. run clean package cargo:run
1. point browser to
    http://localhost:9090/handson-springweb/hello

<em>Issues:</em>

1. jstl does not work.

    url: http://localhost:9090/handson-springweb/greeting

    if jsp starts with

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    we get the following exception:

    2013-08-27 23:04:36.780:WARN:oejs.ServletHandler:
    org.apache.jasper.JasperException: /WEB-INF/pages/HelloWorldPage.jsp(1,63) PWC6188: The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application
    	at org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:89)




