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
import DAO.RapDAO;
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
      RapDAO rap = new RapDAO();
     
  public String PhatSinhPhongChieu() throws SQLException, ClassNotFoundException
   {
        sqlcn=new Sqlconnect();
         //Statement statement = a.createStatement();
        //ResultSet rs1=statement.executeQuery("select top 1 MaRap from RAP where MaRap = " + );
      
      
      String ma = "";
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select top 1 * from PHONGCHIEU order by MAPC desc");
            while(rs.next())
            {
              ma = rs.getString("MAPC");
            }
            
            if(ma == "")
            {
                    ma = "PC/0" +  1;
                    return ma;
            }
                 
            
            String[] split = ma.split("/");
            String  m = split[1].toString().trim();
            int n = Integer.parseInt(m);
            if(n < 9)
            {
                n = n + 1;
                ma = "PC/0" +  n;
                
            }
            else
            {
                 n = n + 1;
                ma = "PC/" +  n;
            }
         return  ma;
   } 
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
            
            String n = rap.LayMaRap(pc.getMARAP());
            String sql="insert into PhongChieu(MaPC,MoTa,TinhTrang,MaRap,SODG,SOHG) values(?,?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,PhatSinhPhongChieu() );
           ps.setString(2, pc.getMOTA());
           ps.setString(3,pc.getTinhTrang());
           ps.setString(4, rap.LayMaRap(pc.getMARAP()) );
           ps.setInt(5, pc.getSODG());
           ps.setInt(6, pc.getSOHG());
       
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
               pc.setMARAP(rap.LayTenRap(rs.getString("MARAP")));
               pc.setSODG(rs.getInt("SODG"));
               pc.setSOHG(rs.getInt("SOHG"));
                  
                   
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
            String sql="UPDATE PHONGCHIEU SET MOTA=?,TINHTRANG=?,MARAP=?,SODG=?,SOHG=? WHERE MAPC =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMOTA());
           ps.setString(2, pc.getTinhTrang());
           ps.setString(3, rap.LayMaRap(pc.getMARAP()));
           
             int  m = pc.getSODG();
           ps.setInt(4, m);
         
           
             int  n = pc.getSOHG();
           ps.setInt(5, n);
          
         
           ps.setString(6, pc.getMAPC());
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhongChieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
