package cn.mars.gxkl.center.executor;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.mars.gxkl.UI.Login;
import cn.mars.gxkl.UI.ManagerUI;
import cn.mars.gxkl.UI.WorkerUI;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.protocol.Person;
import cn.mars.gxkl.protocol.UserInfo;
import cn.mars.gxkl.utils.Jsoner;

public class UserInfoExecutor implements Executor,Sender{
	private boolean isInitialFirst=false;
	private ClientService client;
	private String targetUrl;
	private Login login;
	private WorkerUI workerUI;
	private ManagerUI managerUI;
	
	private StaffInfoPanel staffpanel_worker;
	@Override
	public void query(Object object) {
		UserInfo user=(UserInfo)object;
		//staffpanel_worker.setWorker_num(Integer.valueOf(user.getId()));
	client.sendMessage(encoder(user,"operateLogin"));
	}
	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isInitialFirst() {
		// TODO Auto-generated method stub
		return isInitialFirst;
	}
	@Override
	public void sendInitRequest() {
		// TODO Auto-generated method stub
		return;
		
	}
	@Override
	public void decode(AppProtocol response) throws MalformedURLException {
		List<Person> users=translate(response);
	 System.out.println("Òª°ÂÁú"+users.toString());
	 staffpanel_worker.setText(users);
	 workerUI.showUp();
	 login.setVisible(false);
	}
	
	private String encoder(UserInfo user,String operateType) {
//		LiveMessageProtocol liveMsg = new LiveMessageProtocol();
//		liveMsg.setProcessName(processNow);
		List<UserInfo> rows = new ArrayList<UserInfo>();
		rows.add(user);
		FrontEndingCommunicationProtocol<UserInfo> content = new FrontEndingCommunicationProtocol<UserInfo>();
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("operateType", operateType);
		content.setCondition(condition);
		content.setRows(rows);
		Gson gson = new Gson();
		AppProtocol msg = new AppProtocol();
		 msg.setTargetUrl(targetUrl);
		msg.setContent(gson.toJson(content));
		msg.setAuthenticate("");
		if(gson.toJson(msg)==null){
		}
		return gson.toJson(msg);
	}
	private List<Person> translate(AppProtocol response){
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public WorkerUI getWorkerUI() {
		return workerUI;
	}
	public void setWorkerUI(WorkerUI workerUI) {
		this.workerUI = workerUI;
	}
	public ManagerUI getManagerUI() {
		return managerUI;
	}
	public void setManagerUI(ManagerUI managerUI) {
		this.managerUI = managerUI;
	}
	public StaffInfoPanel getStaffpanel_worker() {
		return staffpanel_worker;
	}
	public void setStaffpanel_worker(StaffInfoPanel staffpanel_worker) {
		this.staffpanel_worker = staffpanel_worker;
	}


	

}
