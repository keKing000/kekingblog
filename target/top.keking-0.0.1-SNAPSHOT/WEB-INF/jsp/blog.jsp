<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>博客</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/global.css" rel="stylesheet">

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/quit.js"></script>
<script src="/js/blog.js"></script>
<script src="/js/search.js"></script>
<script type="text/javascript">
	$(function() {
		//鼠标悬停颜色变化
		$(".blog").mouseover(function() {
			$(this).css("background-color", "#EDEDED");
			$(this).css("cursor", "pointer");
		});
	
		$(".blog").mouseout(function() {
			$(this).css("background-color", "#FFF");
		});
	
	});

	//新增收藏
	function keepBlogByBlogId() {
		var userId = $("#userIdByInput").val();
		if(userId == null){
			$(".custombox").empty();
			$(".custombox").load("/prompt/请先登录!/100", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}
		var blogId = $("#blogIdByInput").val();
		$.post("/keep/addkeep", {
			"userId" : userId,
			"blogId" : blogId
		}, function(result){
			$(".custombox").empty();
			$(".custombox").load("/prompt/"+result.message+"/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
		});
	}	
	//新增评论
	function addReviewByBlogId() {
		var userId = $("#userIdByInput").val();
		if(userId == null){
			$(".custombox").empty();
			$(".custombox").load("/prompt/请先登录!/100", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}
		var blogId = $("#blogIdByInput").val();
		var content = $("#reviewContent").val();
		if (content.length > 50) {
			$(".custombox").empty();
			$(".custombox").load("/prompt/评论字数不能大于50字!/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		} else {
			$.post("/review/addreview", {
				"userid" : userId,
				"blogid" : blogId,
				"content" : content
			}, function(result){
				$("#reviewContent").val("");
				$("#reviewList").empty();
				$("#reviewList").load("/page/blogreviewlist/1/"+blogId, function(){
					$(".custombox").empty();
					$(".custombox").load("/prompt/"+result.message+"/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
				});
			});
		}
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
							<li><a href="/page/manager.html"><span class="glyphicon glyphicon-home"
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
								<a class="dropdown-toggle" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false"> <img
									src="${user.userpic }" class="img-responsive" />
								</a>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li id="quit"><a>退出</a></li>
								</ul>
							</div>
							<input id="userIdByInput" type="hidden" value="${user.userid }"/>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<!-- 博客 -->
	<div class="container">
		<!-- 博文部分 -->
		<div class="col-sm-8 col-md-8 col-lg-8" style="background-color: #FFF;">
			<input id="blogIdByInput" type="hidden" value="${blog.blogid }"/>
			<!-- 博客标题 -->
			<div class="row" style="border-bottom: #EDEDED solid 1px;">
				<div class="row" style="margin: 0px 15px;">
					<h3>${blog.blogtitle }</h3>
				</div>
				<div class="row"
					style="margin: 0px 15px; padding-bottom: 10px; font-size: 12px;">
					更新日期:<span>${blog.updatedate }</span>&nbsp;&nbsp;&nbsp; <span
						class="glyphicon glyphicon-tag" aria-hidden="true"><a style="cursor: pointer;"
						onclick="keepBlogByBlogId();">收藏</a></span>&nbsp;&nbsp; <span
						class="glyphicon glyphicon-comment" aria-hidden="true"><a
						href="#reviewInput">评论</a></span>&nbsp;&nbsp;&nbsp; <span
						class="glyphicon glyphicon-eye-open pull-right"
						aria-hidden="true">${blog.readnum }</span>
				</div>
			</div>
			<!-- 博客主体 -->
			<div class="row"
				style="border-bottom: #EDEDED solid 1px; margin-top: 30px; margin-bottom: 20px; padding: 0px 15px;">
				${blog.desc.content }
			</div>
			<!-- 博客评论输入框 -->
			<div id="reviewInput" class="row" style="border-bottom: #EDEDED solid 1px;">
				<div class="input-group" style="margin: 5px 15px;">
					<input id="reviewContent" type="text" class="form-control" placeholder="50字以内评论!">
					<span class="input-group-btn">
						<button onclick="addReviewByBlogId();" class="btn btn-default" type="button">发布</button>
					</span>
				</div>
			</div>
			<!-- 博客评论 -->
			<div id="reviewList" style="border-bottom: #EDEDED solid 1px;">
				<%@include file="blogreviewlist.jsp" %>
			</div>
		</div>
		<!-- 博主信息 -->
		<div class="col-sm-4 col-md-4 col-lg-4">
			<div class="panel panel-info">
				<div class="panel-heading" style="font-size: 20px;">博主信息</div>
				<div class="panel-body">
					<div class="col-sm-12 col-md-12 col-lg-12" style="height: 100px;">
						<img src="${blog.user.userpic }" class="img-responsive center-block" />
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12 text-center" style="font-size: 18px;">
						<a>${blog.user.username }</a>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-12" style="margin-top: 10px;">
						<div class="col-sm-6 col-md-6 col-lg-6 text-center">
							<div class="glyphicon glyphicon-tag" aria-hidden="true"><a>收藏数</a>${blog.keepnum }</div>
						</div>
						<div class="col-sm-6 col-md-6 col-lg-6 text-center">
							<div class="glyphicon glyphicon-tag" aria-hidden="true"><a>评论数</a>${blog.reviewnum }</div>
						</div>
					</div>
				</div>
			</div>

			<!-- 热门 -->
			<div class="panel panel-danger col-sm-12 col-md-12 col-lg-12"
				style="padding: 0px;">
				<div class="panel-heading" style="font-size: 20px;">热门</div>
				<div class="panel-body" style="padding: 10px 10px;">
					<c:forEach items="${host.data }" var="item">
						<div onclick="selectBlogByBlogId(this);" class="col-sm-12 col-md-12 col-lg-12 blog"
							style="padding: 0px; border-bottom: #EDEDED solid 1px;">
							<input type="hidden" value="${item.blogid }"/>
							<div class="col-sm-2 col-md-2 col-lg-2" style="padding: 0px;">
								<div style="width: 50px; height: auto;">
									<img src="${item.user.userpic }" class="img-responsive" />
								</div>
							</div>
							<div class="col-sm-10 col-md-10 col-lg-10"
								style="padding-left: 0px; padding-right: 0px;">
								<div style="margin: 15px 0px;">${item.blogtitle }</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="custombox"></div>
</body>
</html>