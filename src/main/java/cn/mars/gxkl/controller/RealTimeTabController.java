package cn.mars.gxkl.controller;

import java.util.List;

import cn.mars.gxkl.utils.Pair;

public interface RealTimeTabController {
	 void addInfo(List<Pair<Object, String>>msg,int index);
	 void cleanInfo(int index);
}
