package cn.mars.gxkl.test;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class TabbedPaneDemo extends JFrame implements ActionListener {  
    private static final long serialVersionUID = 1L;  
    private ImageIcon m_tabimage;  
    private ImageIcon m_tab1;  
    private ImageIcon m_tab2;  
    private ImageIcon m_tab3;  
    private JTabbedPane m_tabbedPane;  
    private JButton m_topButton;  
    private JButton m_bottomButton;  
    private JButton m_leftButton;  
    private JButton m_rightButton;  
    private JButton m_addButton;  
    private JButton m_removeButton;  

    public TabbedPaneDemo() {  
        // ����ѡ���ͼ��  
        m_tabimage = new ImageIcon("tabimage.gif");  
        // ��������ͼ��  
        m_tab1 = new ImageIcon("1.gif");  
        m_tab2 = new ImageIcon("2.gif");  
        m_tab3 = new ImageIcon("3.gif");  
        // ������������������������������������������������������  
        // �����ǹ��ܰ�ť���Ĵ�������  
        // ������������������������������������������������������  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setLayout(new GridLayout(1, 6));  
        m_topButton = new JButton("����");  
        m_bottomButton = new JButton("�ײ�");  
        m_leftButton = new JButton("���");  
        m_rightButton = new JButton("�ұ�");  
        m_addButton = new JButton("���ѡ�");  
        m_removeButton = new JButton("ɾ��ѡ�");  
        // ����¼�������  
        m_topButton.addActionListener(this);  
        m_bottomButton.addActionListener(this);  
        m_leftButton.addActionListener(this);  
        m_rightButton.addActionListener(this);  
        m_addButton.addActionListener(this);  
        m_removeButton.addActionListener(this);  
        // ���ĸ����ܰ�ť���빦�ܰ�ť�����  
        buttonPanel.add(m_topButton);  
        buttonPanel.add(m_bottomButton);  
        buttonPanel.add(m_leftButton);  
        buttonPanel.add(m_rightButton);  
        buttonPanel.add(m_addButton);  
        buttonPanel.add(m_removeButton);  

        // ��ѡ����������͹��ܰ�ť�����뵽���ݴ���������  
        m_tabbedPane = new JTabbedPane(SwingConstants.TOP);  
        getContentPane().add("South", buttonPanel);  
        getContentPane().add("Center", m_tabbedPane);  

        // ��������ѡ�  
        createTab();  
        createTab();  
        createTab();  
        // ������ʾ��һ��ѡ�  
        m_tabbedPane.setSelectedIndex(0);  
    }  

    // ����ѡ�  
    public void createTab() {  
        JLabel label = null;  
        switch (m_tabbedPane.getTabCount() % 3) {  
        case 0:  
            label = new JLabel("Tab #" + m_tabbedPane.getTabCount(), m_tab1,  
                    SwingConstants.CENTER);  
            break;  
        case 1:  
            label = new JLabel("Tab #" + m_tabbedPane.getTabCount(), m_tab2,  
                    SwingConstants.CENTER);  
            break;  
        case 2:  
            label = new JLabel("Tab #" + m_tabbedPane.getTabCount(), m_tab3,  
                    SwingConstants.CENTER);  
            break;  
        }  
        label.setVerticalTextPosition(SwingConstants.BOTTOM);  
        label.setHorizontalTextPosition(SwingConstants.CENTER);  
        label.setOpaque(true);  
        label.setBackground(Color.white);  
        // ���´�����ѡ���ӵ�ѡ�������  
        m_tabbedPane.addTab("Tab #" + m_tabbedPane.getTabCount(), m_tabimage,  
                label);  
    }  

    // ɾ��ѡ�  
    public void deleteTab() {  
        // ɾ�����һ��ѡ�  
        if (m_tabbedPane.getTabCount() > 0)  
            m_tabbedPane.removeTabAt(m_tabbedPane.getTabCount() - 1);  
    }  

    // ����ť�¼�  
    public void actionPerformed(ActionEvent e) {  
        if (e.getSource() == m_topButton)  
            m_tabbedPane.setTabPlacement(SwingConstants.TOP);  
        else if (e.getSource() == m_bottomButton)  
            m_tabbedPane.setTabPlacement(SwingConstants.BOTTOM);  
        else if (e.getSource() == m_leftButton)  
            m_tabbedPane.setTabPlacement(SwingConstants.LEFT);  
        else if (e.getSource() == m_rightButton)  
            m_tabbedPane.setTabPlacement(SwingConstants.RIGHT);  
        else if (e.getSource() == m_addButton)  
            createTab();  
        else if (e.getSource() == m_removeButton)  
            deleteTab();  
        // ���»���ѡ�����  
        m_tabbedPane.revalidate();  
        m_tabbedPane.repaint();  
    }  

    // �������ڷ���  
    public static void main(String[] args) {  
        TabbedPaneDemo frame = new TabbedPaneDemo();  
        // ���ÿ�ܴ�����¼�����(�رմ����¼�)  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
        // ��ʾ��ܴ���  
        frame.pack();  
        frame.setVisible(true);  
    }  
}   