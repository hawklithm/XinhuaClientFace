package cn.mars.gxkl.UI.dataobject.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

public class StatisticTableCell implements ItemInfo, Rfid, StatisticNumber {
	
	private Map<String,List<String>> rfidTable = new HashMap<String,List<String>>();
	private Map<String,List<MachinedItemInfoDO>> itemTable = new HashMap<String,List<MachinedItemInfoDO>>();
	private Map<String,Integer> statisticNum = new HashMap<String,Integer>();
	
	public void add(MachinedItemInfoDO item) {
		String mRfid = item.getMachineId().toString();
		List<String> sList = rfidTable.get(mRfid);
		Integer cnt = statisticNum.get(mRfid);
		if(cnt == null) {
			cnt = 0;
		}
		cnt++;
		statisticNum.put(mRfid, cnt);
		if(sList == null) {
			sList = new ArrayList<String>();
		}
		sList.add(item.getItemId().toString());
		rfidTable.put(mRfid, sList);
		List<MachinedItemInfoDO> mList = itemTable.get(mRfid);
		if(mList == null) {
			mList = new ArrayList<MachinedItemInfoDO>();
		}
		mList.add(item);
		itemTable.put(mRfid, mList);
	}
	
	public boolean contains(MachinedItemInfoDO item) {
		String rfid = item.getItemId().toString(),mRfid = item.getMachineId().toString();
		if(rfidTable.get(mRfid) == null)
			return false;
		return rfidTable.get(mRfid).contains(rfid);
	}
	
	public void remove(MachinedItemInfoDO item) {
		String rfid = item.getItemId().toString(),mRfid = item.getMachineId().toString();
		List<String> sList = rfidTable.get(mRfid);
		sList.remove(rfid);
		rfidTable.put(mRfid, sList);
		List<MachinedItemInfoDO> mList = itemTable.get(mRfid);
		mList.remove(item);
		itemTable.put(mRfid, mList);
	}
	
	@Override
	public Integer getNumber() {
		Integer all = 0;
		Iterator<String> iterator = statisticNum.keySet().iterator();
		while(iterator.hasNext()) {
			all += statisticNum.get(iterator.next());
		}
		return all;
	}
	
	public Integer getNumberByMachineRfid(String machineRfid) {
		return statisticNum.get(machineRfid);
	}

	@Override
	public List<String> getRfidByMachineRfid(String machineRfid) {
		return rfidTable.get(machineRfid);
	}
	
	@Override
	public List<String> getAllRfid() {
		List<String> all = new ArrayList<String>();
		Iterator<String> iterator = rfidTable.keySet().iterator();
		while(iterator.hasNext()) {
			all.addAll(rfidTable.get(iterator.next()));
		}
		return all;
	}

	@Override
	public MachinedItemInfoDO[] getItemByMachineRfid(String machineRfid) {
		return (MachinedItemInfoDO[])itemTable.get(machineRfid).toArray();
	}
	
	@Override
	public MachinedItemInfoDO[] getAllItem() {
		List<MachinedItemInfoDO> all = new ArrayList<MachinedItemInfoDO>();
		Iterator<String> iterator = itemTable.keySet().iterator();
		while(iterator.hasNext()) {
			all.addAll(itemTable.get(iterator.next()));
		}
		return (MachinedItemInfoDO[])all.toArray();
	}
}
