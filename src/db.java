/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jana
 */
import java.sql.*;
import javax.swing.*;
import static java.lang.Class.forName;
public class db {
    
    
    
   
    public static Connection java_db(){
         Connection conn=null;
        try{
            Class.forName("org.sqlite.JDBC");
            conn =DriverManager.getConnection("jdbc:sqlite:E:\\Projects\\Java\\EDMS\\ExamDept\\ExamDept.db");
           JOptionPane.showMessageDialog(null, "Connection to database is successful");
           
            return conn;
           
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
            return null;
        }
        
    }
}