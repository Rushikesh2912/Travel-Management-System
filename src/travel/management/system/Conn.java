package travel.management.system;

import java.sql.*;

public class Conn {

    Connection c;  //==>Creating Connection String
    Statement s;   //==>Creating a Statement 

    Conn() {
        //1. Register The Driver Class 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.Cerate Connection String
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root", "root");

            //3.Cerate A Statment
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
