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
public class Khoi {
    private int id;
    private String tenkhoi;
    private int sisotoida;
    public Khoi() {
        this.id = 0;
        this.tenkhoi = ""; 
        this.sisotoida = 40;
    }
    public Khoi(int id,String tenkhoi, int sisotoida) {
        this.id = id;
        this.tenkhoi = tenkhoi; 
        this.sisotoida = sisotoida;
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
     public void settenkhoi(String tenkhoi ) {
        this.tenkhoi = tenkhoi;
    }

    public String gettenkhoi() {
        return tenkhoi;
    }
    
    public void setsisotoida(int sisotoida ) {
        this.sisotoida = sisotoida;
    }

    public int getsisotoida() {
        return sisotoida;
    }
}
