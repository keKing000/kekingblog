package top.keking.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkBlogMapper;
import top.keking.mapper.KkReviewMapper;
import top.keking.mapper.KkUserMapper;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkReview;
import top.keking.pojo.KkReviewExample;
import top.keking.pojo.KkReviewExample.Criteria;
import top.keking.pojo.KkUser;
import top.keking.service.ReviewService;
import top.keking.utils.UUIDUtil;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private KkReviewMapper reviewMapper;
	@Autowired
	private KkUserMapper userMapper;
	@Autowired
	private KkBlogMapper blogMapper;

	/**
	 * 
	* @Title: selectReviewPageList
	* @Description: 评论分页查询 
	* @param @param map
	* @param @return    
	* @return List<KkReview>    
	* @throws
	 */
	@Override
	public KkResult selectReviewPageList(String blogId, Integer pageNum, Integer count, Integer PAGE_COUNT) {
		//计算起始位置
		int start = (pageNum - 1) * count;
		//设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("count", count);
		map.put("blogId", blogId);
		//查询评论列表
		List<KkReview> list = reviewMapper.selectReviewPageList(map);
		
		//查询总条数
		KkReviewExample example = new KkReviewExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andBlogidEqualTo(blogId);
		int total = reviewMapper.countByExample(example);
		
		//计算总页数
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
	* @Title: addReview
	* @Description: 新增评论
	* @param @param review
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult addReview(KkReview review) {
		KkUser user = userMapper.selectByPrimaryKey(review.getUserid());
		KkResult result = new KkResult();
		//判断用户是否被禁言
		if(user.getStatus() == 0) {
			review.setReviewid(UUIDUtil.creatUUID());
			review.setCreatdate(new Date());
			review.setStatus(0);
			int num = reviewMapper.insertSelective(review);
			if(num == 1) {
				//评论数加一
				blogMapper.updateReviewNum(review.getBlogid());
				result.setMessage("评论成功!");
				result.setStatus(200);
			} else {
				result.setMessage("评论失败!");
				result.setStatus(201);
			}
		} else {
			result.setMessage("您已经被禁言!");
			result.setStatus(201);
		}
		return result;
	}

	/**
	 * 
	* @Title: removeReview
	* @Description: 删除评论
	* @param @param reviewId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@Override
	public KkResult removeReview(String reviewId) {
		KkReview review = new KkReview();
		review.setReviewid(reviewId);
		review.setStatus(1);
		int num = reviewMapper.updateByPrimaryKeySelective(review);
		KkResult result = new KkResult();
		if(num == 1) {
			result.setMessage("删除成功!");
			result.setStatus(200);
		} else {
			result.setMessage("删除失败!");
			result.setStatus(201);
		}
		return result;
	}

}
