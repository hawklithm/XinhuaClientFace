package cn.mars.gxkl.UI.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static cn.mars.gxkl.constant.Constant.*;
import cn.mars.gxkl.UI.dataobject.utils.StatisticNumber;
import cn.mars.gxkl.UI.dataobject.utils.StatisticTableCell;
import cn.mars.gxkl.utils.Pair;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

public class ProcessItemInfoHandlerBak implements ItemsAddition,Rfid2Item {
	
	private Map<String, StatisticTableCell[]> table = new TreeMap<String, StatisticTableCell[]>();
	private List<String> machineNum2MachinedRfid = new ArrayList<String>();
	private Map<String,MachinedItemInfoDO> rfid2Item = new HashMap<String,MachinedItemInfoDO>();

	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		return rfid2Item.get(rfid);
	}

	@Override
	public void addItemVector(List<?> items) {
		for(MachinedItemInfoDO item : (List<MachinedItemInfoDO>)items) {
			String name = item.getItemName();
			String mRfid = item.getMachineId().toString();
			StatisticTableCell[] cell = table.get(name);
			if(cell == null) {
				cell = new StatisticTableCell[] {
						new StatisticTableCell(),new StatisticTableCell(),new StatisticTableCell()
				};
			}
			switch(item.getStatus()) {
				case ITEM_STATUS_TODO: cell[0].add(item);break;
				case ITEM_STATUS_DOING: {
					cell[1].add(item);
					if(cell[0].contains(item)) {
						cell[0].remove(item);
					}
					if(!machineNum2MachinedRfid.contains(mRfid)) {
						machineNum2MachinedRfid.add(mRfid);
					}
				}break;
				case ITEM_STATUS_DONE: {
					cell[2].add(item);
					if(cell[1].contains(item)) {
						cell[1].remove(item);
					}
					if(!machineNum2MachinedRfid.contains(mRfid)) {
						machineNum2MachinedRfid.add(mRfid);
					}
				}
			}
			table.put(name, cell);
			rfid2Item.put(item.getItemId().toString(), item);
		}
	}

	@Override
	public List<String> getRfidVector(int equipId, String name, int column) {
		if(equipId == 0) {
			return table.get(name)[column-1].getAllRfid();
		}
		return table.get(name)[column].getRfidByMachineRfid(machineNum2MachinedRfid.get(equipId-1));
	}
	
//	public List<String>[] getAllStatisticNumber() {
//		Iterator<String> iterator = table.keySet().iterator();
//		List<List<String>> all = new ArrayList<List<String>>();
//		while(iterator.hasNext()) {
//			String name = iterator.next();
//			List<String> list = new ArrayList<String>();
//			list.add(name);
//			StatisticNumber[] staNum = table.get(name);
//			for(StatisticNumber now : staNum) {
//				list.add(""+now.getNumber());
//			}
//		}
//		return (List<String>[])all.toArray();
//	}
	
	public int getMachineNumber() {
		return machineNum2MachinedRfid.size();
	}
	
	public List<List<String>> getStatisticNumber(int machineNum) {
		Iterator<String> iterator = table.keySet().iterator();
		List<List<String>> all = new ArrayList<List<String>>();
		while(iterator.hasNext()) {
			String name = iterator.next();
			List<String> list = new ArrayList<String>();
			list.add(name);
			StatisticNumber[] staNum = table.get(name);
			for(StatisticNumber now : staNum) {
				if(machineNum == 0) {
					list.add(now.getNumber().toString());
				}
				else {
					Integer tmp = now.getNumberByMachineRfid(machineNum2MachinedRfid.get(machineNum-1));
					if(tmp == null) {
						tmp = 0;
					}
					list.add(tmp.toString());
				}
			}
			if(machineNum != 0) {
				list.remove(1);
			}
			all.add(list);
		}
		return all;
	}
	
}
