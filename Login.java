package project_resu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton btnlogin,btncancel;
    JLabel lblname,lblpassword;
    JTextField txtname;
    JPasswordField txtpassword;
    Login(){
        getContentPane().setBackground(new Color(113, 159, 245, 225));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblname=new JLabel("Username");
        lblname.setBounds(40, 20, 100, 20);
        add(lblname);
        
        txtname=new JTextField();
        txtname.setBounds(150,20,150,20);
        add(txtname);
        
        lblpassword=new JLabel("Password");
        lblpassword.setBounds(40, 60, 100, 20);
        add(lblpassword);
        
        txtpassword=new JPasswordField();
        txtpassword.setBounds(150,60,150,20);
        add(txtpassword);
        
        btnlogin=new JButton("Login");
        btnlogin.setBounds(40,140,120,30);
        btnlogin.setBackground(Color.BLUE);
        btnlogin.setForeground(Color.WHITE);
        add(btnlogin);
        btnlogin.setFont(new Font("serif",Font.BOLD,18));
        
        btncancel=new JButton("Cancel");
        btncancel.setBounds(180,140,120,30);
        btncancel.setBackground(Color.BLUE);
        btncancel.setForeground(Color.WHITE);
        add(btncancel);
        btncancel.setFont(new Font("serif",Font.BOLD,18));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setSize(600,300);
        setLocation(400,250);
        setVisible(true);
        
        btnlogin.addActionListener(this);
        btncancel.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        Object obj=e.getSource();
        if(obj==btnlogin){
            String username = txtname.getText();
            String password = new String (txtpassword.getPassword()); // Use getPassword() for JPasswordField

            
           String query = "select * from loginn where username='" + username + "' and password='" + password + "'";

            try{
                Conn con=new Conn();
                ResultSet rs=con.stmt.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                 JOptionPane.showMessageDialog(null,"invalid username or password");
                 setVisible(false);
                }
                con.stmt.close();
            }catch(Exception ex){ex.printStackTrace();}
        }
        else if(obj==btncancel){
            setVisible(false);
        }
    }
    public static void main(String args[]){
        Login l=new Login();
    }
}
