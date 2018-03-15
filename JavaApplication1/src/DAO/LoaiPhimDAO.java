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
import DTO.LoaiPhimDTO;
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
public class LoaiPhimDAO {
      public static Connection a;
    public static ResultSet rs;
   public static  Sqlconnect sqlcn;
   
     public List<LoaiPhimDTO> laydanhsachloaiphim() throws ClassNotFoundException 
    {
         sqlcn=new Sqlconnect();
     
         List<LoaiPhimDTO> list=new ArrayList();
     
      
     
     
        try {
              a =sqlcn.getSQLServerConnection();
           System.out.print("ket noi thanh cong ");
             
            
        } catch (SQLException ex) {
             System.out.print("khong the ket noi den SQLserver ");
             
        }
        try {
            Statement statement = a.createStatement();
            rs=statement.executeQuery("select MALOAI,TENLOAI from LOAIPHIM");
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
                  LoaiPhimDTO lpm=new LoaiPhimDTO();
                  lpm.setMALOAI(rs.getString("MALOAI"));
               lpm.setTENLOAI(rs.getString("TENLOAI"));
               list.add(lpm);
               
            }
        } catch (SQLException ex) {
            System.out.print("loi khong the khoi tao hoc sinh ");
            
        }
         
        
        return list;
    }
}
