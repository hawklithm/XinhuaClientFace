package cn.mars.gxkl.controller;

public interface WorkerBaseInfoController {
	 void setWorkerInfo(String message);    //设置员工的消息
	 void setMachineInfo(String message);       //设置所负责的机器的消息
	 void setWorkerImage(String url);           //设置员工图片参数为URL
}
