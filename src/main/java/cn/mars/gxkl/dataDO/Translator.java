package cn.mars.gxkl.dataDO;

import cn.mars.gxkl.constant.Constant;
import cn.mars.gxkl.observe.DataCenter;
import cn.mars.gxkl.observe.Observer;

public class Translator implements Observer {
	
	private DataCenter dataCenter;   //包括注册，移出，通知等内容
	
	public Translator(DataCenter dataCenter) {
		this.dataCenter = dataCenter;
		this.dataCenter.register(this, Constant.jobs[2]);
	}

	@Override
	public void exec(String msg) {
		// TODO Auto-generated method stub
		
	}
}
