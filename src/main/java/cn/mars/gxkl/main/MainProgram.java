package cn.mars.gxkl.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mars.gxkl.UI.Default;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.observe.DataCenter;

public class MainProgram {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		Default defaultUI = (Default)context.getBean("defaultUI");
//		StaffInfoPanel staffInfoPanel = (StaffInfoPanel)context.getBean("staffInfoPanel");
//		defaultUI.add(staffInfoPanel);
		defaultUI.showUp();
	}
}
