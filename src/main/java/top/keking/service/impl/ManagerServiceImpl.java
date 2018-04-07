package top.keking.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkBlogMapper;
import top.keking.mapper.KkRecommendMapper;
import top.keking.mapper.KkScrollMapper;
import top.keking.mapper.KkUserMapper;
import top.keking.pojo.KkBlog;
import top.keking.pojo.KkBlogExample;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkScroll;
import top.keking.pojo.KkUser;
import top.keking.pojo.KkUserExample;
import top.keking.pojo.KkBlogExample.Criteria;
import top.keking.pojo.KkRecommend;
import top.keking.service.ManagerService;
import top.keking.utils.UUIDUtil;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private KkBlogMapper blogMapper;
	@Autowired
	private KkUserMapper userMapper;
	@Autowired
	private KkRecommendMapper recommendMapper;
	@Autowired
	private KkScrollMapper scrollMapper;
	
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
	@Override
	public KkResult selectAllBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT) {
		// 计算起始数
		Integer start = (pageNum - 1) * count;
		// 设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);// 起始数
		map.put("count", count);// 查询的条数
		// 根据条件查询博客列表
		List<KkBlog> list = blogMapper.selectToManagerList(map);
		// 查询总条数
		KkBlogExample example = new KkBlogExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusNotEqualTo(2);
		int total = blogMapper.countByExample(example);
		// 计算总页数
		Integer pageTotal = 0;
		if (total % count != 0)
			pageTotal = total / count + 1;
		else
			pageTotal = total / count;

		// 设置返回数据
		Map<String, Object> data = new HashMap<>();
		data.put("total", pageTotal);// 设置总页数
		data.put("list", list);// 博客列表
		data.put("pageNum", pageNum);// 当前页数
		// 分页标签数
		if (pageTotal >= PAGE_COUNT)
			data.put("count", PAGE_COUNT);
		else
			data.put("count", pageTotal);

		KkResult result = new KkResult();
		result.setData(data);
		result.setStatus(200);
		return result;
	}

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
	@Override
	public KkResult selectAllUserList(Integer pageNum, Integer count, Integer PAGE_COUNT) {
		// 计算起始数
		Integer start = (pageNum - 1) * count;
		// 设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);// 起始数
		map.put("count", count);// 查询的条数
		List<KkUser> list = userMapper.selectUserByPage(map);
		KkUserExample example = new KkUserExample();
		int total = userMapper.countByExample(example);
		// 计算总页数
		Integer pageTotal = 0;
		if (total % count != 0)
			pageTotal = total / count + 1;
		else
			pageTotal = total / count;
		// 设置返回数据
		Map<String, Object> data = new HashMap<>();
		data.put("total", pageTotal);// 设置总页数
		data.put("list", list);// 博客列表
		data.put("pageNum", pageNum);// 当前页数
		// 分页标签数
		if (pageTotal >= PAGE_COUNT)
			data.put("count", PAGE_COUNT);
		else
			data.put("count", pageTotal);

		KkResult result = new KkResult();
		result.setData(data);
		result.setStatus(200);
		return result;
	}

	/**
	 * 
	* @Title: updateBlogStatus
	* @Description: 博客状态改变
	* @param @param blog
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult updateBlogStatus(KkBlog blog) {
		int num = blogMapper.updateByPrimaryKeySelective(blog);
		KkResult result = new KkResult();
		if(num == 1) {
			result.setStatus(200);
			result.setMessage("操作成功!");
		} else {
			result.setStatus(201);
			result.setMessage("操作失败!");
		}
		return result;
	}

	/**
	 * 
	* @Title: updateUserStatus
	* @Description: 用户状态改变
	* @param @param user
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult updateUserStatus(KkUser user) {
		int num = userMapper.updateByPrimaryKeySelective(user);
		KkResult result = new KkResult();
		if(num == 1) {
			result.setStatus(200);
			result.setMessage("操作成功!");
		} else {
			result.setStatus(201);
			result.setMessage("操作失败!");
		}
		return result;
	}

	/**
	 * 
	* @Title: addRecommend
	* @Description: 新增推荐
	* @param @param blogId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult addRecommend(String blogId) {
		KkRecommend reco = new KkRecommend();
		reco.setRecommendid(UUIDUtil.creatUUID());
		reco.setBlogid(blogId);
		reco.setStatus(0);
		reco.setCreatdate(new Date());
		int num = recommendMapper.insertSelective(reco);
		KkResult result = new KkResult();
		if(num == 1) {
			result.setStatus(200);
			result.setMessage("操作成功!");
		} else {
			result.setStatus(201);
			result.setMessage("操作失败!");
		}
		return result;
	}

	/**
	 * 
	* @Title: addScroll
	* @Description: 新增滚屏
	* @param @param scroll
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult addScroll(KkScroll scroll) {
		scroll.setScrollid(UUIDUtil.creatUUID());
		scroll.setStatus(0);
		scroll.setCreatdate(new Date());
		int num = scrollMapper.insertSelective(scroll);
		KkResult result = new KkResult();
		if(num == 1) {
			result.setStatus(200);
			result.setMessage("操作成功!");
		} else {
			result.setStatus(201);
			result.setMessage("操作失败!");
		}
		return result;
	}

}
