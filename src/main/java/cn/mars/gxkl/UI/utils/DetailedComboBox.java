package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.UI.dataobject.Rfid2Item;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

public class DetailedComboBox extends JPanel implements Msg2Face {

	private JComboBox<String> comboBox = new JComboBox<String>();
	private JTextPane detailPane = new JTextPane();
	private Font comboFont;
	private DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	private SimpleAttributeSet fontSet = new SimpleAttributeSet(),nbspSet = new SimpleAttributeSet();
	
	private int height,width;
	private String[] rowName = {
			"RIFD：","器械名称：","器械类型：","医院ID：","器械状态：","操作员：","是否可换：","remark：","创建时间：","修改时间："
	};
	private Rfid2Item map;
	
	public DetailedComboBox(int width, int height,Rfid2Item map) {
		this.map = map;
		this.width = width;
		this.height = height;
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
		comboFont = new Font("宋体",Font.PLAIN,(int)(height*0.03));
		initialization();
	}

	public void initialization() {
		comboBox.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.white), "清洗消毒设备正在处理的器械",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, comboFont,Color.white));
		comboBox.setModel(model);
		comboBox.setOpaque(false);
		comboBox.setFont(comboFont);
//		Component c = comboBox.getComponent(0);
		comboBox.setPreferredSize(new Dimension(width, (int)(height*0.1)));
		
		int detailHeight = (int)(height*0.87);
		StyleConstants.setFontSize(fontSet, (int)(detailHeight*0.05));
		StyleConstants.setFontSize(nbspSet, (int)(detailHeight*0.02));
		detailPane.setEditable(false);
		detailPane.setParagraphAttributes(fontSet, false);
		detailPane.setPreferredSize(new Dimension(width,detailHeight));
		StyledDocument document = detailPane.getStyledDocument();
		try {
			for(String str : rowName) {
				document.insertString(document.getLength(), str+"\n", fontSet);
				document.insertString(document.getLength(), "\n", nbspSet);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		this.add(comboBox);
		this.add(detailPane);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String rfid = (String)e.getItem();
				ItemInfoDO item = map.getItemByRfid(rfid);
				setDocument(item);
			}
		});
	}

	
	private void setDocument(ItemInfoDO item) {
		detailPane.setText("");
		StyledDocument document = detailPane.getStyledDocument();
		try {
			document.insertString(document.getLength(), rowName[0]+item.getItemId()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[1]+item.getItemName()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[2]+item.getItemType()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[3]+item.getHospitalId()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[4]+item.getStatus()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[5]+item.getManufacturer()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[6]+item.isInterconvertible()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[7]+item.getRemark()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[8]+item.getGmtCreate()+"\n", fontSet);
			document.insertString(document.getLength(), "\n", nbspSet);
			document.insertString(document.getLength(), rowName[9]+item.getGmtModified()+"\n", fontSet);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setText(List<?> msg) {
		model.removeAllElements();
		for(String rfid : (List<String>)msg) {
			model.addElement(rfid);
		}
//		comboBox.setSelectedIndex(0);
	}
}
