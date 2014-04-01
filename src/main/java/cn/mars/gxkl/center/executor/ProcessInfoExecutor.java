package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.AppProtocol;
import cn.mars.gxkl.protocol.FrontEndingCommunicationProtocol;
import cn.mars.gxkl.protocol.HandleDetails;
import cn.mars.gxkl.protocol.LiveMessageProtocol;
import cn.mars.gxkl.utils.Jsoner;
import cn.mars.gxkl.utils.Pair;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class ProcessInfoExecutor implements Executor {
	
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

	@Override
	public void decode(AppProtocol response) {
		List<Pair<Date, String>>pairs=translate(response);
		for (int i=0;i<pairs.size();i++){
			System.out.println(pairs.get(i).getFirst().toString()+": "+pairs.get(i).getLast());
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
					int rfid = handleDetails.getMachineRfid();
					try {
						ans.addAll(handleRetValue(handleDetails.getTimeStamp(), handleDetails.getItemAdd(), "完成处理", "器械"));
						ans.addAll(handleRetValue(handleDetails.getTimeStamp(), handleDetails.getItemRemove(), "完成处理", "器械"));
						ans.addAll(handleRetValue(handleDetails.getTimeStamp(), handleDetails.getPackageAdd(), "开始处理","手术包"));
						ans.addAll(handleRetValue(handleDetails.getTimeStamp(), handleDetails.getPackageRemove(), "完成处理","手术包"));
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
	private ItemInfoDO map2ItemInfoDO(Map<String, Object> map) {
		ItemInfoDO ret = new ItemInfoDO();

		if (map.containsKey("itemId")) {
			ret.setItemId(((Double) map.get("itemId")).intValue());
		}
		if (map.containsKey("gmtCreate")) {
			ret.setGmtCreate(new Date((String) map.get("gmtCreate")));
		}
		if (map.containsKey("gmtModified")) {
			ret.setGmtModified(new Date((String) map.get("gmtModified")));
		}
		if (map.containsKey("itemName")) {
//			try {
//				ret.setItemName(changeCharset((String) map.get("itemName"),"UTF-8","GBK"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ret.setItemName((String) map.get("itemName"));
		}
		if (map.containsKey("itemType")) {
			ret.setItemType(((Double) map.get("itemType")).intValue());
		}
		if (map.containsKey("hospitalId")) {
			ret.setHospitalId(((Double) map.get("hospitalId")).intValue());
		}
		if (map.containsKey("manufacturer")) {
//			try {
//				ret.setManufacturer(changeCharset((String) map.get("manufacturer"), "UTF-8", "GBK"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ret.setManufacturer((String) map.get("manufacturer"));
		}
		if (map.containsKey("interconvertible")) {
			ret.setInterconvertible((Boolean) map.get("interconvertible"));
		}
		if (map.containsKey("remark")) {
//			try {
//				ret.setRemark(changeCharset((String) map.get("remark"),"UTF-8","GBK"));
//			} catch (UnsupportedEncodingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			ret.setRemark((String) map.get("remark"));
		}

		return ret;
	}

	private List<Pair<Date, String>> handleRetValue(Date time, List<Object> rfid, String dir,
			String type) {
		List<Pair<Date, String>> ans = new ArrayList<Pair<Date, String>>();
		int size = rfid.size();
		for (int i = 0; i < size; i++) {
			// System.out.println(rfid.get(i).toString());
			ItemInfoDO itemInfo = map2ItemInfoDO((Map<String, Object>) rfid.get(i));

			ans.add(new Pair<Date, String>(time, type + " " + itemInfo.getItemName() + " " + dir
					+ " RFID:" + itemInfo.getItemId().toString()));
		}
		return ans;
	}
	
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

}
