package top.keking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;
import top.keking.service.UserService;

/**
 * 
* @ClassName: LoginController
* @Description: 登录页面controller
* @author wk
* @date 2018年3月15日 上午1:14:43
*
 */
@Controller
public class LoginController {
	
	@Value("${MAX_AGE}")
	private Integer MAX_AGE;
	
	@Autowired
	private UserService userService;

	@RequestMapping("login.html")
	public String loginExecute() {
		return "login";
	}
	
	/**
	 * 
	* @Title: loginPostExecute
	* @Description: 根据账号密码查询user
	* @param @param user
	* @param @param opl
	* @param @param request
	* @param @param response
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping(value="loginpost", method=RequestMethod.POST)
	@ResponseBody
	public KkResult loginPostExecute(KkUser user, String opl, HttpServletRequest request, HttpServletResponse response) {
		return userService.loginUser(user, opl, MAX_AGE, request, response);
	}
	
}
