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
public class PhanQuyen implements java.io.Serializable{
    private int id;
    private String tenchucvu;

    //Các phương thức khởi tạo, get, set.
    public PhanQuyen() {
        this.id = 0;
        this.tenchucvu = "";
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void settenchucvu(String tenchucvu ) {
        this.tenchucvu = tenchucvu;
    }

    public String gettenchucvu() {
        return tenchucvu;
    }
}
