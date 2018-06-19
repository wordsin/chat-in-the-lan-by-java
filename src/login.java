import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class loginui extends JFrame implements ActionListener{
	JPanel contentPane;
    JLabel label_user = new JLabel("user:");
    JTextField user=new JTextField();
    JLabel label_password = new JLabel("password:");
    JPasswordField password=new JPasswordField();
    JLabel label_title=new JLabel("登陆界面",JLabel.CENTER);
    JLabel label_tips=new JLabel("", JLabel.CENTER);
    JButton submit=new JButton("提交");
    public loginui() {
    	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
			| UnsupportedLookAndFeelException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	
    	contentPane=(JPanel)this.getContentPane();
    	contentPane.setLayout(null);
    	label_tips.setText("数据库的用户名和密码");
    	
    	label_title.setBounds(160,10,80,20);
    	label_user.setBounds(140, 50, 60, 20);
    	user.setBounds(200, 50, 80, 20);
    	label_password.setBounds(140, 80, 60, 20);
    	password.setBounds(200, 80, 80, 20);
    	label_tips.setBounds(125,120,150,20);
    	submit.setBounds(160, 160, 80, 20);
    	contentPane.add(label_title,null);
    	contentPane.add(label_user,null);
    	contentPane.add(user,null);
    	contentPane.add(label_password,null);
    	contentPane.add(password,null);
    	contentPane.add(label_tips,null);
    	contentPane.add(submit,null);
    	submit.addActionListener(this);
    	this.setSize(400, 300);
    	this.setLocation(600, 300);
    	//this.getContentPane().add(contentPane);
    }
    public String getuser() {
    	return user.getText();
    }
    public String getpassword() {
    	return password.getText();
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		String str=arg0.getActionCommand();
		if(str.equals(submit.getText())) {
			String notice="you push the submit button\n";
			if(user.getText().isEmpty())
				notice+="you didn't input the user line!\n";
			if(password.getText().isEmpty())
				notice+="you didn't input the password line!\n";
			if(!user.getText().isEmpty()&&!password.getText().isEmpty()) {
				this.dispose();
				groupchatui ui=new groupchatui(user.getText(),password.getText());
				ui.setVisible(true);
				ui.setDefaultCloseOperation(ui.EXIT_ON_CLOSE);
			}
			else
				JOptionPane.showMessageDialog(null, notice);
		}
	}
}
//public class login {
//
//	public static void main(String[] args) {
//		// TODO 自动生成的方法存根
//		loginui pane=new loginui();
//		pane.setVisible(true);
//	}
//
//}
