package top.keking.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import top.keking.pojo.KkBlog;
import top.keking.pojo.KkBlogExample;

public interface KkBlogMapper {
    int countByExample(KkBlogExample example);

    int deleteByExample(KkBlogExample example);

    int deleteByPrimaryKey(String blogid);

    int insert(KkBlog record);

    int insertSelective(KkBlog record);

    List<KkBlog> selectByExample(KkBlogExample example);

    KkBlog selectByPrimaryKey(String blogid);

    int updateByExampleSelective(@Param("record") KkBlog record, @Param("example") KkBlogExample example);

    int updateByExample(@Param("record") KkBlog record, @Param("example") KkBlogExample example);

    int updateByPrimaryKeySelective(KkBlog record);

    int updateByPrimaryKey(KkBlog record);
    
    //分页查询博客列表
    List<KkBlog> selectToPageList(Map<String, Object> map);
    
    //查询热门博客列表
    List<KkBlog> selectToHostList(int count);
    
    //网站管理分页查询博客列表
    List<KkBlog> selectToManagerList(Map<String, Object> map);
    
    //显示博客内容查询
    KkBlog selectBlogByBlogId(String blogId);
    
    //阅读数加一
    int updateReadNum(String blogId);
    
    //收藏数加一
    int updateKeepNum(String blogId);
    
    //评论数加一
    int updateReviewNum(String blogId);
    
    //搜索查询
    List<KkBlog> searchToPageList(Map<String, Object> map);
    
}