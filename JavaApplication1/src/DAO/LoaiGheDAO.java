/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import DTO.LoaiGheDTO;
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
public class LoaiGheDAO {
        public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
   
    public List<LoaiGheDTO> laydanhLoaiGhe() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<LoaiGheDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from LOAIGHE");
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
                  LoaiGheDTO LoaiGhe=new LoaiGheDTO();
               LoaiGhe.setMALG(rs.getString("MALG"));
                LoaiGhe.setTENLG(rs.getString("TENLG"));
              
               list.add(LoaiGhe);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return list;
    }
    
    
      public void themLoaiGhe(LoaiGheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into LoaiGhe(MALG,TENLG) values(?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMALG());
           ps.setString(2, pc.getTENLG());
         
    
        
           ps.executeUpdate();
           System.out.print("Đã Thêm Thành Công");
            
        } catch (SQLException ex) {
          Logger.getLogger(LoaiGheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
      public void xoaLoaiGhe(LoaiGheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE LoaiGhe  WHERE MALG= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMALG());
           ps.executeUpdate();
           System.out.print("Đã xóa thành công  " + pc.getMALG());
          
           
        } catch (SQLException ex) {
          Logger.getLogger(LoaiGheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatLoaiGhe(LoaiGheDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE LoaiGhe SET TENLG=? WHERE MALG =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getTENLG());
         
            ps.setString(3, pc.getMALG());
         
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(LoaiGheDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
