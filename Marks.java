package project_resu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Marks extends JFrame implements ActionListener{
    String rno;
    JButton btncancel;
    Marks(String rno){
        this.rno=rno;
     
        setSize(500,600);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
         
        JLabel lblHeading =new JLabel("Banasthali University");
        lblHeading.setBounds(140, 10, 500, 25);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblHeading);
        
        JLabel lblsubheading =new JLabel("Result of Examination 2022");
        lblsubheading.setBounds(130, 50, 500, 20);
        lblsubheading.setFont(new Font("Tahoma",Font.BOLD,18));
        add(lblsubheading);
        
        JLabel lblrno =new JLabel("Roll Number "+ rno);
        lblrno.setBounds(60, 100, 500, 20);
        lblrno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrno);
        
        JLabel lblsem =new JLabel("");
        lblsem.setBounds(60, 130, 500, 20);
        lblsem.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsem);
        
        JLabel lblsub1 =new JLabel();
        lblsub1.setBounds(100, 200, 500, 20);
        lblsub1.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsub1);
     
        JLabel lblsub2 =new JLabel();
        lblsub2.setBounds(100, 230, 500, 20);
        lblsub2.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsub2);
        
        JLabel lblsub3 =new JLabel();
        lblsub3.setBounds(100, 260, 500, 20);
        lblsub3.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsub3);
        
        JLabel lblsub4 =new JLabel();
        lblsub4.setBounds(100, 290, 500, 20);
        lblsub4.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsub4);
        
        JLabel lblsub5 =new JLabel();
        lblsub5.setBounds(100, 320, 500, 20);
        lblsub5.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblsub5);
        
        try{
            Conn c=new Conn();
            ResultSet rs1=c.stmt.executeQuery("select * from subject where rno='"+rno+"'");
            while(rs1.next()){
                lblsub1.setText(rs1.getString("subject1"));
                lblsub2.setText(rs1.getString("subject2"));
                lblsub3.setText(rs1.getString("subject3"));
                lblsub4.setText(rs1.getString("subject4")); 
                lblsub5.setText(rs1.getString("subject5"));
            }
            ResultSet rs2=c.stmt.executeQuery("select * from marks where rno='"+rno+"'");
            while(rs2.next()){
                lblsub1.setText(lblsub1.getText() + "---------" + rs2.getString("marks1"));
                lblsub2.setText(lblsub2.getText() + "---------" + rs2.getString("marks2"));
                lblsub3.setText(lblsub3.getText() + "---------" + rs2.getString("marks3")); 
                lblsub4.setText(lblsub4.getText() + "---------" + rs2.getString("marks4"));
                lblsub5.setText(lblsub5.getText() + "---------" + rs2.getString("marks5")); 
                lblsem.setText("Semester = " + rs2.getString("semester"));
            
            }
        }catch(Exception e){e.printStackTrace();}
       
        btncancel=new JButton("Back");
        btncancel.setBounds(250,500,120,25);
        btncancel.setBackground(Color.black);
        btncancel.setForeground(Color.WHITE);
        add(btncancel);
        btncancel.setFont(new Font("serif",Font.BOLD,15));
        btncancel.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new Marks("");
    }
}
