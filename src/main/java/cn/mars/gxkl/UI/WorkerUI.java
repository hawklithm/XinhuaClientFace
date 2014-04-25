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

import cn.mars.gxkl.UI.utils.EquipmentBriefPanel;
import cn.mars.gxkl.UI.utils.HistoryPanel;
import cn.mars.gxkl.UI.utils.SearchPanel;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.UI.utils.WorkerHandlingPanel;
import cn.mars.gxkl.observe.DataCenter;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.Person;

/**
 * @author 
 * dataCenter数据中心处理
 * 员工信息
 * 设备概要信息
 * 工人处理信息
 * 搜索框
 * 历史记录
 * 默认的长度和宽度
 * 
 */
public class WorkerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private DataCenter dataCenter;
	private int width, height;
	private JPanel left,right;
	
	private StaffInfoPanel staffinfoPanel;
	private EquipmentBriefPanel equipmentbriefPanel;
	private WorkerHandlingPanel workerhandlingPanel;
	private SearchPanel searchPanel;
	private HistoryPanel historyPanel;

	/**
	 * @param dataCenter
	 */
	public WorkerUI(DataCenter dataCenter) {
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
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setBackground(Color.black);
		left=new JPanel();
		left.setPreferredSize(new Dimension((int)(width*0.22),height));
		
		staffinfoPanel.setWidth((int)(width*0.22));
		staffinfoPanel.setHeight((int)(height*0.25));
		staffinfoPanel.initialization();
		left.add(staffinfoPanel);
	
		equipmentbriefPanel.setWidth((int)(width*0.22));
		equipmentbriefPanel.setHeight((int)(height*0.75));
		equipmentbriefPanel.initialization();
		left.add(equipmentbriefPanel);
		this.add(left);

		right=new JPanel();
		right.setPreferredSize(new Dimension((int)(width*0.77),height));
		
		workerhandlingPanel.setWidth((int)(width*0.77));
		workerhandlingPanel.setHeight((int)(height*0.6));
		workerhandlingPanel.initialization();
		right.add(workerhandlingPanel);
		
		searchPanel.setWidth((int)(width*0.77));
		searchPanel.setHeight((int)(height*0.055));
		searchPanel.initialization();
		right.add(searchPanel);
		
		
		historyPanel.setWidth((int) (width*0.77));
		historyPanel.setHeight((int) (height*0.32));
		historyPanel.initialization();

		right.add(historyPanel);
		this.add(right);
		
		testData();
	}

	private void testData(){
		Person staff = new Person();
		//staff.setID("201106004000");
		staff.setGender("男");
		staff.setImgPath("imgs/head.png");
		staff.setName("李华");
//		staff.setRFID("1234567901");
		staff.setJob("清洗消毒操作员");
		staffinfoPanel.setStaff(staff);
		
		List<String> detailTitel=new ArrayList<String>();
		detailTitel.add("试剂一");
		detailTitel.add("试剂二");
		detailTitel.add("试剂三");
		List<String> detailValue=new ArrayList<String>();
		detailValue.add("30g/ml");
		detailValue.add("50g/ml");
		detailValue.add("30g/ml");
		Equipment equipment=new Equipment();
		equipment.setType("清洗消毒机");
		equipment.setName("清洗消毒1号机");
		equipment.setId("12345678901");
		equipment.setCapacity("40把");
		equipment.setGmtCreate(new Date("2014/3/4 15:00:39"));
		equipment.setGmtModified(new Date("2014/3/5 16:00:48"));
		equipment.setGmtLastRepair(new Date("2014/3/5 14:30:22"));
		equipment.setManufacturer("shinva");
		equipment.setDetailTitel(detailTitel);
		equipment.setDetailValue(detailValue);
		equipmentbriefPanel.setEquipment(equipment);
		

		List<String> searchtype=new ArrayList<String>();
		searchtype.add("RFID");
		searchtype.add("姓名");
		searchtype.add("设备");
		searchtype.add("测试");
		searchPanel.setSearchType(searchtype);
		
		List<String> HistoryType=new ArrayList<String>();
		HistoryType.add("设备");
		HistoryType.add("工段");
		historyPanel.setSubTitel(HistoryType);
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
	public EquipmentBriefPanel getEquipmentBriefPanel(){
		return equipmentbriefPanel;
	}
	public void setEquipmentBriefPanel(EquipmentBriefPanel equipmentBriefPanel){
		this.equipmentbriefPanel=equipmentBriefPanel;
	}
	public void setWorkerHandlingPanel(WorkerHandlingPanel workerHandlingPanel){
		this.workerhandlingPanel=workerHandlingPanel;
	}
	public WorkerHandlingPanel getworkerHandlingPanel(){
		return workerhandlingPanel;
	}
	public void setSearchPanel(SearchPanel searchPanel){
		this.searchPanel=searchPanel;
	}
	public SearchPanel getSearchPanel(){
		return searchPanel;
	}
	public void setStaffInfoPanel(StaffInfoPanel staffInfoPanel){
		this.staffinfoPanel=staffInfoPanel;
	}
	public StaffInfoPanel getStaffInfoPanel(){
		return staffinfoPanel;
	}
}