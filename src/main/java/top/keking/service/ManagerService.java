package top.keking.service;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkScroll;
import top.keking.pojo.KkUser;

public interface ManagerService {

	/**
	 * 
	* @Title: selectAllBlogList
	* @Description: 网站管理博客列表
	* @param @param pageNum 当前页数
	* @param @param count 查询条数
	* @param @param PAGE_COUNT 分页标签数
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult selectAllBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT);
	
	/**
	 * 
	* @Title: selectAllUser
	* @Description: 分页查询用户列表
	* @param @param pageNum 当前页数
	* @param @param count 查询条数
	* @param @param PAGE_COUNT 分页数
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult selectAllUserList(Integer pageNum, Integer count, Integer PAGE_COUNT);
	
	/**
	 * 
	* @Title: updateBlogStatus
	* @Description: 博客状态改变
	* @param @param blog
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult updateBlogStatus(KkBlog blog);
	
	/**
	 * 
	* @Title: updateUserStatus
	* @Description: 用户状态改变
	* @param @param user
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult updateUserStatus(KkUser user);
	
	/**
	 * 
	* @Title: addRecommend
	* @Description: 新增推荐
	* @param @param blogId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult addRecommend(String blogId);
	
	/**
	 * 
	* @Title: addScroll
	* @Description: 新增滚屏
	* @param @param scroll
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult addScroll(KkScroll scroll);
}
