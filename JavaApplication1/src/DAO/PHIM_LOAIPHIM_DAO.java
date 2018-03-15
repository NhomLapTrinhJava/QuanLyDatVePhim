/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import static DAO.NhanVienDAO.a;
import static DAO.NhanVienDAO.rs;
import static DAO.PhimDAO.a;
import static DAO.PhimDAO.rs;
import static DAO.PhimDAO.sqlcn;
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
import DTO.PHIM_LOAIPHIM_DTO;
import DTO.PhimDTO;
import java.util.List;
/**
 *
 * @author abcd
 */
public class PHIM_LOAIPHIM_DAO {
       public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
   public void them(PHIM_LOAIPHIM_DTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PHIM_LOAIPHIM values(?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.MAPHIM );
           ps.setString(2, phim.TENLOAI);
      
           ps.executeUpdate();
           System.out.print("them bo loai phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public List<PHIM_LOAIPHIM_DTO> laydanhsachphimloaiphim( ) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PHIM_LOAIPHIM_DTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
             Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHIM_LOAIPHIM");
          
            
            
            
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
                  PHIM_LOAIPHIM_DTO phimdto=new PHIM_LOAIPHIM_DTO();
               phimdto.setMAPHIM(rs.getString("MAPHIM"));
               phimdto.setTENLOAI(rs.getString("TENLOAI"));
               
               list.add(phimdto);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
         
        
        return list;
    }
    public void xoaphimloaiphim(PHIM_LOAIPHIM_DTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHIM_LOAIPHIM WHERE MAPHIM = ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.MAPHIM );
           ps.executeUpdate();
           System.out.print("xoa bo phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       public void capnhatphimloaiphim(PHIM_LOAIPHIM_DTO phim) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE PHIM_LOAIPHIM SET TENLOAI = ? WHERE MAPHIM = ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phim.TENLOAI );
           ps.setString(2,phim.MAPHIM );
           ps.executeUpdate();
           System.out.print("xoa bo phim thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
