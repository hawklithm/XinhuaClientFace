package cn.mars.gxkl.UI.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import cn.mars.gxkl.protocol.Item;

public class HandlingPanel extends JPanel {
	
	private int width,height;
	private String[] text = {
			"手术钳：1234567把","定制牌手术刀：2345678把","好用牌手术锤子：3456789把"
	};
	private Map<String, Object> condition1 = new HashMap<String,Object>() {
		{
			put("name","锤子");
			put("rfid","1234567890112345678901");
			put("procedure","清洗消毒-清洗消毒-清洗消毒-清洗消毒-清洗消毒");
			put("process","清洗消毒");
			put("history","这个锤子已经用过9999999999999999999次乐");
		}
	};
	private Map<String, Object> condition2 = new HashMap<String,Object>() {
		{
			put("name","棒子");
			put("rfid","9876543210198765432101");
			put("procedure","清洗消毒-清洗消毒-清洗消毒-清洗消毒-清洗消毒");
			put("process","清洗消毒");
			put("history","这个锤子已经用过9999999999999999999次乐");
		}
	};
	private Map<String, Object> condition3 = new HashMap<String,Object>() {
		{
			put("name","剪刀");
			put("rfid","4567891233045678912330");
			put("procedure","清洗消毒-清洗消毒-清洗消毒-清洗消毒-清洗消毒");
			put("process","清洗消毒");
			put("history","这个锤子已经用过9999999999999999999次乐");
		}
	};
	private Item[][] items = {
			{	new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),
				new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),
				new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),
				new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),
				new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),
				new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1),new Item(condition1)
			},
			{	new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),
				new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),
				new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),
				new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),
				new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),
				new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2),new Item(condition2)
			},
			{	new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),
				new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),
				new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),
				new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),
				new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),
				new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3),new Item(condition3)
			}
	};
	
	private String[] labelName = {
			"名字：","RFID：","处理流程：","流程进度："
	};
	
	private Color color = new Color(0x16, 0x49, 0x9a);
	private JPanel left,right;
	private JTextArea history;
	private JLabel[] label = new JLabel[4];
	
	public HandlingPanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setLayout(new FlowLayout(FlowLayout.LEADING,5,5));
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(color);
		initialization();
	}
	
	private void initialization() {
		initRight();
		initLeft();
		this.add(left);
		this.add(right);
	}
	
	private void initLeft() {
		left = new JPanel();
		left.setPreferredSize(new Dimension((int)(width*0.5-8),height));
		left.setLayout(new FlowLayout(FlowLayout.LEADING,0,5));
		left.setOpaque(false);
		JLabel top = new JLabel(" 当前正在处理：",JLabel.LEFT);
		top.setFont(new Font("宋体",Font.BOLD,(int)(height*0.06)));
		top.setOpaque(false);
		top.setForeground(Color.white);
		top.setPreferredSize(new Dimension((int)(width*0.5-8),(int)(height*0.06)));
		JPanel menuGroup = new JPanel();
		menuGroup.setPreferredSize(new Dimension((int)(width*0.5-8),(int)(height*0.9-15)));
		menuGroup.setOpaque(false);
		MenuLabel[] menuLabel = new MenuLabel[3];
		for(int i=0;i<menuLabel.length;i++) {
			menuLabel[i] = new MenuLabel((int)(width*0.5-8),(int)(height*0.06),text[i],items[i],label,history);
			menuLabel[i].setFont(new Font("宋体",Font.PLAIN,(int)(height*0.04)));
			menuGroup.add(menuLabel[i]);
		}
		left.add(top);
		left.add(menuGroup);
	}
	
	private void initRight() {
		right = new JPanel();
		right.setPreferredSize(new Dimension((int)(width*0.5-8),height));
		right.setLayout(new FlowLayout(FlowLayout.CENTER,0,(int)(height*0.04)));
		right.setOpaque(false);
		
		JPanel blank = new JPanel();
		blank.setPreferredSize(new Dimension((int)(width*0.5-8),(int)(height*0.04)));
		blank.setOpaque(false);
		right.add(blank);
		
		for(int i=0;i<label.length;i++) {
			label[i] = new JLabel(labelName[i]);
			label[i].setPreferredSize(new Dimension((int)(width*0.5-8),(int)(height*0.05)));
			label[i].setFont(new Font("宋体",Font.PLAIN,(int)(height*0.05)));
			label[i].setForeground(Color.white);
			right.add(label[i]);
		}
		
		history = new JTextArea();
		history.setPreferredSize(new Dimension((int)(width*0.5-8),(int)(height*0.48)));
		history.setFont(new Font("宋体",Font.PLAIN,(int)(height*0.05)));
		history.setForeground(Color.white);
		history.setOpaque(false);
		history.setLineWrap(true);
		history.setEditable(false);
		history.setText("处理历史：");
		right.add(history);
	}
}
