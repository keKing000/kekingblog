package top.keking.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.keking.mapper.KkUserMapper;
import top.keking.pojo.KkResult;
import top.keking.pojo.KkUser;
import top.keking.pojo.KkUserExample;
import top.keking.pojo.KkUserExample.Criteria;
import top.keking.service.UserService;
import top.keking.utils.CookieUtils;
import top.keking.utils.JsonUtils;
import top.keking.utils.MD5Util;
import top.keking.utils.UUIDUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private KkUserMapper userMapper;
	
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
	@Override
	public KkResult checkUser(Integer type, String param) {
		//从kk_user表中查询数据
		KkUserExample example = new KkUserExample();
		Criteria createCriteria = example.createCriteria();
		KkResult result = new KkResult();
		if(type == 1) { //验证账号
			createCriteria.andUsercodeEqualTo(param);
			List<KkUser> list = userMapper.selectByExample(example);
			if(list != null && list.size() > 0) {
				result.setMessage("账号已存在,请更换账号!");
				result.setStatus(201);
			} else {
				result.setStatus(200);
			}
		} else if(type == 2) { //验证名字
			createCriteria.andUsernameEqualTo(param);
			List<KkUser> list = userMapper.selectByExample(example);
			if(list != null && list.size() > 0) {
				result.setMessage("昵称已存在,请更换昵称!");
				result.setStatus(201);
			} else {
				result.setStatus(200);
			}
		} 
		return result;
	}
	
	/**
	 * 
	* @Title: addUser
	* @Description: 用户注册添加
	* @param @param user    
	* @return void    
	* @throws
	 */
	@Override
	public KkResult addUser(KkUser user) {
		user.setUserid(UUIDUtil.creatUUID());
		user.setCreatdate(new Date());
		//对密码进行加密
		String password = user.getPassword();
		user.setPassword(MD5Util.md5(password));
		//用户权限:0是普通用户,1是管理员
		user.setPower(0);
		//状态:0正常 1封禁
		user.setStatus(0);
		int num = userMapper.insertSelective(user);
		KkResult result = new KkResult();
		if(num != 0) { //注册成功,返回100
			result.setStatus(100);
			result.setMessage("尊敬的" + user.getUsername() + ",注册成功,请登录!");
		} else { //注册失败,返回101
			result.setStatus(101);
			result.setMessage("对不起,注册失败,请重新注册!");
		}
		return result;
	}

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
	@Override
	public KkResult loginUser(KkUser user, String opl, Integer maxAge, HttpServletRequest request, HttpServletResponse response) {
		//根据用户账号查询
		KkUserExample example = new KkUserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsercodeEqualTo(user.getUsercode());
		List<KkUser> list = userMapper.selectByExample(example);
		String password = MD5Util.md5(user.getPassword());
		KkResult result = new KkResult();
		//根据查询结果判断账号密码
		if(list != null && list.size() > 0 && list.get(0).getPassword().equals(password)) {
			//账号密码正确
			result.setStatus(200);
			//将用户信息保存在session中
			HttpSession session = request.getSession();
			session.setAttribute("user", list.get(0));
			String id = session.getId();
			//设置JSESSIONID的值,并编码
			CookieUtils.setCookie(request, response, "JSESSIONID", id, true);
			//判断是否30天自动登录
			if(opl != null && "ok".equals(opl)) {
				//选择30天自动登录,增加一个cookie保存用户信息,设置过期时间
				KkUser kkuser = list.get(0);
				CookieUtils.setCookie(request, response, "token", JsonUtils.objectToJson(kkuser), true);
			}
		} else {
			//账号密码错误
			result.setMessage("用户名或密码错误");
			result.setStatus(201);
		}
		return result;
	}

	/**
	 * 
	* @Title: selectUser
	* @Description: 通过id查找用户信息
	* @param @param userId
	* @param @return    
	* @return KkUser    
	* @throws
	 */
	@Override
	public KkUser selectUser(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

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
	@Override
	public KkResult updateUser(KkUser user, Integer type, String oldPassword, HttpServletRequest request) {
		KkResult result = new KkResult();
		if(type == 1) {//修改头像
			int count = userMapper.updateByPrimaryKeySelective(user);
			if(count == 1) {
				result.setStatus(200);
				result.setMessage("头像修改成功!");
				result.setData(user);
			}else {
				result.setStatus(201);
				result.setMessage("头像修改失败,请重试!");
			}
		} else if(type == 2) {//修改密码
			KkUser selectUser = userMapper.selectByPrimaryKey(user.getUserid());
			if(selectUser.getPassword().equals(MD5Util.md5(oldPassword))) {
				user.setPassword(MD5Util.md5(user.getPassword()));
				int count = userMapper.updateByPrimaryKeySelective(user);
				if(count == 1) {
					result.setStatus(200);
					result.setMessage("密码修改成功!");
				} else {
					result.setStatus(201);
					result.setMessage("密码修改失败,请重试!");
				}
			} else {
				result.setStatus(201);
				result.setMessage("原始密码不正确!");
			}
		} else if(type == 3) {//修改用户名
			int count = userMapper.updateByPrimaryKeySelective(user);
			if(count == 1) {
				result.setStatus(200);
				result.setMessage("用户名修改成功!");
			}else {
				result.setStatus(201);
				result.setMessage("用户名修改失败,请重试!");
			}
		}
		//将修改后的用户信息保存到request
		if(result.getStatus() == 200) {
			KkUser newUser = userMapper.selectByPrimaryKey(user.getUserid());
			request.setAttribute("user", newUser);
		}
		return result;
	}

}
