package cn.mars.gxkl.UI.utils;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class MainDetailsPanel extends JPanel {
	
	private int width,height;
	
	JPanel left,right;
	
	public MainDetailsPanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		this.setOpaque(false);
		initialization();
	}
	
	private void initialization() {
		initLeft();
		initRight();
	}
	
	private void initLeft() {
		left = new JPanel(new CardLayout());
		left.setPreferredSize(new Dimension((int)(width*0.8-8),height));
	}
	
	private void initRight() {
		right = new JPanel(new FlowLayout(FlowLayout.LEADING,5,5));
		right.setPreferredSize(new Dimension((int)(width*0.2-8),height));
	}
}
