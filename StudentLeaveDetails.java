package project_resu;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StudentLeaveDetails extends JFrame implements ActionListener{
    JLabel heading,backgroundLabel;
    Choice crno,ctime;
    JDateChooser dcdate;
    JButton btnsearch,btnprint,btncancel;
    JTable table;
    StudentLeaveDetails(){
        
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.pink);        

        heading=new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 200, 20);
        heading.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(heading);
        
        crno=new Choice();
        crno.setBounds(240, 20, 200, 20);
        add(crno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from student");
            while(rs.next()){
                crno.add(rs.getString("rno"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        table = new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();}
            
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        jsp.getViewport().setBackground(Color.white);
        add(jsp);
   
        btnsearch=new JButton("Search");
        btnsearch.setBounds(20,70,100,20);
        btnsearch.setBackground(Color.GRAY);
        btnsearch.setForeground(Color.WHITE);
        btnsearch.setFont(new Font("serif",Font.BOLD,18));
        btnsearch.addActionListener(this);
        add(btnsearch);
        
        btnprint=new JButton("Print");
        btnprint.setBounds(140,70,100,20);
        btnprint.setBackground(Color.GRAY);
        btnprint.setForeground(Color.WHITE);
        btnprint.setFont(new Font("serif",Font.BOLD,18));
        btnprint.addActionListener(this);
        add(btnprint);
        
        btncancel=new JButton("Cancel");
        btncancel.setBounds(260,70,100,20);
        btncancel.setBackground(Color.GRAY);
        btncancel.setForeground(Color.WHITE);
        btncancel.setFont(new Font("serif",Font.BOLD,18));
        btncancel.addActionListener(this);
        add(btncancel);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==btnsearch){
            String query="select * from studentleave where rno='"+crno.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception er){er.printStackTrace();}
        }
        else if(obj==btnprint){
            try{
                table.print();
            }catch(Exception et){et.printStackTrace();}
        }
        else if (obj==btncancel){
            setVisible(false);
        }
        
    }
    public static void main(String[]args){   
        new StudentLeaveDetails();    
    }
}
