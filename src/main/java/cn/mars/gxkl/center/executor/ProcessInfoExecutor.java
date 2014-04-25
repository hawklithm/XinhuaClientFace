package cn.mars.gxkl.center.executor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.center.communication.Executor;
import cn.mars.gxkl.center.communication.Sender;
import cn.mars.gxkl.constant.Constant;
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
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

/*
 * 流水线过程信息执行器
 */
public class ProcessInfoExecutor implements Executor, Sender {
	private boolean isInitialFirst = true;
	private ClientService client;
	private String targetUrl;
	private String processName = Constant.processName[0]; // 默认是分类
	private Msg2Face msg2Face;
	
	@Override
	public boolean isInitialFirst() {
		return isInitialFirst;
	}

	@Override
	public void sendInitRequest() {
		LiveMessageProtocol msg = new LiveMessageProtocol();
		msg.setProcessName(processName);
		client.sendMessage(encoder(msg, true));
	}

	@Override
	public void decode(AppProtocol response) {
		List<Pair<MachinedItemInfoDO, String>> pairs = translate(response);
		for (int i = 0; i < pairs.size(); i++) {
			System.out.println(pairs.get(i).getFirst().toString() + ": "
					+ pairs.get(i).getLast());
		}
		msg2Face.setText(pairs);
	}

	private List<Pair<MachinedItemInfoDO, String>> translate(AppProtocol response) {
		try {
			List<Pair<MachinedItemInfoDO, String>> ans = new ArrayList<Pair<MachinedItemInfoDO, String>>();
			FrontEndingCommunicationProtocol<LiveMessageProtocol> msgContent = Jsoner
					.fromJson(
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
						ans.addAll(handleRetValue(handleDetails.getTimeStamp(),
								handleDetails.getMachineRfid(),
								handleDetails.getStaffRFID(),
								handleDetails.getItemInfo(),
								handleDetails.getSourceType()));
						// ans.addAll(handleRetValue(handleDetails.getTimeStamp(),
						// handleDetails.getItemAdd(), "进入设备", "器械"));
						// ans.addAll(handleRetValue(handleDetails.getTimeStamp(),
						// handleDetails.getItemRemove(), "离开设备", "器械"));
						// ans.addAll(handleRetValue(handleDetails.getTimeStamp(),
						// handleDetails.getPackageAdd(), "进入设备","手术包"));
						// ans.addAll(handleRetValue(handleDetails.getTimeStamp(),
						// handleDetails.getPackageRemove(), "离开设备","手术包"));
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
			ret.setItemName((String) map.get("itemName"));
		}
		if (map.containsKey("itemType")) {
			ret.setItemType(((Double) map.get("itemType")).intValue());
		}
		if (map.containsKey("hospitalId")) {
			ret.setHospitalId(((Double) map.get("hospitalId")).intValue());
		}
		if (map.containsKey("manufacturer")) {
			ret.setManufacturer((String) map.get("manufacturer"));
		}
		if (map.containsKey("interconvertible")) {
			ret.setInterconvertible((Boolean) map.get("interconvertible"));
		}
		if (map.containsKey("remark")) {
			ret.setRemark((String) map.get("remark"));
		}

		return ret;
	}

	private List<Pair<MachinedItemInfoDO, String>> handleRetValue(Date time, int mRfid,
			int sRfid, List<Map<String,Object>> maps, String sourceType) {
		List<Pair<MachinedItemInfoDO, String>> ans = new ArrayList<Pair<MachinedItemInfoDO, String>>();
		for (Map<String,Object> map : maps) {
			MachinedItemInfoDO item = new MachinedItemInfoDO(map,mRfid);
			ans.add(new Pair<MachinedItemInfoDO, String>(item, "[" + time.toString()
					+ "]" + item.getItemName() + " " + item.getStatus()
					+ " RFID:" + item.getItemId()));
		}
		return ans;
	}

	private List<Pair<ItemInfoDO, String>> handleRetValue(Date time,
			List<Object> rfid, String dir, String type) {
		List<Pair<ItemInfoDO, String>> ans = new ArrayList<Pair<ItemInfoDO, String>>();
		int size = rfid.size();
		for (int i = 0; i < size; i++) {
			ItemInfoDO itemInfo = map2ItemInfoDO((Map<String, Object>) rfid
					.get(i));

			ans.add(new Pair<ItemInfoDO, String>(itemInfo, "["
					+ itemInfo.getGmtCreate().toString() + "]" + type + " "
					+ itemInfo.getItemName() + " " + dir + " RFID:"
					+ itemInfo.getItemId().toString()));
		}
		return ans;
	}

	private String encoder(LiveMessageProtocol liveMsg, boolean keepAlive) {
		// LiveMessageProtocol liveMsg = new LiveMessageProtocol();
		// liveMsg.setProcessName(processNow);
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
		// msg.setTargetUrl(url);
		msg.setTargetUrl(targetUrl);
		msg.setContent(gson.toJson(content));
		msg.setAuthenticate("");
		if (keepAlive) {
			msg.setKeepAlive("keep_alive_true");
		}
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
		processName = (String) object;
		LiveMessageProtocol msg = new LiveMessageProtocol();
		msg.setProcessName(processName);
		client.sendMessage(encoder(msg, true));
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub

	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public void setInitialFirst(boolean isInitialFirst) {
		this.isInitialFirst = isInitialFirst;
	}

	public Msg2Face getMsg2Face() {
		return msg2Face;
	}

	public void setMsg2Face(Msg2Face msg2Face) {
		this.msg2Face = msg2Face;
	}

}
