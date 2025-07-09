package project_resu;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class AddFaculty extends JFrame implements ActionListener {
    JLabel lblHeading,backgroundLabel,lblname,lblfname,lblempid,lblemp_id,lbldob,lbladdr,lblphn,lblemail,lblx,lblxii,lblaadhar,lblqual,lbldept;
    JTextField txtname,txtfname,txtdob,txtaddr,txtphn,txtemail,txtx,txtxii,txtaadhar;
    JDateChooser dcdob;
    JComboBox c1,b1;
    JButton btnsubmit,btncancel;
    
    Random ran=new Random(); //for rollno to be auto generated.
    long first4=Math.abs((ran.nextLong() % 9000L)+1000L);// for roll no. to be auto generated.
    AddFaculty(){
        setSize(900,700);
        setLocationRelativeTo(null);
         
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/p1.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setContentPane(backgroundLabel);
        
        lblHeading =new JLabel("New Teacher Details");
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
        
        lblempid =new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);
        lblemp_id =new JLabel("101"+first4);
        lblemp_id.setBounds(200, 200, 200, 30);
        lblemp_id.setFont(new Font("serif",Font.BOLD,20));
        add(lblemp_id);
        
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
        
        lblqual =new JLabel("Qualification");
        lblqual.setBounds(50, 400, 200, 30);
        lblqual.setFont(new Font("serif",Font.BOLD,20));
        add(lblqual);
        String c[]={"--SELECT--","B.Tech","MBA","BCA","Bsc","Msc","BA"};
        c1=new JComboBox(c);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200, 400, 150, 30);
        add(c1);
        
        lbldept =new JLabel("Department");
        lbldept.setBounds(400, 400, 200, 30);
        lbldept.setFont(new Font("serif",Font.BOLD,20));
        add(lbldept);
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
        
        setVisible(true);
    } 
    public void actionPerformed(ActionEvent evt){
        Object obj=evt.getSource();
        if(obj==btnsubmit){
            String name=txtname.getText();
            String fname=txtfname.getText();
            String empid=lblemp_id.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address=txtaddr.getText();
            String phone=txtphn.getText();
            String email=txtemail.getText();
            String x=txtx.getText();
            String xii=txtxii.getText();
            String aadhar=txtaadhar.getText();
            String qualification=(String)c1.getSelectedItem();
            String department=(String)b1.getSelectedItem();
            
            try{
                String query = "insert into faculty  (name, fname, empid, dob, address, phone, email, class_x, class_xii, aadhar, qualification, department) values ";
                query+=" ('" + name + "', '" + fname + "', '" + empid + "', '" + dob + "', '" + address + "', '" + phone + "', '" + email + "', '" + x + "', '" + xii + "', '" + aadhar + "', '" + qualification + "', '" + department + "')";
                Conn con=new Conn();
                con.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Teacher Details inserted successfully");
                setVisible(false);
            }catch(Exception ee){ee.printStackTrace();}
            
        }
        else if(obj==btncancel){
        setVisible(false);   
        }
    }
    public static void main(String args[]){
        new AddFaculty();
    }
}

