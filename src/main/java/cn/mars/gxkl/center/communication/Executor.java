package cn.mars.gxkl.center.communication;

import cn.mars.gxkl.protocol.AppProtocol;

public interface Executor {
	 boolean  isInitialFirst();

	void sendInitRequest();

	void decode(AppProtocol response);
}
