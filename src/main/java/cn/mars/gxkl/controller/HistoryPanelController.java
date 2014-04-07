package cn.mars.gxkl.controller;

import java.util.List;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.utils.Pair;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class HistoryPanelController implements RealTimeTabController {

	
	private Msg2Face msg2Face;
	private static int length[]=new int[]{200,200};
	private ItemInfoDO[][] itemInfoLists=new ItemInfoDO[][]{new  ItemInfoDO[length[0]],new ItemInfoDO[length[1]]};
	private int[] tail=new int[]{0,0};
	private int[] head=new int[]{0,0};
	
	@Override
	public void cleanInfo(int index) {
		// TODO Auto-generated method stub

	}
	
	private int moveNext(int index){
		int pos=tail[index];
		tail[index]=(tail[index]+1)%length[index];
		if (tail[index]==head[index]){
			head[index]=(head[index]+1)%length[index];
		}
		return pos;
	}

	@Override
	public void addInfo(List<Pair<Object, String>> msg, int index) {
		for (Pair<Object, String> pair:msg){
			Object object=(ItemInfoDO) pair.getFirst();
			if (object !=null && object instanceof ItemInfoDO){
				itemInfoLists[index][moveNext(index)]=(ItemInfoDO) object;
			}
		}
	}

	public Msg2Face getMsg2Face() {
		return msg2Face;
	}

	public void setMsg2Face(Msg2Face msg2Face) {
		this.msg2Face = msg2Face;
	}

}
