package top.keking.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;

public interface UserService {

	/**
	 * 
	* @Title: checkUser
	* @Description: 用户注册检查Service
	* @param @param type 1:用户账号 2:用户名字 
	* @param @param param
	* @param @return   
	* @return KkResult  status:200表示ok,201表示fail  
	* @throws
	 */
	KkResult checkUser(Integer type, String param);
	/**
	 * 
	* @Title: addUser
	* @Description: 用户注册添加
	* @param @param user    
	* @return void    
	* @throws
	 */
	KkResult addUser(KkUser user);
	
	/**
	 * 
	* @Title: loginUser
	* @Description: 用户登录
	* @param @param userCode 用户账号
	* @param @param password 用户密码
	* @param @param opl 30天自动登录 
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult loginUser(KkUser user, String opl, Integer maxAge, HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 
	* @Title: selectUser
	* @Description: 通过id查找用户信息
	* @param @param userId
	* @param @return    
	* @return KkUser    
	* @throws
	 */
	KkUser selectUser(String userId);
	
	/**
	 * 
	* @Title: updateUser
	* @Description: 修改用户信息
	* @param @param user
	* @param @param type 1:头像 2:密码 3:用户名
	* @param @param request
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult updateUser(KkUser user, Integer type, String oldPassword, HttpServletRequest request);
	
}
