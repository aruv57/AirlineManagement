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

public class SignUp_CList extends JFrame{
	 private JLabel l1;
	 private JButton bg,bg1;
	 private Container c;
	 private Font f,h;
	 private JTable table;

	 SignUp_CList(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
		this.setBounds(300,70,800,600);
		this.setTitle("Add Customer");
		c = this.getContentPane();
		c.setLayout(null);
		h = new Font("Arial",Font.BOLD,20);
		f = new Font("Arial",Font.BOLD,16);
		
		l1 = new JLabel("SighnedUp Customers");
    	l1.setBounds(290,35,300,50);
    	l1.setFont(h);
    	c.add(l1);
		
		bg = new JButton("Show");
    	bg.setBounds(310,415,80,50);
    	bg.setFont(f);
    	c.add(bg);
    	
    	bg1 = new JButton("Back");
    	bg1.setBounds(400,415,80,50);
    	bg1.setFont(f);
    	c.add(bg1);
    	
    	
        table = new JTable();
        table.setBackground(Color.WHITE);
	    table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(23, 100, 740, 300);
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
  					
  					String str="SELECT * FROM add_customer";
  					ResultSet rs=c1.s.executeQuery(str);
  					table.setModel(DbUtils.resultSetToTableModel(rs));
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
  	    
		
}
public static void main(String args[]) {
	SignUp_CList a = new SignUp_CList();
	a.setVisible(true);	
}
}