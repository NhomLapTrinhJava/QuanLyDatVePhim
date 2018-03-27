/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Connection.Sqlconnect;
import DTO.RapDTO;
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
public class RapDAO {
        public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
   
    public List<RapDTO> laydanhrapphim() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<RapDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from RAP");
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
                  RapDTO rap=new RapDTO();
               rap.setMARAP(rs.getString("MARAP"));
                rap.setTENRAP(rs.getString("TENRAP"));
                rap.setDIACHI(rs.getString("DIACHI"));
               list.add(rap);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return list;
    }
    
    
      public void themRap(RapDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into Rap(MaRap,TenRap,DiaChi) values(?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMARAP());
           ps.setString(2, pc.getTENRAP());
           ps.setString(3,pc.getDIACHI());
    
        
           ps.executeUpdate();
           System.out.print("Đã Thêm Thành Công");
            
        } catch (SQLException ex) {
          Logger.getLogger(RapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
      public void xoaRap(RapDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE Rap  WHERE MARAP= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getMARAP());
           ps.executeUpdate();
           System.out.print("Đã xóa thành công  " + pc.getMARAP());
          
           
        } catch (SQLException ex) {
          Logger.getLogger(RapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatRap(RapDTO pc) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();
           
      
      
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE Rap SET TenRap=?,DiaChi=? WHERE MaRap =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,pc.getTENRAP());
           ps.setString(2, pc.getDIACHI());
            ps.setString(3, pc.getMARAP());
         
           
           ps.executeUpdate();
           System.out.print("Cập nhật thành công ");
            
        } catch (SQLException ex) {
          Logger.getLogger(RapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
     
}
