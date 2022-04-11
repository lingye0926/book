
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
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
			<span class="wel_word">我的订单</span>
			<%@include file="/pages/common/login_success_menu.jsp" %>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>
			<c:forEach items="${requestScope.myOrders}" var="order">
			<tr>
				<td>${fn:split(order.createTime," ")[0]}</td>
				<td>${order.price}</td>
				<c:choose>
					<c:when test="${order.status == 0}">
						<td>未发货</td>
					</c:when>
					<c:when test="${order.status == 1}">
						<td><a href="orderServlet?action=recieveOrder&orderId=${order.orderId}">已发货</a></td>
					</c:when>
					<c:when test="${order.status == 2}">
						<td>已签收</td>
					</c:when>
				</c:choose>
				<td><a href="orderServlet?action=showOrderDetail&orderId=${order.orderId}">查看详情</a></td>
			</tr>	
			</c:forEach>	
		</table>
		
	
	</div>
	
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>