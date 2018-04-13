/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class PhieuDatVeDTO {
     public String getMAPDV() {
        return MAPDV;
    }

    public void setMAPDV(String MAPDV) {
        this.MAPDV = MAPDV;
    }
    
     public int getSLVE() {
        return SLVE;
    }

    public void setSLVE(int SLVE) {
        this.SLVE = SLVE;
    }
    public Date getGIODV() {
        return GIODV;
    }

    public void setGIODV(Date GIODV) {
        this.GIODV = GIODV;
    }
    
     public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }
    
     public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }
    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }
    public String MAPDV;
    public int SLVE;
    public Date GIODV;
    public String TINHTRANG;
    public String MAKH;
    public String MANV;
}
