<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	String basePath = request.getScheme()
				+"://"
				+request.getServerName()
				+ ":"
				+ request.getServerPort()
				+ "/book/";
	pageContext.setAttribute("basePath", basePath);

%>


<base href=<%= basePath %>>
<!--  Base标签，永远固定相对路径 -->
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>