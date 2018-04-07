package top.keking.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkDesc;
import top.keking.pojo.KkDescExample;

public interface KkDescMapper {
    int countByExample(KkDescExample example);

    int deleteByExample(KkDescExample example);

    int deleteByPrimaryKey(String descid);

    int insert(KkDesc record);

    int insertSelective(KkDesc record);

    List<KkDesc> selectByExampleWithBLOBs(KkDescExample example);

    List<KkDesc> selectByExample(KkDescExample example);

    KkDesc selectByPrimaryKey(String descid);

    int updateByExampleSelective(@Param("record") KkDesc record, @Param("example") KkDescExample example);

    int updateByExampleWithBLOBs(@Param("record") KkDesc record, @Param("example") KkDescExample example);

    int updateByExample(@Param("record") KkDesc record, @Param("example") KkDescExample example);

    int updateByPrimaryKeySelective(KkDesc record);

    int updateByPrimaryKeyWithBLOBs(KkDesc record);

    int updateByPrimaryKey(KkDesc record);
}