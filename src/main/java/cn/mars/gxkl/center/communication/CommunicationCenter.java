package cn.mars.gxkl.center.communication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.utils.Pair;

/**
 *控制中心 
 * @author hawklithm
 * 2014-4-11下午5:56:56
 */
public class CommunicationCenter implements Runnable {

	private ClientService client;
	private boolean closed = false;
	private Map<String, Executor> map = new HashMap<String, Executor>();


	public void initialization() {
		System.out.println("connecting");
		while (!client.isConnected()) {
			System.out.print(".");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		requestAll();
		new Thread(this).start();
	}

	public boolean getACK() {
		// return client.getACK();
		return false;
	}

	public boolean getConnectionStatus() {
		// return client.getConnectionStatus();
		return false;
	}

	public void requestAll() {
		for (Map.Entry<String, Executor> entry : map.entrySet()) {
			String key = entry.getKey().toString();
			Executor executor = entry.getValue();
			if (executor.isInitialFirst()) {
				initRequest(executor);
			}
		}
	}

	@Override
	public void run() {
		while (!closed) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			infoHandler();
		}
	}

	private void infoHandler() {
//		AppProtocol response = new AppProtocol();// client.getMessage();
		AppProtocol response =client.getMessage();
		if (response == null) {
			return;
		}
		System.out.println("something new ");
		List<Pair<Integer, String>> info = null;
		Executor executor = map.get(response.getTargetUrl());
		executor.decode(response);
	}

	public void initRequest(Executor executor) {
		executor.sendInitRequest();
	}

	public void execute(Executor executor, String message) {
	}

	public void closeConnection() {
		closed = true;
	}



	public Map<String, Executor> getMap() {
		return map;
	}

	public void setMap(Map<String, Executor> map) {
		this.map = map;
	}


	public ClientService getClient() {
		return client;
	}

	public void setClient(ClientService client) {
		this.client = client;
	}

}
