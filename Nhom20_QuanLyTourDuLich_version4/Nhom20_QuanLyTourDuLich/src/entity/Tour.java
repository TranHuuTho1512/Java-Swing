package entity;

import java.sql.Date;

import entity.DiaDanh;

public class Tour {
	private String maTour;
	private String tenTour;
	private float giaTour;
	private int soLuongNguoi;
	private Date ngayKhoiHanh;
	private Date ngayKetThuc;
	private String moTa;
	private boolean tinhTrang;
	private String hinhAnh;
	private HuongDanVien huongDanVien;
	private DiaDanh diaDanh;
	private LoaiTour loaiTour;
	public Tour() {
		
		super();
	}
	public Tour(String tenTour) {
		this.tenTour = tenTour;
		
	}
	public Tour(String maTour, String tenTour, float giaTour, int soLuongNguoi, Date ngayKhoiHanh, Date ngayKetThuc,
			String moTa, boolean tinhTrang, String hinhAnh, HuongDanVien huongDanVien, DiaDanh diaDanh,
			LoaiTour loaiTour) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTour = giaTour;
		this.soLuongNguoi = soLuongNguoi;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.hinhAnh = hinhAnh;
		this.huongDanVien = huongDanVien;
		this.diaDanh = diaDanh;
		this.loaiTour = loaiTour;
	}
	public Tour(String maTour, String tenTour, float giaTour, int soLuongNguoi,
			Date ngayKhoiHanh, Date ngayKetThuc, String moTa, boolean tinhTrang, String hinhAnh, DiaDanh diaDanh) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTour = giaTour;
		this.soLuongNguoi = soLuongNguoi;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		this.moTa = moTa;
		this.tinhTrang = tinhTrang;
		this.hinhAnh = hinhAnh;
		this.diaDanh = diaDanh;
	}
	public Tour(String maTour, String tenTour, float giaTour,
			Date ngayKhoiHanh, Date ngayKetThuc) {
		super();
		this.maTour = maTour;
		this.tenTour = tenTour;
		this.giaTour = giaTour;
		this.ngayKhoiHanh = ngayKhoiHanh;
		this.ngayKetThuc = ngayKetThuc;
		
	}
	
	public Tour(String maTour, String tenTour,  double giaTour) {
		this.tenTour = tenTour;
		this.maTour = maTour;
		this.giaTour = (float) giaTour;
		this.soLuongNguoi = soLuongNguoi;
	}
	public HuongDanVien getHuongDanVien() {
		return huongDanVien;
	}
	public void setHuongDanVien(HuongDanVien huongDanVien) {
		this.huongDanVien = huongDanVien;
	}
	public LoaiTour getLoaiTour() {
		return loaiTour;
	}
	public void setLoaiTour(LoaiTour loaiTour) {
		this.loaiTour = loaiTour;
	}
	public String getMaTour() {
		return maTour;
	}
	public void setMaTour(String maTour) {
		this.maTour = maTour;
	}
	public String getTenTour() {
		return tenTour;
	}
	public void setTenTour(String tenTour) {
		this.tenTour = tenTour;
	}
	public float getGiaTour() {
		return giaTour;
	}
	public void setGiaTour(float giaTour) {
		this.giaTour = giaTour;
	}
	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}
	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}
	public Date getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(Date ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public DiaDanh getDiaDanh() {
		return diaDanh;
	}
	public void setDiaDanh(DiaDanh diaDanh) {
		this.diaDanh = diaDanh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTour == null) ? 0 : maTour.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		if (maTour == null) {
			if (other.maTour != null)
				return false;
		} else if (!maTour.equals(other.maTour))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return tenTour;
	}
	
	
	
}
