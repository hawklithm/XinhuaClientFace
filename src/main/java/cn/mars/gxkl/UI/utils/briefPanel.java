package cn.mars.gxkl.UI.utils;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.mars.gxkl.protocol.Equipment;

/**
 * 	Copyright   2014  MARS
 *
 *    All right reserved.
 *    afsd-pc   ����7:19:09
 *
 *    TODO �����Ϣ�� 
 */

public class BriefPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -252570012266809058L;
	private int width,height;
	private Equipment equipment; 
	private BriefDetailPanel briefDetailPanel;
	
	private JLabel rfid, type, create,modified, repair,
			manufacturer;
	private List<BriefDetailPanel>detailList_Panel=new ArrayList<BriefDetailPanel>();
	private Color bgColor= new Color(0x16,0x49,0x9a),fgColor=Color.white;
	private Font font;
	
	/**
	 * @param width ��������
	 * @param height ������߶�
	 * @param equipment ���������
	 */
	public BriefPanel(int width, int height,Equipment equipment) {
		super();
		this.width = width;
		this.height = height;
		this.equipment=equipment;
		font=new Font("����",Font.PLAIN,(int)(width*0.055));
		this.setPreferredSize(new Dimension(width,height));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		initialization();
	}
	
	/**
	 * ��ʼ��Panel
	 */
	private void initialization() {	
		
		type=getJLabel("�豸�ͺţ�"+equipment.getTYPE());
		rfid=getJLabel("RFID:"+equipment.getRFID());
		create=getJLabel("�볡ʱ��:"+equipment.getCREATE());
		modified=getJLabel("�������:"+equipment.getMODIFIED());
		repair=getJLabel("����޸�:"+equipment.getREPAIR());
		manufacturer=getJLabel("��������:"+equipment.getMANFACTURER());
		
		this.add(type);
		this.add(rfid);
		this.add(create);
		this.add(modified);
		this.add(repair);
		this.add(manufacturer);
		for(String str:equipment.getDETAIL()){
			detailList_Panel.add(new BriefDetailPanel((int)width,height/15-14,str));
			this.add(detailList_Panel.get(detailList_Panel.size()-1));
		}
	}

	/**
	 * @param str
	 * @return 
	 * ���ɰ���str��JLable
	 */
	private JLabel getJLabel(String str){
		JLabel label=new JLabel(str);
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		label.setPreferredSize(new Dimension((int)(width*0.8),height/15-14));
		return label;
	}
	
	/**
	 * @param str
	 * @return
	 * 
	 */
	private JPanel getJPanel(String str){
		JPanel panel=new JPanel();
		JLabel label;
		panel.setBackground(bgColor);
		label=getJLabel(str);
		panel.add(label);
		return panel;
	}

	public void setEquipment(Equipment equipment){
		this.equipment=equipment;
		type.setText("�豸�ͺ�:"+equipment.getTYPE());
		rfid.setText("RFID:"+equipment.getRFID());
		create.setText("�볡ʱ��:"+equipment.getCREATE());
		modified.setText("�������:"+equipment.getMODIFIED());
		repair.setText("����޸�:"+equipment.getREPAIR());
		manufacturer.setText("��������:"+equipment.getMANFACTURER());
		int i=0;
		for(BriefDetailPanel detailpanel:detailList_Panel){
			detailpanel.setString(equipment.getDETAIL().get(i));
			i++;
		}
	}
}
