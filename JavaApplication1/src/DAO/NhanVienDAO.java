/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Sqlconnect;
import DTO.NHANVIENDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abcd
 */
public class NhanVienDAO {
     public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
       public void laydanhsachnhanvien(String sql) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
              Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery(sql);
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach nhan vien");
        try {
            while(rs.next())
            {
                 
               System.out.print("\n");
              System.out.print(rs.getString("MANV"));
              System.out.print("\n");
               System.out.print(rs.getString("TENNV"));
                System.out.print("\n");
              System.out.print(rs.getString("DIACHI"));
                System.out.print("\n");
               System.out.print(rs.getString("DIENTHOAI"));
             
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao nhan vien ");
            
        }
         
        
        
    }
    public List<NHANVIENDTO> laythongtintaikhoan(String tk,String mk) throws ClassNotFoundException 
    {
            List<NHANVIENDTO> list=new ArrayList();
            sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="select TENTK,MATKHAU from NHANVIEN where MATKHAU =? ";
            PreparedStatement ps=a.prepareStatement(sql);
           

            
            ps.setString(1, mk);
           rs=ps.executeQuery();
           System.out.print("lay danh sach   thanh cong ");
            
        } catch (SQLException ex) {
                       System.out.print("khong the lay danh sach ");

          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          
            while(rs.next())
            {
                 
//               System.out.print("\n");
//              System.out.print(rs.getInt("MaHS"));
//              System.out.print("\n");
//               System.out.print(rs.getString("TenHS"));
//                System.out.print("\n");
//              System.out.print(rs.getString("NgaySinh"));
//                System.out.print("\n");
//               System.out.print(rs.getString("GhiChu"));
//                System.out.print("\n");
//              System.out.print(rs.getInt("Extinfo"));
//                System.out.print("\n");
                  NHANVIENDTO lpm=new NHANVIENDTO();
                  lpm.setTENTK(rs.getString("TENTK"));
               lpm.setMATKHAU(rs.getString("MATKHAU"));
               list.add(lpm);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao hoc sinh ");
            
        }
         return list;
    }
}
