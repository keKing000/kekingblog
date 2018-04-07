<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	//点击标签页
	function selectScrollByPage(target) {
		var pageNum = $(target).find("a").html();
		$("#content").empty();
		$("#content").load("/page/managerscrolllist/" + pageNum);
	}
	//点击上一页
	function selectScrollByPrePage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) - 1;
		if (pageNum > 0) {
			$("#content").empty();
			$("#content").load("/page/managerscrolllist/" + pageNum);
		}
	}
	//点击下一页
	function selectScrollByNextPage(target) {
		var pageNum = parseInt($(target).siblings(".active").find("a").html()) + 1;
		if ($(target).attr("class") != "disabled") {
			$("#content").empty();
			$("#content").load("/page/managerscrolllist/" + pageNum);
		}
	}
	//上传图片
	function imgUpload(){
		var formData = new FormData($("#uploadForm")[0]);
		$.ajax({
			url : "/pic/imageupload",
			type : "post",
			data : formData,
			async : false,
			cache : false,
			contentType : false,
			processData : false,
			success : function(result){
				if(result.status == 200){
					$(".custombox").empty();
					$(".custombox").load("/prompt/"+result.message+"/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
					$("#image").attr("src", result.data);
					$("#image").removeClass("hidden");
				}else{
					$(".custombox").empty();
					$(".custombox").load("/prompt/"+result.message+"/0", function(){
						$("#myModal").modal({
							keyboard : false,
							backdrop : "static"
						});
					});
				}
			},
			error : function(){
				$(".custombox").empty();
				$(".custombox").load("/prompt/图片上传失败/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
					});
				});
			}
		});
	}
	//新增滚动
	function addScroll(target){
		var scrolltitle = $("#scrollTitle").val().trim();
		var blogid = $(target).next().val();
		var scrollimg = $("#image").attr("src");
		$.post("/admin/addscroll", {
			"scrolltitle" : scrolltitle,
			"blogid" : blogid,
			"scrollimg" : scrollimg
		}, function(result){
			if(result.status == 200){
				$(".custombox").empty();
				$(".custombox").load("/prompt/"+result.message+"/0", function(){
					$("#myModal").modal({
						keyboard : false,
						backdrop : "static"
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
</script>
<div class="col-sm-12 col-md-12 col-lg-12" style="margin-bottom: 20px;">
<div class="form-group">
    <label for="exampleInputEmail1">标题</label>
    <input type="text" class="form-control" id="scrollTitle" placeholder="标题">
<form id="uploadForm">
    730px*300px图片:<input type="file" id="exampleInputFile" name="imageFile">
</form>
</div>
<button id="btn" class="btn btn-default" onclick="imgUpload();">保存图片</button>
<img id="image" src="" height="100px" width="100px" class="hidden"/>
</div>
<c:forEach items="${result.data.list }" var="item">
	<div class="col-sm-12 col-md-12 col-lg-12 blog"
		style="padding: 0px; border-bottom: #EDEDED solid 1px;">
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
			<div class="btn-group-vertical" role="group"
				style="padding: 2px 2px;">
				<button onclick="addScroll(this);" type="button" class="btn btn-default">选择</button>
				<input type="hidden" value="${item.blogid }" />
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
				<li onclick="selectScrollByPrePage(this);"
					class='<c:if test="${result.data.pageNum == 1 }">disabled</c:if>'>
					<a aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
				</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${result.data.pageNum == 1 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectScrollByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == 2 }">
					<c:forEach begin="1" end="${result.data.count }" var="item"
						step="1">
						<li onclick="selectScrollByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectScrollByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:when test="${result.data.pageNum == result.data.total-1 }">
					<c:forEach begin="${result.data.total-result.data.count+1 }"
						end="${result.data.total }" var="item" step="1">
						<li onclick="selectScrollByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<c:forEach begin="${result.data.pageNum-2 }"
						end="${result.data.pageNum+2 }" var="item" step="1">
						<li onclick="selectScrollByPage(this);"
							class='<c:if test="${item == result.data.pageNum }">active</c:if>'><a>${item }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			<c:if test="${result.data.count != 0 }">
				<li onclick="selectScrollByNextPage(this);"
					class="<c:if test="${result.data.pageNum == result.data.total }">disabled</c:if>">
					<a aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a>
				</li>
			</c:if>
		</ul>
	</nav>
</div>