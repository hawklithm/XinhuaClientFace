package cn.mars.gxkl.protocol;

public class AppProtocol {
	
	private String targetUrl,status,content,authenticate,response,keepAlive;
	
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

	public String getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(String keepAlive) {
		this.keepAlive = keepAlive;
	}
}
