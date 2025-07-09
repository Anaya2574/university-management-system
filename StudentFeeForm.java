package project_resu;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {
    JLabel labeltotal,lblcourse,lblbranch,lblrno,lblname,lblfname;
    Choice crno;
    JComboBox c1,b1,cbsem;
    JButton btnupdate,btnpay,btnback;
    StudentFeeForm(){
        setSize(900,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50, 500, 300);
        add(image);
        
        lblrno=new JLabel("Select Roll No");
        lblrno.setBounds(40, 60, 150, 20);
        lblrno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblrno);
        
        crno=new Choice();
        crno.setBounds(200, 60, 150, 20);
        add(crno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from student");
            while(rs.next()){
                crno.add(rs.getString("rno"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        lblname =new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200, 100, 150, 30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        lblfname =new JLabel("Father's Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);
        
        JLabel labelfname=new JLabel();
        labelfname.setBounds(200, 140, 150, 16);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);
        
        try{
            Conn c=new Conn();
            String query="select * from student where rno='"+crno.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        }catch(Exception o){o.printStackTrace();}
        
        crno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    String query="select * from student where rno='"+crno.getSelectedItem()+"'";
                    ResultSet rs=c.stmt.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                }catch(Exception o){o.printStackTrace();}
            }
        });
        
        lblcourse =new JLabel("Course");
        lblcourse.setBounds(40, 180, 150, 20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);
        String course[]={"--SELECT--","BTech","BBA","MBA","BCA","Bsc","Msc","MCA","MA","BA"};
        c1=new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 180, 150, 20);
        add(c1);
        
        lblbranch =new JLabel("Branch");
        lblbranch.setBounds(40, 220, 150, 20);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblbranch);
        String branch[]={"--SELECT--","CS","Electronincs","Mechanical","civil","IT","English"};
        b1=new JComboBox(branch);
        b1.setBackground(Color.WHITE);
        b1.setBounds(200, 220, 150, 20);
        add(b1);
        
        JLabel lblsem =new JLabel("Semester");
        lblsem.setBounds(40, 260, 150, 20);
        lblsem.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsem);
        String semester[]={"Semester1","Semeste2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsem=new JComboBox(semester);
        cbsem.setBounds(200,260,150,20);
        cbsem.setBackground(Color.white);
        add(cbsem);
        
        JLabel lbltotal =new JLabel("Total Payable");
        lbltotal.setBounds(40, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labeltotal =new JLabel();
        labeltotal.setBounds(200, 300, 150, 20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);
        
        btnupdate=new JButton("Update");
        btnupdate.setBounds(30,380,100,25);
        btnupdate.setBackground(Color.black);
        btnupdate.setForeground(Color.WHITE);
        add(btnupdate);
        btnupdate.addActionListener(this);
        
        btnpay=new JButton("Pay Fee");
        btnpay.setBounds(150,380,100,25);
        btnpay.setBackground(Color.black);
        btnpay.setForeground(Color.WHITE);
        add(btnpay);
        btnpay.addActionListener(this);
        
        btnback=new JButton("Back");
        btnback.setBounds(270,380,100,25);
        btnback.setBackground(Color.black);
        btnback.setForeground(Color.WHITE);
        add(btnback);
        btnback.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        Object obj=evt.getSource();
        if(obj==btnupdate){
            String course = (String)c1.getSelectedItem();
            String semester= (String)cbsem.getSelectedItem();
            try{
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery("select * from fee where course='"+course+"' ");
                while(rs.next()){
                 labeltotal.setText(rs.getString(semester));   
                    
                }
            }catch(Exception e){e.printStackTrace();}
        }
        else if(obj==btnpay){
            String rno=crno.getSelectedItem();
            String course = (String)c1.getSelectedItem();
            String semester= (String)cbsem.getSelectedItem();
            String branch=(String)b1.getSelectedItem();
            String total= labeltotal.getText();
            try{
                Conn c=new Conn();
                String query="insert into collegefee values('"+rno+"','"+course+"','"+branch+"','"+semester+"','"+total+"')";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "College fee submitted successfully");
                setVisible(false);
            }catch(Exception e){e.printStackTrace();}
        }
        else if(obj==btnback){
            setVisible(false);
        }
    }
    
    public static void main(String args[]){
        new StudentFeeForm();
    }
}
