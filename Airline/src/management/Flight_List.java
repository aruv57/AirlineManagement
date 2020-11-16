
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

public class Flight_List extends JFrame{
	 private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	 private JButton bg,bg1;
	 private Container c;
	 private Font f,h;
	 private JTable table;

	 Flight_List(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
		this.setBounds(285,70,750,580);
		this.setTitle("Add Customer");
		c = this.getContentPane();
		c.setLayout(null);
		h = new Font("Arial",Font.BOLD,20);
		f = new Font("Arial",Font.BOLD,16);
		
		l1 = new JLabel("All Flight list");
    	l1.setBounds(290,35,200,50);
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
	    table.setBounds(17, 100, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(17, 100, 700, 300);
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
  					
  					String str="SELECT * FROM flight_list";
  					ResultSet rs=c1.s.executeQuery(str);
  					table.setModel(DbUtils.resultSetToTableModel(rs));
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
  	    
		
}
public static void main(String args[]) {
	Flight_List a = new Flight_List();
	a.setVisible(true);	
}
}