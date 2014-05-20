package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.utils.Pair;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

/**
 * Copyright 2014 MARS
 * 
 * All right reserved. afsd-pc 下午7:12:35
 * 
 * TODO 流水信息框
 */
public class HistoryPanel extends JPanel implements Msg2Face {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5390410285673282364L;
	private int index = 0;
	private int Num;

	private int width, height;
	private JTextArea textArea;
	private Font font;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private int limit = 200;
	private boolean Enend;

	private Msg2Face statisticInfo;

	// public HistoryPanel(int width, int height, List<String> subTitel) {
	// super();
	// this.width = width;
	// this.height = height;
	// this.subTitel = subTitel;

	// initialization();
	// Enend = true;
	// }

	public void initialization() {
		font = new Font("宋体", Font.PLAIN, (int) (width * 0.015));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		this.add(this.getTitelPanel(width, height/12));
		this.add(this.getTextPanel(width,height*11/12));
        this.addString("fhkdfhkjs");
/*
		JButton button1 = new JButton("add");
		button1.addActionListener(new ActionListener() {
			int total = 0;;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addString("add:" + total);
				total++;

			}
		});
		this.add(button1);
		JButton button2 = new JButton("end");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setEnend(!Enend);
			}

		});
		this.add(button2);*/

		Enend = true;
	}
	private JPanel getTitelPanel(int width,int height){
		JPanel titel=new JPanel();
		titel.setBackground(bgColor);
		titel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		titel.setPreferredSize(new Dimension(width-10,height));
		JPanel titelLeft=new JPanel();
		titelLeft.setBackground(bgColor);
		Font font_Title = new Font("宋体", Font.BOLD, width / 50);
		titelLeft.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));	
		JLabel titelLabel=new JLabel("滚动信息");
		titelLabel.setForeground(fgColor);
		titelLabel.setFont(font_Title);	
		titelLeft.add(titelLabel);
		titel.add(titelLeft);
		return titel;
	}
	private JPanel getTextPanel(int width,int height){
		JPanel panel=new JPanel();
		
		JScrollPane scrollpane;
		textArea = new JTextArea();
		textArea.setFont(font);
		textArea.selectAll();
		textArea.setCaretPosition(textArea.getText().length());
		textArea.requestFocus();
		textArea.setEditable(false);
		scrollpane = new JScrollPane(textArea);
		scrollpane.setPreferredSize(new Dimension(width-30,height-30));
		scrollpane.setBorder(null);
		panel.add(scrollpane);
		return panel;
	}


	/**
	 * 设置流水信息框数据是否置于最下层
	 * 
	 * @param Enend
	 */
	public void setEnend(boolean Enend) {
		this.Enend = Enend;
	}

	/**
	 * 在流水信息框中添加字符串，
	 * 
	 * @param index
	 *            所选择的标签页
	 * @param str
	 *            所要添加的字符串
	 */
	public void addString( String str) {
		System.out.println("in");
		String value;
		int Position = 0;
		int l = 0;
		value = textArea.getText();
		if (value.split("\n").length >= limit) {
			Position = textArea.getCaretPosition();
			l = value.indexOf("\n") + 1;
			textArea.setText(value.substring(l));
		}
		System.out.println("position:"+textArea.getCaretPosition());
		textArea.append(str + "\n");
		if (Enend) {
			textArea.setCaretPosition(
					textArea.getText().length());
			textArea.requestFocus();
		} else {
			textArea.setCaretPosition(Position - l);
			textArea.requestFocus();
		}
	}

	public Msg2Face getStatisticInfo() {
		return statisticInfo;
	}

	public void setStatisticInfo(Msg2Face statisticInfo) {
		this.statisticInfo = statisticInfo;
	}

	@Override
	public void setText(List<?> msg) throws Exception {
		System.out.println(this.toString());
		List<Object> itemInfo = new ArrayList<Object>();
		System.out.println("setText start");
		for (Object object : msg) {
			
			Pair<MachinedItemInfoDO, String> info = (Pair<MachinedItemInfoDO, String>) object;
			addString(info.getLast());
			itemInfo.add(info.getFirst());
		}
		System.out.println("正式插入");
		statisticInfo.setText(itemInfo);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}





}
