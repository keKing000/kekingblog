<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>首页</title>

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

	//点击标签页
	function selectByPage(target) {
		var pageNum = $(target).find("a").html();
		$("#blogAndPage").empty();
		$("#blogAndPage").load("/page/indexlist/" + pageNum);
	}
	//点击上一页
	function selectByPrePage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) - 1;
		if (pageNum > 0) {
			$("#blogAndPage").empty();
			$("#blogAndPage").load("/page/indexlist/" + pageNum);
		}
	}
	//点击下一页
	function selectByNextPage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) + 1;
		if ($(target).attr("class") != "disabled") {
			$("#blogAndPage").empty();
			$("#blogAndPage").load("/page/indexlist/" + pageNum);
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
						<li class="active"><a href="/page/index.html"><span
								class="glyphicon glyphicon-tasks" aria-hidden="true"></span> 首页</a></li>
						<li><a href="/page/editor.html"><span
								class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								写博客</a></li>
						<li><a href="/page/setting.html"><span
								class="glyphicon glyphicon-user" aria-hidden="true"></span> 个人中心</a></li>
						<c:if test="${user!=null && user.power==1 }">
							<li><a href="/page/manager.html"><span
									class="glyphicon glyphicon-home" aria-hidden="true"></span>
									网站管理</a></li>
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
								<a class="dropdown-toggle" data-toggle="dropdown" role="button"
									aria-haspopup="true" aria-expanded="false"> <img
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
	<div class="container">
		<div class="col-sm-8 col-md-8 col-lg-8">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel" style="height: 300px; margin-bottom: 10px;">
				<ol class="carousel-indicators">
					<c:forEach begin="0" end="${fn:length(scroll)-1 }" var="item" step="1">
					<li data-target="#carousel-example-generic" data-slide-to="${item }"
						class="<c:if test="${item==0 }">active</c:if>"></li>
					</c:forEach>
				</ol>

				<div class="carousel-inner" role="listbox">
				<c:forEach items="${scroll }" var="item" varStatus="it">
					<div onclick="selectBlogByBlogId(this);" class="item <c:if test='${it.index==0 }'>active</c:if>">
						<input type="hidden" value="${item.blogid }"/>
						<img src="${item.scrollimg }">
						<div class="carousel-caption">
							<h3 style="cursor: pointer;">${item.scrolltitle }</h3>
						</div>
					</div>
				</c:forEach>
				</div>

				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>

			<!-- 博客列表 -->
			<div id="blogAndPage" class="col-sm-12 col-md-12 col-lg-12"
				style="padding: 0px; background-color: #fff;">
				<%@include file="indexblogandpage.jsp"%>
			</div>
		</div>
		<div class="col-sm-4 col-md-4 col-lg-4">
			<div class="panel panel-primary col-sm-12" style="padding: 0px;">
				<div class="panel-heading" style="font-size: 20px;">keKing</div>
				<div class="panel-body">keKing是一个关于分享和探索的地方!</div>
			</div>
			<!-- 置顶推荐 -->
			<div class="panel panel-success col-sm-12 col-md-12 col-lg-12"
				style="padding: 0px;">
				<div class="panel-heading" style="font-size: 20px;">置顶推荐</div>
				<div class="panel-body" style="padding: 10px 10px;">
					<c:forEach items="${reco }" var="item">
						<div onclick="selectBlogByBlogId(this);"
							class="col-sm-12 col-md-12 col-lg-12 blog"
							style="padding: 0px; border-bottom: #EDEDED solid 1px;">
							<input type="hidden" value="${item.blog.blogid }" />
							<div class="col-sm-2" style="padding: 0px;">
								<div style="width: 50px; height: auto;">
									<img src="${item.blog.user.userpic }" class="img-responsive" />
								</div>
							</div>
							<div class="col-sm-10 col-md-10 col-lg-10"
								style="padding-left: 0px; padding-right: 0px;">
								<div style="margin: 15px 0px;">${item.blog.blogtitle }</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<!-- 热门 -->
			<div class="panel panel-danger col-sm-12 col-md-12 col-lg-12"
				style="padding: 0px;">
				<div class="panel-heading" style="font-size: 20px;">热门</div>
				<div class="panel-body" style="padding: 10px 10px;">
					<c:forEach items="${host.data }" var="item">
						<div onclick="selectBlogByBlogId(this);"
							class="col-sm-12 col-md-12 col-lg-12 blog"
							style="padding: 0px; border-bottom: #EDEDED solid 1px;">
							<input type="hidden" value="${item.blogid }" />
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
</body>
</html>