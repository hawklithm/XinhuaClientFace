package cn.mars.gxkl.UI.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.mars.gxkl.sql.entity.RuntimeEntity;
import cn.mars.gxkl.sql.entity.StatisticEntity;
import cn.mars.gxkl.sql.mapper.ItemInfoMapper;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

public class EquipItemInfoHandler implements Rfid2Item, ItemsAddition {

	private ItemInfoMapper itemMapper;
	
	@Override
	public void addItemVector(List<?> items) {
		for(MachinedItemInfoDO item : (List<MachinedItemInfoDO>)items) {
			MachinedItemInfoDO entity = itemMapper.getItemByRfid(item.getItemId());
			if(entity != null) {
				if(entity.getStatus() != item.getStatus()) {
					itemMapper.deleteByRfid(item.getItemId());
				}
			}
			itemMapper.insert(item);
		}
	}

	public ItemInfoMapper getItemMapper() {
		return itemMapper;
	}

	public void setItemMapper(ItemInfoMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@Override
	public List<String> getRfidVector(int equiId, final String name, final int column) {
//		return itemMapper.getRfidsByNameAndStatus(new HashMap<String,Object>() {
//			{
//				put("itemName",name);
//				put("status",column+1);
//			}
//		});
		return null;
	}

	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		return itemMapper.getItemByRfid(Integer.parseInt(rfid));
	}
	
	public List<List<String>> getRuntimeInformation() {
		List<RuntimeEntity> list = itemMapper.getMachineRuntimeInfo();
		List<List<String>> ans = new ArrayList<List<String>>();
		for(RuntimeEntity entity : list) {
			List<String> tmp = new ArrayList<String>();
			tmp.add(entity.getItemName());
			tmp.add(entity.getRfid().toString());
			ans.add(tmp);
		}
		return ans;
	}
	
	public List<List<String>> getStatisticNumber() {
		List<StatisticEntity> list = itemMapper.getMachineStatistic();
		List<List<String>> ans = new ArrayList<List<String>>();
		for(StatisticEntity entity : list) {
			List<String> tmp = new ArrayList<String>();
			tmp.add(entity.getItemName());
			tmp.add(entity.getDoing().toString());
			tmp.add(entity.getDone().toString());
			ans.add(tmp);
		}
		return ans;
	}

}
