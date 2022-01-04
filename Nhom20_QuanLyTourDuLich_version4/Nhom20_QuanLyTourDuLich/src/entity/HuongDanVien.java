package entity;

import java.util.Date;

public class HuongDanVien {
	private String maHuongDanVien;
	private String tenHuongDanVien;
	private String email;
	private String diaChi;
	private String soDT;
	private Date ngayVaoLam;
	private String cmnd;
	private boolean gioiTinh;
	private boolean tinhTrang;
	
	
	
	public HuongDanVien(String maHuongDanVien) {
		super();
		this.maHuongDanVien = maHuongDanVien;
	}
	public HuongDanVien(String maHuongDanVien, String tenHuongDanVien, String email, String diaChi, String soDT,
			Date ngayVaoLam, String cmnd, boolean gioiTinh, boolean tinhTrang) {
		super();
		this.maHuongDanVien = maHuongDanVien;
		this.tenHuongDanVien = tenHuongDanVien;
		this.email = email;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.ngayVaoLam = ngayVaoLam;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
		this.tinhTrang = tinhTrang;
	}
	public HuongDanVien(String ma, String ten, String email2, String diachi2, String sodt2, String cmnd2,
			java.sql.Date ngayVaoLam2, boolean tinhTrang2, boolean gioiTinh2) {
		// TODO Auto-generated constructor stub
	}
	public String getMaHuongDanVien() {
		return maHuongDanVien;
	}
	public void setMaHuongDanVien(String maHuongDanVien) {
		this.maHuongDanVien = maHuongDanVien;
	}
	public String getTenHuongDanVien() {
		return tenHuongDanVien;
	}
	public void setTenHuongDanVien(String tenHuongDanVien) {
		this.tenHuongDanVien = tenHuongDanVien;
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
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
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
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	
}
