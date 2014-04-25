package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.sender.Sender4Face;
import cn.mars.gxkl.utils.Jsoner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/*
 * 机器信息执行器
 * targetUrl代表的本执行器处理的URL
 * 
 */
public class MachineInfoExecutor implements Executor,Sender,Sender4Face {

	private boolean isInitialFirst=true;
	private ClientService client;
	private String targetUrl;
	private int targetMachineRFID=1025;
	private Msg2Face msg2Face;

	@Override
	public boolean isInitialFirst() {
		return isInitialFirst;
	}

	@Override
	public void sendInitRequest() {
		query(new Integer(targetMachineRFID));
		return;
	}
	
/*
 * 解码
 * 
 * (non-Javadoc)
 * @see cn.mars.gxkl.center.communication.Executor#decode(cn.mars.gxkl.protocol.AppProtocol)
 */
	@Override
	public void decode(AppProtocol response) {
		List<Equipment> equipments=translate(response);
		for (int i=0;i<equipments.size();i++){
			System.out.println("[MachineInfoExecutor]"+Jsoner.toJson(equipments.get(i)));
		}
		msg2Face.setText(equipments);
	}
	
	private List< Equipment> translate(AppProtocol response){
		try {
			FrontEndingCommunicationProtocol<Equipment> msgContent = Jsoner.fromJson(
					response.getResponse(),
					new TypeToken<FrontEndingCommunicationProtocol<Equipment>>() {
					}.getType());
			List<Equipment> liveMessage = msgContent.getRows();
			return liveMessage;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	//编码
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

	public int getTargetMachineRFID() {
		return targetMachineRFID;
	}

	public void setTargetMachineRFID(int targetMachineRFID) {
		this.targetMachineRFID = targetMachineRFID;
	}

	public Msg2Face getMsg2Face() {
		return msg2Face;
	}

	public void setMsg2Face(Msg2Face msg2Face) {
		this.msg2Face = msg2Face;
	}

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		
	}

}
