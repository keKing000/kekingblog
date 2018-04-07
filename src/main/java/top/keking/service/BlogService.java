package top.keking.service;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkResult;

public interface BlogService {

	/**
	 * 
	* @Title: addBlog
	* @Description: 增加博客文章
	* @param @param blog
	* @param @param content
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult addBlog(KkBlog blog, String content);
	
	/**
	 * 
	* @Title: selectBlogList
	* @Description: 分页查询博客列表
	* @param @param pageNum 页数
	* @param @param count 每页数目
	* @param @param status 博客状态0正常 1删除 2草稿
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult selectBlogList(Integer pageNum, Integer count, Integer status, Integer PAGE_COUNT, String userId);
	
	/**
	 * 
	* @Title: selectCollBlogList
	* @Description: 我的收藏分页查询 
	* @param @param pageNum
	* @param @param count
	* @param @param PAGE_COUNT
	* @param @param userId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult selectCollBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT, String userId);
	
	/**
	 * 
	* @Title: selectToHostList
	* @Description: 热门博客
	* @param @param count 要查询的条数
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult selectToHostList(int count);
	
	/**
	 * 
	* @Title: selectBlogByBlogId
	* @Description: 显示博客内容查询
	* @param @param blogId
	* @param @return    
	* @return KkBlog    
	* @throws
	 */
	KkBlog selectBlogByBlogId(String blogId);
	
}
