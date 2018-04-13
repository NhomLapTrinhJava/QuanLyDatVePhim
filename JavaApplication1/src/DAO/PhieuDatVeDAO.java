/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.Sqlconnect;
import DTO.PhimDTO;
import DTO.PhieuDatVeDTO;
import DTO.RapDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhieuDatVeDAO {
   public static Connection a;
   public static ResultSet rs;
   public static  Sqlconnect sqlcn;
    public void themmotphieudat(PhieuDatVeDTO phieu) throws ClassNotFoundException 
    {
           sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="insert into PHIEUDATVE values(?,?,?,?,?,?)";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phieu.MAPDV );
           ps.setInt(2, phieu.SLVE);
           ps.setDate(3,Date.valueOf(LocalDate.now()));
           ps.setString(4, phieu.TINHTRANG);
           ps.setString(5, phieu.MAKH);
           ps.setString(6, "1");
           ps.executeUpdate();
           System.out.print("them phieu dat thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      public List<PhieuDatVeDTO> laydanhsachphieudatve() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhieuDatVeDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHIEUDATVE");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
         System.out.print("\n Danh sach Phieu Dat Ve");
        try {
          
            while(rs.next())
            {

                  PhieuDatVeDTO phieudat=new PhieuDatVeDTO();
               phieudat.setMAPDV(rs.getString("MAPDV"));
                phieudat.setSLVE(rs.getInt("SLVE"));
                phieudat.setGIODV(rs.getDate("GIODV"));
              phieudat.setTINHTRANG(rs.getString("TINHTRANG"));
                 phieudat.setMAKH(rs.getString("MAKH"));
                  phieudat.setMANV(rs.getString("MANV"));
               
               list.add(phieudat);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao phieu dat ve ");
            
        }
         
        
        return list;
    }
     
      public void xoaphieudat(PhieuDatVeDTO phieudatve) throws ClassNotFoundException 
    {
        
           sqlcn=new Sqlconnect();

        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="DELETE PHIEUDATVE WHERE PHIEUDATVE.MAPDV= ?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setString(1,phieudatve.MAPDV );
           ps.executeUpdate();
           System.out.print("xoa bo phieu dat ve thanh cong ");
            
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     public void capnhatphieudatve(PhieuDatVeDTO phieudatve) throws ClassNotFoundException 
    {
           sqlcn=new Sqlconnect();
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            String sql="UPDATE PHIEUDATVE SET SLVE=?, GIODV=?, TINHTRANG=?,MAKH=?,MANV=? WHERE MAPDV =?";
            PreparedStatement ps=a.prepareStatement(sql);
           ps.setInt(1,phieudatve.getSLVE());
     
           ps.setDate(2, phieudatve.getGIODV());
           ps.setString(3, phieudatve.getTINHTRANG());
           ps.setString(4, phieudatve.getMAKH());
           ps.setString(5,phieudatve.getMANV());
                ps.setString(6, phieudatve.getMAPDV());
           ps.executeUpdate();
           System.out.print("cap nhat phieu dat ve thanh cong ");
        } catch (SQLException ex) {
          Logger.getLogger(PhimDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
        public ResultSet lapbaocaophieudatve() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<PhieuDatVeDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select * from PHIEUDATVE");
             System.out.print("truy van thanh cong ");
            
        } catch (SQLException ex) {
           System.out.print("loi khong the thuc hien truy van ");
        }
        
         
        
        return rs;
    }
}
