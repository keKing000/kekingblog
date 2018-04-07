package top.keking.service;

import java.util.List;

import top.keking.pojo.KkRecommend;

public interface RecommendService {

	/**
	 * 
	* @Title: selectRecommendList
	* @Description: 查询最新的推荐列表 
	* @param @return    
	* @return List<KkRecommend>    
	* @throws
	 */
	List<KkRecommend> selectRecommendList(int count);
}
