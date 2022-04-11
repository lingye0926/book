<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<%@include file="/pages/common/head.jsp" %>
		<script type="text/javascript">
			$(function(){
				//给验证码的图片绑定单击事件
				$("#code_img").click(function(){
					//this代表当前响应对象的dom对象
					this.src="${basePath}kaptcha.jpg?d=" + new Date();
				})
				
				$("#sub_btn").click(function(){
					//验证用户名，必须由字母，数字下划线组成，并且长度为5到12位
					//1）获取用户名输入框里的内容
					var username = $("#username").val()
					//2）创建正则表达式对象
					var pattern = /^\w{5,12}$/;
					//3）使用test方法验证,验证密码，必须由字母，数字下划线组成，并且长度为12位
					//4）返回验证结果
					if(!pattern.test(username)){
						
						$("span.errorMsg").text("用户名不合法");
						return false;
					}
					
					//验证密码，必须由字母，数字下划线组成，并且长度为5到12位
					var password = $("#password").val();
					var passpatt = /^\w{5,12}$/;
					if(!passpatt.test(password)){
						$("span.errorMsg").text("密码不合法");
						return false;
					}
					
					//确认密码
					var confirmPwd = $("#repwd").val();
					if(confirmPwd !== password){
						$("span.errorMsg").text("确认密码和密码不一致");
						return false;
					}
					
					//验证邮箱
					var emailText = $("#email").val();
					var emailPatt = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
					if(!emailPatt.test(emailText)){
						$("span.errorMsg").text("邮箱不合法");
						return false;
					}
					
					//验证验证码
					var codeText = $.trim($("#code").val());
					if(codeText == ""|| codeText == null){
						$("span.errorMsg").text("验证码不能为空");
						return false;
					}
					
					$("span.errorMsg").text("");

				})

			})
		</script>
	<style type="text/css">
		.login_form{
			height:420px;
			margin-top: 25px;
		}

	</style>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>

			<div class="login_banner">

				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>

				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${requestScope.msg}</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
								   <input type="hidden" value="regist" name="action">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email" value="${requestScope.email}" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" id="code" name="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:110px;height:40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>

						</div>
					</div>
				</div>
			</div>
<%@include file="/pages/common/foot.jsp" %>
		
	</body>
</html>