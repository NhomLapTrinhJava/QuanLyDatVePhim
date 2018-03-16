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
}
