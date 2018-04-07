package top.keking.pojo;

import java.io.Serializable;
/**
 * 
* @ClassName: KkResult
* @Description:返回结果pojo 
* @author wk
* @date 2018年3月15日 下午10:48:06
*
 */
public class KkResult implements Serializable {

	private static final long serialVersionUID = -4310290378552792913L;
	
	private Integer status;
	private String message;
	private Object data;
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "KkResult [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
