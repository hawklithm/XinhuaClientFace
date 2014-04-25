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
import cn.mars.gxkl.UI.utils.ProcessHandlingPanel;
import cn.mars.gxkl.UI.utils.SearchPanel;
import cn.mars.gxkl.UI.utils.SectionBriefPanel;
import cn.mars.gxkl.UI.utils.StaffInfoPanel;
import cn.mars.gxkl.UI.utils.WorkerHandlingPanel;
import cn.mars.gxkl.observe.DataCenter;
import cn.mars.gxkl.protocol.Equipment;
import cn.mars.gxkl.protocol.Person;
import cn.mars.gxkl.protocol.Section;

public class ManagerUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataCenter dataCenter;
	private int width,height;
	private JPanel left,right;
	
	private StaffInfoPanel staffInfoPanel;
	private SectionBriefPanel sectionBriefPanel;
	private ProcessHandlingPanel processHandlingPanel;
	public ProcessHandlingPanel getProcessHandlingPanel() {
		return processHandlingPanel;
	}

	public void setProcessHandlingPanel(ProcessHandlingPanel processHandlingPanel) {
		this.processHandlingPanel = processHandlingPanel;
	}
	private SearchPanel searchPanel;
	private HistoryPanel historyPanel;
	
	public ManagerUI(DataCenter dataCenter){
		this.dataCenter=dataCenter;
		this.width=(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.height=(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	}
	
	private void initialization(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setBackground(Color.black);
		left=new JPanel();
		left.setPreferredSize(new Dimension((int)(width*0.22),height));
		
		
		staffInfoPanel.setWidth((int)(width*0.22));
		staffInfoPanel.setHeight((int)(height*0.25));
		staffInfoPanel.initialization();
		left.add(staffInfoPanel);
		
		sectionBriefPanel=new SectionBriefPanel();
		sectionBriefPanel.setWidth((int)(width*0.22));
		sectionBriefPanel.setHeight((int)(height*0.75));
		sectionBriefPanel.initialization();
		left.add(sectionBriefPanel);
		this.add(left);
		
		right=new JPanel();
		right.setPreferredSize(new Dimension((int)(width*0.77),height));
//		right.add(new HandlingPanel((int)(width*0.77),(int)(height*0.6)));
		
		processHandlingPanel.setWidth((int)(width*0.77));
		processHandlingPanel.setHeight((int)(height*0.6));
		processHandlingPanel.initialization();
		right.add(processHandlingPanel);
	//	right.add(new WorkerHandlingPanel((int)(width*0.77),(int)(height*0.6)));
		
		
		
		searchPanel.setWidth((int)(width*0.77));
		searchPanel.setHeight((int)(height*0.055));
		searchPanel.initialization();
		right.add(searchPanel);
		
		
		historyPanel.setWidth((int) (width*0.77));
		historyPanel.setHeight((int) (height*0.32));
		historyPanel.initialization();
//		right.add(new HistoryPanel((int)(width*0.77),(int)(height*0.32),HistoryType));
		right.add(historyPanel);
		this.add(right);
		testData();
	}
	public void testData(){
		Person staff = new Person();
		//staff.setID("201106004000");
		staff.setGender("男");
		staff.setImgPath("imgs/head.png");
		staff.setName("张三");
//		staff.setRFID("1234567901");
		staff.setJob("清洗消毒工段长");
		staffInfoPanel.setStaff(staff);
		
		List<String> detailTitel=new ArrayList<String>();
		detailTitel.add("试剂一");
		detailTitel.add("试剂二");
		detailTitel.add("试剂三");
		detailTitel.add("试剂四");
		List<String> detailValue=new ArrayList<String>();
		detailValue.add("30g/ml");
		detailValue.add("50g/ml");
		detailValue.add("30g/ml");
		detailValue.add("30g/ml");
		Equipment equipment1=new Equipment();
		equipment1.setType("清洗消毒机");
		equipment1.setName("清洗消毒1号机");
		equipment1.setEquipmentId(1234567890);
		equipment1.setCapacity("40把");
		equipment1.setGmtCreate(new Date("2014/3/4 15:00:39"));
		equipment1.setGmtModified(new Date("2014/3/5 16:00:48"));
		equipment1.setGmtLastRepair(new Date("2014/3/5 14:30:22"));
		equipment1.setManufacturer("shinva");
		equipment1.setDetailTitel(detailTitel);
		equipment1.setDetailValue(detailValue);
		Equipment equipment2=new Equipment();
		equipment2.setType("清洗消毒机");
		equipment2.setName("清洗消毒2号机");
		equipment2.setEquipmentId(1234567891);
		equipment2.setCapacity("40把");
		equipment2.setGmtCreate(new Date("2014/3/4 15:00:39"));
		equipment2.setGmtModified(new Date("2014/3/5 16:00:48"));
		equipment2.setGmtLastRepair(new Date("2014/3/5 14:30:22"));
		equipment2.setManufacturer("shinva");
		equipment2.setDetailTitel(new ArrayList<String>(detailTitel));
		equipment2.setDetailValue(new ArrayList<String>(detailValue));
		
		List<Equipment> equipments=new ArrayList<Equipment>();
		equipments.add(equipment1);
		//equipments.add(equipment2);

		Section section=new Section();
		section.setName("清洗消毒");
		section.setCapacity("180把");
		section.setManager("张三");
		section.setManagerID("1234567901");
		section.setEquipments(equipments);
		sectionBriefPanel.setSection(section);
		equipments.add(equipment2);
		section.setEquipments(equipments);
		sectionBriefPanel.setSection(section);

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
	public void setSearchPanel(SearchPanel searchPanel){
		this.searchPanel=searchPanel;
	}
	public SearchPanel getSearchPanel(){
		return searchPanel;
	}
	public void setStaffInfoPanel(StaffInfoPanel staffInfoPanel){
		this.staffInfoPanel=staffInfoPanel;
	}
	public StaffInfoPanel getStaffInfoPanel(){
		return staffInfoPanel;
	}
	public void setSectionBriefPanel(SectionBriefPanel sectionBriefPanel){
		this.sectionBriefPanel=sectionBriefPanel;
	}
	public SectionBriefPanel getSectionBriefPanel(){
		return sectionBriefPanel;
	}
}
