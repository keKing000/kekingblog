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
* @ClassName: CustomInterceptor
* @Description: 请求到controller前通过session和cookie验证用户的登录状态 
* @author wk
* @date 2018年3月21日 下午11:38:09
*
 */
public class CustomInterceptor implements HandlerInterceptor {

	/**
	 * 
	 * TODO controller执行后且视图返回后调用此方法
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * TODO controller执行后但未返回视图前调用此方法
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * TODO controller执行前调用此方法,用于判断用户的登录状态
	 * 返回true表示继续执行，返回false中止执行
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//在request中获取JSESSIONID的cookie
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		//和本次回话的session比较
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getValue().equals(session.getId())) {
					//如果相同,则说明登录过,刷新session的时间并将user属性保存到requset中
					session.setMaxInactiveInterval(30*60);
					request.setAttribute("user", session.getAttribute("user"));
					return true;
				} else if("token".equals(cookie.getName())) {
					//如果不相同,获取token的cookie,如果有说明,设置了30天自动登录,并将cookie中的user属性保存到session和request中
					String cookieValue = CookieUtils.getCookieValue(request, "token", true);
					KkUser user = JsonUtils.jsonToPojo(cookieValue, KkUser.class);
					session.setAttribute("user", user);
					request.setAttribute("user", user);
					return true;
				}
			}
		}
		return true;
	}

}
