package cn.mars.gxkl.test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class TabbedDialog extends JDialog implements ActionListener {
     
    private Map<String, JPanel> panels;
    private MainPane mainPane;
    private JButton ok = new JButton("OK");
    private JButton cancel = new JButton("Cancel");
    private JButton apply = new JButton("Apply");
     
    private class MainPane extends JPanel {
 
        JTabbedPane tabs;
 
        MainPane() {
            setLayout(new BorderLayout(6, 6));
            tabs = new JTabbedPane();
            add(BorderLayout.CENTER, tabs);
            add(BorderLayout.SOUTH, new Buttons());
        }
         
        public Component addTab(String title, Component component) {
            return tabs.add(title, component);
        }
         
        public Insets getInsets() {
            return new Insets(6, 6, 6, 6);
        }
    }
     
    private class General extends JPanel {
        public void paint(Graphics g) {
            g.drawString("System:", 120, 50);
            g.drawString("Microsoft Windows XP Professional", 160, 62);
        }
        //自己完成...
    }
 
    private class ComputerName extends JPanel {
        //自己完成...
    }
     
    private class Hardware extends JPanel {
        //自己完成...
    }
     
    private class Advanced extends JPanel {
        //自己完成...
    }
     
    private class SystemRestore extends JPanel {
        //自己完成...
    }
     
    private class AutomaticUpdates extends JPanel {
        //自己完成...
    }
     
    private class Remote extends JPanel {
        //自己完成...
    }
     
    private class Buttons extends JPanel {
        Buttons() {
            setLayout(new FlowLayout(FlowLayout.RIGHT, 6, 0));
            add(ok);
            add(cancel);
            add(apply);
        }
    }
     
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().equals("Cancel"))
            save();
        if (!e.getActionCommand().equals("Apply"))
            exit();
    }
     
    private void exit() {
        System.exit(0);
    }
 
    private void save() {
        //自己完成...
        JOptionPane.showMessageDialog(this, "Settings saved");
    }
 
    public TabbedDialog() {
        init();
         
        setTitle("System Properties");
        setSize(420, 480);
         
        mainPane = new MainPane();
        setContentPane(mainPane);
        setVisible(true);
         
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
         
        ok.addActionListener(this);
        cancel.addActionListener(this);
        apply.addActionListener(this);
         
        installTabs();
    }
     
    private void init() {
        panels = new LinkedHashMap<String, JPanel>();
        panels.put("General", new General());
        panels.put("Computer Name", new ComputerName());
        panels.put("Hardware", new Hardware());
        panels.put("Advanced", new Advanced());
        panels.put("System Restore", new SystemRestore());
        panels.put("Automatic Updates", new AutomaticUpdates());
        panels.put("Remote", new Remote());
    }
     
    private void installTabs() {
        for (String s : panels.keySet())
            mainPane.addTab(s, panels.get(s));
    }
     
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) { }
        new TabbedDialog();
    }
 
}