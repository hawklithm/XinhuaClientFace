package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.protocol.Person;

public class StaffInfoPanel extends JPanel  implements Msg2Face {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6199340767530723008L;
	private int width,height;
	private double scaleImgRate = 1.0;
	private Person staff;
	
	private JLabel img, name, gender, id, rfid, job;
	private JPanel right;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private Font font;
	
//	public StaffInfoPanel(int width, int height) {
//		super();
//		this.width = width;
//		this.height = height;
//		this.setPreferredSize(new Dimension(width, height));
//		this.setBackground(bgColor);
//		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
//		initialization();
//}
	
	public StaffInfoPanel(int width, int height, Person staff) {
		super();
		this.width = width;
		this.height = height;
		this.staff = staff;
		font = new Font("����", Font.PLAIN, (int)(width*0.055));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		initialization();
	}
	
	public StaffInfoPanel(int width, int height, Person staff, double scaleImgRate) {
		this(width,height,staff);
		this.scaleImgRate = scaleImgRate;
	}
	
	
	
	private void initialization() {
		ImageIcon imgIcon = new ImageIcon(staff.getImgPath());
		// ��СͼƬ����ע����
		imgIcon.setImage(imgIcon.getImage().getScaledInstance((int)(scaleImgRate*imgIcon.getIconWidth()),
				(int)(scaleImgRate*imgIcon.getIconHeight()),Image.SCALE_SMOOTH));
		img = new JLabel(imgIcon);
		img.setPreferredSize(new Dimension((int)(width*0.46), height));

		right = new JPanel();
		right.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		right.setPreferredSize(new Dimension((int) (width * 0.54 - 15), height));
		right.setOpaque(false);
		name = getJLabel("������" + staff.getName());
		gender = getJLabel("�Ա�" + staff.getGender());
		id = getJLabel("���ţ�" + staff.getID());
		rfid = getJLabel("RFID�ţ�" + staff.getRFID());
		job = getJLabel("��������" + staff.getJob());
		right.add(name);
		right.add(gender);
		right.add(id);
		right.add(rfid);
		right.add(job);

		this.add(img);
		this.add(right);
	}

	private JLabel getJLabel(String str) {
		JLabel label = new JLabel(str);
		label.setPreferredSize(new Dimension((int)(width*0.54-15), height / 5 - 6));
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		return label;
	}
	
	public void setStaff(Person staff) {
		this.staff = staff;
		img.setIcon(new ImageIcon(staff.getImgPath()));
		name.setText("������" + staff.getName());
		gender.setText("�Ա�" + staff.getGender());
		id.setText("���䣺" + staff.getID());
		rfid.setText("�绰��" + staff.getRFID());
		job.setText("��������" + staff.getJob());
	}

	@Override
	public void setText(List<?> msg) {
		Person staff = (Person)msg.get(0);
		setStaff(staff);
	}

}
