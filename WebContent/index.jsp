<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>My JSP 'index.jsp' starting page</title>  
  </head>  
    
  <body>   
    <!-- 下面两种写法都可以访问 --> 
    <a href="${pageContext.request.contextPath }/category_update.action">访问update</a>  
    <a href="category_save.action">访问save</a>  
  </body>  
</html>  