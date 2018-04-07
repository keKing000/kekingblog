package top.keking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkUser;
import top.keking.pojo.KkUserExample;

public interface KkUserMapper {
    int countByExample(KkUserExample example);

    int deleteByExample(KkUserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(KkUser record);

    int insertSelective(KkUser record);

    List<KkUser> selectByExample(KkUserExample example);

    KkUser selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") KkUser record, @Param("example") KkUserExample example);

    int updateByExample(@Param("record") KkUser record, @Param("example") KkUserExample example);

    int updateByPrimaryKeySelective(KkUser record);

    int updateByPrimaryKey(KkUser record);
    
    //分页查询用户
    List<KkUser> selectUserByPage(Map<String, Object> map);
}