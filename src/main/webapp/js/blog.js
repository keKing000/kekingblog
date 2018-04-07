//点击博客展示内容
function selectBlogByBlogId(target) {
	var blogId = $(target).children("input").val();
	location.href="/page/blog.html?blogId="+blogId;
}