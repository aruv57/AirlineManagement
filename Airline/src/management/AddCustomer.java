package management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class AddCustomer extends JFrame{
 private JLabel heading,l1,l2,l3,l4,l5,l6,l7,l8,imgLabel;
 private JTextField t1,t2,t3,t4,t6,t7,t8;
 private JCheckBox Male,Female;
 private ButtonGroup bg;
 private ImageIcon img1;
 private JButton b;
 private Container c;
 private Font f,h;
 private String p;

AddCustomer()
{	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
	this.setBounds(300,85,700,550);
	this.setTitle("Add Customer");
	c = this.getContentPane();
	c.setLayout(null);
	f = new Font("Arial",Font.BOLD,16);
	h = new Font("Arial",Font.BOLD,20);
	
	Genarate s=new Genarate();
	p=s.generateOTP(5);
	
//	img1 = new ImageIcon(getClass().getResource("download.png"));
    ImageIcon img1  = new ImageIcon(ClassLoader.getSystemResource("download.png"));
	
	imgLabel = new JLabel(img1);
    imgLabel.setBounds(420,50,img1.getIconWidth(),400);
    c.add(imgLabel);

    heading = new JLabel(" Fill Customer Details");
	heading.setBounds(420,75,300,50);
	heading.setForeground(Color.blue);
	heading.setFont(h);
	c.add(heading);
    
	l1 = new JLabel("Flight Code:");
	l1.setBounds(50,50,100,50);
	l1.setFont(f);
	c.add(l1);
	
	l2 = new JLabel("Passport No:");
	l2.setBounds(50,100,150,50);
	l2.setFont(f);
	c.add(l2);
	
	l3 = new JLabel("PNR No:");
	l3.setBounds(50,150,100,50);
	l3.setFont(f);
	c.add(l3);
	
	l4 = new JLabel("Name:");
	l4.setBounds(50,200,100,42);
	l4.setFont(f);
	c.add(l4);
	
	l5 = new JLabel("Gender:");
	l5.setBounds(50,250,100,42);
	l5.setFont(f);
	c.add(l5);
	
	l6 = new JLabel("Nationality:");
	l6.setBounds(50,300,100,42);
	l6.setFont(f);
	c.add(l6);
	
	l7 = new JLabel("Address:");
	l7.setBounds(50,350,100,42);
	l7.setFont(f);
	c.add(l7);
	
	l8 = new JLabel("Phone No:");
	l8.setBounds(50,400,100,42);
	l8.setFont(f);
	c.add(l8);
	
	t1 = new JTextField();
	t1.setFont(f);
	t1.setBounds(170,50,200,42);
	c.add(t1);
	
	t2 = new JTextField();
	t2.setFont(f);
	t2.setBounds(170,100,200,42);
	c.add(t2);
	

	
	t3 = new JTextField("AIRIND"+p);
	t3.setFont(f);
	t3.setBounds(170,150,200,42);
	
	c.add(t3);
	
	t4 = new JTextField();
	t4.setFont(f);
	t4.setBounds(170,200,200,42);
	c.add(t4);
	

    Male = new JCheckBox("Male",true );
    Male.setBounds(170,250,100,30);
    Male.setFont(f);
    c.add(Male);
	 
    Female = new JCheckBox("Female");
    Female.setBounds(270,250,100,30);
    Female.setFont(f);
    c.add(Female);
    
    bg = new ButtonGroup();
    bg.add(Male);
    bg.add(Female);
	 
	t6 = new JTextField();
	t6.setFont(f);
	t6.setBounds(170,300,200,42);
	c.add(t6);
	
	t7 = new JTextField();
	t7.setFont(f);
	t7.setBounds(170,350,200,42);
	c.add(t7);
	
	t8 = new JTextField();
	t8.setFont(f);
	t8.setBounds(170,400,200,42);
	c.add(t8);
	
	b = new JButton("Register");
	b.setBounds(470,380,130,40);
	b.setForeground(Color.blue);
	c.add(b);
	
	b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
	                    String F_Code = t1.getText();
	                    String Passport_NO = t2.getText();
	                    String PNR =  t3.getText();
	                    String Name =t4.getText();
	                    String Nationality = t6.getText();
	                    String Adress = t7.getText();
	                    String ph_no = t8.getText();
	                    String gender = null;
	                    
	                    
	                    if(Male.isSelected()){
	                        gender = "Male";
	                    
	                    }else if(Female.isSelected()){
	                        gender = "Female";
	                    }
            
            
	                    try {
	                        Conn c = new Conn();
	                        String str = "INSERT INTO add_customer values( '"+F_Code+"', '"+Passport_NO+"', '"+PNR+"','"+Name+"',"
	                        		+ " '"+gender+"', '"+Nationality+"','"+Adress+"', '"+ph_no+"')";
	                        
	                        c.s.executeUpdate(str);
	                        JOptionPane.showMessageDialog(null,"Customer Added");
	                        setVisible(false);
	                    }
	                        catch (Exception o) {
	                        o.printStackTrace();
	        	    }
			}
	            });
}
 
 
 
 
 
 public static void main(String args[]) {
	 AddCustomer a = new AddCustomer();
	 a.setVisible(true);
  }
}

