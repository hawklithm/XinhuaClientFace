package cn.mars.gxkl.center.core;

import cn.mars.gxkl.controller.DetailContoller;
import cn.mars.gxkl.controller.MachineInfoController;
import cn.mars.gxkl.controller.RealTimeTabController;
import cn.mars.gxkl.controller.WorkerBaseInfoController;

/**
 * ºËÐÄÄ£¿é
 * @author hawklithm
 * 2014-3-30ÏÂÎç2:13:37
 */
public class CoreModule {
//	private CommunicationCenter communicationCenter;
	private DetailContoller detailContoller;
	private MachineInfoController machineInfoController;
	private RealTimeTabController realTimeTabController;
	private WorkerBaseInfoController workerBaseInfoController;
	
	public void init(){
//		communicationCenter.setCoreModule(this);
	}
	
//	public CommunicationCenter getCommunicationCenter() {
//		return communicationCenter;
//	}
//
//	public void setCommunicationCenter(CommunicationCenter communicationCenter) {
//		this.communicationCenter = communicationCenter;
//	}

	public DetailContoller getDetailContoller() {
		return detailContoller;
	}

	public void setDetailContoller(DetailContoller detailContoller) {
		this.detailContoller = detailContoller;
	}

	public MachineInfoController getMachineInfoController() {
		return machineInfoController;
	}

	public void setMachineInfoController(MachineInfoController machineInfoController) {
		this.machineInfoController = machineInfoController;
	}

	public RealTimeTabController getRealTimeTabController() {
		return realTimeTabController;
	}

	public void setRealTimeTabController(RealTimeTabController realTimeTabController) {
		this.realTimeTabController = realTimeTabController;
	}

	public WorkerBaseInfoController getWorkerBaseInfoController() {
		return workerBaseInfoController;
	}

	public void setWorkerBaseInfoController(WorkerBaseInfoController workerBaseInfoController) {
		this.workerBaseInfoController = workerBaseInfoController;
	}
}
