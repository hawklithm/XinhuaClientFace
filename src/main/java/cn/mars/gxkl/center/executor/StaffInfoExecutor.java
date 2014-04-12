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
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.protocol.Person;
import cn.mars.gxkl.utils.Jsoner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class StaffInfoExecutor implements Executor,Sender{
	private boolean isInitialFirst=true;
	private ClientService client;
	private String targetUrl="/StaffManager";
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
	

	@Override
	public void decode(AppProtocol response) {
		List<Person> persons=translate(response);
		for (int i=0;i<persons.size();i++){
			System.out.println("[StaffInfoExecutor]"+Jsoner.toJson(persons.get(i)));
		}
		msg2Face.setText(persons);
	}
	
	private List< Person> translate(AppProtocol response){
		try {
			FrontEndingCommunicationProtocol<Person> msgContent = Jsoner.fromJson(
					response.getResponse(),
					new TypeToken<FrontEndingCommunicationProtocol<Person>>() {
					}.getType());
			List<Person> liveMessage = msgContent.getRows();
			return liveMessage;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	private String encoder(Person liveMsg,String operateType) {
//		LiveMessageProtocol liveMsg = new LiveMessageProtocol();
//		liveMsg.setProcessName(processNow);
		List<Person> rows = new ArrayList<Person>();
		rows.add(liveMsg);
		FrontEndingCommunicationProtocol<Person> content = new FrontEndingCommunicationProtocol<Person>();
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
		Person person=new Person();
		person.setEquipmentId(id);
		client.sendMessage(encoder(person,"operateQuery"));
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


}
