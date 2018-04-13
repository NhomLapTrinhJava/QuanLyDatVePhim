/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Sqlconnect;
import static DAO.NhanVienDAO.a;
import static DAO.NhanVienDAO.rs;
import static DAO.NhanVienDAO.sqlcn;
import DTO.NhanVienDTO;
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
       
        public String LayMANV(String TENNV) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
        
       
      String manhanvien = ""; 
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from NHANVIEN where TENNV = '" + TENNV + "'");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
        try {
          
            while(rs.next())
            {
                
                 
             
                manhanvien =  rs.getString("MANV");
               
            
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return manhanvien;
    }
        
        
        
         public String LayTENNV(String MANV) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
        
       
      String tennv = ""; 
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from NHANVIEN where MANV = '" + MANV + "'");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
        try {
          
            while(rs.next())
            {
                
                 
             
                tennv =  rs.getString("TENNV");
               
            
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return tennv;
    }
         
         
         
          public String PhatSinhMANV() throws SQLException, ClassNotFoundException
   {
        sqlcn=new Sqlconnect();
         //Statement statement = a.createStatement();
        //ResultSet rs1=statement.executeQuery("select top 1 MANV from NHANVIEN where MANV = " + );
      
      
      String ma = "";
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select top 1 * from NHANVIEN order by MANV desc");
            while(rs.next())
            {
              ma = rs.getString("MANV");
            }
            
            if(ma == "")
            {
                    ma = "NV/0" +  1;
                    return ma;
            }
                 
            
            String[] split = ma.split("/");
            String  m = split[1].toString().trim();
            int n = Integer.parseInt(m);
            if(n < 9)
            {
                n = n + 1;
                ma = "NV/0" +  n;
                
            }
            else
            {
                 n = n + 1;
                ma = "NV/" +  n;
            }
         return  ma;
   } 
   
    public List<NhanVienDTO> laydanhnhanvien() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<NhanVienDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from NHANVIEN");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
        try {
          
            while(rs.next())
            {

                  NhanVienDTO nhanvien=new NhanVienDTO();
               nhanvien.setMANV(rs.getString("MANV"));
                nhanvien.setTENNV(rs.getString("TENNV"));
                nhanvien.setDIACHI(rs.getString("DIACHI"));
                nhanvien.setDIENTHOAI(rs.getString("DIENTHOAI"));
               list.add(nhanvien);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return list;
    }
    
    
      public void themNHANVIEN(NhanVienDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into NHANVIEN(MANV,TENNV,DiaChi,DIENTHOAI) values(?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMANV());
           ps.setString(2, pc.getTENNV());
           ps.setString(3,pc.getDIACHI());
           ps.setString(4,pc.getDIENTHOAI());
        
           ps.executeUpdate();
           System.out.print("Đã Thêm Thành Công");
            
        } catch (SQLException ex) {
          Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
      public void xoaNHANVIEN(NhanVienDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE NHANVIEN  WHERE MANV= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMANV());
           ps.executeUpdate();
           System.out.print("Đã xóa thành công  " + pc.getMANV());
          
           
        } catch (SQLException ex) {
          Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatNHANVIEN(NhanVienDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE NHANVIEN SET TENNV=?,DiaChi=?,DIENTHOAI=? WHERE MANV =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getTENNV());
           ps.setString(2, pc.getDIACHI());
              ps.setString(3, pc.getDIENTHOAI());
            ps.setString(4, pc.getMANV());
       
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
}
