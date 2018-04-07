package top.keking.service;

import java.util.List;

import top.keking.pojo.KkScroll;

public interface ScrollService {

	/**
	 * 
	* @Title: selectScrollList
	* @Description: 获取滚屏列表 
	* @param @param count
	* @param @return    
	* @return List<KkScroll>    
	* @throws
	 */
	List<KkScroll> selectScrollList(int count);
}
