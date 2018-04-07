package top.keking.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class KkRecommend implements Serializable {
	private static final long serialVersionUID = -1214603184501223709L;

	private String recommendid;

    private String blogid;

    private Integer status;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date creatdate;
    
    private KkBlog blog;

    public KkBlog getBlog() {
		return blog;
	}

	public void setBlog(KkBlog blog) {
		this.blog = blog;
	}

	public String getRecommendid() {
        return recommendid;
    }

    public void setRecommendid(String recommendid) {
        this.recommendid = recommendid == null ? null : recommendid.trim();
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid == null ? null : blogid.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}