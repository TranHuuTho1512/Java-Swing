package entity;

public class DiaDanh {
	private String maDiaDanh;
	private String tenDiaDanh;
	private String moTa;
	private String tinhThanh;
	public DiaDanh() {
		
	}
	public DiaDanh(String maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}
	public DiaDanh(String maDiaDanh, String tenDiaDanh, String moTa, String tinhThanh) {
		super();
		this.maDiaDanh = maDiaDanh;
		this.tenDiaDanh = tenDiaDanh;
		this.moTa = moTa;
		this.tinhThanh = tinhThanh;
	}
	public String getMaDiaDanh() {
		return maDiaDanh;
	}
	public void setMaDiaDanh(String maDiaDanh) {
		this.maDiaDanh = maDiaDanh;
	}
	public String getTenDiaDanh() {
		return tenDiaDanh;
	}
	public void setTenDiaDanh(String tenDiaDanh) {
		this.tenDiaDanh = tenDiaDanh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getTinhThanh() {
		return tinhThanh;
	}
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDiaDanh == null) ? 0 : maDiaDanh.hashCode());
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
		DiaDanh other = (DiaDanh) obj;
		if (maDiaDanh == null) {
			if (other.maDiaDanh != null)
				return false;
		} else if (!maDiaDanh.equals(other.maDiaDanh))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return tenDiaDanh;
	}
	
	
}
