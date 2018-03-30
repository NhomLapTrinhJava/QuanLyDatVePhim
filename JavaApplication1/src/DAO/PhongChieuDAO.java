/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import static DAO.RapDAO.a;
import static DAO.RapDAO.rs;
import static DAO.RapDAO.sqlcn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DTO.RapDTO;
import DTO.PhongChieuDTO;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
 
/**
 *
 * @author abcd
 */
public class PhongChieuDAO {
     public static Connection a;
    public static ResultSet rs;
     public static  Sqlconnect sqlcn;
          public void themPhongChieu(PhongChieuDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PhongChieu(MaPC,MoTa,TinhTrang,MaRap,SoGhe) values(?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMAPC() );
           ps.setString(2, pc.getMOTA());
           ps.setString(3,pc.getTinhTrang());
           ps.setString(4, pc.getMARAP());
           ps.setInt(5, pc.getSoGhe());
        
           ps.executeUpdate();            
        } catch (SQLException ex) {
          Logger.getLogger(PhongChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
      
      public List<PhongChieuDTO> laydanhsachPhongChieu() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhongChieuDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHONGCHIEU");
             System.out.print("Truy vấn thành công");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach phong chieu");
        try {
          
            while(rs.next())
            {
                 

                PhongChieuDTO pc=new PhongChieuDTO();
               pc.setMAPC(rs.getString("MAPC"));
               pc.setMOTA(rs.getString("MOTA"));
               pc.setTINHTRANG(rs.getString("TINHTRANG"));
               pc.setMARAP(rs.getString("MARAP"));
               pc.setSoGhe(rs.getInt("SOGHE"));
                   
               list.add(pc);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao  ");
            
        }
         
        
        return list;
    }
    
    
      
      public void xoaPhongChieu(PhongChieuDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHONGCHIEU  WHERE MAPC= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMAPC() );
           ps.executeUpdate();
           System.out.print("Đã xóa thành công  " + pc.getMAPC());
            
        } catch (SQLException ex) {
          Logger.getLogger(PhongChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatPhongChieu(PhongChieuDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE PHONGCHIEU SET MOTA=?,TINHTRANG=?,MARAP=?,SOGHE=? WHERE MAPC =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMOTA());
           ps.setString(2, pc.getTinhTrang());
           ps.setString(3, pc.getMARAP());
           int  m = pc.getSoGhe();
           ps.setInt(4, m);
           ps.setString(5, pc.getMAPC());
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhongChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
