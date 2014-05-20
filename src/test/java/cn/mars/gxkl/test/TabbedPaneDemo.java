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
        // 创建选项卡的图标  
        m_tabimage = new ImageIcon("tabimage.gif");  
        // 创建三个图标  
        m_tab1 = new ImageIcon("1.gif");  
        m_tab2 = new ImageIcon("2.gif");  
        m_tab3 = new ImageIcon("3.gif");  
        // ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  
        // 下面是功能按钮面板的创建过程  
        // ＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setLayout(new GridLayout(1, 6));  
        m_topButton = new JButton("顶部");  
        m_bottomButton = new JButton("底部");  
        m_leftButton = new JButton("左边");  
        m_rightButton = new JButton("右边");  
        m_addButton = new JButton("添加选项卡");  
        m_removeButton = new JButton("删除选项卡");  
        // 添加事件监听器  
        m_topButton.addActionListener(this);  
        m_bottomButton.addActionListener(this);  
        m_leftButton.addActionListener(this);  
        m_rightButton.addActionListener(this);  
        m_addButton.addActionListener(this);  
        m_removeButton.addActionListener(this);  
        // 把四个功能按钮加入功能按钮面板中  
        buttonPanel.add(m_topButton);  
        buttonPanel.add(m_bottomButton);  
        buttonPanel.add(m_leftButton);  
        buttonPanel.add(m_rightButton);  
        buttonPanel.add(m_addButton);  
        buttonPanel.add(m_removeButton);  

        // 把选项卡窗格容器和功能按钮面板加入到内容窗格容器中  
        m_tabbedPane = new JTabbedPane(SwingConstants.TOP);  
        getContentPane().add("South", buttonPanel);  
        getContentPane().add("Center", m_tabbedPane);  

        // 创建三个选项卡  
        createTab();  
        createTab();  
        createTab();  
        // 设置显示第一个选项卡  
        m_tabbedPane.setSelectedIndex(0);  
    }  

    // 创建选项卡  
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
        // 把新创建的选项卡添加到选项卡容器中  
        m_tabbedPane.addTab("Tab #" + m_tabbedPane.getTabCount(), m_tabimage,  
                label);  
    }  

    // 删除选项卡  
    public void deleteTab() {  
        // 删除最后一个选项卡  
        if (m_tabbedPane.getTabCount() > 0)  
            m_tabbedPane.removeTabAt(m_tabbedPane.getTabCount() - 1);  
    }  

    // 处理按钮事件  
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
        // 重新绘制选项卡容器  
        m_tabbedPane.revalidate();  
        m_tabbedPane.repaint();  
    }  

    // 程序的入口方法  
    public static void main(String[] args) {  
        TabbedPaneDemo frame = new TabbedPaneDemo();  
        // 设置框架窗体的事件监听(关闭窗体事件)  
        frame.addWindowListener(new WindowAdapter() {  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
        // 显示框架窗体  
        frame.pack();  
        frame.setVisible(true);  
    }  
}   