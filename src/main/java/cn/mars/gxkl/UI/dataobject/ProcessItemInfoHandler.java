package cn.mars.gxkl.UI.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.mars.gxkl.sql.entity.SelectEntity;
import cn.mars.gxkl.sql.entity.StatisticEntity;
import cn.mars.gxkl.sql.mapper.ItemInfoMapper;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

import static cn.mars.gxkl.constant.Constant.ITEM_STATUS_TODO;

public class ProcessItemInfoHandler implements Rfid2Item, ItemsAddition {

	private ItemInfoMapper itemMapper;
	private List<String> machineNum2MachinedRfid = new ArrayList<String>();
	
	@Override
	public void addItemVector(List<?> items) {
		for(MachinedItemInfoDO item : (List<MachinedItemInfoDO>)items) {
			String mRfid = item.getMachineId().toString();
			if(!machineNum2MachinedRfid.contains(mRfid)&&item.getStatus() != ITEM_STATUS_TODO) {
				machineNum2MachinedRfid.add(mRfid);
			}
			MachinedItemInfoDO entity = itemMapper.getItemByRfid(item.getItemId());
			if(entity != null) {
				if(entity.getStatus() != item.getStatus()) {
					itemMapper.deleteByRfid(item.getItemId());
				}
			}
			itemMapper.insert(item);
		}
	}

	@Override
	public List<String> getRfidVector(final int equipId, final String name, final int column) {
		List<Integer> tmp = null;
		SelectEntity entity = new SelectEntity();
		entity.setItemName(name);
		if(equipId == 0) {
			entity.setStatus(column);
			tmp =  itemMapper.getRfidsByNameAndStatus(entity);
		}
		else {
			entity.setStatus(column+1);
			entity.setMachineId(Integer.parseInt(machineNum2MachinedRfid.get(equipId-1)));
			tmp =  itemMapper.getRfidsByNameStatusAndMachineId(entity);
		}
		List<String> list = new ArrayList<String>();
		for(Integer i : tmp) {
			list.add(i.toString());
		}
		return list;
	}

	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		return itemMapper.getItemByRfid(Integer.parseInt(rfid));
	}
	
	public int getMachineNumber() {
		return machineNum2MachinedRfid.size();
	}
	
	public List<List<String>> getStatisticNumber(int equipId) {
		List<StatisticEntity> list = null;
		if(equipId == 0) {
			list = itemMapper.getProcessStatistic();
		}
		else {
			list = itemMapper.getMachineStatisticByMachineRfid(Integer.parseInt(machineNum2MachinedRfid.get(equipId-1)));
		}
		List<List<String>> ans = new ArrayList<List<String>>();
		for(StatisticEntity entity : list) {
			List<String> tmp = new ArrayList<String>();
			tmp.add(entity.getItemName());
			if(equipId == 0) {
				tmp.add(entity.getTodo().toString());
			}
			tmp.add(entity.getDoing().toString());
			tmp.add(entity.getDone().toString());
			ans.add(tmp);
		}
		return ans;
	}

	public ItemInfoMapper getItemMapper() {
		return itemMapper;
	}

	public void setItemMapper(ItemInfoMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

}
