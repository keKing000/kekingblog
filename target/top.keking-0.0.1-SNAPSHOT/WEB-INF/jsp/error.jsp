<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>异常</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">

<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
		var i = 5;
		var t = setInterval(() => {
			i--;
			$("#time").html(i+"秒后");
			if(i<=0){
				clearInterval(t);
				location.href="/";
			}	
		}, 1000);
		
		$("#index").click(function(){
			clearInterval(t);
			location.href="/";
		});
	});
</script>
</head>
<body style="background-color: #FFF">
<div class="container-fluid">
	<div class="col-sm-3 col-md-3 col-lg-3"></div>
	<div class="col-sm-6 col-md-6 col-lg-6">
		<div class="col-sm-8 col-md-8 col-lg-8" style="margin-top: 200px; width: 300px; height: 300px;">
			<img src="/images/error.jpg" class="img-responsive">
		</div>
		<div class="col-sm-4 col-md-4 col-lg-4" style="margin-top: 230px;">
			<p class="text-center" style="font-size: 30px;">网络异常!</p>
			<p id="time" class="text-center" style="font-size: 25px;">5秒后</p>
			<p class="text-center" style="font-size: 25px;">跳转到主页</p>
			<p class="text-center" style="font-size: 25px;"><a id="index" style="cursor: pointer;">直接跳转</a></p>
		</div>
	</div>
	<div class="col-sm-3 col-md-3 col-lg-3"></div>
</div>
</body>
</html>