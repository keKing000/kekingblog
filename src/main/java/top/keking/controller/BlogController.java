package top.keking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkResult;
import top.keking.service.BlogService;
import top.keking.service.ManagerService;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private ManagerService managerService;

	/**
	 * 
	* @Title: addBlog
	* @Description: 发布博客和保存草稿
	* @param @param blog
	* @param @param content
	* @param @param request
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("blog/publish")
	@ResponseBody
	public KkResult addBlog(KkBlog blog, String content, HttpServletRequest request) {
		return blogService.addBlog(blog, content);
	}
	
	/**
	 * 
	* @Title: removeBlog
	* @Description: 删除博客 
	* @param @param blog
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("blog/removeblog")
	@ResponseBody
	public KkResult removeBlog(KkBlog blog) {
		return managerService.updateBlogStatus(blog);
	}
	
	/**
	 * 
	* @Title: updateBlog
	* @Description: 重新编辑博客
	* @param @param blogId
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("blog/updateblog/{blogId}")
	public String updateBlog(@PathVariable String blogId, Model model) {
		KkBlog blog = blogService.selectBlogByBlogId(blogId);
		model.addAttribute("blog", blog);
		return "editor";
	}
}
