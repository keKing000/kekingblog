package top.keking.service;

import top.keking.pojo.KkResult;
import top.keking.pojo.KkReview;

public interface ReviewService {

	/**
	 * 
	* @Title: selectReviewPageList
	* @Description: 评论分页查询 
	* @param @param map
	* @param @return    
	* @return List<KkReview>    
	* @throws
	 */
	KkResult selectReviewPageList(String blogId, Integer pageNum, Integer count, Integer PAGE_COUNT);
	
	/**
	 * 
	* @Title: addReview
	* @Description: 新增评论
	* @param @param review
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult addReview(KkReview review);
	
	/**
	 * 
	* @Title: removeReview
	* @Description: 删除评论
	* @param @param reviewId
	* @param @return    
	* @return KkResult    
	* @throws
	 */
	KkResult removeReview(String reviewId);
}
