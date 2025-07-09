package project_resu;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class AddStudent extends JFrame implements ActionListener {
    JLabel lblHeading,backgroundLabel,lblname,lblfname,lblrno,lblrollno,lbldob,lbladdr,lblphn,lblemail,lblx,lblxii,lblaadhar,lblcourse,lblbranch;
    JTextField txtname,txtfname,txtdob,txtaddr,txtphn,txtemail,txtx,txtxii,txtaadhar;
    JDateChooser dcdob;
    JComboBox c1,b1;
    JButton btnsubmit,btncancel;
    Panel p1;
    Random ran=new Random(); //for rollno to be auto generated.
    long first4=Math.abs((ran.nextLong() % 9000L)+1000L);// for roll no. to be auto generated.
    AddStudent(){
        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/p1.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 600);

        setLayout(null);
        setContentPane(backgroundLabel);
       
        
        lblHeading =new JLabel("New Student Details");
        lblHeading.setBounds(330, 30, 500, 50);
        lblHeading.setFont(new Font("serif",Font.BOLD,30));
        add(lblHeading);
        
        lblname =new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        txtname=new JTextField();
        txtname.setBounds(200, 150, 150, 30);
        add(txtname);
        
        lblfname =new JLabel("Father's Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        txtfname=new JTextField();
        txtfname.setBounds(600, 150, 150, 30);
        add(txtfname);
        
        lblrno =new JLabel("Roll no.");
        lblrno.setBounds(50, 200, 200, 30);
        lblrno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrno);
        lblrollno =new JLabel("1001"+first4);
        lblrollno.setBounds(200, 200, 200, 30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        lbldob =new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        dcdob=new JDateChooser();
        dcdob.setBounds(600,200,150,30);
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
        txtx=new JTextField();
        txtx.setBounds(600, 300, 150, 30);
        add(txtx);
        
        lblxii =new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        txtxii=new JTextField();
        txtxii.setBounds(200, 350, 150, 30);
        add(txtxii);
        
        lblaadhar =new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        txtaadhar=new JTextField();
        txtaadhar.setBounds(600, 350, 150, 30);
        add(txtaadhar);
        
        lblcourse =new JLabel("Course");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        String c[]={"--SELECT--","B.Tech","BBA","MBA","BCA","Bsc","Msc","MCA","MA","BA"};
        c1=new JComboBox(c);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 400, 150, 30);
        add(c1);
        
        lblbranch =new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        String branch[]={"--SELECT--","CS","Electronincs","Mechanical","civil","IT","English"};
        b1=new JComboBox(branch);
        b1.setBackground(Color.WHITE);
        b1.setBounds(600, 400, 150, 30);
        add(b1);
        
        btnsubmit=new JButton("Submit");
        btnsubmit.setBounds(250,550,120,30);
        btnsubmit.setBackground(Color.GRAY);
        btnsubmit.setForeground(Color.WHITE);
        add(btnsubmit);
        btnsubmit.setFont(new Font("serif",Font.BOLD,18));
        btnsubmit.addActionListener(this);
        
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
        if(obj==btnsubmit){
            String name=txtname.getText();
            String fname=txtfname.getText();
            String rno=lblrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address=txtaddr.getText();
            String phone=txtphn.getText();
            String email=txtemail.getText();
            String x=txtx.getText();
            String xii=txtxii.getText();
            String aadhar=txtaadhar.getText();
            String course=(String)c1.getSelectedItem();
            String branch=(String)b1.getSelectedItem();
            
            try{
                String query = "insert into student (name, fname, rno, dob, address, phone, email, class_x, class_xii, aadhar, course, branch) values ";
                query+=" ('" + name + "', '" + fname + "', '" + rno + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + course + "', '" + branch + "')";
                Conn con=new Conn();
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Student Details inserted successfully");
                setVisible(false);
            }catch(Exception ee){ee.printStackTrace();}
            
        }
        else if(obj==btncancel){
        setVisible(false);   
        }
    }
    public static void main(String args[]){
        new AddStudent();
    }
}
