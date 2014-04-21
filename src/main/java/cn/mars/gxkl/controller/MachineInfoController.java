package cn.mars.gxkl.controller;

import cn.mars.gxkl.controller.dataobject.MachineInfoProperty;

public interface MachineInfoController {
	public int addMachine(MachineInfoProperty property);   //添加机器的信息属性
	public void changeInfo(MachineInfoProperty property);  //改变机器的消息属性
	public void deleteMachine(int index);                  //根据索引号码删除特定的机器
}
