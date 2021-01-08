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
public class HanhKiem implements java.io.Serializable{
    private int id;
    private String tenhanhkiem;
    
 
    public HanhKiem() {
        this.id = 0;
        this.tenhanhkiem = ""; 
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    
    
    public void settenhanhkiem(String tenhanhkiem ) {
        this.tenhanhkiem = tenhanhkiem;
    }

    public String gettenhanhkiem() {
        return tenhanhkiem;
    }
    
}
