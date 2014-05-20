package cn.mars.gxkl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mars.gxkl.UI.Login;
import cn.mars.gxkl.UI.ManagerUI;
import cn.mars.gxkl.UI.SelectorUI;
import cn.mars.gxkl.UI.WorkerUI;
import cn.mars.gxkl.center.executor.ProcessInfoExecutor;
import cn.mars.gxkl.sql.mapper.ItemInfoMapper;

public class MainProgram {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
	
		ItemInfoMapper itemMapper = (ItemInfoMapper)context.getBean("itemInfoMapper");
		
	   SelectorUI login=(SelectorUI)context.getBean("selectorUI");
	   login.showUp();
		
		
		
		
//		itemMapper.create();
//		ProcessInfoExecutor p = (ProcessInfoExecutor)context.getBean("processInfoExecutor");
//		p.test();
		
//		WorkerUI workerUI = (WorkerUI)context.getBean("workerUI");
//		workerUI.showUp();
//		ManagerUI managerUI=(ManagerUI)context.getBean("managerUI");
//		managerUI.showUp();
		/***************************************************************
		 * 注意！！！！！
		 * ATTENTION PLEASE！！！！！
		 * 注意！！！！！如果测试中使用数据相同，那么第二次测试时需要先运行下面一句话来清空数据库内容
		 * ATTENTION PLEASE！！！！！
		 * 注意！！！！！
		 **************************************************************/
//		itemMapper.clear();
	}
}
