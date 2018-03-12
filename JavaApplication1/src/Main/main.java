/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import DAO.NhanVienDAO;
import Connection.Sqlconnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 *
 * @author abcd
 */
public class main {
    public static void main(String[] args) {
        // TODO code application logic here
        String sql="select MANV,TENNV,DIACHI,DIENTHOAI from NHANVIEN ";
        
        NhanVienDAO a=new NhanVienDAO();
        
        try {
            a.laydanhsachnhanvien(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
