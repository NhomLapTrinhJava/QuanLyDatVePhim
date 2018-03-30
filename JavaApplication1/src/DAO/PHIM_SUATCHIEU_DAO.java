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
import DTO.PHIM_SUATCHIEU_DTO;
import DTO.SUATCHIEU_DTO;
import java.util.List;
/**
 *
 * @author abcd
 */
public class PHIM_SUATCHIEU_DAO {
         public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
     public void themsuatchieu(PHIM_SUATCHIEU_DTO sc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PHIM_SUATCHIEU values(?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,sc.MAPHIM );
          
           ps.setString(2, sc.MASC);
          
           ps.executeUpdate();
           System.out.print("them suat chieu thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<SUATCHIEU_DTO> laydanhsachsuatchieu(PHIM_SUATCHIEU_DTO dto ) throws ClassNotFoundException 
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
              String sql="select SUATCHIEU.* from SUATCHIEU,PHIM_SUATCHIEU where SUATCHIEU.MASC=PHIM_SUATCHIEU.MASC AND PHIM_SUATCHIEU.MAPHIM=?  ";
            PreparedStatement ps=a.prepareStatement(sql);
           

            
            ps.setString(1, dto.MAPHIM);
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
               suat.setMASC(rs.getString("MASC"));
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
    public void xoasuatchieu(PHIM_SUATCHIEU_DTO sc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHIM_SUATCHIEU WHERE MASC = ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,sc.MASC );
           ps.executeUpdate();
           System.out.print("xoa suat chieu thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
