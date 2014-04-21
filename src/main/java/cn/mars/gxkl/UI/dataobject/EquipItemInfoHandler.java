package cn.mars.gxkl.UI.dataobject;

import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_DOING;
import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_DONE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class EquipItemInfoHandler implements Rfid2Item,ItemsAddition {

	private Map<String,List<Integer>> staData = new HashMap<String,List<Integer>>(),
									  retData = new HashMap<String,List<Integer>>();
	private Map<String,ItemInfoDO> itemData = new HashMap<String,ItemInfoDO>();
	private Integer rowCnt = 0;
	
	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		return itemData.get(rfid);
	}

	@Override
	public void addItemVector(List<?> items) {
		retData.clear();
		for(ItemInfoDO item : (List<ItemInfoDO>)items) {
			itemData.put(item.getItemId().toString(), item);
			List<Integer> vector = addItem(item);
			staData.put(item.getItemName(), vector);
			retData.put(item.getItemName(), vector);
		}
	}
	
	private List<Integer> addItem(ItemInfoDO item) {
		List<Integer> data = staData.get(item.getItemName());
		if(data == null) {
			data = new ArrayList<Integer>();
			data.add(rowCnt++);
			data.add(0);
			data.add(0);
		}
		String status = item.getStatus();
		switch(status) {
			case ITEM_STATUS_DOING:data.set(1, data.get(1)+1);break;
			case ITEM_STATUS_DONE:data.set(2, data.get(2)+1);
		}
		return data;
	}
	
	public Map<String,List<Integer>> getStaVector() {
		return retData;
	}

	@Override
	public List<String> getRfidVector(int flag, int row, int column) {
		return null;
	}
	
}
