package top.keking.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkScroll;
import top.keking.pojo.KkScrollExample;

public interface KkScrollMapper {
    int countByExample(KkScrollExample example);

    int deleteByExample(KkScrollExample example);

    int deleteByPrimaryKey(String scrollid);

    int insert(KkScroll record);

    int insertSelective(KkScroll record);

    List<KkScroll> selectByExample(KkScrollExample example);

    KkScroll selectByPrimaryKey(String scrollid);

    int updateByExampleSelective(@Param("record") KkScroll record, @Param("example") KkScrollExample example);

    int updateByExample(@Param("record") KkScroll record, @Param("example") KkScrollExample example);

    int updateByPrimaryKeySelective(KkScroll record);

    int updateByPrimaryKey(KkScroll record);
    
    //查询滚屏列表
    List<KkScroll> selectScrollList(int count);
}