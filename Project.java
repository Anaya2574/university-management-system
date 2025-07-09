package project_resu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Project extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu mInfo,mDetails,mLeave,mLeaveDetails,mExam,mUpdateInfo,mFee,mUtility,mExit,mAbout;
    JMenuItem miFacultyinfo,miStudentinfo,miFacultyDetails,miStudentDetails,miFacultyLeave,miStudentLeave;
    JMenuItem miFacLeaveDe,miStuLeaveDe,miExamDe,miEnterM,miUpdateFacInfo,miUpdateStuInfo;
    JMenuItem miFeeStruc,miFeeForm,miNotepad,miCal,miEx,miAbt;
    Project(){
        
        setSize(1370,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.blue);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/p2.jpg")); 
        Image i2 = i1.getImage().getScaledInstance(1370, 800, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
         
        mb=new JMenuBar();
        setJMenuBar(mb);
        mInfo=new JMenu("New Information");
        mDetails=new JMenu("View Details");
        mLeave=new JMenu("Apply Leave");
        mLeaveDetails=new JMenu("Leave Details");
        mExam=new JMenu("Examination Details");
        mUpdateInfo=new JMenu("Update Details");
        mFee=new JMenu("Fee Details");
        mUtility=new JMenu("Utility");
        mAbout=new JMenu("About");
        mExit=new JMenu("Exit");
        
//adding menu into menubar
        mb.add(mInfo); mb.add(mDetails);
        mb.add(mLeave);mb.add(mLeaveDetails);
        mb.add(mExam);mb.add(mUpdateInfo);
        mb.add(mFee);mb.add(mUtility);
        mb.add(mAbout);mb.add(mExit);
        
        miFacultyinfo=new JMenuItem("New Faculty Information");
        miStudentinfo=new JMenuItem("New Student Information");
        miFacultyDetails=new JMenuItem("View Faculty Details");
        miStudentDetails=new JMenuItem("View Student Details");
        miFacultyLeave=new JMenuItem("Faculty Leave");
        miStudentLeave=new JMenuItem("Student Leave");
        miFacLeaveDe=new JMenuItem("Faculty Leave Details");
        miStuLeaveDe=new JMenuItem("Student Leave Details");
        miExamDe=new JMenuItem("Examination Results");
        miEnterM=new JMenuItem("Enter Marks");
        miUpdateFacInfo=new JMenuItem("Update Faculty Details");
        miUpdateStuInfo=new JMenuItem("Update Student Details");
        miFeeStruc=new JMenuItem("Fee Structure");
        miFeeForm=new JMenuItem("Student Fee Form");
        miNotepad=new JMenuItem("Notepad");
        miCal=new JMenuItem("Calculator");
        miAbt=new JMenuItem("About");
        miEx=new JMenuItem("Exit");
        
//adding menuitem into menu
        mDetails.add(miFacultyDetails);
        mDetails.add(miStudentDetails);
        
        mInfo.add(miFacultyinfo);
        mInfo.add(miStudentinfo);
        
        mLeave.add(miFacultyLeave);
        mLeave.add(miStudentLeave);
        
        mLeaveDetails.add(miFacLeaveDe);
        mLeaveDetails.add(miStuLeaveDe);
        
        mExam.add(miExamDe);
        mExam.add(miEnterM);
        
        mUpdateInfo.add(miUpdateFacInfo);
        mUpdateInfo.add(miUpdateStuInfo);
        
        mFee.add(miFeeStruc);
        mFee.add(miFeeForm);
        
        mUtility.add(miNotepad);
        mUtility.add(miCal);
        
        mAbout.add(miAbt);
        mExit.add(miEx);
        
//implementing action listener
        miEx.addActionListener(this);
        miAbt.addActionListener(this);
        
        miNotepad.addActionListener(this);
        miCal.addActionListener(this);
        
        miFacultyinfo.addActionListener(this);
        miStudentinfo.addActionListener(this);
        
        miFacultyDetails.addActionListener(this);
        miStudentDetails.addActionListener(this);
        
        miFacultyLeave.addActionListener(this);
        miStudentLeave.addActionListener(this);
        
        miFacLeaveDe.addActionListener(this);
        miStuLeaveDe.addActionListener(this);
        
        miUpdateFacInfo.addActionListener(this);
        miUpdateStuInfo.addActionListener(this);
        
        miEnterM.addActionListener(this);
        miExamDe.addActionListener(this);
        
        miFeeStruc.addActionListener(this);
        miFeeForm.addActionListener(this);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String msg = e.getActionCommand();
        if (msg.equals("Exit")){
            setVisible(false);
        }
        else if(msg.equals("Calculator")){
            /*becoz calculator is not in our project it is outside the project/system so if we need access the calculator
            we use try n catchn create n object for runtime class which have static function getRuntime which helps to run
            an executable file of extension exe by function exec.*/
            try{
                Runtime.getRuntime().exec("calc.exe");//calc.exe is a executable file
            }catch(Exception ex){
            
            }
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");// 
            }catch(Exception ex){}
        }
        else if(msg.equals("New Faculty Information")){
            new AddFaculty();
        }
        else if(msg.equals("New Student Information")){
            new AddStudent();
        }
        else if(msg.equals("View Student Details")){
            new StudentDetails();
        }
        else if(msg.equals("View Faculty Details")){
            new TeacherDetails();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if(msg.equals("Student Leave Details")){
            new StudentLeaveDetails();
        }else if(msg.equals("Faculty Leave Details")){
            new TeacherLeaveDetails();
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent();
        }else if(msg.equals("Update Faculty Details")){
            new UpdateTeacher();
        }
        else if(msg.equals("Enter Marks")){
            new EnterMarks();
        }else if(msg.equals("Examination Results")){
            new ExaminationDetails();
        }else if(msg.equals("Fee Structure")){
            new FeeStructure();
        }
        else if(msg.equals("About")){
            new About();
        }
        else if(msg.equals("Student Fee Form")){
            new StudentFeeForm();
        }
    }
    public static void main(String args[]){
        new Project();
    }
}
