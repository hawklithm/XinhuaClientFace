package cn.mars.gxkl.UI.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author afsd-pc
 * 
 */
public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4132678401935867541L;
	private int width, height;
	private List<String> searchTypeList;

	private JTextField searchField;
	private JButton searchButton;
	private JScrollPane searchType;
	private Color bgColor = new Color(0x16, 0x49, 0x9a), fgColor = Color.white;
	private Font font;
	private final DefaultComboBoxModel type = new DefaultComboBoxModel();
	/*public SearchPanel(int width, int height, List<String> SearchType) {
		super();
		this.width = width;
		this.height = height;
		this.SearchType = SearchType;
		
		initialization();
	}
*/
	public void initialization() {
		font = new Font("ËÎÌå", Font.PLAIN, (int) (width * 0.015));
		this.setPreferredSize(new Dimension(width,(int) (height*0.9)));
		this.setBackground(bgColor);
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		
		searchType = getTypeJPanel((int) (width * 0.1), (int) (height * 0.7));
		searchField = getJTextField((int) (width * 0.75), (int) (height * 0.8));
		searchButton = getJButton((int) (width * 0.1), (int) (height * 0.8),
				"ËÑË÷");
		this.add(searchType);
		this.add(searchField);
		this.add(searchButton);
	}
	
	private JScrollPane getTypeJPanel(int width, int height) {
		JScrollPane typepanel = new JScrollPane();
		
		final JComboBox typeJCombo = new JComboBox(type);
		typeJCombo.setPreferredSize(new Dimension(width, height));
		typeJCombo.setFont(font);
		typepanel = new JScrollPane(typeJCombo);
		type.addElement("test");
		return typepanel;
	}

	private JLabel getJLabel(int width, int height, String str) {
		JLabel label = new JLabel(str);
		label.setOpaque(false);
		label.setForeground(fgColor);
		label.setFont(font);
		label.setPreferredSize(new Dimension(width, height));
		return label;
	}

	private JTextField getJTextField(int width, int height) {
		JTextField textarea = new JTextField();
		textarea.setPreferredSize(new Dimension(width, height));
		textarea.setFont(font);
		return textarea;
	}

	private JButton getJButton(int width, int height, String str) {
		JButton button = new JButton(str);
		button.setPreferredSize(new Dimension(width, height));
		button.setFont(font);
		return button;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getWidth(){
		return width;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public int getHeight(){
		return height;
	}
	
	public void setSearchType(List<String> searchTypeList){
		type.removeAllElements();
		this.searchTypeList=searchTypeList;
		for(String str:searchTypeList){
			type.addElement(str);
		}
	}
}
