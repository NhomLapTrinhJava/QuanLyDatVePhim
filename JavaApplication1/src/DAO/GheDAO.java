/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import DTO.GheDTO;
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
public class GheDAO {
        public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
   
    public List<GheDTO> laydanhsachghe() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<GheDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from Ghe");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
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
                  GheDTO ghe=new GheDTO();
               ghe.setMAGHE(rs.getString("MAGHE"));
                ghe.setMALG(rs.getString("MALG"));
                ghe.setMAPC(rs.getString("MAPC"));
                ghe.setVITRI(rs.getString("VITRI"));
                ghe.setTINHTRANG(rs.getString("TINHTRANG"));
               list.add(ghe);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return list;
    }
    
    
      public void themGhe(GheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into Ghe(MaGhe,MALG,MAPC,VITRI,TINHTRANG) values(?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMAGHE());
           ps.setString(2, pc.getMALG());
           ps.setString(3,pc.getMAPC());
            ps.setString(4, pc.getVITRI());
           ps.setString(5,pc.getTINHTRANG());
    
        
           ps.executeUpdate();
           System.out.print("Đã Thêm Thành Công");
            
        } catch (SQLException ex) {
          Logger.getLogger(GheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
      public void xoaGhe(GheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE Ghe  WHERE MAGHE= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMAGHE());
           ps.executeUpdate();
           System.out.print("Đã xóa thành công  " + pc.getMAGHE());
          
           
        } catch (SQLException ex) {
          Logger.getLogger(GheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatGhe(GheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE Ghe SET MALG=?,MAPC=?,VITRI=?,TINHTRANG=? WHERE MaGhe =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMALG());
           ps.setString(2, pc.getMAPC());
            ps.setString(3, pc.getMAGHE());
             ps.setString(4, pc.getVITRI());
            ps.setString(5, pc.getTINHTRANG());
         
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(GheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
