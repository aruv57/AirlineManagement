package management;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Journey_D extends JFrame{
	 private JLabel l,l1,l2;
	 private JButton b;
	 private JTable table;
	 private JComboBox src,dst;
	 private String[] Source = {"Bombay","Kolkata","Delhi","Bangalore"};
	 private String[] Destination = {"Bangalore","Bombay","Kolkata","Delhi",};
	 private Container c;
	 private Font f,h;
		
	Journey_D(){
		super("Flight Details");
	this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
	this.setBounds(350,175,600,450);
	c = this.getContentPane();
	c.setLayout(null);
	h = new Font("Arial",Font.BOLD,25);
	f = new Font("Arial",Font.BOLD,16);
	  l = new JLabel("Search Flight Here");
	  l.setBounds(175,40,300,30);
	  l.setFont(h);
	  c.add(l);
	
	  l1 = new JLabel("Source:");
	  l1.setBounds(27,100,300,50);
	  l1.setForeground(Color.blue);
	  l1.setFont(f);
	  c.add(l1);
		
      l2 = new JLabel("Destination:");
	  l2.setBounds(225,100,300,50);
	  l2.setForeground(Color.blue);
	  l2.setFont(f);
	  c.add(l2);
	
	src = new JComboBox(Source);
	src.setBounds(95,100,100,50);
	src.setEditable(true);
	c.add(src);
	
	dst = new JComboBox(Destination);
	dst.setBounds(325,100,100,50);
	dst.setEditable(true);
	c.add(dst);
	

    table = new JTable();
    table.setBackground(Color.WHITE);
    table.setBounds(12, 170, 56, 200);
    add(table);
    
    JScrollPane p = new JScrollPane(table);
    p.setBounds(12, 170, 560, 200);
    p.setBackground(Color.WHITE);
    c.add(p);
	
	b = new JButton("View");
	b.setBounds(445,100,80,50);
	c.add(b);
	
	
	b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
         
		try{
                  
		   	String srce  =  (String) src.getSelectedItem();
            String dsti  =  (String) dst.getSelectedItem();
            
                    Conn c = new Conn();
                    
                    String str = "select * from flight_list where Src='"+srce+"' AND dst='"+dsti+"'";
                    ResultSet rs=c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    					
                    
					
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"No Flight Available "+e);
		}
            }
	});
}
	public static void main(String args[]) {
		Journey_D f = new Journey_D();
		f.setVisible(true);
	}
}