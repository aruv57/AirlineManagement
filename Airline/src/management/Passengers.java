package management;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class Passengers extends JFrame{
	 private JLabel l1;
	 private JButton bg,bg1;
	 private Container c;
	 private Font f,h;
	 private JTable table;

	 Passengers(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
		this.setBounds(314,120,700,500);
		this.setTitle("Add Customer");
		c = this.getContentPane();
		c.setLayout(null);
		h = new Font("Arial",Font.BOLD,20);
		f = new Font("Arial",Font.BOLD,16);
		
		l1 = new JLabel("All Passengers list");
    	l1.setBounds(260,25,200,50);
    	l1.setFont(h);
    	c.add(l1);
		
		bg = new JButton("Show");
    	bg.setBounds(265,380,80,50);
    	bg.setFont(f);
    	c.add(bg);
    	
    	
		bg1 = new JButton("Back");
    	bg1.setBounds(365,380,80,50);
    	bg1.setFont(f);
    	c.add(bg1);
    	
        table = new JTable();
        table.setBackground(Color.WHITE);
	    table.setBounds(35, 80, 610, 280);
        
        JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(35, 80, 610, 280);
        pane.setBackground(Color.WHITE);
        add(pane);
	
        bg1.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				try {
  					dispose();
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});

    	  bg.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				try {
  					
  					Conn k=new Conn();
  					String str="select  Name,Gender,Phone,Address,T_Date from add_customer,pay where add_customer.PNR_No=pay.PNR_No ";
  					
//String str="select Name,Gender,Passport_No,Phone,Address,T_Date,F_Name,Src,dst  FROM add_customer JOIN pay add_customer.PNR_No=pay.PNR_No JOIN flight_list ON add_customer.Flight_Code=flight_list.Flight_Code"; 
  							
  							
  							
  					ResultSet rs=k.s.executeQuery(str);
  					table.setModel(DbUtils.resultSetToTableModel(rs));
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
  	    
		
}
public static void main(String args[]) {
	Passengers a = new Passengers();
	a.setVisible(true);	
}
}