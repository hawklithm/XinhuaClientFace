package cn.mars.gxkl.UI.dataobject;

import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_DOING;
import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_DONE;
import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_TODO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.mars.gxkl.UI.dataobject.utils.StatisticNumber;
import cn.mars.gxkl.UI.dataobject.utils.StatisticTableCell;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

public class EquipItemInfoHandlerBak implements Rfid2Item,ItemsAddition {

	private Map<String, StatisticTableCell[]> table = new TreeMap<String, StatisticTableCell[]>();
	private Map<String,MachinedItemInfoDO> rfid2Item = new HashMap<String,MachinedItemInfoDO>();
	private Map<String,String> runtimeInfo = new TreeMap<String,String>();
	
	@Override
	public void addItemVector(List<?> items) {
		for(MachinedItemInfoDO item : (List<MachinedItemInfoDO>)items) {
			String name = item.getItemName();
			String mRfid = item.getMachineId().toString();
			StatisticTableCell[] cell = table.get(name);
			if(cell == null) {
				cell = new StatisticTableCell[] {
						new StatisticTableCell(),new StatisticTableCell()
				};
			}
			switch(item.getStatus()) {
				case ITEM_STATUS_TODO:;break;
				case ITEM_STATUS_DOING: {
					cell[0].add(item);
					runtimeInfo.put(item.getItemId().toString(),name);
				}break;
				case ITEM_STATUS_DONE: {
					cell[1].add(item);
					if(cell[0].contains(item)) {
						cell[0].remove(item);
						runtimeInfo.remove(item.getItemId().toString());
					}
				}
			}
			table.put(name, cell);
			rfid2Item.put(item.getItemId().toString(), item);
		}
	}
	
	@Override
	public List<String> getRfidVector(int equiId, String name, int column) {
		return table.get(name)[column-1].getAllRfid();
	}
	
	public List<List<String>> getRuntimeInfomation() {
		List<List<String>> ret = new ArrayList<List<String>>();
		Iterator<String> iterator = runtimeInfo.keySet().iterator();
		while(iterator.hasNext()) {
			String rfid = iterator.next();
			List<String> list = new ArrayList<String>();
			list.add(runtimeInfo.get(rfid));
			list.add(rfid);
			ret.add(list);
		}
		return ret;
	}
	
	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		return rfid2Item.get(rfid);
	}
	
	public List<List<String>> getStatisticNumber() {
		Iterator<String> iterator = table.keySet().iterator();
		List<List<String>> all = new ArrayList<List<String>>();
		while(iterator.hasNext()) {
			String name = iterator.next();
			List<String> list = new ArrayList<String>();
			list.add(name);
			StatisticNumber[] staNum = table.get(name);
			for(StatisticNumber now : staNum) {
					list.add(now.getNumber().toString());
			}
			all.add(list);
		}
		return all;
	}
	
//	private Map<String,List<Integer>> staData = new HashMap<String,List<Integer>>(),
//									  retData = new HashMap<String,List<Integer>>();
//	private Map<String,ItemInfoDO> itemData = new HashMap<String,ItemInfoDO>();
//	private Integer rowCnt = 0;
//	
//	@Override
//	public ItemInfoDO getItemByRfid(String rfid) {
//		return itemData.get(rfid);
//	}
//
//	@Override
//	public void addItemVector(List<?> items) {
//		retData.clear();
//		for(ItemInfoDO item : (List<ItemInfoDO>)items) {
//			itemData.put(item.getItemId().toString(), item);
//			List<Integer> vector = addItem(item);
//			staData.put(item.getItemName(), vector);
//			retData.put(item.getItemName(), vector);
//		}
//	}
//	
//	private List<Integer> addItem(ItemInfoDO item) {
//		List<Integer> data = staData.get(item.getItemName());
//		if(data == null) {
//			data = new ArrayList<Integer>();
//			data.add(rowCnt++);
//			data.add(0);
//			data.add(0);
//		}
//		int status = item.getStatus();
//		switch(status) {
//			case ITEM_STATUS_DOING:data.set(1, data.get(1)+1);break;
//			case ITEM_STATUS_DONE:data.set(2, data.get(2)+1);
//		}
//		return data;
//	}
//	
//	public Map<String,List<Integer>> getStaVector() {
//		return retData;
//	}
//
//	@Override
//	public List<String> getRfidVector(int flag, String name, int column) {
//		return null;
//	}
	
}
