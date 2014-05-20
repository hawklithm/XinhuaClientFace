package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;
import com.multiagent.hawklithm.item.dataobject.MachinedItemInfoDO;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.UI.dataobject.EquipItemInfoHandler;
import cn.mars.gxkl.testData.ItemInfoDOData;
import cn.mars.gxkl.utils.Pair;

public class WorkerHandlingPanel extends JPanel implements Msg2Face {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2312768428623069441L;
	private int width, height;
	private JPanel left, topStatistics, bottomStatistics;
	private Font font_Title;
	private Color color = new Color(0x16, 0x49, 0x9a);
	private JTextPane detailPane = new JTextPane();
	private SimpleAttributeSet fontSet = new SimpleAttributeSet(),nbspSet = new SimpleAttributeSet();
	
	private String[] itemTbTitle = {"器械类型","RFID"};
	private String[] staTbTitle = {"器械类型","正在处理","已处理"};
	private String processName = "清洗消毒";
	private String[] rowName = {
			"RIFD：","器械名称：","器械类型：","医院ID：","器械状态：","生产厂商：","是否可换：","remark："
	};

//	private List<ItemInfoDO> itemCache = new ArrayList<ItemInfoDO>();
	private EquipItemInfoHandler handler;
	
	public EquipItemInfoHandler getHandler() {
		return handler;
	}

	public void setHandler(EquipItemInfoHandler handler) {
		this.handler = handler;
	}

	private DefaultTableModel staModel = new DefaultTableModel() {
		
		private static final long serialVersionUID = -1304030423395805825L;

		public boolean isCellEditable(int row,int column) {
			return false;
		}
	};
	private DefaultTableModel itemModel = new DefaultTableModel() {

		private static final long serialVersionUID = -6346234311461713590L;

		public boolean isCellEditable(int row,int column) {
			if(column==0) {
				column++;
			}
			String rfid = (String)this.getValueAt(row, column);
			setDocument(handler.getItemByRfid(rfid));
			return false;
		}
	};


	public void initialization() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(color);
		font_Title = new Font("宋体", Font.BOLD, width / 50);

		left = getLeft((int) (width * 0.4), height);
//		right = getRight((int) (width * 0.57), height);

		this.add(left);
//		this.add(right);
//		detailedComboBox = new DetailedComboBox((int) (width * 0.57), height,handler);
		initRight((int) (width * 0.58), height);
		this.add(detailPane);
//		this.add(detailedComboBox);
//		setText(new ItemInfoDOData().getData());
	}

	private JPanel getLeft(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel.setBackground(color);
		panel.setOpaque(false);
		topStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5),itemTbTitle,itemModel);
		panel.add(topStatistics);
		bottomStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5),staTbTitle,staModel);
		panel.add(bottomStatistics);
		return panel;
	}

	private void initRight(int width,int height) {
		StyleConstants.setFontSize(fontSet, (int)(height*0.05));
		StyleConstants.setFontSize(nbspSet, (int)(height*0.02));
		detailPane.setEditable(false);
		detailPane.setParagraphAttributes(fontSet, false);
		detailPane.setPreferredSize(new Dimension(width,height-20));
		StyledDocument document = detailPane.getStyledDocument();
		try {
			for(String str : rowName) {
				document.insertString(document.getLength(), str+"\n", fontSet);
				document.insertString(document.getLength(), "\n", nbspSet);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
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
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
//	private JPanel initEqpDataPanel(int width,int height,String str) {
//		String[] tableTitle = {"器械类型","正在处理","已处理"};
//		
//		
//	}
	
	private JPanel getStatisticsPanel(int width, int height, String[] tableTitle, DefaultTableModel model) {
		JPanel panel = new JPanel();
		JPanel topic = new JPanel();
		topic.setPreferredSize(new Dimension(width, (int) (height / 8)));
	//	topic.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		topic.setLayout(new FlowLayout(FlowLayout.LEFT,5,0));
		topic.setOpaque(false);
		if(tableTitle.length==2) {
			topic.add(getTitleLabel("正在处理"));
		}
		else {
			topic.add(getTitleLabel("今日统计"));
		}
		JTable table;
		panel.setPreferredSize(new Dimension(width, height - 10));
		panel.setBackground(color);
		panel.setOpaque(false);
		

//		String[] Titles = { new String("器械类型"), new String("待处理"),
//				new String("正在处理"), new String("已处理") };
		model.setColumnIdentifiers(tableTitle);
		model.setColumnCount(tableTitle.length);
		table = new JTable(model);
		Font font = new Font("宋体", Font.BOLD, width / 35);
		table.setFont(font);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setPreferredScrollableViewportSize(new Dimension(width - 20,
				height / 8 * 7 - 10));
//		table.setEnabled(false);
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);

		panel.add(topic);
		panel.add(scrollPane);
		return panel;
	}

	private JLabel getTitleLabel(String str) {
		JLabel label = new JLabel(str);
		label.setFont(font_Title);
		label.setForeground(Color.white);
		return label;
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

	@Override
	public void setText(List<?> msg) {
		handler.addItemVector((List<MachinedItemInfoDO>)msg);
		List<List<String>> ret = handler.getStatisticNumber();
		while(staModel.getRowCount()>0) {
			staModel.removeRow(staModel.getRowCount()-1);
		}
		for(List<String> data : ret) {
			staModel.addRow(data.toArray());
		}
		ret = handler.getRuntimeInformation();
		while(itemModel.getRowCount()>0) {
			itemModel.removeRow(itemModel.getRowCount()-1);
		}
		for(List<String> data : ret) {
			itemModel.addRow(data.toArray());
		}
	}

}
