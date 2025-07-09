package project_resu;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class UpdateTeacher extends JFrame implements ActionListener {
    JLabel labeleid,lblHeading,backgroundLabel,lblname,lblfname,lblempid,lbldob,lbladdr,lblphn,lblemail,lblx,lblxii,lblaadhar,lbledu,lbldept;
    JTextField txtdob,txtaddr,txtphn,txtemail,tfedu,tfdept;
    JButton btnupdate,btncancel;
    Choice cempid;
    UpdateTeacher(){
        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/p1.jpg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 500, 600);

        setLayout(null);
        setContentPane(backgroundLabel);
       
        
        lblHeading =new JLabel("Update Teacher Details");
        lblHeading.setBounds(300, 30, 500, 50);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(lblHeading);
        
        lblempid=new JLabel("Select Employee ID");
        lblempid.setBounds(50, 100, 200, 20);
        lblempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempid);
        
        cempid=new Choice();
        cempid.setBounds(250, 100, 200, 20);
        add(cempid);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from faculty");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
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
        
        lblempid =new JLabel("Employee ID");
        lblempid.setBounds(50, 200, 200, 30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);
        labeleid =new JLabel();
        labeleid.setBounds(200, 200, 200, 30);
        labeleid.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeleid);
        
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
        
        lbledu =new JLabel("Education");
        lbledu.setBounds(50, 400, 200, 30);
        lbledu.setFont(new Font("serif",Font.BOLD,20));
        add(lbledu);
        tfedu=new JTextField();
        tfedu.setBackground(Color.WHITE);
        tfedu.setBounds(200, 400, 150, 30);
        add(tfedu);
        
        lbldept =new JLabel("Department");
        lbldept.setBounds(400, 400, 200, 30);
        lbldept.setFont(new Font("serif",Font.BOLD,20));
        add(lbldept);
      
        tfdept=new JTextField();
        tfdept.setBackground(Color.WHITE);
        tfdept.setBounds(600, 400, 150, 30);
        add(tfdept);
        
        try{
            Conn c=new Conn();
            String query="select * from faculty where empid='"+cempid.getSelectedItem()+"'";
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
                labeleid.setText(rs.getString("empid"));
                tfedu.setText(rs.getString("qualification"));
                tfdept.setText(rs.getString("department"));
              
            }
        }catch(Exception o){o.printStackTrace();}
        
        cempid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c=new Conn();
                    String query="select * from faculty where empid='"+cempid.getSelectedItem()+"'";
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
                        labeleid.setText(rs.getString("empid"));
                        tfedu.setText(rs.getString("qualification"));
                        tfdept.setText(rs.getString("department"));
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
            
            String empid=labeleid.getText();
            String address=txtaddr.getText();
            String phone=txtphn.getText();
            String email=txtemail.getText();
            String qualification=tfedu.getText();
            String department=tfdept.getText();
            
            try{
                String query = "update faculty set address='"+address+"', phone='"+phone+"', email='"+email+"', qualification='"+qualification+"', department='"+department+"' where empid='"+empid+"' " ;

                Conn c=new Conn();
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"teacher Details updated successfully");
                setVisible(false);
            }catch(Exception ee){ee.printStackTrace();}
            
        }
        else if(obj==btncancel){
        setVisible(false);   
        }
    }
    public static void main(String args[]){
        new UpdateTeacher();
    }
}
