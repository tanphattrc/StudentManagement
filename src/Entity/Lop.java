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
public class Lop implements java.io.Serializable{
    private int id;
    private String tenlop;
    private int khoi;
    private int siso;
    private String malop;
    
    public Lop() {
        this.id = 0;
        this.tenlop = "";
        this.khoi =0;   
        this.siso = 0;
        this.malop = "";
    }
    public Lop(String tenlop, String malop,int khoi) {
        this.tenlop = tenlop;
        this.khoi =khoi;   
        this.siso = 0;
        this.malop = malop;
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void settenlop(String tenlop ) {
        this.tenlop = tenlop;
    }

    public String gettenlop() {
        return tenlop;
    }
    public void setkhoi(int khoi ) {
        this.khoi = khoi;
    }

    public int getkhoi() {
        return khoi;
    }
    public void setsiso(int siso ) {
        this.siso = siso;
    }

    public int getsiso() {
        return siso;
    }
      public void setmalop(String malop ) {
        this.malop = malop;
    }

    public String getmalop() {
        return malop;
    }
}
