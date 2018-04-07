package top.keking.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class KkScroll implements Serializable {
	private static final long serialVersionUID = 6720470344450807534L;

	private String scrollid;

    private String scrolltitle;

    private String blogid;

    private Integer status;

    private String scrollimg;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date creatdate;

    public String getScrollid() {
        return scrollid;
    }

    public void setScrollid(String scrollid) {
        this.scrollid = scrollid == null ? null : scrollid.trim();
    }

    public String getScrolltitle() {
        return scrolltitle;
    }

    public void setScrolltitle(String scrolltitle) {
        this.scrolltitle = scrolltitle == null ? null : scrolltitle.trim();
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

    public String getScrollimg() {
        return scrollimg;
    }

    public void setScrollimg(String scrollimg) {
        this.scrollimg = scrollimg == null ? null : scrollimg.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}