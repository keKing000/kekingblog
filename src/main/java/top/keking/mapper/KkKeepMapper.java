package top.keking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import top.keking.pojo.KkBlog;
import top.keking.pojo.KkKeep;
import top.keking.pojo.KkKeepExample;

public interface KkKeepMapper {
    int countByExample(KkKeepExample example);

    int deleteByExample(KkKeepExample example);

    int deleteByPrimaryKey(String keepid);

    int insert(KkKeep record);

    int insertSelective(KkKeep record);

    List<KkKeep> selectByExample(KkKeepExample example);

    KkKeep selectByPrimaryKey(String keepid);

    int updateByExampleSelective(@Param("record") KkKeep record, @Param("example") KkKeepExample example);

    int updateByExample(@Param("record") KkKeep record, @Param("example") KkKeepExample example);

    int updateByPrimaryKeySelective(KkKeep record);

    int updateByPrimaryKey(KkKeep record);
    
    //我的收藏分页查询
    List<KkBlog> selectCollToPageList(Map<String, Object> map);
}