package cn.mars.gxkl.netty;

import org.jboss.netty.channel.Channel;

import cn.mars.gxkl.observe.DataCenter;
import cn.mars.gxkl.observe.Observer;

public class ClientService {
	
	private String addr;
	private int port;
	private Channel channel;
	private DataCenter dataCenter;
	
	public ClientService(int port, DataCenter dataCenter) {
		this.port = port;
		this.dataCenter = dataCenter;
//		this.dataCenter.register(this, "ClientService");
		initialization();
	}
	
	public ClientService(String addr, int port, DataCenter dataCenter) {
		this(port,dataCenter);
		this.addr = addr;
	}
	
	private void initialization() {
		
	}

	
}
