package entity;

import java.util.Date;

public class NhanVien {
	private String maNV,tenNV,cmnd,email,soDienThoai,diaChi;
	private boolean gioiTinh,tinhTrang;
	private Date ngayVaoLam;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
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
	
	public NhanVien(String maNV, String cmnd) {
		super();
		this.maNV = maNV;
		this.cmnd = cmnd;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", cmnd=" + cmnd + ", email=" + email + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", tinhTrang=" + tinhTrang
				+ ", ngayVaoLam=" + ngayVaoLam + "]";
	}
	public NhanVien getNhanVien() {
		// TODO Auto-generated method stub
		return null;
	}
	public NhanVien(String maNV, String tenNV,String email,String diaChi,String soDienThoai,String cmnd, 
			 Date ngayVaoLam,boolean gioiTinh, boolean tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.cmnd = cmnd;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.tinhTrang = tinhTrang;
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVien(String tenNV) {
		super();
		this.tenNV = tenNV;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, String email2, String diaChi2, String soDT, String cmnd2,
			boolean gioiTinh2, boolean tinhTrang2, java.sql.Date ngayVaoLam2) {
		// TODO Auto-generated constructor stub
	}

}