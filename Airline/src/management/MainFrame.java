
package management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class MainFrame extends JFrame{
	private JLabel Label,imgLabel;
	private ImageIcon img;
    private Container c;
    private JMenuBar AirlineSystem;
	private Font f;
	
	MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(315,130,750,480);
        this.setTitle("Air Management");	
        f = new Font("Tahoma",Font.BOLD,30);
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.LIGHT_GRAY);
		
		img = new ImageIcon(getClass().getResource("Plane.jpg"));
		
		imgLabel = new JLabel(img);
	    imgLabel.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	    c.add(imgLabel);
		
	    JLabel NewLabel = new JLabel("WeLcome to Air Management System");
	    NewLabel.setBounds(60,15,600,200);
	    NewLabel.setForeground(Color.white);
	    NewLabel.setFont(f);
	    add(NewLabel);//adding label on image
	    imgLabel.add(NewLabel);
	    
	   
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    //First Menu
	    JMenu AirlineSystem = new JMenu("AirLine System");
	    AirlineSystem.setForeground(Color.red);
	    menuBar.add(AirlineSystem);
	    
	    JMenuItem Flight_Info = new JMenuItem("Flight_Info");
	    Flight_Info.setForeground(Color.blue);
	    AirlineSystem.add(Flight_Info);

	    JMenuItem Add_Customerdetails = new JMenuItem("Add Customerdetails");
	    Add_Customerdetails.setForeground(Color.blue);
	    AirlineSystem.add(Add_Customerdetails);

	    JMenuItem JourneyD = new JMenuItem("Journey details");
	    JourneyD.setForeground(Color.blue);
	    AirlineSystem.add(JourneyD);
	    

	    JMenuItem paymentD = new JMenuItem("Payment Detials");
	    paymentD.setForeground(Color.blue);
	    AirlineSystem.add( paymentD);
	    
	    //Second menu
	      
	    JMenu List = new JMenu("List");
	    List.setForeground(Color.blue);
	    menuBar.add(List);

	    JMenuItem Plane = new JMenuItem("Plane list");
	    Plane.setForeground(Color.blue);
	    List.add(Plane);
	    
	    JMenuItem Cnsl_L = new JMenuItem("Cancellation list");
	    Cnsl_L.setForeground(Color.blue);
	    List.add(Cnsl_L);
	    
	    JMenuItem Awt = new JMenuItem("SignUP list");
	    Awt.setForeground(Color.blue);
	    List.add(Awt);
	    
	    JMenuItem TicketDn = new JMenuItem("Passenger List");
	    TicketDn.setForeground(Color.blue);
	    List.add(TicketDn);
	    
	    
	    //third
	    JMenu Ticket_P = new JMenu("Ticket");
	    Ticket_P.setForeground(Color.blue);
	    menuBar.add(Ticket_P);	    
	    
	    JMenuItem Ticket_C = new JMenuItem("Reservetion");
	    Ticket_C.setForeground(Color.blue);
	    Ticket_P.add(Ticket_C);
	    
	    JMenuItem Cancellation = new JMenuItem("Cancellation");
	    Cancellation.setForeground(Color.blue);
	    Ticket_P.add(Cancellation);
	    
	    //first Menu Action
	    
	    Flight_Info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Flight a =  new Flight();					
					a.setVisible(true);
			}  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
	    Add_Customerdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddCustomer a =  new AddCustomer();	
					a.setVisible(true);
			}  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});  
	    JourneyD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				   
		    Journey_D f= new Journey_D();	
		    f.setVisible(true);
			}    	
	    });
	    paymentD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					PaymentDetails a = new PaymentDetails();					
			 	    a.setVisible(true);
			}  catch(Exception a){
				a.fillInStackTrace();
			}
		 }
		});
	  
	    //second menu Action
	    Plane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Flight_List a = new Flight_List();					
			 	    a.setVisible(true);
			}  catch(Exception a){
				a.fillInStackTrace();
			}
		 }
		});
	    //cansel done customers
	    Cnsl_L.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cancellation_list a =  new Cancellation_list();	
					a.setVisible(true);
			}  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
	    //Signed up customer
	    Awt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 SignUp_CList a =  new   SignUp_CList();	
					 a.setVisible(true);
			  }  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
	    //Signed up customer
	    TicketDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Passengers a =  new  Passengers();	
					 a.setVisible(true);
			  }  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
	  
	    //Third Menu Actiion
	    	//pay Ticket
	    	    Ticket_C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Reservetion a =  new  Reservetion();	
					a.setVisible(true);
			  }  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
	    	    //Cansel request
	    	      Cancellation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Cancelation a =  new Cancelation();	
						a.setVisible(true);
				}  catch(Exception ae){
					ae.fillInStackTrace();
				}
			 }
			});
	  
	    
	}
public static void main(String args[] ){
	
	MainFrame m = new MainFrame();
	m.setVisible(true);
	
}
	
}
