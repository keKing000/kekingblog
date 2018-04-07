package top.keking.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkBlogMapper;
import top.keking.pojo.KkBlog;
import top.keking.pojo.KkBlogExample;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkBlogExample.Criteria;
import top.keking.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private KkBlogMapper blogMapper;
	
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
	@Override
	public KkResult searchBlogList(Integer pageNum, Integer count, Integer PAGE_COUNT, String keyWord) {
		// 计算起始数
		Integer start = (pageNum - 1) * count;
		// 设置查询条件
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);// 起始数
		map.put("count", count);// 查询的条数
		map.put("keyWord", "%" + keyWord + "%");// 设置关键字
		List<KkBlog> list = blogMapper.searchToPageList(map);
		// 查询总条数
		KkBlogExample example = new KkBlogExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andBlogtitleLike("%" + keyWord + "%");
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
		data.put("keyWord", keyWord);
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

}
