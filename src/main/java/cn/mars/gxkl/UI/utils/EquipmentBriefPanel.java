package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.center.executor.MachineInfoExecutor;
import cn.mars.gxkl.protocol.Equipment;

/**
 * Copyright 2014 MARS
 * 
 * All right reserved. afsd-pc 下午7:19:09
 * 
 * TODO 简介信息栏
 */

public class EquipmentBriefPanel extends JPanel implements Msg2Face {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252570012266809058L;
	private int width, height;
	private Equipment equipment;
	private BriefDetailPanel briefDetailPanel;
	private JLabel rfid, type, name, capacity, create, modified, repair,
			manufacturer;
	private List<BriefDetailPanel> detailList_Panel = new ArrayList<BriefDetailPanel>();
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private Font font;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	private Msg2Face statisticInfo;
	private MachineInfoExecutor machineInfoExecutor;
	/**
	 * 初始化Panel
	 */
	public void initialization() {
		font = new Font("宋体", Font.PLAIN, (int) (width * 0.055));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		type = getJLabel("设备型号：");
		name = getJLabel("设备名称：");
		rfid = getJLabel("RFID：");
		capacity = getJLabel("容量：");

		create = getJLabel("购买时间：");
		modified = getJLabel("最近操作：");
		repair = getJLabel("最近修复：");
		manufacturer = getJLabel("生产厂商：");

		this.add(type);
		this.add(name);
		this.add(rfid);
		this.add(capacity);
		this.add(create);
		this.add(modified);
		this.add(repair);
		this.add(manufacturer);
	}

	public MachineInfoExecutor getMachineInfoExecutor() {
		return machineInfoExecutor;
	}

	public void setMachineInfoExecutor(MachineInfoExecutor machineInfoExecutor) {
		this.machineInfoExecutor = machineInfoExecutor;
	}

	/**
	 * @param str
	 * @return 生成包含str的JLable
	 */
	private JLabel getJLabel(String str) {
		JLabel label = new JLabel(str);
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		label.setPreferredSize(new Dimension((int) (width), height / 15 - 14));
		return label;
	}

	/**
	 * @param str
	 * @return
	 * 
	 */
	private JPanel getJPanel(String str) {
		JPanel panel = new JPanel();
		JLabel label;
		panel.setBackground(bgColor);
		label = getJLabel(str);
		panel.add(label);
		return panel;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		return width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeigth() {
		return height;
	}

	public void setEquipment(Equipment equipment) {
		
		this.equipment = equipment;
		System.out.println(equipment.getType()+"电子科技大学");
		type.setText("设备型号：" + equipment.getType());
		name.setText("设备名称："+equipment.getName());
		rfid.setText("RFID：" + equipment.getEquipmentId());
		capacity.setText("容量：" + equipment.getCapacity());
		create.setText("购买时间：" + df.format(equipment.getGmtCreate()));
		modified.setText("最近操作：" + df.format(equipment.getGmtModified()));
		Date lastRepair=equipment.getGmtLastRepair();
		if (lastRepair!=null){
			repair.setText("最近修复：" + df.format(lastRepair));
		}
		manufacturer.setText("生产厂商：" + equipment.getManufacturer());
		if(!detailList_Panel.isEmpty()){
			for (BriefDetailPanel detailpanel : detailList_Panel) {
				this.remove(detailpanel);
			}
			detailList_Panel.clear();
		}
		if (detailList_Panel.isEmpty()) {
			if(equipment.getDetailTitel()!=null){
			for (int i = 0; i < equipment.getDetailTitel().size(); i++) {
				detailList_Panel.add(new BriefDetailPanel((int) width,
						height / 15 - 14, equipment.getDetailTitel().get(i),
						equipment.getDetailValue().get(i)));
				this.add(detailList_Panel.get(i));
			}
		}
		}
	}

	@Override
	public void setText(List<?> msg) {
	   System.out.println(msg+"long");
		if(!msg.equals("[ ]")){
		
		Equipment equipment = (Equipment) msg.get(0);
		setEquipment(equipment);
	
		}
	}
	public Msg2Face getStatisticInfo() {
		return statisticInfo;
	}

	public void setStatisticInfo(Msg2Face statisticInfo) {
		this.statisticInfo = statisticInfo;
	}
}
