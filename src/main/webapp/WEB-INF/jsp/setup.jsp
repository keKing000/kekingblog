<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
//点击按钮加载模态框,获得头像列表
function picLoad(){
	$(".custombox").empty();
	$(".custombox").load("/picbox", function(){
		$("#myModal").modal({
			keyboard : false,
			backdrop : "static"
		});
	});
}
//修改头像提交
function updateUserPic() {
	var userPic = $("#userPic").attr("src");
	var userId = $("#userIdByInput").val();
	$.post("/user/update/1", {
		"userpic" : userPic,
		"userid" : userId
	}, function(result){
		if(result.status == 200) {
			$(".userPic").attr("src", result.data.userpic);
			$(".custombox").empty();
			$(".custombox").load("/prompt/"+result.message+"/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
		} else {
			$(".custombox").empty();
			$(".custombox").load("/prompt/"+result.message+"/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
		}
	});
}
//修改密码提交
function updateUserPassword() {
	var oldPassword = $("#exampleInputPassword1").val().trim();
	var newPassword = $("#exampleInputPassword2").val().trim();
	var checkPassword = $("#exampleInputPassword3").val().trim();
	var userId = $("#userIdByInput").val();
	if(newPassword == null || newPassword == ""){
		$(".custombox").empty();
		$(".custombox").load("/prompt/新密码不能为空!/0", function(){
			$("#myModal").modal({
				keyboard : false,
				backdrop : "static"
			});
		});
		return;
	}
	if(newPassword == checkPassword){
		$.post("/user/update/2", {
			"password" : newPassword,
			"userid" : userId,
			"oldPassword" : oldPassword
		}, function(result){
			if(result.status == 200) {
				$(".custombox").empty();
				$(".custombox").load("/prompt/"+result.message+"/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
			} else {
				$(".custombox").empty();
				$(".custombox").load("/prompt/"+result.message+"/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
			}
		});
	}else{
		$(".custombox").empty();
		$(".custombox").load("/prompt/新密码和确认密码不一致!/0", function(){
			$("#myModal").modal({
				keyboard : false,
				backdrop : "static"
			});
		});
	}
}
//用户名称修改
function updateUserName() {
	var userName = $("#exampleInputName").val().trim();
	var userId = $("#userIdByInput").val();
	if(userName == null || userName == ""){
		$(".custombox").empty();
		$(".custombox").load("/prompt/用户名不能为空!/0", function(){
			$("#myModal").modal({
				keyboard : false,
				backdrop : "static"
			});
		});
		return;
	}
	var codeReg = /^[\u4e00-\u9fa5a-zA-Z0-9]{5,15}$/;
	if(!codeReg3.test(userName)){
		$(".custombox").empty();
		$(".custombox").load("/prompt/请输入5~15位数字或字母或汉字组成的昵称!/0", function(){
			$("#myModal").modal({
				keyboard : false,
				backdrop : "static"
			});
		});
		return;
	}
	$.get("/check/2/"+userName+"?rd="+Math.random(), function(result) {
		if(result.status == 201){
			$(".custombox").empty();
			$(".custombox").load("/prompt/"+result.message+"/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}else{
			if(userName != null && userName != ""){
				$.post("/user/update/3", {
					"username" : userName,
					"userid" : userId,
				}, function(result){
					if(result.status == 200) {
						$(".custombox").empty();
						$(".custombox").load("/prompt/"+result.message+"/0", function(){
							$("#myModal").modal({
								keyboard : false,
								backdrop : "static"
							});
						});
					} else {
						$(".custombox").empty();
						$(".custombox").load("/prompt/"+result.message+"/0", function(){
							$("#myModal").modal({
								keyboard : false,
								backdrop : "static"
							});
						});
					}
				});
			}else{
				$(".custombox").empty();
				$(".custombox").load("/prompt/用户名不能为空!/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
			}
		}
	});
}
</script>

<!-- 个人设置 -->
<div class="row">
	<div class="col-sm-3 col-md-3 col-lg-3">
		<div class="panel panel-primary" style="min-height: 330px;">
			<div class="panel-heading">我的头像</div>
			<div class="panel-body">
				<div class="col-sm-12 col-md-12 col-lg-12"
					style="min-height: 100px; margin-bottom: 20px;">
					<img id="userPic" src="${user.userpic }"
						class="img-responsive center-block">
				</div>
				<button onclick="picLoad();" type="button"
					class="btn btn-default btn-sm center-block">获得头像列表</button>
				<button onclick="updateUserPic();" type="button"
					class="btn btn-info center-block" style="margin-top: 10px;">修改</button>
			</div>
		</div>
	</div>
	<div class="col-sm-5 col-md-5 col-lg-5">
		<div class="panel panel-danger" style="min-height: 330px;">
			<div class="panel-heading">密码修改</div>
			<div class="panel-body">
				<form>
					<div class="form-group">
						<label for="exampleInputPassword1">旧密码</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="oldPassword">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">新密码</label> <input
							type="password" class="form-control" id="exampleInputPassword2"
							placeholder="newPassword">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">新密码确认</label> <input
							type="password" class="form-control" id="exampleInputPassword3"
							placeholder="checkPassword">
					</div>
					<button onclick="updateUserPassword();" type="button"
						class="btn btn-info center-block">修改</button>
				</form>
			</div>
		</div>
	</div>
	<div class="col-sm-4 col-md-4 col-lg-4">
		<div class="panel panel-success" style="min-height: 330px;">
			<div class="panel-heading">基本信息</div>
			<div class="panel-body">
				<form>
					<div class="form-group">
						<label for="exampleInputName">用户名称</label> <input type="text"
							class="form-control" id="exampleInputName" placeholder="5~15位数字或字母或汉字组成的昵称">
					</div>
					<button onclick="updateUserName();" type="button"
						class="btn btn-info center-block">修改</button>
				</form>
			</div>
		</div>
	</div>
</div>