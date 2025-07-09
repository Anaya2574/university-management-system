package project_resu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class ExaminationDetails extends JFrame implements ActionListener{
    JTextField txtsearch;
    JButton btnsubmit,btncancel;
    JTable table;
    ExaminationDetails(){
        setSize(1000,475);
        setLocationRelativeTo(null);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        getContentPane().setBackground(Color.GRAY);
         
        JLabel lblHeading =new JLabel("Check Result");
        lblHeading.setBounds(80, 15, 400, 50);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,24));
        add(lblHeading);
        
        txtsearch=new JTextField();
        txtsearch.setBounds(80,90,200,30);
        txtsearch.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(txtsearch);
        
        btnsubmit=new JButton("Result");
        btnsubmit.setBounds(300,90,120,30);
        btnsubmit.setBackground(Color.black);
        btnsubmit.setForeground(Color.WHITE);
        add(btnsubmit);
        btnsubmit.setFont(new Font("serif",Font.BOLD,15));
        btnsubmit.addActionListener(this);
        
        btncancel=new JButton("Back");
        btncancel.setBounds(440,90,120,35);
        btncancel.setBackground(Color.black);
        btncancel.setForeground(Color.WHITE);
        add(btncancel);
        btncancel.setFont(new Font("serif",Font.BOLD,15));
        btncancel.addActionListener(this);
        
        table=new JTable();
        table.setFont(new Font("TAhoma",Font.PLAIN,16));
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,130,1000,310);
        add(jsp);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from  student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){e.printStackTrace();}
        
        table.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){ 
               int row=table.getSelectedRow();
               txtsearch.setText(table.getModel().getValueAt(row, 2).toString());
           }
        });
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent evt){
        Object obj=evt.getSource();
        if(obj==btnsubmit){
            setVisible(false);
            new Marks(txtsearch.getText());
            
        }
        else {
            setVisible(false);
        }
    }
    public static void main(String args[]){
        new ExaminationDetails();
    }
}
