package top.keking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkRecommend;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkScroll;
import top.keking.pojo.KkUser;
import top.keking.service.BlogService;
import top.keking.service.RecommendService;
import top.keking.service.ReviewService;
import top.keking.service.ScrollService;
import top.keking.service.UserService;

/**
 * 
* @ClassName: PageController
* @Description: 主要页面显示controller
* @author wk
* @date 2018年3月18日 上午11:14:45
*
 */
@Controller
public class PageController {
	
	//主页显示博客的数目
	@Value("${INDEX_PAGE_NUM}")
	private Integer INDEX_PAGE_NUM;
	//分页数
	@Value("${PAGE_COUNT}")
	private Integer PAGE_COUNT;
	//主页热门博客数
	@Value("${INDEX_HOST_NUM}")
	private Integer INDEX_HOST_NUM;
	//主页推荐数
	@Value("${INDEX_RECO_NUM}")
	private Integer INDEX_RECO_NUM;
	//主页滚屏数
	@Value("${INDEX_SCRO_NUM}")
	private Integer INDEX_SCRO_NUM;
	//个人中心博客数
	@Value("${SET_PAGE_NUM}")
	private Integer SET_PAGE_NUM;
	//博客页面评论数
	@Value("${BLOG_PAGE_NUM}")
	private Integer BLOG_PAGE_NUM;
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private UserService userService;
	@Autowired
	private RecommendService recommendService;
	@Autowired
	private ScrollService scrollService;
	@Autowired
	private ReviewService reviewService;

	/**
	 * 
	* @Title: indexExecute
	* @Description:主页 
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping(value= {"page/index.html","/"})
	public String indexExecute(Model model) {
		//主页博客列表查询
		KkResult result = blogService.selectBlogList(1, INDEX_PAGE_NUM, 0, PAGE_COUNT, null);//0表示博客状态是正常
		model.addAttribute("result", result);
		//主页热门列表查询
		KkResult hostResult = blogService.selectToHostList(INDEX_HOST_NUM);
		model.addAttribute("host", hostResult);
		//主页推荐列表查询
		List<KkRecommend> list = recommendService.selectRecommendList(INDEX_RECO_NUM);
		model.addAttribute("reco", list);
		//主页滚屏列表查询
		List<KkScroll> scrollList = scrollService.selectScrollList(INDEX_SCRO_NUM);
		model.addAttribute("scroll", scrollList);
		return "index";
	}
	
	/**
	 * 
	* @Title: indexListExecute
	* @Description: 主页点击分页标签
	* @param @param pageNum 当前页码
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/indexlist/{pageNum}")
	public String indexListExecute(@PathVariable Integer pageNum, Model model) {
		KkResult result = blogService.selectBlogList(pageNum, INDEX_PAGE_NUM, 0, PAGE_COUNT, null);//0表示博客状态是正常
		model.addAttribute("result", result);
		return "indexblogandpage";
	}
	
	/**
	 * 
	* @Title: editorExecute
	* @Description:编辑博客页面 
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/editor.html")
	public String editorExecute() {
		return "editor";
	}
	
	/**
	 * 
	* @Title: settingExecute
	* @Description: 个人中心页面
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setting.html")
	public String settingExecute() {
		return "setting";
	}
	
	/**
	 * 
	* @Title: setblogExecute
	* @Description: 我的博客子页面
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setblog")
	public String setblogExecute(Model model, String userId) {
		KkResult result = blogService.selectBlogList(1, SET_PAGE_NUM, 0, PAGE_COUNT, userId);//0表示博客状态是正常
		model.addAttribute("result", result);
		return "setblog";
	}
	
	/**
	 * 
	* @Title: setBlogListExecute
	* @Description: 我的博客点击分页标签
	* @param @param pageNum
	* @param @param model
	* @param @param request
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setbloglist/{pageNum}")
	public String setBlogListExecute(@PathVariable Integer pageNum, String userId, Model model) {
		KkResult result = blogService.selectBlogList(pageNum, SET_PAGE_NUM, 0, PAGE_COUNT, userId);//0表示博客状态是正常
		model.addAttribute("result", result);
		return "setblog";
	}
	
	/**
	 * 
	* @Title: setcollectExecute
	* @Description: 我的收藏子页面
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setcollect")
	public String setcollectExecute(Model model, String userId) {
		KkResult result = blogService.selectCollBlogList(1, SET_PAGE_NUM, PAGE_COUNT, userId);
		model.addAttribute("result", result);
		return "setcollect";
	}
	
	/**
	 * 
	* @Title: setcollectListExecute
	* @Description: 我的收藏点击分页标签
	* @param @param pageNum
	* @param @param userId
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setcollect/{pageNum}")
	public String setcollectListExecute(@PathVariable Integer pageNum, String userId, Model model) {
		KkResult result = blogService.selectCollBlogList(pageNum, SET_PAGE_NUM, PAGE_COUNT, userId);
		model.addAttribute("result", result);
		return "setcollect";
	}
	
	/**
	 * 
	* @Title: setdraftExecute
	* @Description: 草稿箱子页面 
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setdraft")
	public String setdraftExecute(Model model, String userId) {
		KkResult result = blogService.selectBlogList(1, SET_PAGE_NUM, 2, PAGE_COUNT, userId);//2表示博客状态时草稿
		model.addAttribute("result", result);
		return "setdraft";
	}
	
	/**
	 * 
	* @Title: setDraftListExecute
	* @Description: 草稿箱点击分页标签
	* @param @param pageNum
	* @param @param model
	* @param @param request
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setdraftlist/{pageNum}")
	public String setDraftListExecute(@PathVariable Integer pageNum, String userId, Model model) {
		KkResult result = blogService.selectBlogList(pageNum, SET_PAGE_NUM, 0, PAGE_COUNT, userId);//0表示博客状态是正常
		model.addAttribute("result", result);
		return "setdraft";
	}
	
	/**
	 * 
	* @Title: setupExecute
	* @Description: 个人设置子页面
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/setup")
	public String setupExecute(Model model, String userId) {
		KkUser user = userService.selectUser(userId);
		model.addAttribute("user", user);
		return "setup";
	}
	
	@RequestMapping("page/blog.html")
	public String blogExecute(String blogId, Model model) {
		KkBlog blog = blogService.selectBlogByBlogId(blogId);
		KkResult result = reviewService.selectReviewPageList(blogId, 1, BLOG_PAGE_NUM, PAGE_COUNT);
		//主页热门列表查询
		KkResult hostResult = blogService.selectToHostList(INDEX_HOST_NUM);
		model.addAttribute("host", hostResult);
		model.addAttribute("blog", blog);
		model.addAttribute("result", result);
		return "blog";
	}
	
	@RequestMapping("page/blogreviewlist/{pageNum}/{blogId}")
	public String blogReviewListExecute(@PathVariable Integer pageNum, @PathVariable String blogId, Model model) {
		KkResult result = reviewService.selectReviewPageList(blogId, pageNum, BLOG_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "blogreviewlist";
	}
	
}
