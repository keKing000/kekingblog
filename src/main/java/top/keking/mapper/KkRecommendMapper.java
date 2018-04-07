package top.keking.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkRecommend;
import top.keking.pojo.KkRecommendExample;

public interface KkRecommendMapper {
    int countByExample(KkRecommendExample example);

    int deleteByExample(KkRecommendExample example);

    int deleteByPrimaryKey(String recommendid);

    int insert(KkRecommend record);

    int insertSelective(KkRecommend record);

    List<KkRecommend> selectByExample(KkRecommendExample example);

    KkRecommend selectByPrimaryKey(String recommendid);

    int updateByExampleSelective(@Param("record") KkRecommend record, @Param("example") KkRecommendExample example);

    int updateByExample(@Param("record") KkRecommend record, @Param("example") KkRecommendExample example);

    int updateByPrimaryKeySelective(KkRecommend record);

    int updateByPrimaryKey(KkRecommend record);
    
    //查询最新推荐
    List<KkRecommend> selectRecommendList(int count);
}