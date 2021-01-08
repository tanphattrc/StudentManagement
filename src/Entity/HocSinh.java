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
public class HocSinh implements java.io.Serializable{
    private int id;
    private String ten;
    private String ngaysinh;
    private String gioitinh;
    private String diachi;
    private String email;
    private String lop;
    private String mahocsinh;
    private String nienkhoa;
    
    public String getNienkhoa() {
		return nienkhoa;
	}

	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}

	public HocSinh() {
        this.id = 0;
        this.ten = "";
        this.ngaysinh = "";
        this.gioitinh = "";
        this.diachi = "";
        this.email = "";
        this.lop = "";
        this.mahocsinh = "";  
    }
    
    public HocSinh(String ten,String ngaysinh,String gioitinh,String diachi,String email,String lop,String mahocsinh) {
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
        this.lop = lop;
        this.mahocsinh = mahocsinh;  
    }
    
    public HocSinh(String ten,String ngaysinh,String gioitinh,String diachi,String email,String lop,String mahocsinh,String nienkhoa) {
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email = email;
        this.lop = lop;
        this.mahocsinh = mahocsinh;  
        this.nienkhoa=nienkhoa;
    }
    public void setid(int id ) {
        this.id = id;
    }

    public int getid() {
        return id;
    }
    
    public void setten(String ten ) {
        this.ten = ten;
    }

    public String getten() {
        return ten;
    }
    
    public void setngaysinh(String ngaysinh ) {
        this.ngaysinh = ngaysinh;
    }

    public String getngaysinh() {
        return ngaysinh;
    }
    
    public void setgioitinh(String gioitinh ) {
        this.gioitinh = gioitinh;
    }

    public String getgioitinh() {
        return gioitinh;
    }
    
    public void setdiachi(String diachi ) {
        this.diachi = diachi;
    }

    public String getdiachi() {
        return diachi;
    }
    
     public void setemail(String email ) {
        this.email = email;
    }

    public String getemail() {
        return email;
    }
    
      public void setlop(String lop ) {
        this.lop = lop;
    }

    public String getlop() {
        return lop;
    }
    
      public void setmahocsinh(String mahocsinh ) {
        this.mahocsinh = mahocsinh;
    }

    public String getmahocsinh() {
        return mahocsinh;
    }
}
