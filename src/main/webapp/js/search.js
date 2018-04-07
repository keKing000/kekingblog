//搜索按钮
function searchByBlogName(target) {
	var keyWord = $(target).parent().siblings("input").val().trim();
	if(keyWord == null || keyWord == ""){
		$(".custombox").empty();
		$(".custombox").load("/prompt/请输入关键字!/0", function(){
			$("#myModal").modal({
				keyboard : false,
				backdrop : "static"
			});
		});
		return;
	}
	location.href = "/search/"+keyWord;
}