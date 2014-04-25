package cn.mars.gxkl.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mars.gxkl.UI.utils.HandlingPanel;
import cn.mars.gxkl.UI.utils.SearchPanel;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.constant.Constant;
import cn.mars.gxkl.observe.DataCenter;
import cn.mars.gxkl.observe.Observer;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.Person;

/**
 * @author 
 * 
 */
public class Default extends JFrame {

	private static final long serialVersionUID = 1L;
	private DataCenter dataCenter;
	private int width, height;
	private JPanel left;

	/**
	 * @param dataCenter
	 */
	public Default(DataCenter dataCenter) {
		// regist to dataCenter
		this.dataCenter = dataCenter;
//		this.dataCenter.register(this, Constant.jobs[0]);
		// GUI initialization
		this.width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		initialization();
	}

	/**
	 * 
	 */
	private void initialization() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.add(new HandlingPanel(800,400));
	}

	/**
	 * 
	 */
	public void showUp() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		 GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(this);
		this.setSize(width, height);
		this.setVisible(true);
	}

	public int getWidth() {
		return width;
	}

	public int getheight() {
		return height;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		//Default defaultUI = (Default)context.getBean("testUI");
//		StaffInfoPanel staffInfoPanel = (StaffInfoPanel)context.getBean("staffInfoPanel");
//		defaultUI.add(staffInfoPanel);
		//defaultUI.showUp();
	}

	
}