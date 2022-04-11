<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详情</title>
<%@include file="/pages/common/head.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">订单详情</span>
			<%@include file="/pages/common/login_success_menu.jsp" %>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>订单编号</td>
				<td>图书名</td>
				<td>数量</td>
				<td>单价</td>
				<td>总价</td>
			</tr>
			<c:forEach items="${requestScope.orderItems}" var="item">
			<tr>
				<td>${item.orderId}</td>
				<td>${item.name}</td>
				<td>${item.count}</td>
				<td>${item.price}</td>
				<td>${item.totalPrice}</td>
			</tr>	
			</c:forEach>	
		</table>
	</div>
	
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>