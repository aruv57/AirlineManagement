package management;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class Login extends JFrame{
	
			private JLabel userLabel,passLabel,imglabel;
			private JTextField tf;
			private JPasswordField pf;
			private ImageIcon img1;
			private JButton loginButton,clearButton,exitButton;
			private Container c;
			private Font f;
			Login(){
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
				this.setBounds(320,80,660,580);
				this.setTitle("Login Demo");
				c = this.getContentPane();
				c.setLayout(null);
				
				f = new Font("Arial",Font.BOLD,16);
				
				
				img1 = new ImageIcon(getClass().getResource("images.png"));
				
				imglabel = new JLabel(img1);
				imglabel.setBounds(200,0,img1.getIconWidth(),250);
			    c.add(imglabel);
				
				userLabel = new JLabel("Username:");
				userLabel.setBounds(115,260,150,50);
				userLabel.setFont(f);
				c.add(userLabel);
				
				tf = new JTextField();
				tf.setFont(f);
				tf.setBounds(215,260,200,50);
				c.add(tf);
				
				passLabel = new JLabel("Password:");
				passLabel.setBounds(115,325,150,50);
				passLabel.setFont(f);
				c.add(passLabel);
				
				pf = new JPasswordField();
				pf.setFont(f);
				pf.setBounds(215,325,200,50);
				c.add(pf);
				
				
				loginButton = new JButton("Login");
				loginButton.setBounds(140,400,90,50);	
				loginButton.setFont(f);
				c.add(loginButton);
				
				clearButton = new JButton("Clear");
				clearButton.setBounds(255,400,100,50);	
				clearButton.setFont(f);
				c.add(clearButton);
				
				exitButton = new JButton("Exit");
				exitButton.setBounds(375,400,100,50);	
				exitButton.setFont(f);
				c.add(exitButton);
				
				loginButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
					try {	
						String userName = tf.getText();
						String password = pf.getText();
						
						Conn c1 = new Conn();
						
						String str="Select * from lgin where Name='"+userName+"' and Pasword='"+password+"'";
						ResultSet rs=c1.s.executeQuery(str);
						 if(rs.next()){
						JOptionPane.showMessageDialog(null,"You have succsessfully loged in");
					    dispose();
				     	 MainFrame  f = new MainFrame();
					     f.setVisible(true);
						 }
						 else {
							 JOptionPane.showMessageDialog(null,"Invalid login");}
					}catch(Exception e1){
							JOptionPane.showMessageDialog(null,e1);
						}
					}
				
				});
				clearButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						tf.setText("");
						pf.setText("");
						
					}
				
				});
				exitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
				
				});
			}
			public static void main(String args[]) {
			Login frame = new Login();
			frame.setVisible(true);
		}
}

