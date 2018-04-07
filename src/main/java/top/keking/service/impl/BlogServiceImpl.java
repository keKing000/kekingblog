package top.keking.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkBlogMapper;
import top.keking.mapper.KkDescMapper;
import top.keking.mapper.KkKeepMapper;
import top.keking.mapper.KkUserMapper;
import top.keking.pojo.KkBlog;
import top.keking.pojo.KkBlogExample;
import top.keking.pojo.KkBlogExample.Criteria;
import top.keking.pojo.KkDesc;
import top.keking.pojo.KkDescExample;
import top.keking.pojo.KkKeepExample;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;
import top.keking.service.BlogService;
import top.keking.utils.UUIDUtil;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private KkBlogMapper blogMapper;
	@Autowired
	private KkDescMapper descMapper;
	@Autowired
	private KkKeepMapper keepMapper;
	@Autowired
	private KkUserMapper userMapper;

	/**
	 * 
	 * @Title: addBlog @Description: 增加博客文章 @param @param blog @param @param
	 *         content @param @return @return KkResult @throws
	 */
	@Override
	public KkResult addBlog(KkBlog blog, String content) {
		KkUser user = userMapper.selectByPrimaryKey(blog.getUserid());
		KkResult result = new KkResult();
		//判断是否被禁言
		if(user.getStatus() == 0) {
			//判断是否为新增博客
			if(blog.getBlogid() == null || "".equals(blog.getBlogid())) {
				String blogid = UUIDUtil.creatUUID();
				String descid = UUIDUtil.creatUUID();
				Date date = new Date();
				blog.setBlogid(blogid);
				blog.setDescid(descid);
				blog.setCreatdate(date);
				blog.setUpdatedate(date);
				KkDesc desc = new KkDesc();
				desc.setBlogid(blogid);
				desc.setDescid(descid);
				desc.setContent(content);
				int blognum = blogMapper.insertSelective(blog);
				int descnum = descMapper.insertSelective(desc);
				if (blognum == 1 && descnum == 1) {// 添加成功
					result.setStatus(200);
				} else {// 添加失败
					result.setStatus(201);
					result.setMessage("博客添加失败,请重试!");
				}
			} else {//不是新增博客,修改博客
				blog.setUpdatedate(new Date());
				int blognum = blogMapper.updateByPrimaryKeySelective(blog);
				KkDesc desc = new KkDesc();
				desc.setContent(content);
				KkDescExample example = new KkDescExample();
				top.keking.pojo.KkDescExample.Criteria createCriteria = example.createCriteria();
				createCriteria.andBlogidEqualTo(blog.getBlogid());
				int descnum = descMapper.updateByExampleSelective(desc, example);
				if (blognum == 1 && descnum == 1) {// 添加成功
					result.setStatus(200);
				} else {// 添加失败
					result.setStatus(201);
					result.setMessage("博客添加失败,请重试!");
				}
			}
		} else {
			result.setStatus(201);
			result.setMessage("您已经被禁言!");
		}
		return result;
	}

	/**
	 * 
	 * @Title: selectBlogList @Description: 分页查询博客列表 @param @param pageNum
	 *         页数 @param @param count 每页数目 @param @param status 博客状态0正常 1删除
	 *         2草稿 @param @param PAGE_COUNT 分页标签个数 @param @return @return
	 *         KkResult @throws
	 */
	@Override
	public KkResult selectBlogList(Integer pageNum, Integer count, Integer status, Integer PAGE_COUNT, String userId) {
		// 计算起始数
		Integer start = (pageNum - 1) * count;
		// 设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);// 起始数
		map.put("count", count);// 查询的条数
		map.put("status", status);// 查询博客的状态
		map.put("userId", userId);// 设置用户id
		// 根据条件查询博客列表
		List<KkBlog> list = blogMapper.selectToPageList(map);
		// 查询总条数
		KkBlogExample example = new KkBlogExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andStatusEqualTo(status);
		if (userId != null) {
			createCriteria.andUseridEqualTo(userId);
		}
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
	* @Title: selectCollBlogList
	* @Description: 我的收藏分页查询 
	* @param @param pageNum
	* @param @param count 每页数目
	* @param @param PAGE_COUNT 分页标签个数
	* @param @param userId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult selectCollBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT, String userId) {
		// 计算起始数
		Integer start = (pageNum - 1) * count;
		// 设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);// 起始数
		map.put("count", count);// 查询的条数
		map.put("userId", userId);// 设置用户id
		// 根据条件查询收藏博客列表
		List<KkBlog> list = keepMapper.selectCollToPageList(map);
		// 查询总条数
		KkKeepExample example = new KkKeepExample();
		top.keking.pojo.KkKeepExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andUseridEqualTo(userId);
		int total = keepMapper.countByExample(example);
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
	* @Title: selectToHostList
	* @Description: 热门博客
	* @param @param count 要查询的条数
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult selectToHostList(int count) {
		KkResult result = new KkResult();
		List<KkBlog> list = blogMapper.selectToHostList(count);
		result.setData(list);
		return result;
	}

	/**
	 * 
	* @Title: selectBlogByBlogId
	* @Description: 显示博客内容查询
	* @param @param blogId
	* @param @return    
	* @return KkBlog    
	* @throws
	 */
	@Override
	public KkBlog selectBlogByBlogId(String blogId) {
		//阅读数加一
		blogMapper.updateReadNum(blogId);
		//查询博客内容
		KkBlog blog = blogMapper.selectBlogByBlogId(blogId);
		return blog;
	}

	

}
