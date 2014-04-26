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
	private List<String> subTitel;
	private List<JTextArea> textAreaList = new ArrayList<JTextArea>();
	private Font font;
	private JTabbedPane tabbedPane;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private int limit = 20;
	private boolean Enend;

	private Msg2Face statisticInfo;

//	public HistoryPanel(int width, int height, List<String> subTitel) {
//		super();
//		this.width = width;
//		this.height = height;
//		this.subTitel = subTitel;
	
//		initialization();
//		Enend = true;
//	}

	public void initialization() {
		font = new Font("宋体", Font.PLAIN, (int) (width * 0.015));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setPreferredSize(new Dimension(width - 30, height - 50));
		tabbedPane.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				index = tabbedPane.getSelectedIndex();
			}

		});


		tabbedPane.setFont(font);
		
		this.add(tabbedPane);

		JButton button1 = new JButton("add");
		button1.addActionListener(new ActionListener() {
			int total = 0;;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				addString(index, "add:" + total);
				total++;

			}

		});
		JButton button2 = new JButton("end");
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setEnend(!Enend);
			}

		});
		this.add(button1);
		this.add(button2);
		Enend = true;
	}

	private JScrollPane getPanel(int i) {
		JScrollPane scrollpane;
		JTextArea textarea = new JTextArea();
		textarea.setFont(font);
		textarea.selectAll();
		textarea.setCaretPosition(textarea.getText().length());
		textarea.requestFocus();
		textarea.setEditable(false);
		textAreaList.add(textarea);
		scrollpane = new JScrollPane(textarea);
		return scrollpane;
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
	public void addString(int index, String str) {
		String value;
		int Position = 0;
		int l = 0;
		value = textAreaList.get(index).getText();
		if (value.split("\n").length >= limit) {
			Position = textAreaList.get(index).getCaretPosition();
			l = value.indexOf("\n") + 1;
			textAreaList.get(index).setText(value.substring(l));
		}
		System.out.println(textAreaList.get(index).getCaretPosition());
		textAreaList.get(index).append(str + "\n");
		if (Enend) {
			textAreaList.get(index).setCaretPosition(
					textAreaList.get(index).getText().length());
			textAreaList.get(index).requestFocus();
		} else {
			textAreaList.get(index).setCaretPosition(Position - l);
			textAreaList.get(index).requestFocus();
		}
	}
	
	public Msg2Face getStatisticInfo() {
		return statisticInfo;
	}

	public void setStatisticInfo(Msg2Face statisticInfo) {
		this.statisticInfo = statisticInfo;
	}

	@Override
	public void setText(List<?> msg) {
		List<Object> itemInfo = new ArrayList<Object>();
		System.out.println("setText start");
		for (Object object : msg) {
			Pair<MachinedItemInfoDO, String> info = (Pair<MachinedItemInfoDO, String>) object;
			addString(index, info.getLast());
			itemInfo.add(info.getFirst());
		}
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

	public List<String> getSubTitel() {
		return subTitel;
	}


	public void setSubTitel(List<String> subTitel){
		if(this.subTitel!=null){
			for(int i=0;i<this.subTitel.size();i++){
				tabbedPane.removeTabAt(0);
			}
		}
		this.subTitel=subTitel;
		Num = subTitel.size();
		int i = 0;
		for (String str : subTitel) {
			// JPanel panel=new JPanel();
			// tabbedPane.addTab(str,getJLabel(width-50,height-30,str));
			tabbedPane.addTab(str, getPanel(i));
			i++;
		}
	}

}
