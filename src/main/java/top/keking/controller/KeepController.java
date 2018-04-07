package top.keking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkResult;
import top.keking.service.KeepService;

@Controller
public class KeepController {

	@Autowired
	private KeepService keepService;
	
	/**
	 * 
	* @Title: addKeep
	* @Description: 新增收藏
	* @param @param userId
	* @param @param blogId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("keep/addkeep")
	@ResponseBody
	public KkResult addKeep(String userId, String blogId) {
		return keepService.addKeep(userId, blogId);
	}
}
