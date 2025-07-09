package project_resu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class About extends JFrame{
    
    About(){
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(113, 159, 245, 225));
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 300, 200);
        add(image);
        
        JLabel heading =new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(70, 20, 300, 130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);
        
        JLabel name =new JLabel("Developed By: Anaya Tomar");
        name.setBounds(70, 220, 550, 40);
        name.setFont(new Font("Tahoma",Font.BOLD,30));
        add(name);
        
        JLabel rno =new JLabel("Roll number: 2116105");
        rno.setBounds(70, 280, 550, 40);
        rno.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(rno);
        
        JLabel contact =new JLabel("Contact: anayatomar2574@gmail.com");
        contact.setBounds(70, 340, 550, 40);
        contact.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(contact);
        
        
        setVisible(true);
    }
    
    public static void main(String args[]){
        new About();
    }
}
