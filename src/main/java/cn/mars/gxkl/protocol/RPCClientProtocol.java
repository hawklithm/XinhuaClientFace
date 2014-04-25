package cn.mars.gxkl.protocol;
//自定义的客户端请求
public class RPCClientProtocol {
	
  private String[] paramters;
  private String version;
  private String className;
  private String userName;
  private String methodName;
public String[] getParamters() {
	return paramters;
}
public void setParamters(String[] paramters) {
	this.paramters = paramters;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getMethodName() {
	return methodName;
}
public void setMethodName(String methodName) {
	this.methodName = methodName;
}
  

}
