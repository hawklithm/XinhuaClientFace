package cn.mars.gxkl.controller;

import cn.mars.gxkl.controller.dataobject.ObjectPair;

public interface DetailContoller {
	void addScalpels(ObjectPair... objectPair);         //添加
	void addHammers(ObjectPair... objectPair);          //添加锤子
	void addForcepses(ObjectPair... objectPair);          //添加
	void clearAll();                                     //清楚所有
}
