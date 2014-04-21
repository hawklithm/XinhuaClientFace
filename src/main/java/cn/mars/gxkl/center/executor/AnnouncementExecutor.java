package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.protocol.HandleDetails;
import cn.mars.gxkl.protocol.LiveMessageProtocol;
import cn.mars.gxkl.utils.Jsoner;
import cn.mars.gxkl.utils.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/*
 * 消息通知执行器
 * Executor主要是用来确定解析协议并且渲染界面、发送初始请求，与服务器进行连接
 * Sender发送查询更新功能
 * 
 * 
 */
public class AnnouncementExecutor implements Executor,Sender{

	private boolean isInitialFirst=true;
	private ClientService client;
	private String targetUrl;
	@Override
	public boolean isInitialFirst() {
		return isInitialFirst;
	}

	@Override
	public void sendInitRequest() {
		client.sendMessage(encoder(new LiveMessageProtocol()));
	}
/*
 * 解码(non-Javadoc)
 * @see cn.mars.gxkl.center.communication.Executor#decode(cn.mars.gxkl.protocol.AppProtocol)
 */
	@Override
	public void decode(AppProtocol response) {
		List<Pair<Date, String>>pairs=translate(response);
		for (int i=0;i<pairs.size();i++){
			System.out.println("[AnnouncementExecutor]"+pairs.get(i).getFirst().toString()+": "+pairs.get(i).getLast());
		}
		//TODO 添加处理控件显示
	}
	
	private List<Pair<Date, String>> translate(AppProtocol response){
		try {
			List<Pair<Date, String>> ans = new ArrayList<Pair<Date, String>>();
			FrontEndingCommunicationProtocol<LiveMessageProtocol> msgContent = Jsoner.fromJson(
					response.getResponse(),
					new TypeToken<FrontEndingCommunicationProtocol<LiveMessageProtocol>>() {
					}.getType());
			List<LiveMessageProtocol> liveMessage = msgContent.getRows();
			for (int i = 0; i < liveMessage.size(); i++) {
				LiveMessageProtocol pro = liveMessage.get(i);
				List<Map<String, Object>> retValue = pro.getRetValue();
				int size = retValue.size();
				for (int j = 0; j < size; j++) {
					HandleDetails handleDetails;
					try {
						handleDetails = new HandleDetails(retValue.get(j));
					} catch (IndexOutOfBoundsException e) {
						continue;
					}
					try {
						ans.add(new Pair<Date,String>(handleDetails.getTimeStamp(), handleDetails.getMessage()));
					} catch (NullPointerException e) {
						continue;
					}
				}
			}
			return ans;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

/*
 * 编码
 */
	private String encoder(LiveMessageProtocol liveMsg) {
//		LiveMessageProtocol liveMsg = new LiveMessageProtocol();
//		liveMsg.setProcessName(processNow);
		List<LiveMessageProtocol> rows = new ArrayList<LiveMessageProtocol>();
		rows.add(liveMsg);
		FrontEndingCommunicationProtocol<LiveMessageProtocol> content = new FrontEndingCommunicationProtocol<LiveMessageProtocol>();
		content.setRows(null);
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("operateType", "operateQuery");
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

	public void setInitialFirst(boolean isInitialFirst) {
		this.isInitialFirst = isInitialFirst;
	}

	@Override
	public void query(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}


}
