package project_resu;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener{
    JLabel heading,lblrno,lbldate,lbltime,backgroundLabel;
    Choice crno,ctime;
    JDateChooser dcdate;
    JButton btnsubmit,btncancel;
    StudentLeave(){
        
        setSize(400,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/leave.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 550);
        add(backgroundLabel);
        setContentPane(backgroundLabel);
        
        getContentPane().setBackground(Color.white);
        
        heading=new JLabel("Apply leave(Student)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        lblrno=new JLabel("Search by Roll Number");
        lblrno.setBounds(60, 100, 200, 20);
        lblrno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrno);
        
        crno=new Choice();
        crno.setBounds(60, 130, 200, 20);
        add(crno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from student");
            while(rs.next()){
                crno.add(rs.getString("rno"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        lbldate=new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 25);
        add(dcdate);
        
        lbltime=new JLabel("Time Duration");
        lbltime.setBounds(60, 260, 200, 20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);
        
        ctime=new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("--SELECT--");
        ctime.add("Half Day");
        ctime.add("Full Day");
        add(ctime);
        
        btnsubmit=new JButton("Submit");
        btnsubmit.setBounds(60,350,100,25);
        btnsubmit.setBackground(Color.GRAY);
        btnsubmit.setForeground(Color.WHITE);
        btnsubmit.setFont(new Font("serif",Font.BOLD,18));
        btnsubmit.addActionListener(this);
        add(btnsubmit);
        
        btncancel=new JButton("Cancel");
        btncancel.setBounds(200,350,100,25);
        btncancel.setBackground(Color.GRAY);
        btncancel.setForeground(Color.WHITE);
        btncancel.setFont(new Font("serif",Font.BOLD,18));
        btncancel.addActionListener(this);
        add(btncancel);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==btnsubmit){
            String rno=crno.getSelectedItem();
            String date=((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration=ctime.getSelectedItem();
            String query="insert into studentleave values('"+rno+"','"+date+"','"+duration+"')";
            try{
                Conn c=new Conn();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception er){er.printStackTrace();}
        }
        else if (obj==btncancel){
            setVisible(false);
        }
        
    }
    public static void main(String[]args){   
        new StudentLeave();    
    }
}
