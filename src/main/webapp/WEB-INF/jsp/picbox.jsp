<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="/css/picbox.css" type="text/css" rel="stylesheet">

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">选择头像</h4>
			</div>
			<div class="modal-body" style="overflow: hidden;">
				<c:forEach items="${picList}" var="item">
					<div class="picies">
						<img src="${item}" class="img-thumbnail" />
						<img src="/images/right.jpg" class="img-thumbnail right hidden" />
					</div>
				</c:forEach>
			</div>
			<div class="modal-footer">
				<button id="picSure" type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
$(function(){
	//为图片绑定选中效果
	$(".picies").click(function() {
		$(".picies").css("border-color", "#FFF");
		$(".picies .right").removeClass("show").addClass("hidden");
		$(this).css("border-color", "#33FF00");
		$(this).find(".right").removeClass("hidden").addClass("show");
	});
	//为确定按钮绑定选中事件
	$("#picSure").click(function(){
		//获取选取头像的url
		var picSrc = $(".modal-body .right:not('.hidden')").prev().attr("src");
		//页面中显示选取的头像
		$("#userPic").attr("src", picSrc);
		$("#userPic").css("border", "1px solid #33FF00");
	});
});
</script>









