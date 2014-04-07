package cn.mars.gxkl.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.mars.gxkl.UI.utils.BriefPanel;
import cn.mars.gxkl.UI.utils.HistoryPanel;
import cn.mars.gxkl.UI.utils.SearchPanel;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.UI.utils.WorkerHandlingPanel;
import cn.mars.gxkl.observe.DataCenter;
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
	private JPanel left,right;
	
	private HistoryPanel historyPanel;

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
		
//		initialization();
	}

	/**
	 * 
	 */
	private void initialization() {
		Person staff = new Person();
		staff.setID("201106004000");
		staff.setGender("男");
		staff.setImgPath("imgs/head.png");
		staff.setName("李华");
		staff.setRFID("1234567901");
		staff.setJob("清洗消毒");
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setBackground(Color.black);
		left=new JPanel();
		left.setPreferredSize(new Dimension((int)(width*0.22),height));
		left.add(new StaffInfoPanel((int) (width * 0.22),(int) (height * 0.25),staff));
		//this.add(new StaffInfoPanel((int) (width * 0.22),(int) (height * 0.25),staff));
		
		Equipment equipment=new Equipment();
		equipment.setType("清洗消毒机");
		equipment.setId("12345678901");
		equipment.setGmtCreate(new Date("2014/3/4 15:00:39"));
		equipment.setGmtModified(new Date("2014/3/5 16:00:48"));
		equipment.setGmtLastRepair(new Date("2014/3/5 14:30:22"));
		equipment.setManufacturer("shinva");
		equipment.setDetail("试剂一浓度：xxxx\n"+"试剂二浓度：xxxx\n"+"试剂三浓度：xxxx\n"+"试剂浓度四：xxxxx\n");
		left.add(new BriefPanel((int) (width * 0.22),(int) (height * 0.75),equipment));
		//this.add(new briefPanel((int) (width * 0.22),(int) (height * 0.75),equipment));
		this.add(left);
		
		right=new JPanel();
		right.setPreferredSize(new Dimension((int)(width*0.77),height));
//		right.add(new HandlingPanel((int)(width*0.77),(int)(height*0.6)));
		right.add(new WorkerHandlingPanel((int)(width*0.77),(int)(height*0.6)));
		List<String> searchtype=new ArrayList<String>();
		searchtype.add("RFID");
		searchtype.add("姓名");
		searchtype.add("设备");
		searchtype.add("测试");
		right.add(new SearchPanel((int)(width*0.77),(int)(height*0.053),searchtype));
		
		List<String> HistoryType=new ArrayList<String>();
		HistoryType.add("设备");
		HistoryType.add("工段");
		historyPanel.setWidth((int) (width*0.77));
		historyPanel.setHeight((int) (height*0.32));
		historyPanel.setSubTitel(HistoryType);
		historyPanel.initialization();
//		right.add(new HistoryPanel((int)(width*0.77),(int)(height*0.32),HistoryType));
		right.add(historyPanel);
		this.add(right);
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

	public HistoryPanel getHistoryPanel() {
		return historyPanel;
	}

	public void setHistoryPanel(HistoryPanel historyPanel) {
		this.historyPanel = historyPanel;
	}

}