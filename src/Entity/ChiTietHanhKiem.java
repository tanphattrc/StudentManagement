package Entity;

public class ChiTietHanhKiem {
	   private int id;
	   private int mahanhkiem;
	   private String mahocsinh;
	   private String malop;
	   public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	private String mahocky;
	   public ChiTietHanhKiem()
	   {
		   
	   }
	   public ChiTietHanhKiem(int mahanhkiem,String mahocsinh)
	   {
		   this.mahanhkiem=mahanhkiem;
		   this.mahocsinh=mahocsinh;
	   }
	   public ChiTietHanhKiem(int mahanhkiem,String mahocsinh,String malop,String mahocky)
	   {
		   this.mahanhkiem=mahanhkiem;
		   this.mahocsinh=mahocsinh;
		   this.malop=malop;
		   this.mahocky=mahocky;
	   }
	public String getMahocky() {
		return mahocky;
	}
	public void setMahocky(String mahocky) {
		this.mahocky = mahocky;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMahanhkiem() {
		return mahanhkiem;
	}
	public void setMahanhkiem(int mahanhkiem) {
		this.mahanhkiem = mahanhkiem;
	}
	public String getMahocsinh() {
		return mahocsinh;
	}
	public void setMahocsinh(String mahocsinh) {
		this.mahocsinh = mahocsinh;
	}
}
