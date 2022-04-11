<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 分页条的开始 --%>
	<div id="page_nav">
		<c:if test="${requestScope.page.pageNo > 1}">
			<a href="${requestScope.page.url}&pageNo=1">首页</a>
		    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
		</c:if>
		<%-- 页码输出的开始 --%>
		
		<c:choose>
		<%-- 情况1:如果总页码小于等于5的情况，页码的范围是1～总页码 --%>
			<c:when test="${requestScope.page.pageTotal <= 5}">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="${requestScope.page.pageTotal}"/>
			</c:when>
		<%-- 情况2: 如果总页码大于5小于10的情况，页码的范围是：总页码减4～总页码--%>
			<c:when test="${requestScope.page.pageTotal > 5}">
				<c:choose>
					<%-- 小情况1:当页码为前面3个：1，2，3的情况，页码范围是：1-5 --%>
					<c:when test="${requestScope.page.pageNo <= 3}">
						<c:set var="begin" value="1"/>
						<c:set var="end" value="5"/>
					</c:when>
					<%-- 小情况2:当页码为后面3个：8，9，10的情况，页码范围是：总页码-4～总页码 --%>
					<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
						<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
						<c:set var="end" value="${requestScope.page.pageTotal}"/>
					</c:when>
					<%-- 小情况3:当页码为中间4个：4，5，6，7的情况，页码范围是：当前页码-2～当前页码+2 --%>
					<c:otherwise>
						<c:set var="begin" value="${requestScope.page.pageNo-2}"/>
						<c:set var="end" value="${requestScope.page.pageNo+2}"/>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
		
		<c:forEach begin="${begin}" end="${end}" var="i">
			<c:if test="${i == requestScope.page.pageNo}">
				【${i}】
			</c:if>
			<c:if test="${i != requestScope.page.pageNo}">
				<a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
			</c:if>
		</c:forEach>
		
		<%-- 页码输出的结束 --%>
		
		<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
			<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
			<a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
		</c:if>

		共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第
		<input value="${param.pageNo}" name="pn" id="pn_input"/>页
		<input id="searchPageBtn" type="button" value="确定">
		<script type="text/javascript">
			$("#searchPageBtn").click(function(){
				var pageNo = $("#pn_input").val();
				var pageTotal = ${requestScope.page.pageNo}
				if(pageNo < 1 || pageNo > pageTotal){
					return false;
				}else{
					//javascript语言中提供了一个location地址栏对象
					//它又一个属性叫href，它可以获取浏览器地址栏中的地址
					//href属性可读，可写
				location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
				}
			})
		</script>
		</div>
		<%-- 分页条的结束 --%>