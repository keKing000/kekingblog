<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录页面</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">


<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		//账号输入框获得焦点绑定
		$("#exampleInputUserCode").focus(function() {
			$("#exampleInputUserCode").popover("show");
			$("#exampleInputUserCode").next().hide();
			$("#exampleInputUserCode").next().next().hide();
		});
		//账号输入框失去焦点绑定
		$("#exampleInputUserCode").blur(function() {
			$("#exampleInputUserCode").popover("hide");
			var codeReg = /^[A-Za-z0-9]{10,18}$/;
			var userCode = $("#exampleInputUserCode").val().trim();
			if (codeReg.test(userCode)) {
				$("#exampleInputUserCode").next().next().hide();
				$("#exampleInputUserCode").next().show();
			} else {
				$("#exampleInputUserCode").next().hide();
				$("#exampleInputUserCode").next().next().show();
			}
		});
		//密码输入框获得焦点绑定
		$("#exampleInputPassword1").focus(function() {
			$("#exampleInputPassword1").popover("show");
			$("#exampleInputPassword1").next().hide();
			$("#exampleInputPassword1").next().next().hide();
		});
		//密码输入框失去焦点绑定
		$("#exampleInputPassword1").blur(function() {
			$("#exampleInputPassword1").popover("hide");
			var codeReg = /^[A-Za-z0-9]{6,15}$/;
			var password = $("#exampleInputPassword1").val().trim();
			if (codeReg.test(password)) {
				$("#exampleInputPassword1").next().next().hide();
				$("#exampleInputPassword1").next().show();
			} else {
				$("#exampleInputPassword1").next().hide();
				$("#exampleInputPassword1").next().next().show();
			}
		});
		//注册按钮,跳转到注册页面
		$("#register").click(function(){
			window.location.pathname="/register.html";
		});
		//
		$("#login").click(function() {
			var codeReg1 = /^[A-Za-z0-9]{10,18}$/;
			var userCode = $("#exampleInputUserCode").val().trim();
			var codeReg2 = /^[A-Za-z0-9]{6,15}$/;
			var password = $("#exampleInputPassword1").val().trim();
			var opl = $(".checkbox input:checked").val();
			if (!codeReg1.test(userCode)) { //账号不符合格式
				$(".custombox").empty();
				$(".custombox").load("/prompt/请输入10~18位数字或字母组成的账号/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			if(!codeReg2.test(password)){ //密码不符合规范
				$(".custombox").empty();
				$(".custombox").load("/prompt/请输入6~15位数字或字母组成的密码/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			$.post("/loginpost",
					{
						"usercode":userCode,
						"password":password,
						"opl":opl
					},
					function(result){
						if(result.status == 201){
							$(".custombox").empty();
							$(".custombox").load("/prompt/用户名或密码错误/0", function(){
								$("#myModal").modal({
									keyboard : false,
									backdrop : "static"
								});
							});
						} else {
							location.href="/page/index.html";
						}
					});
		});
	});
</script>
</head>

<body
	style="background-image: url(/images/background.jpg); background-repeat: no-repeat; background-position: center;">
	<div class="container">
		<div class="row col-sm-12 col-md-12 col-lg-12" style="min-height: 150px;"></div>
		<div class="row">
			<div class="col-sm-4 col-md-4 col-lg-4"></div>
			<div class="col-sm-4 col-md-4 col-lg-4" style="background-color: #fff;">
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 25px;"></div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<img class="img-responsive" alt="logo" src="images/logo.jpg">
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 15px;">
					<form>
						<!-- 
						$('#element').tooltip('show')显示提示框
						$('#element').tooltip('hide')隐藏提示框
						 -->
						<div class="form-group has-success has-feedback">
							<label for="exampleInputUserCode"><span
								class="glyphicon glyphicon-user" aria-hidden="true"
								style="font-size: 16px;"> 账号</span></label> <input name="userCode" type="text"
								class="form-control" id="exampleInputUserCode" placeholder="账号"
								data-container="body" data-toggle="popover"
								data-placement="right" data-content="请输入10~18位数字或字母组成的账号">
							<span class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true" style="display: none;"></span> <span
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="display: none;"></span>
						</div>
						<div class="form-group has-success has-feedback">
							<label for="exampleInputPassword1"><span
								class="glyphicon glyphicon-lock" aria-hidden="true"
								style="font-size: 16px;"> 密码</span></label> <input name="password" type="password"
								class="form-control" id="exampleInputPassword1" placeholder="密码"
								data-container="body" data-toggle="popover"
								data-placement="right" data-content="请输入6~15位数字或字母组成的密码">
							<span class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true" style="display: none;"></span> <span
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="display: none;"></span>
						</div>
						<div class="checkbox">
							<label> <input id="checkbox" value="ok" type="checkbox"> 30天自动登录
							</label>
						</div>
						<button id="login" type="button"
							class="btn btn-primary center-block">登录</button>
					</form>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 15px;">
					<font class="btn" style="font-size: 16px;">没有账号?</font>
					<button id="register" type="button" class="btn btn-link">
						<font style="font-size: 16px;">注册!</font>
					</button>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 25px;"></div>
			</div>
		</div>
	</div>
	<div class="custombox"></div>
</body>
</html>