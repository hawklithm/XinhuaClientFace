package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.mars.gxkl.UI.Login;
import cn.mars.gxkl.UI.ManagerUI;
import cn.mars.gxkl.UI.WorkerUI;
import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
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
	@Override
	public void query(Object object) {
		// TODO Auto-generated method stub
		//UserInfo user=(UserInfo)object;
		UserInfo user=(UserInfo)object;
		client.sendMessage(encoder(user,"operateQuery"));
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
	public void decode(AppProtocol response) {
		List<UserInfo> users=translate(response);
	  if(users.get(0).getName()==null){
      System.out.println("用户名不存在");
     login.setMsg("用户名不存在");
         return;
	   }		
		if(login.getPassword().getText().toString().equals(users.get(0).getPassword())){
			if(users.get(0).getLevel().equals("common user")){
				 workerUI.showUp();		
				 login.setVisible(false);
			}
			if(users.get(0).getLevel().equals("work_manager")){
				managerUI.showUp();
				login.setVisible(false);
			}
		
		 }
		else{
			login.setMsg("密码错误，请重新输入");
		}
		}
	
	
	private String encoder(UserInfo user,String operateType) {
//		LiveMessageProtocol liveMsg = new LiveMessageProtocol();
//		liveMsg.setProcessName(processNow);
		List<UserInfo> rows = new ArrayList<UserInfo>();
		rows.add(user);
		FrontEndingCommunicationProtocol<UserInfo> content = new FrontEndingCommunicationProtocol<UserInfo>();
		//content.setRows(null);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("operateType", operateType);
		content.setCondition(condition);
		content.setRows(rows);
		Gson gson = new Gson();
		AppProtocol msg = new AppProtocol();
		 msg.setTargetUrl(targetUrl);
		msg.setContent(gson.toJson(content));
		msg.setAuthenticate("");
		System.out.println("卧槽"+gson.toJson(msg));
		if(gson.toJson(msg)==null){
			System.out.println("卧槽"+"居然是控制");
		}
		return gson.toJson(msg);
	}
	private List< UserInfo> translate(AppProtocol response){
		try {
			FrontEndingCommunicationProtocol<UserInfo> msgContent = Jsoner.fromJson(
					response.getResponse(),
					new TypeToken<FrontEndingCommunicationProtocol<UserInfo>>() {
					}.getType());
			List<UserInfo> liveMessage = msgContent.getRows();
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

	

}
