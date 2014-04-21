package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.protocol.Section;

public class SectionBriefPanel extends JPanel implements Msg2Face {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;
	private Section section;
	private String[][] equipmentData;
	private String[] equipmentName;
	private JLabel name, capacity, manager, managerID, equipmentNum;
	private SectionEquipmentPanel sectionEquipmentPanel;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private Font font;

	public void initialization() {
		font = new Font("宋体", Font.PLAIN, (int) (width * 0.055));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));

		name = getJLabel("工段名：");
		capacity = getJLabel("工段容量：");
		manager = getJLabel("工段负责人：");
		managerID = getJLabel("负责人ID：");
		equipmentNum=getJLabel("设备数：");
		sectionEquipmentPanel=new SectionEquipmentPanel();
		this.add(name);
		this.add(capacity);
		this.add(manager);
		this.add(managerID);
		this.add(equipmentNum);
		this.add(sectionEquipmentPanel.getScrollPane());
		sectionEquipmentPanel.setSize(width-12, height/2);
	}

	public void setSection(Section section) {
		this.section = section;
		name.setText("工段名：" + section.getName());
		capacity.setText("工段容量：" + section.getCapacity());
		manager.setText("工段负责人：" + section.getManager());
		managerID.setText("负责人ID：" + section.getManagerID());
		equipmentNum.setText("工段设备数：" + section.getEquipments().size());
		getData(section);
		sectionEquipmentPanel.setRowHeader(equipmentName);
		sectionEquipmentPanel.addRow(equipmentData);		
		sectionEquipmentPanel.setSize(width-12, height/2);
	}
	
	private void getData(Section section) {
		int colNum=section.getEquipments().size();
		int rowNum=section.getEquipments().get(0).getDetailTitel().size()+8;
		equipmentData=new String[rowNum][colNum];
		equipmentName=new String[rowNum];
		equipmentName[0]="设备名称";
		equipmentName[1]="谁边型号";
		equipmentName[2]="RFID";
		equipmentName[3]="容量";
		equipmentName[4]="购买时间";
		equipmentName[5]="最近操作";
		equipmentName[6]="最近修复";
		equipmentName[7]="生产厂商";
		for(int i=8;i<rowNum;i++){
			equipmentName[i]=section.getEquipments().get(0).getDetailTitel().get(i-8);
		}
		for(int i=0;i<colNum;i++){
			equipmentData[0][i]=section.getEquipments().get(i).getName();
			equipmentData[1][i]=section.getEquipments().get(i).getType();
			equipmentData[2][i]=""+section.getEquipments().get(i).getEquipmentId();
			equipmentData[3][i]=section.getEquipments().get(i).getCapacity();
			equipmentData[4][i]=section.getEquipments().get(i).getGmtCreate().toLocaleString();
			equipmentData[5][i]=section.getEquipments().get(i).getGmtModified().toLocaleString();
			equipmentData[6][i]=section.getEquipments().get(i).getGmtLastRepair().toLocaleString();
			equipmentData[7][i]=section.getEquipments().get(i).getManufacturer();
			for(int j=8;j<rowNum;j++){
				equipmentData[j][i]=section.getEquipments().get(i).getDetailValue().get(j-8);
			}
		}
	}

	
	private JLabel getJLabel(String str) {
		JLabel label = new JLabel(str);
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		label.setPreferredSize(new Dimension((int) (width), height / 15 - 14));
		return label;
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

	public int getHeight() {
		return height;
	}

	@Override
	public void setText(List<?> msg) {
		// TODO Auto-generated method stub

	}

}
