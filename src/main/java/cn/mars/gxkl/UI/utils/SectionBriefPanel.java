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
	private int rowNum, colNum;
	private JLabel name, capacity, manager, managerID, equipmentNum;
	private JScrollPane scrollPane;

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
		
		this.add(name);
		this.add(capacity);
		this.add(manager);
		this.add(managerID);
		this.add(equipmentNum);

	}

	public void setSection(Section section) {
		this.section = section;
		name.setText("工段名：" + section.getName());
		capacity.setText("工段容量：" + section.getCapacity());
		manager.setText("工段负责人：" + section.getManager());
		managerID.setText("负责人ID：" + section.getManagerID());
		equipmentNum.setText("工段设备数：" + section.getEquipments().size());
		rowNum = section.getEquipments().get(0).getDetailTitel().size() + 7;
		colNum = section.getEquipments().size();
		equipmentData = getData(rowNum, colNum);
	
				
	}

	private String[][] getData(int rowNum, int colNum) {
		String[][] Data = new String[rowNum][colNum + 1];
		equipmentName = new String[colNum + 1];
		equipmentName[0] = "设备名称";
		Data[0][0] = "设备型号";
		Data[1][0] = "RFID";
		Data[2][0] = "容量";
		Data[3][0] = "购买时间";
		Data[4][0] = "最近操作";
		Data[5][0] = "最近修复";
		Data[6][0] = "生产厂商";
		for (int i = 7; i < rowNum; i++) {
			Data[i][0] = section.getEquipments().get(0).getDetailTitel()
					.get(i - 7);
		}
		for (int j = 0; j < colNum; j++) {
			equipmentName[j + 1] = section.getEquipments().get(j).getName();
			System.out.println("j:"+j+";"+section.getEquipments().get(j).getName());
			Data[0][j + 1] = section.getEquipments().get(j).getType();
			Data[1][j + 1] = section.getEquipments().get(j).getId();
			Data[2][j + 1] = section.getEquipments().get(j).getCapacity();
			Data[3][j + 1] = section.getEquipments().get(j).getGmtCreate()
					.toLocaleString();
			Data[4][j + 1] = section.getEquipments().get(j).getGmtModified()
					.toLocaleString();
			Data[5][j + 1] = section.getEquipments().get(j).getGmtLastRepair()
					.toLocaleString();
			Data[6][j + 1] = section.getEquipments().get(j).getManufacturer();
			for (int i = 7; i < rowNum; i++) {
				Data[i][j + 1] = section.getEquipments().get(j)
						.getDetailValue().get(i - 7);
			}
		}
		return Data;
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
