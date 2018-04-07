package top.keking.service;

import top.keking.pojo.KkResult;

public interface SearchService {

	/**
	 * 
	* @Title: searchBlogList
	* @Description: 关键字查询博客列表
	* @param @param pageNum 当前页数
	* @param @param count 每页个数
	* @param @param PAGE_COUNT 标签个数
	* @param @param keyWord 关键字
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult searchBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT, String keyWord);
}
