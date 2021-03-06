package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.mars.gxkl.UI.dataobject.BriefDetailObject;
import cn.mars.gxkl.controller.PannelExecutor;
import cn.mars.gxkl.sender.Sender4Face;
import static cn.mars.gxkl.utils.Jsoner.*;

/**
 * Copyright 2014 MARS
 * 
 * All right reserved. afsd-pc 下午2:09:31
 * 
 * TODO 界面左下角详情栏中的详情列
 */
public class BriefDetailPanel extends JPanel implements MouseListener,
		ActionListener, PannelExecutor<BriefDetailObject> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5808306429972803032L;
	private String value, titel;
	private int width, height;
	private JPanel panel;
	private JTextField ValueTextField;
	private JLabel TitelLabel;
	private JButton button1, button2;
	private Font font;
	private Sender4Face sender4Face;
	private String lastText = "";

	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;

	public BriefDetailPanel(int width, int height, String titel, String value) {
		this.width = width;
		this.height = height;
		this.titel = titel;
		this.value = value;

		font = new Font("宋体", Font.PLAIN, (int) (width * 0.055));

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		initialization();
	}

	private void initialization() {
		TitelLabel = new JLabel(titel+"：");
		TitelLabel.setOpaque(false);
		TitelLabel.setFont(font);
		TitelLabel.setForeground(Color.white);

		ValueTextField = new JTextField(value);
		ValueTextField.setPreferredSize(new Dimension((int) (width * 0.4),
				(int) (height * 0.7)));
		ValueTextField.setEditable(false);
		ValueTextField.setOpaque(false);
		ValueTextField.setBorder(null);
		ValueTextField.setFont(font);
		ValueTextField.setForeground(Color.white);
		ValueTextField.addMouseListener(this);

		button1 = new JButton("确定");
		button1.addMouseListener(this);
		button1.setVisible(false);
		button2 = new JButton("取消");
		button2.addMouseListener(this);
		button2.setVisible(false);

		this.add(TitelLabel);
		this.add(ValueTextField);
		this.add(button1);
		this.add(button2);
		this.addMouseListener(this);
	}

	public void setTitel(String titel) {
		this.titel = titel;
		TitelLabel.setText(titel+"：");
	}

	public String getTitel() {
		return titel;
	}

	public void setValue(String value) {
		this.value = value;
		ValueTextField.setText(value);
	}

	public String getValue() {
		return value;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("button click");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this) {
			button1.setVisible(true);
			button2.setVisible(true);
			ValueTextField.setEditable(true);
			ValueTextField.setOpaque(true);
			ValueTextField.setForeground(Color.black);
		} else if (e.getSource() == button1) {
			int n = JOptionPane.showConfirmDialog(null, "确认更改参数吗", "确认更改",
					JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				ValueTextField.setEditable(false);
				ValueTextField.setOpaque(false);
				ValueTextField.setForeground(Color.white);
				if(!lastText.equals(ValueTextField.getText())) {
					Map<String,String> map = new HashMap<String,String>();
					map.put(ValueTextField.getName(), ValueTextField.getText());
					sender4Face.send(toJson(map));
				}
			} else if (n == JOptionPane.NO_OPTION) {
				ValueTextField.setText(value);
				ValueTextField.setEditable(false);
				ValueTextField.setOpaque(false);
				ValueTextField.setForeground(Color.white);
			}
			button1.setVisible(false);
			button2.setVisible(false);
		} else if (e.getSource() == button2) {
			ValueTextField.setText(value);
			ValueTextField.setEditable(false);
			ValueTextField.setOpaque(false);
			ValueTextField.setForeground(Color.white);
			button1.setVisible(false);
			button2.setVisible(false);
		} else if (e.getSource() == ValueTextField) {
			lastText = ValueTextField.getText();
			if (!ValueTextField.isEditable()) {
				button1.setVisible(true);
				button2.setVisible(true);
				ValueTextField.setEditable(true);
				ValueTextField.setOpaque(true);
				ValueTextField.setForeground(Color.black);
			}

		}
	}

	public Sender4Face getSender4Face() {
		return sender4Face;
	}

	public void setSender4Face(Sender4Face sender4Face) {
		this.sender4Face = sender4Face;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFace(BriefDetailObject arg) {
		// TODO Auto-generated method stub

	}
}
