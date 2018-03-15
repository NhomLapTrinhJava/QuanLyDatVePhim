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
import DTO.PhimDTO;
import DTO.RapDTO;
import java.util.List;
/**
 *
 * @author abcd
 */
public class PhimDAO {
     public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
    public void themmotphim(PhimDTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PHIM values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.MAPHIM );
           ps.setString(2, phim.TENPHIM);
           ps.setInt(3,phim.NAMSX);
           ps.setString(4, phim.HANGPHIM);
           ps.setInt(5, phim.THOILUONG);
           ps.setString(6, phim.MOTA);
           ps.setString(7,"");
           ps.setString(8,"");
           ps.setString(9, "");
           ps.executeUpdate();
           System.out.print("them bo phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public List<PhimDTO> laydanhsachphim() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhimDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHIM");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach Hoc Sinh");
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
                  PhimDTO phim=new PhimDTO();
               phim.setMAPHIM(rs.getString("MAPHIM"));
               phim.setTENPHIM(rs.getString("TENPHIM"));
                phim.setNAMSX(rs.getInt("NAMSX"));
               phim.setHANGPHIM(rs.getString("HANGPHIM"));
                 phim.setTHOILUONG(rs.getInt("THOILUONG"));
                   phim.setMOTA(rs.getString("MOTA"));
               list.add(phim);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao hoc sinh ");
            
        }
         
        
        return list;
    }
     public List<PhimDTO> laydanhsachphimrap(RapDTO rap) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhimDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            PreparedStatement statement = a.prepareStatement("select PHIM.MAPHIM,PHIM.TENPHIM,PHIM.NAMSX,PHIM.HANGPHIM,PHIM.THOILUONG,PHIM.MOTA from PHIM,PHIM_RAP where PHIM.MAPHIM=PHIM_RAP.MAPHIM AND PHIM_RAP.MARAP LIKE ?");
            statement.setString(1, rap.MARAP);
            rs=statement.executeQuery();
            
            
            
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.print("\n Danh sach Hoc Sinh");
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
                  PhimDTO phim=new PhimDTO();
               phim.setMAPHIM(rs.getString("MAPHIM"));
               phim.setTENPHIM(rs.getString("TENPHIM"));
                phim.setNAMSX(rs.getInt("NAMSX"));
               phim.setHANGPHIM(rs.getString("HANGPHIM"));
                 phim.setTHOILUONG(rs.getInt("THOILUONG"));
                   phim.setMOTA(rs.getString("MOTA"));
               list.add(phim);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
         
        
        return list;
    }
      public void xoaphim(PhimDTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHIM WHERE PHIM.MAPHIM= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.MAPHIM );
           ps.executeUpdate();
           System.out.print("xoa bo phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatphim(PhimDTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE PHIM SET TENPHIM=?,NAMSX=?,HANGPHIM=?,THOILUONG=?,MOTA=? WHERE MAPHIM =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.getTENPHIM() );
           ps.setInt(2, phim.getNAMSX());
           ps.setString(3, phim.getHANGPHIM());
           ps.setInt(4, phim.getTHOILUONG());
           ps.setString(5, phim.getMOTA());
           ps.setString(6,phim.getMAPHIM());
           ps.executeUpdate();
           System.out.print("cap nhat bo phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
