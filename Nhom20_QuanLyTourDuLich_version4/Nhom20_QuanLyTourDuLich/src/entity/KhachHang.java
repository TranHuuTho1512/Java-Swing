package entity;

import java.sql.Date;

public class KhachHang {
	private String maKH,tenKH,email,diaChi,soDT,cmnd;
	private boolean gioiTinh;
	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", email=" + email + ", diaChi=" + diaChi + ", soDT="
				+ soDT + ", cmnd=" + cmnd + ", gioiTinh=" + gioiTinh + "]";
	}

	public KhachHang(String maKH, String tenKH, String email, String diaChi, String soDT, String cmnd,
			boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
	}
	public KhachHang(String tenKH) {
		super();
		this.tenKH = tenKH;
		
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
}
