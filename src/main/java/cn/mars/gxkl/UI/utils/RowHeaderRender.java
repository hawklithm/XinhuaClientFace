package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class RowHeaderRender extends JLabel implements TableCellRenderer {
	private static final JTableHeader header = (new JTable()).getTableHeader();
	private static final Color BACKGOURND = header.getBackground();
	private static final Font FONT = header.getFont();
	private Object[] rowHeader;
	private int rowCount;

	public RowHeaderRender(Object[] rowHeader) {
		this.rowHeader = rowHeader;
		this.rowCount = rowHeader.length;
	}

	public Component getTableCellRendererComponent(JTable table, Object obj,
			boolean isselected, boolean hasfocus, int row, int col) {
		((DefaultTableModel) table.getModel()).setRowCount(rowCount);
		this.setOpaque(true);
		/* 设为tableHeader的边框类型 */
		// setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		setHorizontalAlignment(LEFT);
		// setCellEditor(new DefaultTable);
		/* 设置背景色为tableHeader的背景色 */
		setBackground(BACKGOURND);
		setFont(FONT);
		setText(rowHeader[row].toString());
		return this;
	}

}