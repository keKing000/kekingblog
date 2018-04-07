<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
$(function(){
	$(".blog").mouseover(function() {
		$(this).css("background-color", "#EDEDED");
		$(this).css("cursor", "pointer");
	});

	$(".blog").mouseout(function() {
		$(this).css("background-color", "#FFF");
	});
});

	//我的博客点击标签页
	function selectBlogByPage(target) {
		var userId = $("#userIdByInput").val();
		var pageNum = $(target).find("a").html();
		$("#content").empty();
		$("#content").load("/page/setbloglist/" + pageNum,{"userId" : userId});
	}
	//我的博客点击上一页
	function selectBlogByPrePage(target) {
		var userId = $("#userIdByInput").val();
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) - 1;
		if (pageNum > 0) {
			$("#content").empty();
			$("#content").load("/page/setbloglist/" + pageNum,{"userId" : userId});
		}
	}
	//我的博客点击下一页
	function selectBlogByNextPage(target) {
		var userId = $("#userIdByInput").val();
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) + 1;
		if ($(target).attr("class") != "disabled") {
			$("#content").empty();
			$("#content").load("/page/setbloglist/" + pageNum,{"userId" : userId});
		}
	}
	
	//删除博客按钮
	function deleteBlogById(target) {
		var blogId = $(target).parent().parent().parent().find("input").val();
		var userId = $("#userIdByInput").val();
		$.post("/blog/removeblog", {
			"blogid" : blogId,
			"status" : 1
		}, function(result){
			if(result.status == 200){
				var pageNum = $(".pagination").children(".active").children("a").html();
				$("#content").empty();
				$("#content").load("/page/setbloglist/" + pageNum,{"userId" : userId},function(){
					$(".custombox").empty();
					$(".custombox").load("/prompt/"+result.message+"/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
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
	//修改博客按钮
	function updateBlogById(target) {
		var blogId = $(target).parent().parent().parent().find("input").val();
		location.href = "/blog/updateblog/"+blogId;
	}
</script>

<!-- 我的博客 -->
<c:forEach items="${result.data.list }" var="item">
	<div class="col-sm-12 col-md-12 col-lg-12 blog"
		style="padding: 0px; border-bottom: #EDEDED solid 1px; border-top: #EDEDED solid 1px; padding: 5px 10px;">
		<div class="col-sm-2 col-md-2 col-lg-2">
			<div class="btn-group-vertical" role="group"
				style="padding: 2px 2px;">
				<button type="button" class="btn btn-default"
					onclick="updateBlogById(this);">修改</button>
				<button type="button" class="btn btn-default"
					onclick="deleteBlogById(this);">删除</button>
			</div>
		</div>
		<div class="col-sm-8 col-md-8 col-lg-8" style="padding-left: 0px;" onclick="selectBlogByBlogId(this);">
			<input type="hidden" value="${item.blogid }" />
			<div class="row" style="padding: 5px;">
				<h4>${item.blogtitle }</h4>
			</div>
			<div class="row" style="padding: 0px 5px; font-size: 12px;">
				<span class="text-success" style="margin-right: 5px;"> <span
					class="glyphicon glyphicon-user" aria-hidden="true">${item.user.username }</span>
				</span> <span class="text-primary" style="margin-right: 5px;"> <span
					class="glyphicon glyphicon-calendar" aria-hidden="true">${item.updatedate }</span>
				</span> <span class="text-info"> <span
					class="glyphicon glyphicon-tag" aria-hidden="true">${item.keepnum }</span>
				</span>
			</div>
		</div>
		<div class="col-sm-2 col-md-2 col-lg-2"
			style="padding: 25px 0px; height: 100%;">
			<p class="badge col-md-offset-8" style="margin-bottom: 0px;">${item.readnum }</p>
		</div>
	</div>
</c:forEach>

<div class="row"
	style="padding: 0px 10px; margin: 0px; background-color: #fff;">
	<nav aria-label="Page navigation" class="col-sm-offset-5"
		style="height: 50px;">
		<ul class="pagination" style="margin-top: 8px; margin-bottom: 8px;">
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectBlogByPrePage(this);"
					class='<c:if test="${result.data.pageNum == 1 }">disabled</c:if>'>
					<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${result.data.pageNum == 1 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectBlogByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == 2 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectBlogByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectBlogByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total-1 }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectBlogByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${result.data.pageNum-2 }"
						end="${result.data.pageNum+2 }" var="item" step="1">
						<li onclick="selectBlogByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectBlogByNextPage(this);"
					class="<c:if test="${result.data.pageNum == result.data.total }">disabled</c:if>">
					<a aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
	</nav>
</div>

