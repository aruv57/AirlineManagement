package management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Reservetion extends JFrame{
 private JLabel heading,l1,l2,tdl,l3,l4,l5;
 private JTextField t1,t2,Tdt,t3,t4;
 private JCheckBox Male,Female;
 private ButtonGroup bg;
 private JRadioButton Cash,Card;
 private ButtonGroup grp;
 private JButton b1,b2;
 private Container c;
 private Font f,h;
 private String p;

Reservetion()
{	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
	this.setBounds(100,50,1200,650);
	this.setTitle("Add Customer");
	c = this.getContentPane();
	c.setLayout(null);
	f = new Font("Arial",Font.BOLD,16);
	h = new Font("Arial",Font.BOLD,20);
	

	
	
    heading = new JLabel(" Payment Section");
	heading.setBounds(550,5,300,50);
	heading.setForeground(Color.blue);
	heading.setFont(h);
	c.add(heading);
   
	
	l1 = new JLabel("PNR No:");
	l1.setBounds(450,100,100,50);
	l1.setFont(f);
	c.add(l1);
	
	l2 = new JLabel("Flight Code:");
	l2.setBounds(450,150,100,42);
	l2.setFont(f);
	c.add(l2);
	
	tdl = new JLabel("Travel Date:");
	tdl.setBounds(450,200,100,42);
	tdl.setFont(f);
	c.add(tdl);
	
	l3 = new JLabel("Payment mode:");
	l3.setBounds(450,250,200,42);
	l3.setFont(f);
	c.add(l3);
	
	l4 = new JLabel("Time:");
	l4.setBounds(495,300,200,42);
	l4.setFont(f);
	c.add(l4);
	
	l5 = new JLabel("Date:");
	l5.setBounds(495,350,100,42);
	l5.setFont(f);
	c.add(l5);
		
	
	t1 = new JTextField();
	t1.setFont(f);
	t1.setBounds(575,100,200,42);
	c.add(t1);
	
	t2 = new JTextField();
	t2.setFont(f);
	t2.setBounds(575,150,200,42);
	c.add(t2);
	
	Tdt = new JTextField();
	Tdt.setFont(f);
	Tdt.setBounds(575,200,100,42);
	c.add(Tdt);
	
	Cash = new JRadioButton("Cash");
	Cash.setBounds(575,250,70,50);
	Cash.setSelected(true);
	Cash.setFont(f);
	c.add(Cash);
	
	Card = new JRadioButton("Card");
	Card.setBounds(650,250,70,50);
	Card.setFont(f);
	c.add(Card);
	
	
	t3 = new JTextField();
	t3.setFont(f);
	t3.setBounds(575,300,100,42);
	c.add(t3);	


	t4 = new JTextField();
	t4.setFont(f);
	t4.setBounds(575,350,100,42);
	c.add(t4);	
	
	grp = new ButtonGroup();
	grp.add(Cash);
	grp.add(Card);
	
	b2 = new JButton("Book");
	b2.setBounds(500,420,130,40);
	b2.setForeground(Color.blue);
	c.add(b2);
	
	b1 = new JButton("Confirm");
	b1.setBounds(780,100,100,40);
	b1.setForeground(Color.blue);
	c.add(b1);
	
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String o=t1.getText();
		
		try {
			
			Conn a=new Conn();
			
             String s = "Select Flight_Code from add_customer where PNR_No='"+o+"'";
             ResultSet rs = a.s.executeQuery(s);	
         	 rs.next();
           t2.setText(rs.getString("Flight_Code"));
		}  catch(Exception f){
			f.printStackTrace();
		}
	}
	});

          	
	b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            String Pnr = t1.getText();
            String fcd = t2.getText();
            String td = Tdt.getText();
            String t = t3.getText();
            String d = t4.getText();
            String methd = null;
	                    
	                    
	                    if(Cash.isSelected()){
	                        methd = "Cash";
	                        
	                    
	                    }else if(Card.isSelected()){
	                        methd = "Card";
	                    }
				try {
					
					Conn a=new Conn();
					
					String str="INSERT INTO pay values( '"+Pnr+"', '"+fcd+"','"+td+"','"+methd+"','"+t+"','"+d+"')";
					a.s.executeUpdate(str);
				    JOptionPane.showMessageDialog(null,"Ticket Booked");
                    setVisible(false);
			}  catch(Exception f){
				f.printStackTrace();
			}
			}
		});
 
}
 public static void main(String args[]) {
	 Reservetion a = new Reservetion();
	 a.setVisible(true);
  }
}
