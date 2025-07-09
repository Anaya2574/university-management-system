package project_resu;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class UpdateStudent extends JFrame implements ActionListener {
    JLabel labelrollno,lblHeading,backgroundLabel,lblname,lblfname,lblrno,lbldob,lbladdr,lblphn,lblemail,lblx,lblxii,lblaadhar,lblcourse,lblbranch;
    JTextField txtdob,txtaddr,txtphn,txtemail,tfcourse,tfbranch;
    JButton btnupdate,btncancel;
    Choice crno;
    UpdateStudent(){
        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/p1.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 600);

        setLayout(null);
        setContentPane(backgroundLabel);
       
        
        lblHeading =new JLabel("Update Student Details");
        lblHeading.setBounds(300, 30, 500, 50);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(lblHeading);
        
        lblrno=new JLabel("Select Roll Number");
        lblrno.setBounds(50, 100, 200, 20);
        lblrno.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrno);
        
        crno=new Choice();
        crno.setBounds(250, 100, 200, 20);
        add(crno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from student");
            while(rs.next()){
                crno.add(rs.getString("rno"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        lblname =new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        JLabel labelname=new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);
        
        lblfname =new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        JLabel labelfname=new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);
        
        lblrno =new JLabel("Roll no.");
        lblrno.setBounds(50, 200, 200, 30);
        lblrno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrno);
        labelrollno =new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelrollno);
        
        lbldob =new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        JLabel dcdob=new JLabel();
        dcdob.setBounds(600,200,150,30);
        dcdob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(dcdob);
        
        lbladdr =new JLabel("Address");
        lbladdr.setBounds(50, 250, 200, 30);
        lbladdr.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdr);
        txtaddr=new JTextField();
        txtaddr.setBounds(200, 250, 150, 30);
        add(txtaddr);
        
        lblphn =new JLabel("Phone Number");
        lblphn.setBounds(400, 250, 200, 30);
        lblphn.setFont(new Font("serif",Font.BOLD,20));
        add(lblphn);
        txtphn=new JTextField();
        txtphn.setBounds(600, 250, 150, 30);
        add(txtphn);
        
        lblemail =new JLabel("Email ID");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        txtemail=new JTextField();
        txtemail.setBounds(200, 300, 150, 30);
        add(txtemail);
        
        lblx =new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        JLabel labelx=new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelx);
        
        lblxii =new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        JLabel labelxii=new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxii);
        
        lblaadhar =new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        JLabel labelaadhar=new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        
        lblcourse =new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        tfcourse=new JTextField();
        tfcourse.setBackground(Color.WHITE);
        tfcourse.setBounds(200, 400, 150, 30);
        add(tfcourse);
        
        lblbranch =new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
      
        tfbranch=new JTextField();
        tfbranch.setBackground(Color.WHITE);
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);
        
        try{
            Conn c=new Conn();
            String query="select * from student where rno='"+crno.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                dcdob.setText(rs.getString("dob"));
                txtaddr.setText(rs.getString("address"));
                txtphn.setText(rs.getString("phone"));
                txtemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("rno"));
                tfcourse.setText(rs.getString("course"));
                tfbranch.setText(rs.getString("branch"));
              
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
                        dcdob.setText(rs.getString("dob"));
                        txtaddr.setText(rs.getString("address"));
                        txtphn.setText(rs.getString("phone"));
                        txtemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));  
                    }
                }catch(Exception o){o.printStackTrace();}
            }
        });
        
        btnupdate=new JButton("Update");
        btnupdate.setBounds(250,550,120,30);
        btnupdate.setBackground(Color.GRAY);
        btnupdate.setForeground(Color.WHITE);
        add(btnupdate);
        btnupdate.setFont(new Font("serif",Font.BOLD,18));
        btnupdate.addActionListener(this);
        
        btncancel=new JButton("Cancel");
        btncancel.setBounds(450,550,120,30);
        btncancel.setBackground(Color.GRAY);
        btncancel.setForeground(Color.WHITE);
        add(btncancel);
        btncancel.setFont(new Font("serif",Font.BOLD,18));
        btncancel.addActionListener(this);
        
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);        
        setVisible(true);
    } 
    public void actionPerformed(ActionEvent evt){
        Object obj=evt.getSource();
        if(obj==btnupdate){
            
            String rno=labelrollno.getText();
            String address=txtaddr.getText();
            String phone=txtphn.getText();
            String email=txtemail.getText();
            String course=tfcourse.getText();
            String branch=tfbranch.getText();
            
            try{
                String query = "update student set address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', branch='"+branch+"' where rno='"+rno+"' " ;

                Conn c=new Conn();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details updated successfully");
                setVisible(false);
            }catch(Exception ee){ee.printStackTrace();}
            
        }
        else if(obj==btncancel){
        setVisible(false);   
        }
    }
    public static void main(String args[]){
        new UpdateStudent();
    }
}
