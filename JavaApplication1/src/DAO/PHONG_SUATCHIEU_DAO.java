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
import DTO.PHONG_SUATCHIEU_DTO;
import DTO.SUATCHIEU_DTO;
import java.util.List;
/**
 *
 * @author abcd
 */
public class PHONG_SUATCHIEU_DAO {
          public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
     public void themphongsuatchieu(PHONG_SUATCHIEU_DTO sc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PHONG_SUATCHIEU_DTO values(?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,sc.MAPC );
          
           ps.setString(2, sc.MASC);
          
           ps.executeUpdate();
           System.out.print("them phong suat chieu thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<SUATCHIEU_DTO> laydanhsachphongsuatchieu(PHONG_SUATCHIEU_DTO dto ) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<SUATCHIEU_DTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
              String sql="select SUATCHIEU.* from SUATCHIEU,PHONG_SUATCHIEU where SUATCHIEU.MASC=PHONG_SUATCHIEU.MASC AND PHONG_SUATCHIEU.MAPC=?  ";
            PreparedStatement ps=a.prepareStatement(sql);
           

            
            ps.setString(1, dto.MAPC);
           rs=ps.executeQuery();
           System.out.print("lay danh sach   thanh cong ");
          
            
            
            
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.print("\n Danh sach suat chieu");
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
                    SUATCHIEU_DTO suat=new SUATCHIEU_DTO();
               suat.setMASC(rs.getString("MAPHIM"));
               suat.setCACHIEU(rs.getInt("CACHIEU"));
               suat.setGioBD(rs.getString("GIOBD"));
               suat.setGioKT(rs.getString("GIOKT"));
               suat.setNgayChieu(rs.getString("NGAYCHIEU"));
               list.add(suat);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
         
        
        return list;
    }
    public void xoaphongsuatchieu(PHONG_SUATCHIEU_DTO sc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHONG_SUATCHIEU_DTO WHERE MASC = ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,sc.MASC );
           ps.executeUpdate();
           System.out.print("xoa suat chieu thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
