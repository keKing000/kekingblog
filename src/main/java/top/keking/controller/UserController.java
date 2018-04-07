package top.keking.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;
import top.keking.service.UserService;

/**
 * 
* @ClassName: UserController
* @Description:用户controller 
* @author wk
* @date 2018年3月18日 下午12:32:56
*
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 
	* @Title: quitExecute
	* @Description: 用户退出
	* @param @param request
	* @param @param response
	* @param @return    
	* @return String  重定向到index页面  
	* @throws
	 */
	@RequestMapping("user/quit")
	public String quitExecute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		//和本次回话的session比较
		for (Cookie cookie : cookies) {
			if(cookie.getValue().equals(session.getId())) {
				//删除session
				session.invalidate();
				//删除jsessionid的cookie
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			} else if("token".equals(cookie.getName())) {
				//删除token的cookie
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		return "redirect:/page/index.html";
	}
	
	/**
	 * 
	* @Title: updateUserExecute
	* @Description: 用户信息修改
	* @param @param user
	* @param @param type
	* @param @param request
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("user/update/{type}")
	@ResponseBody
	public KkResult updateUserExecute(KkUser user, @PathVariable Integer type, @RequestParam(value="oldPassword",defaultValue="") String oldPassword, HttpServletRequest request) {
		return userService.updateUser(user, type, oldPassword, request);
	}
}
