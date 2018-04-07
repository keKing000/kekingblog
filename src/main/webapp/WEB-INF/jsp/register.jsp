<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注册页面</title>

<link href="css/bootstrap.min.css" rel="stylesheet">


<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function() {
		//ajax同步执行
		$.ajaxSetup({ 
		    async : false 
		});
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
		//确认密码输入框获得焦点绑定
		$("#exampleInputPassword2").focus(function() {
			$("#exampleInputPassword2").popover("show");
			$("#exampleInputPassword2").next().hide();
			$("#exampleInputPassword2").next().next().hide();
		});
		//确认密码输入框失去焦点绑定
		$("#exampleInputPassword2").blur(function() {
			$("#exampleInputPassword2").popover("hide");
			var password = $("#exampleInputPassword2").val().trim();
			var passwordBefore = $("#exampleInputPassword1").val().trim();
			if (password.length > 4 && password == passwordBefore) {
				$("#exampleInputPassword2").next().next().hide();
				$("#exampleInputPassword2").next().show();
			} else {
				$("#exampleInputPassword2").next().hide();
				$("#exampleInputPassword2").next().next().show();
			}
		});
		//昵称输入框获得焦点绑定
		$("#userName").focus(function() {
			$("#userName").popover("show");
			$("#userName").next().hide();
			$("#userName").next().next().hide();
		});
		//昵称输入框失去焦点绑定
		$("#userName").blur(function() {
			$("#userName").popover("hide");
			var codeReg = /^[\u4e00-\u9fa5a-zA-Z0-9]{5,15}$/;
			var userName = $("#userName").val().trim();
			if (codeReg.test(userName)) {
				$("#userName").next().next().hide();
				$("#userName").next().show();
			} else {
				$("#userName").next().hide();
				$("#userName").next().next().show();
			}
		});
		//点击按钮加载模态框,获得头像列表
		$("#picLoad").click(function() {
			$(".custombox").empty();
			$(".custombox").load("/picbox", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
		});
		//登录按钮
		$("#login").click(function(){
			window.location.pathname="/login.html";
		});
		//注册按钮
		$("#register").click(function(){
			var codeReg1 = /^[A-Za-z0-9]{10,18}$/;
			var userCode = $("#exampleInputUserCode").val().trim();
			var codeReg2 = /^[A-Za-z0-9]{6,15}$/;
			var password = $("#exampleInputPassword1").val().trim();
			var passwordBefore = $("#exampleInputPassword2").val().trim();
			var codeReg3 = /^[\u4e00-\u9fa5a-zA-Z0-9]{5,15}$/;
			var userName = $("#userName").val().trim();
			var pic = $("#userPic").attr("src");
			//验证账号
			//账号符合规范
			if (codeReg1.test(userCode)) {//验证账号是否存在
				$.get("/check/1/"+userCode+"?rd="+Math.random(), function(result) {
					if(result.status == 201){
						$(".custombox").empty();
						$(".custombox").load("/prompt/"+result.message+"/0", function(){
							$("#myModal").modal({
								keyboard : false,
								backdrop : "static"
							});
						});
						$("#exampleInputUserCode").next().hide();
						$("#exampleInputUserCode").next().next().show();
						return;
					} else {
						next1();
					}
				})
			} else { //账号不符合规范
				$(".custombox").empty();
				$(".custombox").load("/prompt/请输入10~18位数字或字母组成的账号/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			//验证密码
			function next1(){
			if(codeReg2.test(password)){ 
				if(password != passwordBefore){ //密码和确认密码不一致
					$(".custombox").empty();
					$(".custombox").load("/prompt/密码和确认密码不一致/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
					$("#exampleInputPassword2").next().hide();
					$("#exampleInputPassword2").next().next().show();
					return;
				}
			} else { //密码不符合规范
				$(".custombox").empty();
				$(".custombox").load("/prompt/请输入6~15位数字或字母组成的密码/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			//验证昵称
			
			//昵称符合规范
			if (codeReg3.test(userName)) {
				$.get("/check/2/"+userName+"?rd="+Math.random(), function(result) {
					if(result.status == 201){
						$(".custombox").empty();
						$(".custombox").load("/prompt/"+result.message+"/0", function(){
							$("#myModal").modal({
								keyboard : false,
								backdrop : "static"
							});
						});
						$("#userName").next().hide();
						$("#userName").next().next().show();
						return;
					} else {
						next2();
					}
				})
			} else { //昵称不符合规范
				$(".custombox").empty();
				$(".custombox").load("/prompt/请输入5~15位数字或字母或汉字组成的昵称/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			}
			//头像验证
			function next2(){
			if(pic.length == 0){
				$(".custombox").empty();
				$(".custombox").load("/prompt/请选择头像/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				return;
			}
			//验证成功,注册提交
			$.post("/registerpost",
					{
						"usercode":userCode,
			    		"password":password,
			    		"username":userName,
			    		"userpic":pic
					},
					function(result){
						$(".custombox").empty();
						$(".custombox").load("/prompt/"+ result.message + "/" + result.status, function(){
							$("#myModal").modal({
								keyboard : false,
								backdrop : "static"
							});
						});
					});
			}
		});
	});
</script>
</head>

<body
	style="background-image: url(/images/background.jpg); background-repeat: no-repeat; background-position: center;">
	<div class="container">
		<div class="row col-sm-12 col-md-12 col-lg-12" style="min-height: 50px;"></div>
		<div class="row">
			<div class="col-sm-4 col-md-4 col-lg-4"></div>
			<div class="col-sm-4 col-md-4 col-lg-4" style="background-color: #fff;">
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 25px;"></div>
				<div class="col-sm-12 col-md-12 col-lg-12">
					<img class="img-responsive" alt="logo" src="images/logo.jpg">
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 15px;">
					<form>
						<div class="form-group has-success has-feedback">
							<label for="exampleInputUserCode"><span
								class="glyphicon glyphicon-user" aria-hidden="true"
								style="font-size: 16px;"> 账号</span></label> <input type="text"
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
								style="font-size: 16px;"> 密码</span></label> <input type="password"
								class="form-control" id="exampleInputPassword1" placeholder="密码"
								data-container="body" data-toggle="popover"
								data-placement="right" data-content="请输入6~15位数字或字母组成的密码">
							<span class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true" style="display: none;"></span> <span
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="display: none;"></span>
						</div>
						<div class="form-group has-success has-feedback">
							<label for="exampleInputPassword2"><span
								class="glyphicon glyphicon-flag" aria-hidden="true"
								style="font-size: 16px;"> 确认密码</span></label> <input type="password"
								class="form-control" id="exampleInputPassword2"
								placeholder="确认密码" data-container="body" data-toggle="popover"
								data-placement="right" data-content="请确认您的密码"> <span
								class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true" style="display: none;"></span> <span
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="display: none;"></span>
						</div>
						<div class="form-group has-success has-feedback">
							<label for="userName"><span
								class="glyphicon glyphicon-tag" aria-hidden="true"
								style="font-size: 16px;"> 昵称</span></label> <input type="text"
								class="form-control" id="userName" placeholder="昵称"
								data-container="body" data-toggle="popover"
								data-placement="right" data-content="请输入5~15位数字或字母或汉字组成的昵称">
							<span class="glyphicon glyphicon-ok form-control-feedback"
								aria-hidden="true" style="display: none;"></span> <span
								class="glyphicon glyphicon-remove form-control-feedback"
								aria-hidden="true" style="display: none;"></span>
						</div>
						<div class="row" style="height: 80px;">
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div style="margin-bottom: 5px;"><span class="glyphicon glyphicon-picture" aria-hidden="true"
									style="font-size: 16px;"> 头像</span></div>
								<button id="picLoad" type="button" class="btn btn-default btn-sm">点击选择初始头像信息</button>
							</div>
							<div class="col-sm-6 col-md-6 col-lg-6">
								<div class="center-block" style="width:60px; height:60px;">
									<img id="userPic" src="" class="img-responsive"/>
								</div>
							</div>
						</div>
						<button id="register" type="button"
							class="btn btn-primary center-block">注册</button>
					</form>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 15px;">
					<font class="btn" style="font-size: 16px;">已有账号?</font>
					<button id="login" type="button" class="btn btn-link">
						<font style="font-size: 16px;">登录!</font>
					</button>
				</div>
				<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 25px;"></div>
			</div>
			<div class="col-sm-4 col-md-4 col-lg-4"></div>
		</div>
	</div>
	<div class="custombox"></div>
	

</body>

</html>