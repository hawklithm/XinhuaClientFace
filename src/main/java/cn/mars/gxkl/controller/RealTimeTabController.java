package cn.mars.gxkl.controller;

import java.util.List;

import cn.mars.gxkl.utils.Pair;

public interface RealTimeTabController {
	 void addInfo(List<Pair<Object, String>>msg,int index);    //ʱ�����������Ϣ������ֵ����Ӧ����Ϣ
	 void cleanInfo(int index);                                //��������ֵɾ���ض���ʱ��������Ϣ
}
