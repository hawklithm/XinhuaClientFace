package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SectionEquipmentPanel {
	private JTable dataTable;
	private JTable headerTable;
	private JScrollPane scrollPane;
	private DefaultTableModel dataTableModel;
	private DefaultTableModel headerTableModel;
	private int HeadTitelWidth;
	private int HeadTitelHeight;
	private int height, width;
	private Font font;
	public SectionEquipmentPanel() {
		String[] header = { "" };
		setRowHeader(header);
		addRow(null);

	}

	public void setRowHeader(String[] rowHeader) {
		if (headerTableModel == null) {
			headerTableModel = new DefaultTableModel(0, 1);
			headerTable = new JTable(headerTableModel);
			headerTable.setEnabled(false);
			headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			// headerTable.getColumnModel().getColumn(0).setPreferredWidth(100);
			// headerTable.setPreferredScrollableViewportSize(new Dimension(100,
			// 30));
		}
		headerTableModel.setRowCount(rowHeader.length);
		/* 为rowHeaderTable设置预设的绘制器 */
		headerTable.setDefaultRenderer(headerTable.getColumnClass(0),
				new RowHeaderRender(rowHeader));
	}

	public void addRow(String[][] values) {
		if (dataTableModel == null) {
			// Object[] header = { "对应值1" ,"对应值2"};
			Object[] header = { "", "", "" };
			dataTableModel = new DefaultTableModel(0, 1);
			dataTableModel.setColumnIdentifiers(header);
			dataTable = new JTable(dataTableModel){
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			dataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		if (values != null) {
			
			Object[] header = new Object[values[0].length];
			for(int i=0;i<values[0].length;i++){
				header[i]="";
			}
			dataTableModel.setColumnIdentifiers(header);
			removeAllRow();
			for (int i = 0; i < values.length; i++) {
				String[] value = values[i];
				dataTableModel.addRow(value);
			}
		}
	}

	public void removeAllRow() {
		if (dataTableModel != null) {
			dataTableModel.setRowCount(0);
		}
	}

	public DefaultTableModel getModel() {
		return dataTableModel;
	}

	public void stopCellEditing() {
		if (dataTable.getCellEditor() != null) {
			dataTable.getCellEditor().stopCellEditing();
		}
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		this.HeadTitelWidth = width / 5;
		this.HeadTitelHeight = height / 12;
		System.out.println(height);
		if (scrollPane != null) {
			scrollPane.setPreferredSize(new Dimension(width, height));
			headerTable.getColumnModel().getColumn(0)
					.setPreferredWidth(HeadTitelWidth);
			headerTable.setRowHeight(HeadTitelHeight);
			dataTable.setRowHeight(HeadTitelHeight);
			headerTable.setPreferredScrollableViewportSize(new Dimension(
					HeadTitelWidth, HeadTitelHeight));
			for (int i = 0; i < dataTable.getColumnCount(); i++) {
				dataTable.getColumnModel().getColumn(i)
						.setPreferredWidth(HeadTitelWidth * 3/2);
			}
		}
		font=new Font("宋体",Font.PLAIN,width/30);
		headerTable.setFont(font);
		dataTable.setFont(font);
	}

	public JScrollPane getScrollPane() {
		// /* 将table加入JScrollPane */
		scrollPane = new JScrollPane(dataTable);
		scrollPane.setRowHeaderView(headerTable);
		scrollPane.getRowHeader().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		return scrollPane;
	}
}
