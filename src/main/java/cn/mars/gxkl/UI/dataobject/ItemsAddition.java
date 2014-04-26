package cn.mars.gxkl.UI.dataobject;

import java.util.List;
import java.util.Map;

import cn.mars.gxkl.utils.Pair;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public interface ItemsAddition {
	public void addItemVector(List<?> items);
	public List<String> getRfidVector(int equiId, String name, int column);
}
