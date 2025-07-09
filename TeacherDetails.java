package project_resu;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class TeacherDetails extends JFrame implements ActionListener{
    JLabel backgroundLabel,heading;
    Choice cempid;
    JTable table;
    JButton btnsearch,btnprint,btnupdate,btnadd,btncancel;
    TeacherDetails(){
        setLayout(null);
        
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\RCTI\\OneDrive\\Documents\\NetBeansProjects\\Project_resu\\src\\icons/bgclr1.jpeg");
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 900, 700);
        add(backgroundLabel);
        setContentPane(backgroundLabel);
        
        heading=new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        cempid=new Choice();
        cempid.setBounds(180, 20, 150, 20);
        add(cempid);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from faculty");
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){e.printStackTrace();}
        
        table=new JTable();
          try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("select * from faculty");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setBackground(new Color(175,228,222,100));
        }catch(Exception e){e.printStackTrace();}
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(20, 100, 850, 600);
        jsp.getViewport().setBackground(Color.white);
        add(jsp);
        
        btnsearch = new JButton("Search");
        btnsearch.setBounds(20, 70, 80, 20);
        btnsearch.setBackground(new Color(244,194,194,250));
        btnsearch.addActionListener(this);
        add(btnsearch);
        
        btnprint = new JButton("Print");
        btnprint.setBounds(120, 70, 80, 20);
        btnprint.setBackground(new Color(244,194,194,250));
        btnprint.addActionListener(this);
        add(btnprint);
        
        btnupdate = new JButton("Update");
        btnupdate.setBounds(220, 70, 80, 20);
        btnupdate.setBackground(new Color(244,194,194,250));
        btnupdate.addActionListener(this);
        add(btnupdate);
        
        btnadd = new JButton("Add");
        btnadd.setBounds(320, 70, 80, 20);
        btnadd.setBackground(new Color(244,194,194,250));
        btnadd.addActionListener(this);
        add(btnadd);
        
        btncancel= new JButton("Cancel");
        btncancel.setBounds(420, 70, 80, 20);
        btncancel.setBackground(new Color(244,194,194,250));
        btncancel.addActionListener(this);
        add(btncancel);
        
        setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Object obj=e.getSource();
        if(obj==btnsearch){
            String query="select * from faculty where empid='"+cempid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs = c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception et){et.printStackTrace();}
        }
        else if(obj==btnprint){
            try{
                table.print();
            }catch(Exception ex){ex.printStackTrace();}
        }
        else if(obj==btnadd){
            setVisible(false);
            new AddStudent();
        }
        else if(obj==btnupdate){
            setVisible(false);
            new UpdateTeacher();
        }
        if(obj==btncancel){
            setVisible(false);
        }
    }
    public static void main(String [] args){
        new TeacherDetails();
    }
}
