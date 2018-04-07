package top.keking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkRecommendMapper;
import top.keking.pojo.KkRecommend;
import top.keking.service.RecommendService;

@Service
public class RecommendServiceImpl implements RecommendService {
	
	@Autowired
	private KkRecommendMapper recommendMapper;

	/**
	 * 
	* @Title: selectRecommendList
	* @Description: 查询最新的推荐列表 
	* @param @return    
	* @return List<KkRecommend>    
	* @throws
	 */
	@Override
	public List<KkRecommend> selectRecommendList(int count) {
		List<KkRecommend> list = recommendMapper.selectRecommendList(count);
		return list;
	}

}
