package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.multiagent.hawklithm.item.dataobject.ItemInfoDO;

import cn.mars.gxkl.UI.Msg2Face;

public class WorkerHandlingPanel extends JPanel implements Msg2Face {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2312768428623069441L;
	private int width, height;
	private JPanel right, left, topStatistics, bottomStatistics;
	private String titel = ":实时统计信息";
	private Font font_titel, font_detatil_titel, font_detatil_value;
	private Color color = new Color(0x16, 0x49, 0x9a);

	private List<ItemInfoDO> itemCache = new ArrayList<ItemInfoDO>();


	public void initialization() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(color);
		font_titel = new Font("宋体", Font.BOLD, width / 50);
		font_detatil_titel = new Font("宋体", Font.BOLD, height / 20);
		font_detatil_value = new Font("宋体", Font.BOLD, height / 20);

		left = getLeft((int) (width * 0.4), height);
		right = getRight((int) (width * 0.57), height);

		this.add(left);
		this.add(right);
	}

	private JPanel getLeft(int width, int height) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel.setBackground(color);
		panel.setOpaque(false);
		topStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5), "清洗消毒工段");
		panel.add(topStatistics);
		bottomStatistics = getStatisticsPanel((int) (width * 0.9),
				(int) (height * 0.5), "清洗消毒1号机");
		panel.add(bottomStatistics);
		return panel;
	}

	private JPanel getRight(int width, int height) {
		JPanel panel = new JPanel();
		JPanel titelPanel = new JPanel();
		JPanel detailPanel = new JPanel();

		panel.setPreferredSize(new Dimension(width, height));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		panel.setBackground(color);
		panel.setOpaque(false);

		titelPanel.setPreferredSize(new Dimension(width, height / 18));
		titelPanel.setBackground(color);
		titelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		titelPanel.setOpaque(false);

		JLabel titelLabel = new JLabel("xxx设备：正在处理");
		titelLabel.setPreferredSize(new Dimension(width / 3, height / 18));
		titelLabel.setFont(new Font("宋体", Font.BOLD, width / 30));
		titelLabel.setForeground(Color.white);
		titelPanel.add(titelLabel);

		List<String> subtitel = new ArrayList<String>();
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		subtitel.add("RFID:123124123124124");
		final DefaultComboBoxModel subtitels = new DefaultComboBoxModel();
		for (String str : subtitel) {
			subtitels.addElement(str);
		}
		JComboBox subTitel = new JComboBox(subtitels);
		subTitel.setSelectedIndex(0);
		subTitel.setPreferredSize(new Dimension(width * 2 / 3 - 20, height / 18));
		subTitel.setFont(new Font("宋体", Font.BOLD, width / 30));
		titelPanel.add(subTitel);
		panel.add(titelPanel);

		detailPanel.setPreferredSize(new Dimension(width, height * 16 / 18));
		detailPanel.setBackground(Color.white);
		detailPanel.setOpaque(true);
		detailPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		detailPanel.add(getDetailItemPanel(width, height / 18, "RFID",
				"12345645687"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "名称", "手术锤"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "正在进行", "清洗消毒"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "当前操作员", "李华"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "所属单位", "中心自有"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "开机时间",
				"2014/3/30 14:50"));
		detailPanel.add(getDetailItemPanel(width, height / 18, "所属单位", "华西医院"));

		panel.add(detailPanel);
		return panel;
	}

	private JPanel getDetailItemPanel(int width, int height, String Titel,
			String Value) {
		JPanel DetailItemPanel = new JPanel();
		DetailItemPanel.setPreferredSize(new Dimension(width, height));
		DetailItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		DetailItemPanel.add(getDetailTitelLabel(Titel));
		DetailItemPanel.add(getDetailValueLabel(Value));
		return DetailItemPanel;
	}

	private JLabel getDetailTitelLabel(String str) {
		JLabel detailTitelLabel = new JLabel(str + "：");
		detailTitelLabel.setFont(font_detatil_titel);
		return detailTitelLabel;
	}

	private JLabel getDetailValueLabel(String str) {
		JLabel detailValueLabel = new JLabel(str);
		detailValueLabel.setFont(font_detatil_value);
		return detailValueLabel;
	}

	private JPanel getStatisticsPanel(int width, int height, String str) {
		JPanel panel = new JPanel();
		JLabel topic = new JLabel(str + titel);
		JTable table;
		panel.setPreferredSize(new Dimension(width, height - 10));
		panel.setBackground(color);
		panel.setOpaque(false);

		topic.setPreferredSize(new Dimension(width, (int) (height / 8)));
		topic.setFont(font_titel);
		topic.setForeground(Color.white);

		String[] titels = { new String("器械类型"), new String("已处理"),
				new String("待处理"), new String("正在处理") };
		String[][] info = {
				{ "手术锤", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" },
				{ "手术锤", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" },
				{ "手术锤", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" },
				{ "手术锤", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" },
				{ "手术锤", "1003", "1005", "300" },
				{ "手术钳子", "1003", "1005", "300" },
				{ "手术剪刀", "1003", "1005", "300" },
				{ "手术棒槌", "1003", "1005", "300" }
			};
		DefaultTableModel model = new DefaultTableModel(info, titels) {
			public boolean isCellEditable(int row,int column) {
				
				return false;
			}
		};
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
		for (Object object : msg) {
			itemCache.add((ItemInfoDO) object);
		}
	}

}
