### Simple Spring 3.2 WebMVC: ###

Note:

1. Credits to  Codeleak.pl for setting up the project and managing to successfully install a xml-free spring/servlet3/tomcat7/maven web application.

    1. He posted a useful article at
         http://blog.codeleak.pl/2011/06/spring-31-mvc-xml-free-configuration-in.html

    1. And created a superb maven archetype for spring mvc/servlet3/tomcat7/spring-data/spring-security:
        https://github.com/kolorobot/spring-mvc-quickstart-archetype

1. Simple ModelAttribute examples article:
    http://thespringthing.blogspot.ro/2010/11/how-does-modelattribute-work.html

The intention of the project is to learn:

1. Servlet 3  (xml free)
1. maven 3.0 build tool
1. Tomcat 7 Servlet container (both standalone and embedded)
1. Tomcat maven plugin
1. spring webmvc xml-free
1. spring security
1. spring data

How to test application:

1. $ clean tomcat:run
1. point browser to
    http://localhost:8080/handson-springweb/hello

<em>TODO:</em>

1. [V] Conversions with ConvertersRegistry, ConversionService and Converter. This is the spring recommended way of conversion.
   Property editors are obsolete. Use them no more.
1. Validation support with Spring validation and JSR 303 validation. Example with a form page.
1. Internationalization example
1. [>] Add formatting support
1. POST with data binding and spring form taglib
1. [V] setup the spring JPA data 
1. [V] simple spring data example.
1. [V] spring data used through services in mvc controllers.
1. return a json in the response body
1. binding from JPA entities to beans. 1. using dozer or 2. spring support
1. create the login page and functionality
1. use https (configure Tomcat for https)
1. configure Spring Security to prevent unauthenticated call to protected resources.

Advanced:
1. use twitter bootstrap
1. use AngularJS 2
1.
1. try to integrate spring boot in the application. It looks like a good dependencies manager and bootstrap-er 


Take aways:
1. Return a different content type in controllers - the @ResponseBody is required.
Example
    
    @RequestMapping(value = "/customerid", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public @ResponseBody String getCustomerIdByName(@RequestParam(value = "name", required = true) String name) {
        final Long customerId = customerService.getCustomerId(name);
        if(customerId != -1L) {
            return customerId.toString();
        }
        return "No customer found for the provided name";
    }

<em>Issues:</em>

1. [FIXED] jstl does not work.

    url: http://localhost:9090/handson-springweb/greeting

    if jsp starts with

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    we get the following exception:

    2013-08-27 23:04:36.780:WARN:oejs.ServletHandler:
    org.apache.jasper.JasperException: /WEB-INF/pages/HelloWorldPage.jsp(1,63) PWC6188: The absolute uri: http://java.sun.com/jsp/jstl/core cannot be resolved in either web.xml or the jar files deployed with this application
    	at org.apache.jasper.compiler.DefaultErrorHandler.jspError(DefaultErrorHandler.java:89)

