package top.keking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;
import top.keking.service.UserService;

/**
 * 
* @ClassName: RegisterController
* @Description: 注册页面controller
* @author wk
* @date 2018年3月14日 下午7:06:10
*
 */
@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;

	/**
	 * 
	* @Title: registerExecute
	* @Description: 返回注册页面的视图
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("register.html")
	public String registerExecute() {
		return "register";
	}
	
	/**
	 * 
	* @Title: checkExecute
	* @Description: 注册提交的检查
	* @param @param type 1:用户账号 2:用户名字 3:用户密码
	* @param @param param
	* @param @return    
	* @return KkResult 
	* @throws
	 */
	@RequestMapping("check/{type}/{param}")
	@ResponseBody
	public KkResult checkExecute(@PathVariable Integer type, @PathVariable String param) {
		return userService.checkUser(type, param);
	}
	
	/**
	 * 
	* @Title: registerPostExecute
	* @Description: 用户注册
	* @param @param user
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping(value="registerpost", method=RequestMethod.POST)
	@ResponseBody
	public KkResult registerPostExecute(KkUser user) {
		return userService.addUser(user);
	}
	
}
