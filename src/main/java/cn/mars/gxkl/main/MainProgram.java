package cn.mars.gxkl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mars.gxkl.UI.ManagerUI;
import cn.mars.gxkl.UI.WorkerUI;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.observe.DataCenter;

public class MainProgram {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		WorkerUI workerUI = (WorkerUI)context.getBean("workerUI");
		workerUI.showUp();
//		ManagerUI managerUI=(ManagerUI)context.getBean("managerUI");
//		managerUI.showUp();
		
	}
}
