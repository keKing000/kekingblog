package top.keking.controller.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import top.keking.pojo.KkUser;
import top.keking.utils.CookieUtils;
import top.keking.utils.JsonUtils;

/**
 * 
* @ClassName: UpdateUserInterceptor
* @Description: 用户修改个人信息后更改session和cookie中的用户信息 
* @author wk
* @date 2018年3月21日 下午11:40:15
*
 */
public class UpdateUserInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	/**
	 * 
	 * TODO controller执行后但未返回视图前调用此方法
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//获取最新的user信息
		KkUser user = (KkUser)request.getAttribute("user");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			//如果自动登录,更新cookie的用户信息
			if("token".equals(cookie.getName())) {
				int maxAge = cookie.getMaxAge();
				CookieUtils.setCookie(request, response, "token", JsonUtils.objectToJson(user), maxAge, true);
			}
		}
		//重新将user信息放在session中
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//设置jsessionid的cookie
		CookieUtils.setCookie(request, response, "JSESSIONID", session.getId(), true);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
