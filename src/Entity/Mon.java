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
public class Mon implements java.io.Serializable{
    private int id;
    private String tenmon;
    private String hesomon;
    private String mamon;
    
    public Mon() {
        this.id = 0;
        this.tenmon = "";
        this.hesomon = "";
        this.mamon = "";
    }
    public Mon(String mamon, String tenmon) {
        this.tenmon = tenmon;
        this.hesomon = "10";
        this.mamon = mamon;
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void settenmon(String tenmon ) {
        this.tenmon = tenmon;
    }

    public String gettenmon() {
        return tenmon;
    }
    
    public void sethesomon(String hesomon ) {
        this.hesomon = hesomon;
    }

    public String gethesomon() {
        return hesomon;
    }
    
    public void setmamon(String mamon ) {
        this.mamon = mamon;
    }

    public String getmamon() {
        return mamon;
    }
}
