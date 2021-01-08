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
public class HocKy implements java.io.Serializable{
    private int id;
    private String tenhocky;
    private String mahocky;
    
    public String getNamhoc()
    {
    	String hocky=gettenhocky();
    	String hocky1 = hocky.substring(9, 13)+"_" ;
        String hocky2 = hocky.substring(16, 20);
        hocky = hocky1.concat(hocky2);
    	return hocky;
    };
    public HocKy() {
        this.id = 0;
        this.tenhocky = ""; 
        this.mahocky = "";
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
     public void setmahocky(String mahocky ) {
        this.mahocky = mahocky;
    }

    public String getmahocky() {
        return mahocky;
    }
    
    public void settenhocky(String tenhocky ) {
        this.tenhocky = tenhocky;
    }

    public String gettenhocky() {
        return tenhocky;
    }
    
}
