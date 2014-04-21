package cn.mars.gxkl.controller;

import java.util.List;

import cn.mars.gxkl.utils.Pair;

public interface RealTimeTabController {
	 void addInfo(List<Pair<Object, String>>msg,int index);    //时间表控制添加信息，索引值和相应的消息
	 void cleanInfo(int index);                                //根据索引值删除特定的时间表控制信息
}
