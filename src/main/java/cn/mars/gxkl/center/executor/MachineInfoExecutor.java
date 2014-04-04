package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.utils.Jsoner;
import cn.mars.gxkl.utils.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MachineInfoExecutor implements Executor,Sender {

	private boolean isInitialFirst=false;
	private ClientService client;
	private String targetUrl;

	@Override
	public boolean isInitialFirst() {
		return isInitialFirst;
	}

	@Override
	public void sendInitRequest() {
		return;
//		client.sendMessage(encoder(new LiveMessageProtocol()));
	}
	

	@Override
	public void decode(AppProtocol response) {
		List<Pair<String, Equipment>>pairs=translate(response);
		for (int i=0;i<pairs.size();i++){
			System.out.println("[MachineInfoExecutor]"+pairs.get(i).getFirst().toString()+": "+Jsoner.toJson(pairs.get(i).getLast()));
		}
		//TODO 添加处理控件显示
	}
	
	private List<Pair<String, Equipment>> translate(AppProtocol response){
		try {
			List<Pair<String, Equipment>> ans = new ArrayList<Pair<String, Equipment>>();
			FrontEndingCommunicationProtocol<Equipment> msgContent = Jsoner.fromJson(
					response.getResponse(),
					new TypeToken<FrontEndingCommunicationProtocol<Equipment>>() {
					}.getType());
			List<Equipment> liveMessage = msgContent.getRows();
			for (int i = 0; i < liveMessage.size(); i++) {
				Equipment pro = liveMessage.get(i);
				ans.add(new Pair<String,Equipment>(pro.getMachineNumber(),pro));
			}
			return ans;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String encoder(Equipment liveMsg,String operateType) {
//		LiveMessageProtocol liveMsg = new LiveMessageProtocol();
//		liveMsg.setProcessName(processNow);
		List<Equipment> rows = new ArrayList<Equipment>();
		rows.add(liveMsg);
		FrontEndingCommunicationProtocol<Equipment> content = new FrontEndingCommunicationProtocol<Equipment>();
		content.setRows(null);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("operateType", operateType);
		content.setCondition(condition);
		content.setRows(rows);
		Gson gson = new Gson();
		AppProtocol msg = new AppProtocol();
//		msg.setTargetUrl(url);
		 msg.setTargetUrl(targetUrl);
		msg.setContent(gson.toJson(content));
		msg.setAuthenticate("");
		return gson.toJson(msg);
	}

	public ClientService getClient() {
		return client;
	}

	public void setClient(ClientService client) {
		this.client = client;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}


	@Override
	public void query(Object object) {
		Integer id=(Integer) object;
		Equipment equipment=new Equipment();
		equipment.setEquipmentId(id);
		client.sendMessage(encoder(equipment,"operateQuery"));
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

}
