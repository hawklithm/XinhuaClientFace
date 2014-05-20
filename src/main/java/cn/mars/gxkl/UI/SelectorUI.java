package cn.mars.gxkl.UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.mars.gxkl.center.executor.MachineInfoExecutor;
import cn.mars.gxkl.center.executor.ProcessInfoExecutor;
import cn.mars.gxkl.constant.Constant;

public class SelectorUI extends JFrame implements ActionListener{

private    ProcessInfoExecutor        processInfoExecutor;
private MachineInfoExecutor machineInfoExecutor;
private Login login;
	/*
	 * 清洗消毒
	 */
	private JButton cleanMachine;
	private JButton cleanRFID1;
	private JButton cleanRFID2;
	
	
	
	/*
	 * 打包台
	 */
	private JButton packageMachine;
	private JButton packageRFID1;
	private JButton packageRFID2;
	
	
	/*
	 *多功能清洗消毒 
	 */
	private JButton multiCleanMachine;
	private JButton multiCleanRFID1;
	private JButton multiCleanRFID2;
	
/*
 * 分拣工作台
 */
	private JButton sortingMachine;
	private JButton sortingRFID1;
	private JButton sortingRFID2;
	
	/*
	 * 无菌储藏
	 */
	private JButton storageMachine;
	private JButton storageRFID1;
	private JButton storageRFID2;
	
	private JPanel jp1,jp2,jp3,jp4,jp5;
	public SelectorUI(){
		cleanMachine=new JButton("大型清洗消毒器");
		packageMachine=new JButton("打包台");
		multiCleanMachine=new JButton("多功能清洗中心");
		sortingMachine=new JButton("分拣工作台");
		storageMachine=new JButton("无菌储藏");
		
		cleanRFID1=new JButton("2024");
		cleanRFID2=new JButton("2025");
		packageRFID1=new JButton("3024");
		packageRFID2=new JButton("3025");
		multiCleanRFID1=new JButton("4024");
		multiCleanRFID2=new JButton("4025");
		sortingRFID1=new JButton("1024");
		sortingRFID2=new JButton("1025");
		storageRFID1=new JButton("5024");
		storageRFID2=new JButton("5025");
		
		cleanMachine.addActionListener(this);
		cleanRFID1.addActionListener(this);
		cleanRFID2.addActionListener(this);
		packageMachine.addActionListener(this);
		packageRFID1.addActionListener(this);
		packageRFID2.addActionListener(this);
		multiCleanMachine.addActionListener(this);
	    multiCleanRFID1.addActionListener(this);
	    multiCleanRFID2.addActionListener(this);
	    sortingMachine.addActionListener(this);
	    sortingRFID1.addActionListener(this);
	    sortingRFID2.addActionListener(this);
	    storageMachine.addActionListener(this);
	    storageRFID1.addActionListener(this);
	    storageRFID2.addActionListener(this);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		
		this.setLayout(new GridLayout(3,2));
		
		jp1.add(cleanMachine);
		jp1.add(cleanRFID1);
		jp1.add(cleanRFID2);
		jp2.add(packageMachine);
		jp2.add(packageRFID1);
		jp2.add(packageRFID2);
		jp3.add(multiCleanMachine);
		jp3.add(multiCleanRFID1);
		jp3.add(multiCleanRFID2);
		jp4.add(sortingMachine);
		jp4.add(sortingRFID1);
		jp4.add(sortingRFID2);
		jp5.add(storageMachine);
		jp5.add(storageRFID1);
		jp5.add(storageRFID2);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);
		this.setTitle("工段设置");
		this.setBounds(400,170,600,700);
		this.setSize(600,700);
		
		
	}
	public void showUp(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String args[]){
		SelectorUI ui=new SelectorUI();
		ui.showUp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cleanMachine){
			// processInfoExecutor.setProcessName(Constant.processName[0]);
		}
		if(e.getSource()==cleanRFID1){
		  //  processInfoExecutor.setProcessName(Constant.processName[0]);
		    machineInfoExecutor.setEquipmentId(2024);
		}
		if(e.getSource()==cleanRFID2){
			// processInfoExecutor.setProcessName(Constant.processName[0]);
			 machineInfoExecutor.setEquipmentId(2025);
		}
		if(e.getSource()==packageMachine){
			// processInfoExecutor.setProcessName(Constant.processName[1]);
		}
		if(e.getSource()==packageRFID1){
			// processInfoExecutor.setProcessName(Constant.processName[1]);
			 machineInfoExecutor.setEquipmentId(3024);
		}
		if(e.getSource()==packageRFID2){
			// processInfoExecutor.setProcessName(Constant.processName[1]);
			 machineInfoExecutor.setEquipmentId(3025);
		}
		if(e.getSource()==multiCleanMachine){
			 //processInfoExecutor.setProcessName(Constant.processName[2]);
		}
		if(e.getSource()==multiCleanRFID1){
			// processInfoExecutor.setProcessName(Constant.processName[2]);
			 machineInfoExecutor.setEquipmentId(4024);
		}
		if(e.getSource()==multiCleanRFID2){
			// processInfoExecutor.setProcessName(Constant.processName[2]);
			 machineInfoExecutor.setEquipmentId(4025);
		}
		if(e.getSource()==sortingMachine){
			// processInfoExecutor.setProcessName(Constant.processName[3]);
		}
		if(e.getSource()==sortingRFID1){
			 //processInfoExecutor.setProcessName(Constant.processName[3]);
			 machineInfoExecutor.setEquipmentId(1024);
		}
		if(e.getSource()==sortingRFID2){
			// processInfoExecutor.setProcessName(Constant.processName[3]);
			 machineInfoExecutor.setEquipmentId(1025);
		}
		if(e.getSource()==storageMachine){
			 //processInfoExecutor.setProcessName(Constant.processName[4]);
		}
		if(e.getSource()==storageRFID1){
			 //processInfoExecutor.setProcessName(Constant.processName[4]);
			 machineInfoExecutor.setEquipmentId(5024);
		}
		if(e.getSource()==storageRFID2){
			// processInfoExecutor.setProcessName(Constant.processName[4]);
			 machineInfoExecutor.setEquipmentId(5025);
		}
		this.setVisible(false);
	    machineInfoExecutor.query(1);
		login.showUp();
	}
	public ProcessInfoExecutor getProcessInfoExecutor() {
		return processInfoExecutor;
	}
	public void setProcessInfoExecutor(ProcessInfoExecutor processInfoExecutor) {
		this.processInfoExecutor = processInfoExecutor;
	}
	public MachineInfoExecutor getMachineInfoExecutor() {
		return machineInfoExecutor;
	}
	public void setMachineInfoExecutor(MachineInfoExecutor machineInfoExecutor) {
		this.machineInfoExecutor = machineInfoExecutor;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}	
	
}
