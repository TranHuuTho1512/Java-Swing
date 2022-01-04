package entity;

import java.sql.Date;


public class Ve {
	private String maVe;
	private Date ngayDatVe;
	Tour tour;
	KhachHang khachhang;
	NhanVien nhanvien;
	public Ve(String maVe, Date ngayDatVe, Tour tour, KhachHang khachhang,NhanVien nhanvien) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.tour = tour;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
	}
	public Ve(String maVe, Date ngayDatVe, KhachHang khachHang, NhanVien nhanVien, Tour tour) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.nhanvien = nhanVien;
		this.khachhang = khachHang;
		this.tour = tour;
	}
	public Ve(String maVe, Date ngayDatVe, Tour tour, KhachHang kh) {
		super();
		this.maVe = maVe;
		this.ngayDatVe = ngayDatVe;
		this.tour = tour;
		this.khachhang = kh; // Sá»­a chá»— nÃ y
	}
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public Date getNgayDatVe() {
		return ngayDatVe;
	}
	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	
	
	
}
