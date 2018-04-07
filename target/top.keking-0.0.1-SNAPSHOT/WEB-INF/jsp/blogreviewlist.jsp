<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<script type="text/javascript">
	//我的博客点击标签页
	function selectReviewByPage(target) {
		var blogId = $("#blogIdByInput").val();
		var pageNum = $(target).find("a").html();
		$("#reviewList").empty();
		$("#reviewList").load("/page/blogreviewlist/" + pageNum + "/" + blogId);
	}
	//我的博客点击上一页
	function selectReviewByPrePage(target) {
		var blogId = $("#blogIdByInput").val();
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) - 1;
		if (pageNum > 0) {
			$("#reviewList").empty();
			$("#reviewList").load("/page/blogreviewlist/" + pageNum + "/" + blogId);
		}
	}
	//我的博客点击下一页
	function selectReviewByNextPage(target) {
		var blogId = $("#blogIdByInput").val();
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) + 1;
		if ($(target).attr("class") != "disabled") {
			$("#reviewList").empty();
			$("#reviewList").load("/page/blogreviewlist/" + pageNum + "/" + blogId);
		}
	}
	//删除评论
	function removeReviewById(target) {
		var reviewId = $(target).parent().siblings("input").val();
		var blogId = $("#blogIdByInput").val();
		$.get("/review/removereview/"+reviewId, function(result){
			$("#reviewList").empty();
			$("#reviewList").load("/page/blogreviewlist/1/" + blogId, function(){
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
</script>

<div class="col-sm-12">
<c:forEach items="${result.data.list }" var="item">
	<div class="row" style="border-bottom: #EDEDED solid 1px;">
		<div class="col-sm-3" style="width: 80px; height: auto;">
			<img src="${item.user.userpic }" class="img-responsive" />
		</div>
		<div class="col-sm-9" style="margin: 0px 5px;">
			<div class="row">
				<input type="hidden" value="${item.reviewid }"/>
				<div class="col-sm-3" style="padding: 5px; margin: 0px 0px; font-size: 12px; cursor: pointer;">
					<a>${item.user.username }</a>
				</div>
				<div class="col-sm-7"
					style="padding: 5px; margin: 0px 0px; font-size: 12px;">${item.creatdate }</div>
				<c:if test="${user.userid == item.userid }">
				<div class="col-sm-2 pull-right" style="padding: 5px; margin: 0px 0px; font-size: 12px; cursor: pointer;">
					<a onclick="removeReviewById(this);">删除</a>
				</div>
				</c:if>
			</div>
			<div class="row">
				<p style="margin: 0px 5px;">${item.content }</p>
			</div>
		</div>
	</div>
</c:forEach>
</div>

<div class="row"
	style="padding: 0px 10px; margin: 0px; background-color: #fff;">
	<nav aria-label="Page navigation" class="col-sm-offset-5"
		style="height: 50px;">
		<ul class="pagination pagination-sm" style="margin-top: 8px; margin-bottom: 8px;">
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
						<li onclick="selectReviewByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == 2 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectReviewByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectReviewByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total-1 }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectReviewByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${result.data.pageNum-2 }"
						end="${result.data.pageNum+2 }" var="item" step="1">
						<li onclick="selectReviewByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectReviewByNextPage(this);"
					class="<c:if test="${result.data.pageNum == result.data.total }">disabled</c:if>">
					<a aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
	</nav>
</div>

