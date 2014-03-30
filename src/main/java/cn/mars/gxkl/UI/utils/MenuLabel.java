package cn.mars.gxkl.UI.utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import cn.mars.gxkl.protocol.Item;

public class MenuLabel extends JLabel {

	private int width,height;
	private String text;
	private boolean flag = false;
	private Item[] items;
	
	private JPopupMenu menu;
	private JTextArea textArea;
	private JLabel[] label;
	
	public MenuLabel(int width, int height, Item[] items, JLabel[] label, JTextArea textArea) {
		super();
		this.items = items;
		this.width = width;
		this.height = height;
		this.textArea = textArea;
		this.label = label;
		this.setOpaque(true);
		this.setHorizontalAlignment(SwingConstants.LEFT);
		this.setPreferredSize(new Dimension(width,height));
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				setText(" "+text+" ▼");//:" ▲"));
				menu.show(MenuLabel.this, 0, MenuLabel.this.getHeight());
//				flag = !flag;
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		initiazalition();
	}
	
	private void initiazalition() {
		this.menu = new JPopupMenu();
		this.menu.setLayout(new BorderLayout());
		this.menu.setPopupSize(300, 300);
		List<String> rfids = new ArrayList<String>();
		for(Item item : items) {
			rfids.add("RFID:"+item.getRFID());
		}
		JList list = new JList(rfids.toArray());
		list.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JList list = (JList)e.getSource();
				Item chosen = items[list.getSelectedIndex()];
				label[0].setText("名字： "+chosen.getName());
				label[1].setText("RFID： "+chosen.getRFID());
				label[2].setText("处理流程： "+chosen.getProcedure());
				label[3].setText("处理进程： "+chosen.getProcess());
				textArea.setText("处理历史： "+chosen.getHistory());
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {}
			@Override
			public void mouseExited(MouseEvent arg0) {}
			@Override
			public void mousePressed(MouseEvent arg0) {}
			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		list.setFont(new Font("宋体",Font.PLAIN,20));
		this.menu.add(new JScrollPane(list),BorderLayout.CENTER);
	}
	
	public MenuLabel(int width, int height, String text, Item[] items, JLabel[] label, JTextArea textArea) {
		this(width,height,items,label,textArea);
		this.text =text;
		this.setText(" "+text+" ▼");
	}
	
	public void setMenuFont(Font font) {
		this.menu.setFont(font);
	}
	
	public void setMenuSize(int width, int height) {
		this.menu.setPopupSize(width, height);
	}
	
}
