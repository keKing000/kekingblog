package top.keking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkReview;
import top.keking.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	/**
	 * 
	* @Title: addReview
	* @Description: 新增评论 
	* @param @param review
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("review/addreview")
	@ResponseBody
	public KkResult addReview(KkReview review) {
		return reviewService.addReview(review);
	}
	
	/**
	 * 
	* @Title: removeReview
	* @Description: 删除评论
	* @param @param reviewId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	@RequestMapping("review/removereview/{reviewId}")
	@ResponseBody
	public KkResult removeReview(@PathVariable String reviewId) {
		return reviewService.removeReview(reviewId);
	}
	
}
