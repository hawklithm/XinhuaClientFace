package cn.mars.gxkl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mars.gxkl.UI.ManagerUI;
import cn.mars.gxkl.UI.WorkerUI;

public class testUI {
	public static void main(String[] args){
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-beans.xml");
//		ManagerUI managerUI=(ManagerUI)context.getBean("managerUI");
//		managerUI.showUp();
		WorkerUI workerUI=(WorkerUI)context.getBean("workerUI");
		workerUI.showUp();
	}
}
