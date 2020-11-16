package management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Cancelation extends JFrame{
	 private JLabel heading,l1,l2,l3,l4,l5,imgLabel;
	 private JTextField t1,t2,t3,t4,t5;
	 private JButton b,b1;
	 private ImageIcon img;
	 private Container c;
	 private Font f,h;
	 
	 Cancelation(){
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
			this.setBounds(270,75,780,550);
			this.setTitle("Add Customer");
			c = this.getContentPane();
			c.setLayout(null);
			f = new Font("Arial",Font.BOLD,16);
			h = new Font("Arial",Font.BOLD,22);
			
//			img = new ImageIcon(getClass().getResource("Cancel.png"));
			 ImageIcon img  = new ImageIcon(ClassLoader.getSystemResource("Cancel.png"));
			
			
			imgLabel = new JLabel(img);
		    imgLabel.setBounds(400,50,img.getIconWidth(),400);
		    c.add(imgLabel);
			
		    heading = new JLabel(" Cancellation Form");
			heading.setBounds(260,10,300,50);
			heading.setForeground(Color.blue);
			heading.setFont(h);
			c.add(heading);
		    
			l1 = new JLabel("PNR No:");
			l1.setBounds(25,72,200,50);
			l1.setFont(f);
			c.add(l1);
			
			l2 = new JLabel("Flight Code:");
			l2.setBounds(50,122,200,50);
			l2.setFont(f);
			c.add(l2);
			
			l3 = new JLabel("Name:");
			l3.setBounds(50,172,200,50);
			l3.setFont(f);
			c.add(l3);
			
			l4 = new JLabel("Contact No:");
			l4.setBounds(50,232,100,50);
			l4.setFont(f);
			c.add(l4);
			
			l5 = new JLabel("Cancellation Date:");
			l5.setBounds(25,282,150,50);
			l5.setFont(f);
			c.add(l5);
			
			 
			t1 = new  JTextField();
			t1.setBounds(105,73,150,42);
			t1.setFont(f);
			c.add(t1);
			
			t2 = new  JTextField();
			t2.setBounds(170,122,200,42);
			t2.setFont(f);
			c.add(t2);
			
			t3 = new  JTextField();
			t3.setBounds(170,172,200,42);
			t3.setFont(f);
			c.add(t3);
			
			t4 = new  JTextField();
			t4.setBounds(170,232,200,42);
			t4.setFont(f);
			c.add(t4);
			
			t5 = new  JTextField();
			t5.setBounds(170,282,200,42);
			t5.setFont(f);
			c.add(t5);
			
			b = new JButton("Submit");
			b.setBounds(200,350,130,40);
			b.setForeground(Color.red);
			c.add(b);
			

			b1 = new JButton("Confirm");
			b1.setBounds(270,73,80,40);
			b1.setForeground(Color.blue);
			c.add(b1);
			
			b1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String o=t1.getText();
				
				try {
					
					Conn a=new Conn();
					
		             String s = "Select Flight_Code from pay where PNR_No='"+o+"'";
		             ResultSet rs = a.s.executeQuery(s);	
		         	 rs.next();
		           t2.setText(rs.getString("Flight_Code"));
				}  catch(Exception f){
					f.printStackTrace();
				}
			}
			});
			  b.addActionListener(new ActionListener() {
		  			public void actionPerformed(ActionEvent e) {
		  			  String F = t1.getText();
	                    String g = t2.getText();
	                    String h =  t3.getText();
	                    String i = t4.getText();
	                    String j = t5.getText();
		  				try {
		  					
		  					Conn c1=new Conn();
		  					
		  					String str="Insert into Cancel values('"+F+"', '"+g+"', '"+h+"','"+i+"','"+j+"')";
		  							

	                        c1.s.executeUpdate(str);
	                        JOptionPane.showMessageDialog(null,"Cancellaton request has been sent");
	                        setVisible(false);
		  				
		  			}  catch(Exception ae){
		  				ae.fillInStackTrace();
		  			}
		  		 }
		  		});
		  	    
				
		}
	 
 public static void main(String args[]){
	 Cancelation c = new Cancelation();
	 c.setVisible(true);
}
 }