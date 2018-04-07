package top.keking.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class KkKeep implements Serializable {
	private static final long serialVersionUID = 4799959738992473011L;

	private String keepid;

    private String userid;

    private String blogid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date creatdate;

    public String getKeepid() {
        return keepid;
    }

    public void setKeepid(String keepid) {
        this.keepid = keepid == null ? null : keepid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid == null ? null : blogid.trim();
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}