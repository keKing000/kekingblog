package top.keking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkScrollMapper;
import top.keking.pojo.KkScroll;
import top.keking.service.ScrollService;

@Service
public class ScrollServiceImpl implements ScrollService {
	
	@Autowired
	private KkScrollMapper scrollMapper;

	/**
	 * 
	* @Title: selectScrollList
	* @Description: 获取滚屏列表 
	* @param @param count
	* @param @return    
	* @return List<KkScroll>    
	* @throws
	 */
	@Override
	public List<KkScroll> selectScrollList(int count) {
		List<KkScroll> list = scrollMapper.selectScrollList(count);
		return list;
	}

}
