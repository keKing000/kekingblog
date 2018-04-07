package top.keking.pojo;

import java.io.Serializable;

public class KkDesc implements Serializable {
	private static final long serialVersionUID = -8763422248608700907L;

	private String descid;

    private String blogid;

    private String content;

    public String getDescid() {
        return descid;
    }

    public void setDescid(String descid) {
        this.descid = descid == null ? null : descid.trim();
    }

    public String getBlogid() {
        return blogid;
    }

    public void setBlogid(String blogid) {
        this.blogid = blogid == null ? null : blogid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}