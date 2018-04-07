<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">×</button>
				<h4 class="modal-title" id="myModalLabel">提示</h4>
			</div>
			<div class="modal-body">${message }</div>
			<div class="modal-footer">
				<c:if test="${status != null && status == 100 }">
					<button id="success" type="button" class="btn btn-primary" data-dismiss="modal">登录</button>
				</c:if>
				<button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	//注册成功登录按钮
	$(function(){
		$("#success").click(function(){
			window.location.pathname="/login.html";
		});
	});
</script>