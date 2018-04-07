package top.keking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.keking.pojo.KkRecommend;
import top.keking.pojo.KkResult;
import top.keking.service.BlogService;
import top.keking.service.RecommendService;
import top.keking.service.SearchService;

@Controller
public class SearchController {

	@Value("${SEARCH_NUM}")
	private Integer SEARCH_NUM;
	@Value("${PAGE_COUNT}")
	private Integer PAGE_COUNT;
	@Value("${INDEX_HOST_NUM}")
	private Integer INDEX_HOST_NUM;
	@Value("${INDEX_RECO_NUM}")
	private Integer INDEX_RECO_NUM;
	
	@Autowired
	private SearchService searchService;
	@Autowired
	private BlogService blogService;
	@Autowired
	private RecommendService recommendService;
	
	/**
	 * 
	* @Title: searchExecute
	* @Description: 搜索结果页面
	* @param @param keyWord
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/search/{keyWord}")
	public String searchExecute(@PathVariable String keyWord, Model model) {
		KkResult result = searchService.searchBlogList(1, SEARCH_NUM, PAGE_COUNT, keyWord);
		model.addAttribute("result", result);
		//主页热门列表查询
		KkResult hostResult = blogService.selectToHostList(INDEX_HOST_NUM);
		model.addAttribute("host", hostResult);
		//主页推荐列表查询
		List<KkRecommend> list = recommendService.selectRecommendList(INDEX_RECO_NUM);
		model.addAttribute("reco", list);
		return "search";
	}
	
	/**
	 * 
	* @Title: searchListExecute
	* @Description: 搜索分页查询 
	* @param @param keyWord
	* @param @param pageNum
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("/searchlist/{keyWord}/{pageNum}")
	public String searchListExecute(@PathVariable String keyWord, @PathVariable Integer pageNum, Model model) {
		KkResult result = searchService.searchBlogList(pageNum, SEARCH_NUM, pageNum, keyWord);
		model.addAttribute("result", result);
		return "indexblogandpage";
	}
}
