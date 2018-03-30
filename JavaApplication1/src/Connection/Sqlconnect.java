/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Sqlconnect {
     public  Connection getSQLServerConnection() throws ClassNotFoundException, SQLException {
     
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 
   
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyRapPhim;user=sa;password=123456";
 
     Connection conn = DriverManager.getConnection(dbURL);
     return conn;
     
 }
}
