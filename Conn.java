
package project_resu;
import java.sql.*;
public class Conn {
    Connection con;
    Statement stmt;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3305/mysql","root","12345678");
            stmt=con.createStatement();
        }catch(Exception ex){ex.printStackTrace();}
    }
}
