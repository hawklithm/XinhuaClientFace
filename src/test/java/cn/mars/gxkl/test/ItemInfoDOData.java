package cn.mars.gxkl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.mars.gxkl.constant.Constant;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class ItemInfoDOData {
	public List<ItemInfoDO> getData() {
		List<ItemInfoDO> data = new ArrayList<ItemInfoDO>();
		for(int i=0;i<20;i++) {
			ItemInfoDO item = new ItemInfoDO();
			item.setGmtCreate(new Date("2014-4-9"));
			item.setGmtModified(new Date("2013-4-9"));
			item.setHospitalId(123456789+(100+i));
			item.setInterconvertible(item.getHospitalId()/2==0?false:true);
			item.setItemId(987654321+(100+i));
			String name = "";
			int x = item.getItemId()/6;
			switch(x) {
			case 0: name = "����";
			case 1: name = "������";
			case 2: name = "���";
			case 3: name = "��ͷ";
			case 4: name = "����";
			case 5: name = "����";
			}
			item.setItemName(name);
			item.setItemType(x);
			item.setManufacturer("����ʲô");
			item.setRemark("remark");
			String status = "";
			switch(x/2) {
			case 0: status = Constant.ITEM_STATUS_DOING;
			case 1: status = Constant.ITEM_STATUS_DONE;
			case 2: status = Constant.ITEM_STATUS_TODO;
			}
			item.setStatus(status);
			data.add(item);
		}
		return data;
	}
}
