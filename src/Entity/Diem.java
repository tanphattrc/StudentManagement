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

public class Diem implements java.io.Serializable{
    private int id;
    private String mahocsinh;
    private String mamonhoc;
    private String mahocky;
    private String malop;
    private Float diemtbmon;
    private Float diemmieng1;
    private Float diemmieng2;
    private Float diemmieng3;
    private Float diem15ph1;
    private Float diem15ph2;
    private Float diem15ph3;
    private Float diem1tiet1;
    private Float diem1tiet2;
    private Float diem1tiet3;
    private Float diemhocky;
    public Float getDiemhocky() {
		return diemhocky;
	}

	public void setDiemhocky(Float diemhocky) {
		this.diemhocky = diemhocky;
	}

	public Diem() {
      
        
    }
	
	
    
    public Diem( String mahocsinh, String mamonhoc, String mahocky, String malop, Float diemtbmon,
			Float diemmieng1, Float diemmieng2, Float diemmieng3, Float diem15ph1, Float diem15ph2, Float diem15ph3,
			Float diem1tiet1, Float diem1tiet2, Float diem1tiet3, Float diemhocky) {
		this.mahocsinh = mahocsinh;
		this.mamonhoc = mamonhoc;
		this.mahocky = mahocky;
		this.malop = malop;
		this.diemtbmon = diemtbmon;
		this.diemmieng1 = diemmieng1;
		this.diemmieng2 = diemmieng2;
		this.diemmieng3 = diemmieng3;
		this.diem15ph1 = diem15ph1;
		this.diem15ph2 = diem15ph2;
		this.diem15ph3 = diem15ph3;
		this.diem1tiet1 = diem1tiet1;
		this.diem1tiet2 = diem1tiet2;
		this.diem1tiet3 = diem1tiet3;
		this.diemhocky = diemhocky;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMahocsinh() {
		return mahocsinh;
	}

	public void setMahocsinh(String mahocsinh) {
		this.mahocsinh = mahocsinh;
	}

	public String getMamonhoc() {
		return mamonhoc;
	}

	public void setMamonhoc(String mamonhoc) {
		this.mamonhoc = mamonhoc;
	}

	public String getMahocky() {
		return mahocky;
	}

	public void setMahocky(String mahocky) {
		this.mahocky = mahocky;
	}

	public String getMalop() {
		return malop;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public Float getDiemtbmon() {
		return diemtbmon;
	}

	public void setDiemtbmon(Float diemtbmon) {
		this.diemtbmon = diemtbmon;
	}

	public Float getDiemmieng1() {
		return diemmieng1;
	}

	public void setDiemmieng1(Float diemmieng1) {
		this.diemmieng1 = diemmieng1;
	}

	public Float getDiemmieng2() {
		return diemmieng2;
	}

	public void setDiemmieng2(Float diemmieng2) {
		this.diemmieng2 = diemmieng2;
	}

	public Float getDiemmieng3() {
		return diemmieng3;
	}

	public void setDiemmieng3(Float diemmieng3) {
		this.diemmieng3 = diemmieng3;
	}

	public Float getDiem15ph1() {
		return diem15ph1;
	}

	public void setDiem15ph1(Float diem15ph1) {
		this.diem15ph1 = diem15ph1;
	}

	public Float getDiem15ph2() {
		return diem15ph2;
	}

	public void setDiem15ph2(Float diem15ph2) {
		this.diem15ph2 = diem15ph2;
	}

	public Float getDiem15ph3() {
		return diem15ph3;
	}

	public void setDiem15ph3(Float diem15ph3) {
		this.diem15ph3 = diem15ph3;
	}

	public Float getDiem1tiet1() {
		return diem1tiet1;
	}

	public void setDiem1tiet1(Float diem1tiet1) {
		this.diem1tiet1 = diem1tiet1;
	}

	public Float getDiem1tiet2() {
		return diem1tiet2;
	}

	public void setDiem1tiet2(Float diem1tiet2) {
		this.diem1tiet2 = diem1tiet2;
	}

	public Float getDiem1tiet3() {
		return diem1tiet3;
	}

	public void setDiem1tiet3(Float diem1tiet3) {
		this.diem1tiet3 = diem1tiet3;
	}


   
}
