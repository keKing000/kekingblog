<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>网站管理</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/global.css" rel="stylesheet">

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/quit.js"></script>
<script src="/js/search.js"></script>
<script type="text/javascript">
$(function() {
	$("#content").load("/page/managerblog");
});
function managerBlogList(data){
	$(data).parent().siblings().removeClass("active");
	$(data).parent().addClass("active");
	$("#content").empty();
	$("#content").load("/page/managerblog");
}
function managerUserList(data){
	$(data).parent().siblings().removeClass("active");
	$(data).parent().addClass("active");
	$("#content").empty();
	$("#content").load("/page/manageruser");
}
function managerScrollList(data){
	$(data).parent().siblings().removeClass("active");
	$(data).parent().addClass("active");
	$("#content").empty();
	$("#content").load("/page/managerscroll");
}
function managerRecoList(data){
	$(data).parent().siblings().removeClass("active");
	$(data).parent().addClass("active");
	$("#content").empty();
	$("#content").load("/page/managerrecommend");
}
</script>
</head>
<body style="background-color: #FFFAF0">
	<!-- 导航栏 -->
	<div class="container-fluid" style="margin: 0px; padding: 0px;">
		<nav class="navbar navbar-default" style="background-color: #fff;">
			<div class="container-fluid">
				<div class="navbar-header" style="margin-right: 20px;">
					<a class="navbar-brand" href="#" style="margin: 0px; padding: 0px;">
						<img class="img-responsive" alt="logo" src="/images/logo-s.jpg">
					</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="/page/index.html"><span
								class="glyphicon glyphicon-tasks" aria-hidden="true"></span> 首页</a></li>
						<li><a href="/page/editor.html"><span
								class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								写博客</a></li>
						<li><a href="/page/setting.html"><span
								class="glyphicon glyphicon-user" aria-hidden="true"></span> 个人中心</a></li>
						<c:if test="${user!=null && user.power==1 }">
							<li class="active"><a href="/page/manager.html"><span class="glyphicon glyphicon-home"
									aria-hidden="true"></span> 网站管理</a></li>
						</c:if>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="input-group">
							<input type="text" class="form-control" placeholder="搜索博文">
							<span class="input-group-btn">
								<button onclick="searchByBlogName(this);" class="btn btn-default" type="button">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									搜索
								</button>
							</span>
						</div>
					</form>
					<ul id="usermenu" class="nav navbar-nav navbar-right"
						style="margin-right: 20px;">
						<c:if test="${user==null }">
							<li><a href="/login.html">登录</a></li>
							<li><a href="/register.html">注册</a></li>
						</c:if>
						<c:if test="${user!=null }">
							<div class="dropdown" style="width: 50px;">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false"> <img
									src="${user.userpic }" class="img-responsive" />
								</a>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li id="quit"><a>退出</a></li>
								</ul>
							</div>
							<input id="userIdByInput" type="hidden" value="${user.userid }" />
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container" style="background-color: #FFF;">
		<div class="row">
			<ul class="nav nav-tabs">
				<li role="presentation" class="active"><a onclick="managerBlogList(this);">博客管理</a></li>
				<li role="presentation"><a onclick="managerUserList(this);">用户管理</a></li>
				<li role="presentation"><a onclick="managerScrollList(this);">滚屏管理</a></li>
				<li role="presentation"><a onclick="managerRecoList(this);">推荐管理</a></li>
			</ul>
		</div>
		<div id="content" class="row" style="margin-top: 15px;">
			
		</div>
	</div>
	<div class="custombox"></div>
</body>
</html>