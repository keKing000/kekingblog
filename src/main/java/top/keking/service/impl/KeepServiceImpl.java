package top.keking.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkBlogMapper;
import top.keking.mapper.KkKeepMapper;
import top.keking.pojo.KkKeep;
import top.keking.pojo.KkResult;
import top.keking.service.KeepService;
import top.keking.utils.UUIDUtil;

@Service
public class KeepServiceImpl implements KeepService {
	
	@Autowired
	private KkKeepMapper keepMapper;
	@Autowired
	private KkBlogMapper blogMapper;
	

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
	@Override
	public KkResult addKeep(String userId, String blogId) {
		KkKeep keep = new KkKeep();
		keep.setBlogid(blogId);
		keep.setUserid(userId);
		keep.setCreatdate(new Date());
		keep.setKeepid(UUIDUtil.creatUUID());
		int num = keepMapper.insertSelective(keep);
		KkResult result = new KkResult();
		if(num == 1) {
			//收藏数加一
			blogMapper.updateKeepNum(blogId);
			result.setMessage("收藏成功!");
			result.setStatus(200);
		} else {
			result.setMessage("收藏失败");
			result.setStatus(201);
		}
		return result;
	}

}
