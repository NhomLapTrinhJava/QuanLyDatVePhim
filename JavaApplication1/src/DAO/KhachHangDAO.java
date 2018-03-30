/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DTO.KhachHangDTO;

import java.util.List;
/**
 *
 * @author Admin
 */
public class KhachHangDAO {
     public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
      public List<KhachHangDTO> laydanhsachKH() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<KhachHangDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from KHACHHANG");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach Hoc Sinh");
        try {
          
            while(rs.next())
            {
                
                  KhachHangDTO phim=new KhachHangDTO();
               phim.setMAKH(rs.getString("MAKH"));
               phim.setTENKH(rs.getString("TENKH"));
               
               list.add(phim);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao hoc sinh ");
            
        }
         
        
        return list;
    }
}
