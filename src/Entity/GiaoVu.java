/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Carvin
 */
public class GiaoVu {
    private int id;
    private float diemchuandatmon;
    private int tuoitoida;
    private int tuoitoithieu;
    public GiaoVu() {
        this.id = 0;
        this.tuoitoida = 0; 
        this.tuoitoithieu = 0;
        this.diemchuandatmon = 0;
    }
    
     public GiaoVu(float dcdm, int ttd, int ttt) {
        this.tuoitoida = ttd; 
        this.tuoitoithieu = ttt;
        this.diemchuandatmon = dcdm;
    }
     
      public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void settuoitoida(int tuoitoida ) {
        this.tuoitoida = tuoitoida;
    }

    public int gettuoitoida() {
        return tuoitoida;
    }
    
    public void settuoitoithieu(int tuoitoithieu ) {
        this.tuoitoithieu = tuoitoithieu;
    }

    public int gettuoitoithieu() {
        return tuoitoithieu;
    }
    
    public void setdiemchuandatmon(float diemchuandatmon ) {
        this.diemchuandatmon = diemchuandatmon;
    }

    public float getdiemchuandatmon() {
        return diemchuandatmon;
    }
    
}
