package management;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Flight extends JFrame{  //Second Frame

  
    private JLabel label,Heading;
    private JTextField textField;
    private JButton b;
    private JScrollPane p;
    private Container c;
    private Font f,h;
    private JTable table;

    
    Flight(){
    	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
    	this.setBounds(325,150,665,450);
    	this.setTitle("Flight Info");
    	c = this.getContentPane();
    	c.setLayout(null);
    	f = new Font("Arial",Font.BOLD,16);
    	h = new Font("Arial",Font.BOLD,20);
    	
    	Heading = new JLabel("Get Info About Flight:");
    	Heading.setBounds(200,10,300,50);
    	Heading.setFont(h);
    	c.add(Heading);   	
    	   
    	label = new JLabel("Flight Code:");
    	label.setBounds(75,75,100,50);
    	label.setFont(f);
    	c.add(label);
    	
    	textField = new JTextField();
    	textField.setBounds(185,75,220,50);
    	textField.setFont(f);
    	c.add(textField);
    
    	b = new JButton("View");
    	b.setBounds(415,77,80,45);
    	b.setFont(f);
    	c.add(b);
    	

        table = new JTable();
        table.setBackground(Color.WHITE);
	    table.setBounds(23, 150, 600, 200);
        
        JScrollPane p = new JScrollPane(table);
	    p.setBounds(23, 150, 600, 200);
        p.setBackground(Color.WHITE);
         add(p);
	
    
    	 b.addActionListener(new ActionListener() {
   			public void actionPerformed(ActionEvent e) {
                String code = textField.getText();
   				try {
   					
   					Conn c1=new Conn();
   					
   					String str="SELECT * from flight_list where Flight_Code='"+code+"'; ";
   					ResultSet rs=c1.s.executeQuery(str);
   				    table.setModel(DbUtils.resultSetToTableModel(rs));
   				   //a.setVisible(true);
   			}  catch(Exception ae){
   				ae.fillInStackTrace();
   			}
   		 }
   		});
   	    
    }
    public static void main(String[] args){		
    	Flight a = new Flight();
    	a.setVisible(true);
    }
}