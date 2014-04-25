package cn.mars.gxkl.testData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.mars.gxkl.constant.Constant;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class ItemInfoDOData {
	public List<ItemInfoDO> getData() {
		List<ItemInfoDO> data = new ArrayList<ItemInfoDO>();
		for(int i=0;i<40;i++) {
			ItemInfoDO item = new ItemInfoDO();
//			item.setGmtCreate(new Date("2014-04-09"));
//			item.setGmtModified(new Date("2013-04-09"));
			item.setHospitalId(123456789+(100+i));
			item.setInterconvertible(item.getHospitalId()/2==0?false:true);
			item.setItemId(987654321+(100+i));
			String name = "";
			int x = item.getItemId()%7;
			switch(x) {
				case 0: name = "����";break;
				case 1: name = "������";break;
				case 2: name = "���";break;
				case 3: name = "��ͷ";break;
				case 4: name = "����";break;
				case 5: name = "����";break;
				case 6: name = "����";
			}
			item.setItemName(name);
			item.setItemType(x);
			item.setManufacturer("����ʲô");
			item.setRemark("remark");
			int status = 0;
			switch(item.getItemId()%3) {
			case 0: status = Constant.ITEM_STATUS_DOING;break;
			case 1: status = Constant.ITEM_STATUS_DONE;break;
			case 2: status = Constant.ITEM_STATUS_TODO;
			}
			item.setStatus(status);
			data.add(item);
		}
		return data;
	}
}
