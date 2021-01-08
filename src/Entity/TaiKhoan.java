/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Util.MD5Lib;

/**
 *
 * @author Carvin
 */
public class TaiKhoan implements java.io.Serializable{

    private int id;
    private String tentaikhoan;
    private String matkhau;
    private int chucvu;
    //Các phương thức khởi tạo, get, set.
    public TaiKhoan() {
        this.id = 0;
        this.tentaikhoan = "";
        this.matkhau = "";
        this.chucvu = 0;
    }
    public TaiKhoan(String tentk,String matkhau) {
        this.id = 0;
        this.tentaikhoan = tentk;
        this.matkhau = MD5Lib.md5(matkhau);
        this.chucvu = 1;
    }
     public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void settentaikhoan(String tentaikhoan ) {
        this.tentaikhoan = tentaikhoan;
    }

    public String gettentaikhoan() {
        return tentaikhoan;
    }
    
    public void setmatkhau(String matkhau ) {
        this.matkhau = matkhau;
    }

    public String getmatkhau() {
        return matkhau;
    }
    
    public void setchucvu(int chucvu ) {
        this.chucvu = chucvu;
    }

    public int getchucvu() {
        return chucvu;
    }
}
