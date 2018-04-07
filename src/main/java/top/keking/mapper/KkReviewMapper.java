package top.keking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkReview;
import top.keking.pojo.KkReviewExample;

public interface KkReviewMapper {
    int countByExample(KkReviewExample example);

    int deleteByExample(KkReviewExample example);

    int deleteByPrimaryKey(String reviewid);

    int insert(KkReview record);

    int insertSelective(KkReview record);

    List<KkReview> selectByExampleWithBLOBs(KkReviewExample example);

    List<KkReview> selectByExample(KkReviewExample example);

    KkReview selectByPrimaryKey(String reviewid);

    int updateByExampleSelective(@Param("record") KkReview record, @Param("example") KkReviewExample example);

    int updateByExampleWithBLOBs(@Param("record") KkReview record, @Param("example") KkReviewExample example);

    int updateByExample(@Param("record") KkReview record, @Param("example") KkReviewExample example);

    int updateByPrimaryKeySelective(KkReview record);

    int updateByPrimaryKeyWithBLOBs(KkReview record);

    int updateByPrimaryKey(KkReview record);
    
    //分页查询评论列表
    List<KkReview> selectReviewPageList(Map<String, Object> map);
}