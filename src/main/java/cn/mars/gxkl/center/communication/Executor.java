package cn.mars.gxkl.center.communication;

import cn.mars.gxkl.protocol.AppProtocol;

/**
 * 
 * @author hawklithm
 * 2014-4-1上午10:07:47
 */
public interface Executor {
	/**
	 * 判断是否需要在创建的时候即发送初始化请求,如请求设备流水信息和通知信息需要提前发送请求告诉服务器并建立长连接便于信息实时传输
	 * 
	 * @return
	 */
	boolean isInitialFirst();

	/**
	 * 发送初始化请求，与服务器建立长连接
	 */
	void sendInitRequest();

	/**
	 * 解析并进行界面渲染
	 * @param response
	 */
	void decode(AppProtocol response) throws Exception;
}
