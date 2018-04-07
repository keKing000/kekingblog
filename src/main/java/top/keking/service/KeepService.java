package top.keking.service;

import top.keking.pojo.KkResult;

public interface KeepService {

	/**
	 * 
	* @Title: addKeep
	* @Description: 增加收藏
	* @param @param userId
	* @param @param blogId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult addKeep(String userId, String blogId);
}
