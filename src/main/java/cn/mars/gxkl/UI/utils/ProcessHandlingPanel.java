package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

import cn.mars.gxkl.UI.Msg2Face;
import cn.mars.gxkl.UI.dataobject.ProcessItemInfoHandler;
import cn.mars.gxkl.utils.Pair;

public class ProcessHandlingPanel extends JPanel implements Msg2Face {

	private static final long serialVersionUID = 2312768428623069441L;
	private int width, height;
	private JPanel left, topStatistics, bottomStatistics;
	private String Title = ":实时统计信息";
	private Font font_Title;
	private Color color = new Color(0x16, 0x49, 0x9a);
	
	private String[] pcsTbTitle = {"器械类型","待处理","正在处理","已处理"};
	private String[] eqmTbTitle = {"器械类型","正在处理","已处理"};
	private String processName = "清洗消毒";
	private int equipId = 1,equipNum = 1;

//	private List<ItemInfoDO> itemCache = new ArrayList<ItemInfoDO>();
	private ProcessItemInfoHandler handler = new ProcessItemInfoHandler();
	
	private DetailedComboBox detailedComboBox;
	private DefaultTableModel pcsModel = new DefaultTableModel() {
		
		private static final long serialVersionUID = -6346234311461713590L;

		public boolean isCellEditable(int row,int column) {
			if(column == 0) {
				return false;
			}
			detailedComboBox.setText(handler.getRfidVector(-1, row, column));
			return false;
		}
	};
	private DefaultTableModel eqpModel = new DefaultTableModel() {

		private static final long serialVersionUID = -6346234311461713590L;

		public boolean isCellEditable(int row,int column) {
			if(column == 0) {
				return false;
			}
			detailedComboBox.setText(handler.getRfidVector(equipId, row, column));
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
		detailedComboBox = new DetailedComboBox((int) (width * 0.57), height,handler);
		this.add(detailedComboBox);
//		setText(new ItemInfoDOData().getData());
	}

	private JPanel getLeft(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel.setBackground(color);
		panel.setOpaque(false);
		topStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5),eqmTbTitle,eqpModel);
		panel.add(topStatistics);
		bottomStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5),pcsTbTitle,pcsModel);
		panel.add(bottomStatistics);
		return panel;
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
		topic.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		topic.setOpaque(false);
		if(tableTitle.length==3) {
			topic.add(getTitleLabel(processName + "设备"));
			JComboBox<String> comboBox = new JComboBox<String>();
			DefaultComboBoxModel<String> comModel = new DefaultComboBoxModel<String>();
			for (int i = 1; i <= equipNum; i++) {
				comModel.addElement("" + i);
			}
			comboBox.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					equipId = (int)e.getItem();
					//TODO
				}
				
			});
			comboBox.setModel(comModel);
			comboBox.setSelectedIndex(0);
			topic.add(comboBox);
			topic.add(getTitleLabel(Title));
		}
		else {
			topic.add(getTitleLabel(processName+"工段" + Title));
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
		handler.addItemVector((List<Pair<Integer, ItemInfoDO>>)msg);
		List<Pair<String,List<Integer>>> ret = handler.getEquipmentData();
		for(Pair<String,List<Integer>> pair : ret) {
			String name = pair.getFirst();
			List<Integer> valueVector = pair.getLast();
			int index = valueVector.get(0);
			if(ret.size()>eqpModel.getRowCount()) {
				eqpModel.setRowCount(ret.size());
			}
			eqpModel.setValueAt(name, index, 0);
			for(int i=1;i<=2;i++) {
				eqpModel.setValueAt(valueVector.get(i), index, i);
			}
		}
	}

}
