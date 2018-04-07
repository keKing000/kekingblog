<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>写博客</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">


<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/quit.js"></script>
<script src="/js/search.js"></script>
<script charset="utf-8" src="/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="/kindeditor/lang/zh-CN.js"></script>
<script>
	KindEditor.ready(function(K) {
		window.editor = K.create("#editor_id", {
			items : [
	         "source","|","undo", "redo", "|","cut", "copy", "paste","|", "justifyleft", "justifycenter", "justifyright",
	         "justifyfull","|", "subscript","superscript","|","formatblock", "fontname", "fontsize", "forecolor", "hilitecolor", "|", "bold",
	         "italic", "underline", "strikethrough", "lineheight", "removeformat", "|", "image","emoticons","|","link","unlink","|","fullscreen"
	         ],
	        resizeType : 1,
	        allowImageRemote : false,
	        //指定上传文件请求的url。 文件名称:imgFile
	        uploadJson : "/pic/upload",
	        //上传类型
	        dir : "image",
	        formatUploadUrl : false,
	        imgMaxSize : 10*1024*1024
		});
	});
	
	function publishBlog(stat){
		editor.sync("editor_id");
		var blogtitle = $("#blogtitle").val().trim();
		if(blogtitle==null || blogtitle==""){
			$(".custombox").empty();
			$(".custombox").load("/prompt/标题不能为空!/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}
		if(blogtitle.length>15){
			$(".custombox").empty();
			$(".custombox").load("/prompt/标题不能超过15字!/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}
		var content = $("#editor_id").val();
		if(content==null || content==""){
			$(".custombox").empty();
			$(".custombox").load("/prompt/内容不能为空!/0", function(){
				$("#myModal").modal({
					keyboard : false,
					backdrop : "static"
				});
			});
			return;
		}
		var blogid = $("#blogid").val();
		var userid = $("#userIdByInput").val();
		$.post("/blog/publish", {
			"blogtitle" : blogtitle,
			"content" : content,
			"blogid" : blogid,
			"userid" : userid,
			"status" : stat
		}, function(result){
			if(result.status == 200){
				//清空标题和博文
				$("#blogtitle").val("");
				editor.html("");
				if(stat == 0){
					$(".custombox").empty();
					$(".custombox").load("/prompt/博客发布成功!/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
				} else {
					$(".custombox").empty();
					$(".custombox").load("/prompt/博客保存为草稿成功!/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
				}
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
	};
	
	$(function(){
		//发布按钮绑定事件 status=0
		$("#publish").click(function(){
			publishBlog(0);
		});
		//保存草稿按钮绑定事件 status=2
		$("#save").click(function(){
			publishBlog(2);
		});
		//取消按钮绑定事件,返回上一页面
		$("#cancel").click(function(){
			history.back();
		});
	});
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
						<li class="active"><a href="/page/editor.html"><span class="glyphicon glyphicon-pencil"
								aria-hidden="true"></span> 写博客</a></li>
						<li><a href="/page/setting.html"><span class="glyphicon glyphicon-user"
								aria-hidden="true"></span> 个人中心</a></li>
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
					<ul id="usermenu" class="nav navbar-nav navbar-right" style="margin-right: 20px;">
						<c:if test="${user==null }">
							<li><a href="/login.html">登录</a></li>
							<li><a href="/register.html">注册</a></li>
						</c:if>
						<c:if test="${user!=null }">
							<div class="dropdown" style="width: 50px;">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
										role="button" aria-haspopup="true" aria-expanded="false">
										<img src="${user.userpic }" class="img-responsive" />
									</a>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
									<li id="quit"><a href="#">退出</a></li>
								</ul>
							</div>
							<input id="userIdByInput" type="hidden" value="${user.userid }"/>
						</c:if>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 10px;">
				<div class="input-group">
					<span class="input-group-addon" id="sizing-addon2">博客标题</span> <input id="blogtitle"
						type="text" class="form-control" placeholder="15字以内博客标题" value="<c:if test='${fn:length(blog.blogtitle)>0}'>${blog.blogtitle }</c:if>"
						aria-describedby="sizing-addon2">
					<input type="hidden" id="blogid" value="<c:if test='${fn:length(blog.blogid)>0 }'>${blog.blogid }</c:if>">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 20px;">
				<textarea id="editor_id" name="content"
					style="width: 100%; height: 550px;"><c:if test="${fn:length(blog.desc.content)>0 }">${blog.desc.content }</c:if>
			</textarea>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-offset-5">
				<button id="publish" type="button" class="btn btn-primary">发布</button>
				<button id="save" type="button" class="btn btn-success">保存草稿</button>
				<button id="cancel" type="button" class="btn btn-danger">取消</button>
			</div>
		</div>
	</div>
	<div class="custombox"></div>
</body>
</html>