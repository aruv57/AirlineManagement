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

public class 	Cancellation_list extends JFrame{
	 private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	 private JButton bg,bg1;
	 private Container c;
	 private Font f,h;
	 private JTable table;

		Cancellation_list(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
		this.setBounds(250,70,750,580);
		this.setTitle("Add Customer");
		c = this.getContentPane();
		c.setLayout(null);
		h = new Font("Arial",Font.BOLD,20);
		f = new Font("Arial",Font.BOLD,16);
		
		l1 = new JLabel("All Cancellation Requests");
    	l1.setBounds(250,35,500,50);
    	l1.setFont(h);
    	c.add(l1);
		
		bg = new JButton("Show");
    	bg.setBounds(265,420,80,50);
    	bg.setFont(f);
    	c.add(bg);
    	
    	bg1 = new JButton("Back");
    	bg1.setBounds(365,420,80,50);
    	bg1.setFont(f);
    	c.add(bg1);
    	
        table = new JTable();
        table.setBackground(Color.WHITE);
	    table.setBounds(23, 100, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(15, 100, 700, 300);
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
  					
  					Conn c1=new Conn();
  					
  					String str="SELECT * FROM cancel";
  					ResultSet rs=c1.s.executeQuery(str);
  					table.setModel(DbUtils.resultSetToTableModel(rs));
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
  	    
		
}
public static void main(String args[]) {
	Cancellation_list a = new 	Cancellation_list();
	a.setVisible(true);	
}
}