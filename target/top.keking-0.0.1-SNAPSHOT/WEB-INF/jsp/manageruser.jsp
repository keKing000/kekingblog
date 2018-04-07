<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	//点击标签页
	function selectUserByPage(target) {
		var pageNum = $(target).find("a").html();
		$("#content").empty();
		$("#content").load("/page/manageruserlist/" + pageNum);
	}
	//点击上一页
	function selectUserByPrePage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) - 1;
		if (pageNum > 0) {
			$("#content").empty();
			$("#content").load("/page/manageruserlist/" + pageNum);
		}
	}
	//点击下一页
	function selectUserByNextPage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) + 1;
		if ($(target).attr("class") != "disabled") {
			$("#content").empty();
			$("#content").load("/page/manageruserlist/" + pageNum);
		}
	}
	//解禁
	function speak(target){
		var userid = $(target).siblings("input").val();
		$.post("/admin/updateuserstatus", {
			"userid" : userid,
			"status" : 0
		}, function(result){
			if(result.status==200){
				$(".custombox").empty();
				$(".custombox").load("/prompt/"+result.message+"/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				$(target).addClass("active");
				$(target).next().removeClass("active");
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
	//禁言
	function shutup(target){
		var userid = $(target).siblings("input").val();
		$.post("/admin/updateuserstatus", {
			"userid" : userid,
			"status" : 1
		}, function(result){
			if(result.status==200){
				$(".custombox").empty();
				$(".custombox").load("/prompt/"+result.message+"/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
				$(target).addClass("active");
				$(target).prev().removeClass("active");
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
</script>

<c:forEach items="${result.data.list }" var="item">
	<div class="col-sm-12 col-md-12 col-lg-12 blog"
		style="padding: 0px; border-bottom: #EDEDED solid 1px;">
		<div class="col-sm-2 col-md-2 col-lg-2">
			<div style="width: 80px; height: auto;">
				<img src="${item.userpic }" class="img-responsive" />
			</div>
		</div>
		<div class="col-sm-8 col-md-8 col-lg-8" style="padding-left: 0px;">
			<div class="row" style="padding: 25px;">
				<h4>${item.username }</h4>
			</div>
		</div>
		<div class="col-sm-2 col-md-2 col-lg-2"
			style="padding: 20px 0px; height: 100%;">
			<div class="btn-group" role="group"
				style="padding: 2px 2px;">
				<button onclick="speak(this);" type="button" class="btn btn-default <c:if test='${item.status==0 }'>active</c:if>">解禁</button>
				<button onclick="shutup(this);" type="button" class="btn btn-default <c:if test='${item.status==1 }'>active</c:if>">禁言</button>
				<input type="hidden" value="${item.userid }" />
			</div>
		</div>
	</div>
</c:forEach>
<div class="row"
	style="padding: 0px 10px; margin: 0px; background-color: #fff;">
	<nav aria-label="Page navigation" class="col-sm-offset-5"
		style="height: 50px;">
		<ul class="pagination" style="margin-top: 8px; margin-bottom: 8px;">
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectAllByPrePage(this);"
					class='<c:if test="${result.data.pageNum == 1 }">disabled</c:if>'>
					<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${result.data.pageNum == 1 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectUserByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == 2 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectUserByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectUserByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total-1 }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectUserByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${result.data.pageNum-2 }"
						end="${result.data.pageNum+2 }" var="item" step="1">
						<li onclick="selectUserByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectUserByNextPage(this);"
					class="<c:if test="${result.data.pageNum == result.data.total }">disabled</c:if>">
					<a aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
	</nav>
</div>