//package com.runoob.test;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class delusr extends JFrame implements ActionListener{

	JPanel contentpane;
	JLabel label_ip=new JLabel("主机ip:");
	//JLabel label_port=new JLabel("接收端口:");
	//JLabel label_name=new JLabel("昵称:");

	JTextField ip=new JTextField();
	//JTextField port=new JTextField();
	//JTextField name=new JTextField();
	
	String Ip;
	//String Name;
	//int Port;
	
    JButton submit=new JButton("删除");
    mysqlmanager mm;
	public delusr(String user,String password) {
		this.setVisible(true);
		//this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    	contentpane=(JPanel) this.getContentPane();
    	contentpane.setLayout(null);
    	this.setSize(400, 300);
    	this.setLocation(600, 300);
    	
    	label_ip.setBounds(100,20,100,20);
    	contentpane.add(label_ip,null);

    	ip.setBounds(200,20,100,20);
    	contentpane.add(ip,null);
    	
//    	label_port.setBounds(100,85,100,20);
//    	contentpane.add(label_port,null);
//
//    	port.setBounds(200,85,100,20);
//    	contentpane.add(port,null);
//    	
//    	label_name.setBounds(100,150,100,20);
//    	contentpane.add(label_name,null);
//
//    	name.setBounds(200,150,100,20);
//    	contentpane.add(name,null);
    	
    	ip.setBounds(200,20,100,20);
    	
    	submit.setBounds(150,215,100,20);
    	contentpane.add(submit,null);
    	submit.addActionListener(this);
    	
    	mm=new mysqlmanager(user,password);
    	mm.linkdb();
    	
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		if(arg0.getActionCommand().equals(submit.getText())) {
			Ip=ip.getText();
//			Port=Integer.parseInt(port.getText());
//			Name=name.getText();
			if(Ip.length()==0)
    			JOptionPane.showMessageDialog(null, "信息不完整");
			else {
				String mysql="Delete From chatusr Where ip='"+Ip+"'";
    			if(mm.del(mysql)) {
    				JOptionPane.showMessageDialog(null, "删除成功");
    			}
    			this.dispose();;
			}
		}
	}
}
