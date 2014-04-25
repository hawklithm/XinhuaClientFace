package cn.mars.gxkl.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.mars.gxkl.center.executor.StaffInfoExecutor;

/*
 * ��½����
 */
public class Login extends JFrame {
	private JTextField userName; // �����ı������
	private JPasswordField password; // ���������
	private JLabel jLabel1, jLabel2;
	private JPanel jp1, jp2, jp3;
	private JButton login, cancel; // ������½��ȡ����ť
	private StaffInfoExecutor staffInfoExecutor;

	public Login() {
//		ClientService clientService = new ClientService();
		userName = new JTextField(12);
		password = new JPasswordField(13);
		jLabel1 = new JLabel("�û���");
		jLabel2 = new JLabel("����");
		login = new JButton("��½");
		cancel = new JButton("ȡ��");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		/*
		 * ���ò���
		 */
		this.setLayout(new GridLayout(3, 1));

		/*
		 * �����Ӧ���������Ӧ�������
		 */
		jp1.add(jLabel1);
		jp1.add(userName);

		jp2.add(jLabel2);
		jp2.add(password);

		jp3.add(login);
		jp3.add(cancel);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("��½����");
		this.setBounds(500, 300, getWidth() / 2, getHeight() / 2);
		this.setSize(500, 300);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				new StaffInfoExecutor().query(1);
				staffInfoExecutor.query(1);
				setVisible(false);
//				ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
				// Login login=(Login)context.getBean("login");

//				WorkerUI workerUI = (WorkerUI) context.getBean("workerUI");
				// workerUI.showUp();
//				ManagerUI managerUI = (ManagerUI) context.getBean("managerUI");
//				managerUI.showUp();
			}

		});
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				userName.setText("");
				password.setText("");
			}

		});
	}

	public StaffInfoExecutor getStaffInfoExecutor() {
		return staffInfoExecutor;
	}

	public void setStaffInfoExecutor(StaffInfoExecutor staffInfoExecutor) {
		this.staffInfoExecutor = staffInfoExecutor;
	}

}
