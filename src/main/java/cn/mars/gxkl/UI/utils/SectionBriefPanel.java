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

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.protocol.Section;

public class SectionBriefPanel extends JPanel implements Msg2Face {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width, height;
	private Section section;

	private JLabel name, capacity, manager, managerID, equipmentNum;

	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private final DefaultComboBoxModel EquipmentStateTitel = new DefaultComboBoxModel();
	private Font font;

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

	public void setSection(Section section) {
		this.section = section;
	}

	public void initialization() {
		font = new Font("����", Font.PLAIN, (int) (width * 0.055));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 0));

		name = getJLabel("��������" + section.getName());
		capacity = getJLabel("����������" + section.getCapacity());
		manager = getJLabel("���θ����ˣ�" + section.getManamger());
		managerID = getJLabel("������ID��" + section.getManagerID());
		equipmentNum = getJLabel("�����豸����" + section.getEquipments().size()
				+ "̨");

		this.add(name);
		this.add(capacity);
		this.add(manager);
		this.add(managerID);
		this.add(equipmentNum);
		this.add(getStatisticsTable(width-25,(int)(height*0.2)));
	}

	private JLabel getJLabel(String str) {
		JLabel label = new JLabel(str);
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		label.setPreferredSize(new Dimension((int) (width), height / 15 - 14));
		return label;
	}

	private JPanel getStatisticsTable(int width,int height){
		JPanel panel=new JPanel();
		int titelNum=section.getEquipments().get(0).getDetailTitel().size()+1;
		int equipmentNum=section.getEquipments().size();
		String [] titels=new String[titelNum];
		titels[0]="�豸����";
		for(int i=1;i<titelNum;i++){
			titels[i]=section.getEquipments().get(0).getDetailTitel().get(i-1);
		}
		String [][] values=new String[equipmentNum][titelNum];
		for (int i=0;i<equipmentNum;i++){
			values[i][0]=section.getEquipments().get(i).getName();
			for(int j=1;j<titelNum;j++){
				values[i][j]=section.getEquipments().get(i).getDetailValue().get(j-1);
				
			}
		}
		JTable table=new JTable(values,titels);
		table.setPreferredScrollableViewportSize(new Dimension(width,height));
		JScrollPane scrollpane=new JScrollPane(table);
		
		panel.add(scrollpane);
		return panel;
	}

	@Override
	public void setText(List<?> msg) {
		// TODO Auto-generated method stub

	}

}
