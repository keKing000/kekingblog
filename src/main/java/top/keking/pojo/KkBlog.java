package top.keking.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class KkBlog implements Serializable {
	private static final long serialVersionUID = 6266855366571553521L;

	private String blogid;

    private String userid;

    private String blogtitle;

    private String descid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date creatdate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updatedate;

    private Integer keepnum;

    private Integer readnum;

    private Integer reviewnum;

    private Integer status;
    
    private KkUser user;
    
    private KkDesc desc;
    
    public KkDesc getDesc() {
		return desc;
	}

	public void setDesc(KkDesc desc) {
		this.desc = desc;
	}

	public KkUser getUser() {
		return user;
	}

	public void setUser(KkUser user) {
		this.user = user;
	}

	public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid == null ? null : blogid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle == null ? null : blogtitle.trim();
    }

    public String getDescid() {
        return descid;
    }

    public void setDescid(String descid) {
        this.descid = descid == null ? null : descid.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getKeepnum() {
        return keepnum;
    }

    public void setKeepnum(Integer keepnum) {
        this.keepnum = keepnum;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public Integer getReviewnum() {
        return reviewnum;
    }

    public void setReviewnum(Integer reviewnum) {
        this.reviewnum = reviewnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}