package cn.mars.gxkl.center.face;

import java.util.List;

import cn.mars.gxkl.UI.WorkerUI;
import cn.mars.gxkl.controller.DetailContoller;
import cn.mars.gxkl.controller.MachineInfoController;
import cn.mars.gxkl.controller.RealTimeTabController;
import cn.mars.gxkl.controller.WorkerBaseInfoController;
import cn.mars.gxkl.controller.dataobject.MachineInfoProperty;
import cn.mars.gxkl.controller.dataobject.ObjectPair;
import cn.mars.gxkl.utils.Pair;

public class FaceController implements DetailContoller,MachineInfoController,RealTimeTabController,WorkerBaseInfoController{
	
	private WorkerUI face;

	@Override
	public void setWorkerInfo(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMachineInfo(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWorkerImage(String url) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void cleanInfo(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addMachine(MachineInfoProperty property) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void changeInfo(MachineInfoProperty property) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMachine(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addScalpels(ObjectPair... objectPair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHammers(ObjectPair... objectPair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addForcepses(ObjectPair... objectPair) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAll() {
		// TODO Auto-generated method stub
		
	}

	public WorkerUI getFace() {
		return face;
	}

	public void setFace(WorkerUI face) {
		this.face = face;
	}

	@Override
	public void addInfo(List<Pair<Object, String>> msg, int index) {
		// TODO Auto-generated method stub
		
	}

}
