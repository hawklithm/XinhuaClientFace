package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class SectionEquipmentPanel {
	private JTable dataTable;
	private JTable headerTable;
	private DefaultTableModel dataTableModel;
	private DefaultTableModel headerTableModel;

	public void setRowHeader(Object[] rowHeader) {
		if (headerTableModel == null) {
			headerTableModel = new DefaultTableModel(0, 1);
			headerTable = new JTable(headerTableModel);
			headerTable.setEnabled(false);
			headerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			headerTable.getColumnModel().getColumn(0).setPreferredWidth(500);
			headerTable
					.setPreferredScrollableViewportSize(new Dimension(35, 6));
		}
		headerTableModel.setRowCount(rowHeader.length);
		/* ΪrowHeaderTable����Ԥ��Ļ����� */
		headerTable.setDefaultRenderer(headerTable.getColumnClass(0),
				new RowHeaderRender(rowHeader));
	}

	public void addRow(Object[][] values) {
		if (dataTableModel == null) {
			// Object[] header = { "��Ӧֵ1" ,"��Ӧֵ2"};
			Object[] header = { "", "", "" };
			dataTableModel = new DefaultTableModel(0, 2);
			dataTableModel.setColumnIdentifiers(header);
			dataTable = new JTable(dataTableModel);
		}
		// �Ѻ���תΪ����
		for (int i = 0; i < values.length; i++) {
			Object[] value = { values[i] };
			// dataTableModel.insertRow(n, values);
			dataTableModel.addRow(value);
		}
		dataTable.getTableHeader().setVisible(false);
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

	public JScrollPane getScrollPane() {
		// /* ��table����JScrollPane */
		JScrollPane scrollPane = new JScrollPane(dataTable);
		scrollPane.setRowHeaderView(headerTable);
		scrollPane.getRowHeader().setBackground(Color.WHITE);
		scrollPane.getViewport().setBackground(Color.WHITE);
		return scrollPane;
	}
}
