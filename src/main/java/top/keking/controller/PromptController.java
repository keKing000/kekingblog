package top.keking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
* @ClassName: PromptController
* @Description: 用于显示提示框Controller
* @author wk
* @date 2018年3月17日 上午10:59:49
*
 */
@Controller
public class PromptController {

	/**
	 * 
	* @Title: promptExecute
	* @Description: 返回提示框
	* @param @param message
	* @param @param model
	* @param @return    
	* @return String    
	* @throws
	 */
	@RequestMapping("prompt/{message}/{status}")
	public String promptExecute(@PathVariable String message, @PathVariable Integer status, Model model) {
		model.addAttribute("message", message);
		if(status != null && status != 0) {
			model.addAttribute("status", status);
		}
		return "custombox";
	}
}
