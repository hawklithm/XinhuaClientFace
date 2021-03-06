package cn.mars.gxkl.protocol;
/*
 * App协议
 * 包括目标URL,状态码、内容、验证消息、响应
 */
public class AppProtocol {
	
	private String targetUrl,status,content,authenticate,response;
	
	public AppProtocol(String content) {
		this.content = content;
	}
	
	public AppProtocol() {
		/***
		 * 
		 *  绌烘瀯閫犲嚱鏁�
		 * 
		 ***/
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(String authenticate) {
		this.authenticate = authenticate;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
