package cn.mars.gxkl.controller;

import cn.mars.gxkl.controller.dataobject.MachineInfoProperty;

public interface MachineInfoController {
	public int addMachine(MachineInfoProperty property);   //��ӻ�������Ϣ����
	public void changeInfo(MachineInfoProperty property);  //�ı��������Ϣ����
	public void deleteMachine(int index);                  //������������ɾ���ض��Ļ���
}
