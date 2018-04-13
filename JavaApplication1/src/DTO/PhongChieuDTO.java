/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;



/**
 *
 * @author abcd
 */
public class PhongChieuDTO {
 
    private String MAPC;
   
    
    private int SOHG;
    
  
    private int SODG;
    private String MOTA;
    private String DKKT;
    private String TINHTRANG;
    private String MARAP;
    
   
    private int SoGhe;

    public PhongChieuDTO() {
    }

    
    
    public PhongChieuDTO(String MAPC) {
        this.MAPC = MAPC;
    }

    public String getMAPC() {
        return MAPC;
    }
    
    public int getSoGhe() {
        return SoGhe;
    }

   

    public String getMOTA() {
        return MOTA;
    }
    
     public int getSOHG() {
        return SOHG;
    }
     
      public int getSODG() {
        return SODG;
    }

   
    
     public String getTinhTrang() {
        return TINHTRANG;
    }
     
      public String getMARAP() {
        return MARAP;
    }

    public void setMAPC(String MAPC) {
        this.MAPC = MAPC;
    }

 

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

   
    
     public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }
     
     public void setSoGhe(int SoGhe) {
        this.SoGhe = SoGhe;
    }
      public void setMARAP(String MARAP) {
        this.MARAP = MARAP;
    }
      
      public void setSODG(int SODG) {
        this.SODG = SODG;
    }
      public void setSOHG(int SOHG) {
        this.SOHG = SOHG;
    }
      
       public PhongChieuDTO(String MAPC, int SOHG, int SODG, String MoTa, String DKKT, String TinhTrang,String MARAP){  
           this.MAPC = MAPC;  
           this.SOHG = SOHG;  
           this.SODG = SODG;  
           this.MOTA = MoTa;  
             this.DKKT = DKKT;  
           this.TINHTRANG = TINHTRANG;  
           this.MARAP = MARAP;  
      }  
}
