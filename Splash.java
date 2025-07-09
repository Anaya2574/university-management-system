package project_resu;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread t;
    public Splash() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.png")); 
            Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            add(image);
//            setLocationRelativeTo(null);
            t=new Thread(this);
            t.start();
            setVisible(true);
            //to dynamically move the loction
            int x=1;
            for(int i=2;i<=500;i+=4,x+=1){
                setLocation(600-((i+x)/2),300-(i/2));
                setSize(i+3*x, i+x/2);
                try{
                    Thread.sleep(10);
                }catch(Exception e){}
            }
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
            new Login();
        }catch(Exception e){}
    }
    public static void main(String args[]) {
        new Splash();
    }
}
