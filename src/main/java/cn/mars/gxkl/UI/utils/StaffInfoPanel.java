package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.protocol.Person;

public class StaffInfoPanel extends JPanel implements Msg2Face {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199340767530723008L;
	private int width, height;
	private double scaleImgRate = 1.0;
	private Person staff;

	private JLabel img, name,namevalue, gender,gendervalue, id,idvalue, rfid,rfidvalue, job,jobvalue;
	private JPanel right;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private Font font;

	private Msg2Face statisticInfo;

	// public StaffInfoPanel(int width, int height) {
	// super();
	// this.width = width;
	// this.height = height;
	// this.setPreferredSize(new Dimension(width, height));
	// this.setBackground(bgColor);
	// this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
	// initialization();
	// }
	/*
	 * public StaffInfoPanel(int width, int height, Person staff) { super();
	 * this.width = width; this.height = height; this.staff = staff;
	 * initialization(); }
	 * 
	 * public StaffInfoPanel(int width, int height, Person staff, double
	 * scaleImgRate) { this(width,height,staff); this.scaleImgRate =
	 * scaleImgRate; }
	 */

	public void initialization() {
		font = new Font("宋体", Font.PLAIN, (int) (width * 0.055));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
	/*	ImageIcon imgIcon = new ImageIcon(staff.getImgPath());
		// 缩小图片，解注下行
		imgIcon.setImage(imgIcon.getImage().getScaledInstance(
				(int) (scaleImgRate * imgIcon.getIconWidth()),
				(int) (scaleImgRate * imgIcon.getIconHeight()),
				Image.SCALE_SMOOTH));*/
		img = new JLabel();
		img.setPreferredSize(new Dimension((int) (width * 0.46), height));

		right = new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		right.setPreferredSize(new Dimension((int) (width * 0.54 - 15), height));
		right.setOpaque(false);
		name = getJLabel("姓名：");
		gender = getJLabel("性别：");
		id = getJLabel("工号：" );
		idvalue=getJLabel("   ");
		rfid = getJLabel("RFID号：" );
		rfidvalue=getJLabel("   ");
		job = getJLabel("工作名：" );
		jobvalue=getJLabel("   ");
		right.add(name);
		right.add(gender);
		right.add(id);
		right.add(idvalue);
		right.add(rfid);
		right.add(rfidvalue);
		right.add(job);
		right.add(jobvalue);
		this.add(img);
		this.add(right);
	}

	private JLabel getJLabel(String str) {
		JLabel label = new JLabel(str);
		label.setPreferredSize(new Dimension((int) (width * 0.54 - 15),
				height / 8 - 6));
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		return label;
	}

	public Msg2Face getStaticInfo(){
		return this.statisticInfo;
	}
	public void setStaticInfor(Msg2Face statisticInfo){
		this.statisticInfo=statisticInfo;
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

	public void setStaff(Person staff){
		this.staff = staff;
		img.setIcon(new ImageIcon(staff.getImgPath()));
		name.setText("姓名：" + staff.getName());
		gender.setText("性别：" + staff.getGender());
		idvalue.setText("   "+ staff.getID());
//		rfidvalue.setText("   "+ staff.getRFID());
		jobvalue.setText("   "+ staff.getJob());
		
	}
	@Override
	public void setText(List<?> msg) {
		Person staff = (Person) msg.get(0);
		setStaff(staff);
	}

}
