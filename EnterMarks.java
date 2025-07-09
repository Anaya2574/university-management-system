package project_resu;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class EnterMarks extends JFrame implements ActionListener {
    Choice crno;
    JComboBox cbsem;
    JTextField tsub1,tsub2,tsub3,tsub4,tsub5,tmarks1,tmarks2,tmarks3,tmarks4,tmarks5;
    JButton btnsubmit,btncancel;
    EnterMarks(){
        setSize(1000,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.CYAN);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        add(image);
         
        JLabel lblHeading =new JLabel("Enter marks of student");
        lblHeading.setBounds(50, 0, 500, 50);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblHeading);
        
        JLabel lblrno=new JLabel("Select Roll Number");
        lblrno.setBounds(50, 70, 150, 20);
        add(lblrno);
        
        crno=new Choice();
        crno.setBounds(200, 70, 150, 20);
        add(crno);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from student");
            while(rs.next()){
                crno.add(rs.getString("rno"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        JLabel lblsem =new JLabel("Select Semester");
        lblsem.setBounds(50, 110, 150, 20);
        add(lblsem);
        
        String semester[]={"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        cbsem=new JComboBox(semester);
        cbsem.setBounds(200,110,150,20);
        cbsem.setBackground(Color.white);
        add(cbsem);
        
        JLabel lblenSub =new JLabel("Enter Subject");
        lblenSub.setBounds(100, 150, 200, 40);
        add(lblenSub);
        
        JLabel lblenMarks =new JLabel("Enter Marks");
        lblenMarks.setBounds(320, 150, 200, 40);
        add(lblenMarks);
        
        tsub1=new JTextField();
        tsub1.setBounds(50,200,200,20);
        add(tsub1);
        
        tsub2=new JTextField();
        tsub2.setBounds(50,230,200,20);
        add(tsub2);
        
        tsub3=new JTextField();
        tsub3.setBounds(50,260,200,20);
        add(tsub3);
        
        tsub4=new JTextField();
        tsub4.setBounds(50,290,200,20);
        add(tsub4);
        
        tsub5=new JTextField();
        tsub5.setBounds(50,320,200,20);
        add(tsub5);
        
        tmarks1=new JTextField();
        tmarks1.setBounds(270,200,200,20);
        add(tmarks1);
        
        tmarks2=new JTextField();
        tmarks2.setBounds(270,230,200,20);
        add(tmarks2);
        
        tmarks3=new JTextField();
        tmarks3.setBounds(270,260,200,20);
        add(tmarks3);
        
        tmarks4=new JTextField();
        tmarks4.setBounds(270,290,200,20);
        add(tmarks4);
        
        tmarks5=new JTextField();
        tmarks5.setBounds(270,320,200,20);
        add(tmarks5);
        
        btnsubmit=new JButton("Submit");
        btnsubmit.setBounds(70,360,150,25);
        btnsubmit.setBackground(Color.black);
        btnsubmit.setForeground(Color.WHITE);
        add(btnsubmit);
        btnsubmit.setFont(new Font("serif",Font.BOLD,18));
        btnsubmit.addActionListener(this);
        
        btncancel=new JButton("Cancel");
        btncancel.setBounds(280,360,150,25);
        btncancel.setBackground(Color.black);
        btncancel.setForeground(Color.WHITE);
        add(btncancel);
        btncancel.setFont(new Font("serif",Font.BOLD,18));
        btncancel.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        Object obj=evt.getSource();
        if(obj==btnsubmit){
            try{
                Conn c=new Conn();
                String query1="insert into subject values('"+crno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tsub1.getText()+"','"+tsub2.getText()+"','"+tsub3.getText()+"','"+tsub4.getText()+"','"+tsub5.getText()+"')";
                String query2="insert into marks values('"+crno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tmarks1.getText()+"','"+tmarks2.getText()+"','"+tmarks3.getText()+"','"+tmarks4.getText()+"','"+tmarks5.getText()+"')";
                
                c.stmt.executeUpdate(query1);
                c.stmt.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"marks inserted successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String []args){
     new EnterMarks();   
    }
}
