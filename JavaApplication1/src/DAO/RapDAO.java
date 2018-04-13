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
   
   
   public String LayMaRap(String TenRap) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
        
       
      String marap = ""; 
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from RAP where TenRap = '" + TenRap + "'");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
        try {
          
            while(rs.next())
            {
                
                 
             
                marap =  rs.getString("MARAP");
               
            
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return marap;
    }
   
   
   public String LayTenRap(String MaRap) throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
        
       
      String tenrap = ""; 
     
     
        try {
              a =sqlcn.getSQLServerConnection();
        
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from RAP where MaRap = '" + MaRap + "'");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach ");
        try {
          
            while(rs.next())
            {
                
                 
             
                tenrap =  rs.getString("TENRAP");
               
            
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao ");
            
        }
         
        
        return tenrap;
    }
      
    
   
   public String PhatSinhMaRap() throws SQLException, ClassNotFoundException
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
            rs=statement.executeQuery("select top 1 * from RAP order by MaRap desc");
            while(rs.next())
            {
              ma = rs.getString("MARAP");
            }
            
            if(ma == "")
            {
                    ma = "R/0" +  1;
                    return ma;
            }
                 
            
            String[] split = ma.split("/");
            String  m = split[1].toString().trim();
            int n = Integer.parseInt(m);
            if(n < 9)
            {
                n = n + 1;
                ma = "R/0" +  n;
                
            }
            else
            {
                 n = n + 1;
                ma = "R/" +  n;
            }
         return  ma;
   } 
   
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
