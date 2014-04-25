package cn.mars.gxkl.UI.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.mars.gxkl.constant.Constant.*;
import cn.mars.gxkl.utils.Pair;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class ProcessItemInfoHandler implements ItemsAddition,Rfid2Item {
	
	private Map<String,List<Integer>> pcsData = new HashMap<String,List<Integer>>(),
			  						  pcsRetData = new HashMap<String,List<Integer>>();
	private Map<String,ItemInfoDO> itemData = new HashMap<String,ItemInfoDO>();
	private Integer pcsRowCnt = 0;
//	private Map<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();//类型映射统计信息
//	private Map<Integer,ArrayList<String>> pos2Items = new HashMap<Integer,ArrayList<String>>();//位置映射rfid
//	private Map<String,ItemInfoDO> rfid2Item = new HashMap<String,ItemInfoDO>();//rfid映射类
//	private List<String> row2Name = new ArrayList<String>();//行号映射类型名
//	private List<Pair<String,List<Integer>>> eqpData = new ArrayList<Pair<String,List<Integer>>>();
//	private List<Pair<String,List<Integer>>> pcsData = new ArrayList<Pair<String,List<Integer>>>();
	@Override
	public ItemInfoDO getItemByRfid(String rfid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addItemVector(List<?> items) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<String> getRfidVector(int flag, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override
//	public void addItemVector(List<?> items) {
//		for(Pair<Integer,ItemInfoDO> item : (List<Pair<Integer,ItemInfoDO>>)items) {
//			List<Integer> vector = addItem(item.getLast());
//			pcsData.add(new Pair(, vector));
//		}
//	}
//	
//	private ArrayList<Integer> addItem(ItemInfoDO newItem) {
//		rfid2Item.put(newItem.getItemId().toString(), newItem);
//		if((numbers=map.get(newItem.getItemName())) == null) {
//			row2Name.add(newItem.getItemName());
//			pos2Items.put(getHashCode(0,cnt,1), new ArrayList<String>());
//			pos2Items.put(getHashCode(0,cnt,2), new ArrayList<String>());
//			pos2Items.put(getHashCode(0,cnt,3), new ArrayList<String>());
//			numbers = new ArrayList<Integer>();
//			numbers.add(cnt++);
//			numbers.add(0);
//			numbers.add(0);
//			numbers.add(0);
//		}
//		switch(newItem.getStatus()) {
//			case ITEM_STATUS_TODO:newItemComming(1,numbers.get(0),newItem);break;
//			case ITEM_STATUS_DOING:newItemComming(2,numbers.get(0),newItem);break;
//			case ITEM_STATUS_DONE:newItemComming(3,numbers.get(0),newItem);
//		}
//		return (ArrayList<Integer>) numbers;
//	}
//	
//	private void newItemComming(int index,int count,ItemInfoDO newItem) {
//		numbers.set(index, numbers.get(index)+1);
//		Integer hashCode = getHashCode(0,count,index);
//		ArrayList<String> items = pos2Items.get(hashCode);
//		items.add(newItem.getItemId().toString());
//		pos2Items.put(hashCode, items);
//		map.put(newItem.getItemName(), (ArrayList<Integer>)numbers);
//	}
//	
//	public List<Pair<String,List<Integer>>> getProcessData() {
//		return this.pcsData;
//	}
//	
	public List<Pair<String,List<Integer>>> getEquipmentData() {
		return null;
	}
//	
//	public void setProcessInitData(List<Pair<String,List<Integer>>> data) {
//		this.pcsData = data;
//	}
//	
//	public void setEquipmentInitData(List<Pair<String,List<Integer>>> data) {
//		this.eqpData = data;
//		
//	}
//	
//	@Override
//	public List<String> getRfidVector(int flag, int row, int column) {
//		return pos2Items.get(getHashCode(flag,row,column));
//	}
//	
//	private Integer getHashCode(int flag, int x, int y) {
//		return x*100000+y*10+flag;
//	}
//
//	@Override
//	public ItemInfoDO getItemByRfid(String rfid) {
//		return rfid2Item.get(rfid);
//	}
	
}
