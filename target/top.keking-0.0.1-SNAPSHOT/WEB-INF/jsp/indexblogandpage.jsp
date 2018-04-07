<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
</script>

<!-- 一篇博客位 -->
<c:forEach items="${result.data.list }" var="item">
	<div onclick="selectBlogByBlogId(this);" class="col-sm-12 col-md-12 col-lg-12 blog"
		style="padding: 0px; border-bottom: #EDEDED solid 1px;">
		<input type="hidden" value="${item.blogid }"/>
		<div class="col-sm-2 col-md-2 col-lg-2">
			<div style="width: 80px; height: auto;">
				<img src="${item.user.userpic }" class="img-responsive" />
			</div>
		</div>
		<div class="col-sm-8 col-md-8 col-lg-8" style="padding-left: 0px;">
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
			style="padding: 31px 0px; height: 100%;">
			<p class="badge col-md-offset-4" style="margin-bottom: 0px;">${item.readnum }</p>
		</div>
	</div>
</c:forEach>
<!-- 分页标签 -->
<div id="pageTitle" class="col-sm-12 col-md-12 col-lg-12"
	style="padding: 0px; margin: 0px; background-color: #fff;">
	<nav aria-label="Page navigation" class="col-sm-offset-4"
		style="height: 50px;">
		<ul class="pagination" style="margin-top: 8px; margin-bottom: 8px;">
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectByPrePage(this);"
					class='<c:if test="${result.data.pageNum == 1 }">disabled</c:if>'>
					<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${result.data.pageNum == 1 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == 2 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total-1 }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${result.data.pageNum-2 }"
						end="${result.data.pageNum+2 }" var="item" step="1">
						<li onclick="selectByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectByNextPage(this);"
					class="<c:if test="${result.data.pageNum == result.data.total }">disabled</c:if>">
					<a aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
	</nav>
</div>