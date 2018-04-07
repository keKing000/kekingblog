package top.keking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkScroll;
import top.keking.pojo.KkUser;
import top.keking.service.ManagerService;

/**
 * 
* @ClassName: ManagerController
* @Description: 网站管理controller
* @author wk
* @date 2018年3月24日 上午11:38:06
*
 */
@Controller
public class ManagerController {

	//网站管理博客数
	@Value("${MANAGER_PAGE_NUM}")
	private Integer MANAGER_PAGE_NUM;
	//网站管理用户数
	@Value("${MANAGER_USER_NUM}")
	private Integer MANAGER_USER_NUM;
	//分页数
	@Value("${PAGE_COUNT}")
	private Integer PAGE_COUNT;
	
	@Autowired
	private ManagerService managerService;
	
	/**
	 * 
	* @Title: managerExecute
	* @Description: 网站管理页面 
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/manager.html")
	public String managerExecute() {
		return "manager";
	}
	
	/**
	 * 
	* @Title: managerBlogExecute
	* @Description: 网站管理博客管理子页面 
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerblog")
	public String managerBlogExecute(Model model) {
		KkResult result = managerService.selectAllBlogList(1, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerblog";
	}
	
	/**
	 * 
	* @Title: managerBlogListExecute
	* @Description: 网站管理博客管理子页面分页查询 
	* @param @param pageNum
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerbloglist/{pageNum}")
	public String managerBlogListExecute(@PathVariable Integer pageNum, Model model) {
		KkResult result = managerService.selectAllBlogList(pageNum, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerblog";
	}
	
	/**
	 * 
	* @Title: managerUserExecute
	* @Description: 网站管理用户管理子页面 
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/manageruser")
	public String managerUserExecute(Model model) {
		KkResult result = managerService.selectAllUserList(1, MANAGER_USER_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "manageruser";
	}
	
	/**
	 * 
	* @Title: managerUserListExecute
	* @Description: 网站管理用户管理子页面分页查询 
	* @param @param pageNum
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/manageruserlist/{pageNum}")
	public String managerUserListExecute(@PathVariable Integer pageNum, Model model) {
		KkResult result = managerService.selectAllUserList(pageNum, MANAGER_USER_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "manageruser";
	}
	
	/**
	 * 
	* @Title: managerScrollExecute
	* @Description: 网站管理滚屏管理子页面
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerscroll")
	public String managerScrollExecute(Model model) {
		KkResult result = managerService.selectAllBlogList(1, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerscroll";
	}
	
	/**
	 * 
	* @Title: managerScrollListExecute
	* @Description: 网站管理滚屏管理子页面分页查询
	* @param @param pageNum
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerscrolllist/{pageNum}")
	public String managerScrollListExecute(@PathVariable Integer pageNum, Model model) {
		KkResult result = managerService.selectAllBlogList(pageNum, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerscroll";
	}
	
	/**
	 * 
	* @Title: managerRecoExecute
	* @Description: 网站管理推荐管理子页面
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerrecommend")
	public String managerRecoExecute(Model model) {
		KkResult result = managerService.selectAllBlogList(1, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerreco";
	}
	
	/**
	 * 
	* @Title: managerRecoListExecute
	* @Description: 网站管理推荐管理子页面分页查询
	* @param @param pageNum
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("page/managerrecolist/{pageNum}")
	public String managerRecoListExecute(@PathVariable Integer pageNum, Model model) {
		KkResult result = managerService.selectAllBlogList(pageNum, MANAGER_PAGE_NUM, PAGE_COUNT);
		model.addAttribute("result", result);
		return "managerreco";
	}
	
	/**
	 * 
	* @Title: updateBlogStatus
	* @Description: 修改博客状态 
	* @param @param blog
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("admin/updateblogstatus")
	@ResponseBody
	public KkResult updateBlogStatus(KkBlog blog) {
		return managerService.updateBlogStatus(blog);
	}
	
	/**
	 * 
	* @Title: updateUserStatus
	* @Description: 修改用户状态
	* @param @param user
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("admin/updateuserstatus")
	@ResponseBody
	public KkResult updateUserStatus(KkUser user) {
		return managerService.updateUserStatus(user);
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
	@RequestMapping("admin/addrecommend")
	@ResponseBody
	public KkResult addRecommend(String blogId) {
		return managerService.addRecommend(blogId);
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
	@RequestMapping("admin/addscroll")
	@ResponseBody
	public KkResult addScroll(KkScroll scroll) {
		return managerService.addScroll(scroll);
	}
}
