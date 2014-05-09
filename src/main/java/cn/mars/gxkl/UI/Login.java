package cn.mars.gxkl.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.mars.gxkl.center.executor.StaffInfoExecutor;
import cn.mars.gxkl.center.executor.UserInfoExecutor;
import cn.mars.gxkl.netty.ClientService;
import cn.mars.gxkl.protocol.UserInfo;

/*
 * 登陆界面
 */
public class Login extends JFrame {
	private JTextField userName; // 定义文本输入框
	private JPasswordField password; // 定义密码框
	private JLabel jLabel1, jLabel2;
	private JPanel jp1, jp2, jp3,jp4;
    private JLabel message;
	private JButton login, cancel; // 创建登陆、取消按钮
	private UserInfoExecutor userInfoExecutor;
	private WorkerUI workerUI;
	public Login() {
		userName = new JTextField(12);
		password = new JPasswordField(13);
		jLabel1 = new JLabel("用户名");
		jLabel2 = new JLabel("密码");
		login = new JButton("登陆");
		cancel = new JButton("取消");
		message=new JLabel("");
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4=new JPanel();
		/*
		 * 设置布局
		 */
		this.setLayout(new GridLayout(4, 1));

		/*
		 * 添加相应的组件到相应的面板中
		 */
		jp1.add(jLabel1);
		jp1.add(userName);

		jp2.add(jLabel2);
		jp2.add(password);
        jp3.add(message);
		jp4.add(login);
		jp4.add(cancel);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("登陆界面");
		this.setBounds(500, 300, getWidth() / 2, getHeight() / 2);
		this.setSize(500, 300);
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			     if(userName.getText().equals("")||password.getText().equals("")){
			    	 String str="用户或者密码为空";
			    	System.out.println(str);
			    	return ;
			    	}
			 UserInfo user=new UserInfo();
			 
		         user.setName(userName.getText());
		         user.setPassword(password.getText());
		         userInfoExecutor.query(user);
			
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
	public UserInfoExecutor getUserInfoExecutor() {
		return userInfoExecutor;
	}
	public void setUserInfoExecutor(UserInfoExecutor userInfoExecutor) {
		this.userInfoExecutor = userInfoExecutor;
	}
	public JTextField getUserName() {
		return userName;
	}
	public void setUserName(JTextField userName) {
		this.userName = userName;
	}
	public JPasswordField getPassword() {
		return password;
	}
	public void setPassword(JPasswordField password) {
		this.password = password;
	}
	public JLabel getjLabel1() {
		return jLabel1;
	}
	public void setjLabel1(JLabel jLabel1) {
		this.jLabel1 = jLabel1;
	}
	public JLabel getjLabel2() {
		return jLabel2;
	}
	public void setjLabel2(JLabel jLabel2) {
		this.jLabel2 = jLabel2;
	}
	public JPanel getJp1() {
		return jp1;
	}
	public void setJp1(JPanel jp1) {
		this.jp1 = jp1;
	}
	public JPanel getJp2() {
		return jp2;
	}
	public void setJp2(JPanel jp2) {
		this.jp2 = jp2;
	}
	public JPanel getJp3() {
		return jp3;
	}
	public void setJp3(JPanel jp3) {
		this.jp3 = jp3;
	}
	public JButton getCancel() {
		return cancel;
	}
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	public WorkerUI getWorkerUI() {
		return workerUI;
	}
	public void setWorkerUI(WorkerUI workerUI) {
		this.workerUI = workerUI;
	}
	public JLabel getMessage() {
		return message;
	}
	public void setMessage(JLabel message) {
		this.message = message;
	}
	public void setMsg(String msg){
		message.setText(msg);
	}
	
}
