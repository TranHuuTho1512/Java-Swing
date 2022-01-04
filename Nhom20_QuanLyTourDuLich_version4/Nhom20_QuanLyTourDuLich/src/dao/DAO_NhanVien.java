package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import connectDB.ConnectDB;
import entity.DiaDanh;
import entity.HuongDanVien;
import entity.LoaiTour;
import entity.NhanVien;
import entity.Tour;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class DAO_NhanVien {
	@SuppressWarnings("unused")
	private int n;
	@SuppressWarnings("unused")
	private ArrayList<entity.NhanVien> listNhanVien;
	private ArrayList<String> list_MaNV;
	public DAO_NhanVien() {
		list_MaNV = new ArrayList<String>();
	}
	public NhanVien LayNhanVienTheoMa(String mnv) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where maNV = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mnv);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString(1);
				String tenNhanVien = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				Date ngayVaoLam = rs.getDate(7);
				String cmnd = rs.getString(6);
				boolean gioiTinh = rs.getBoolean(9);
				boolean tinhTrang = rs.getBoolean(8);
				
				NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, email, diaChi,
						soDT,cmnd,ngayVaoLam,  gioiTinh, tinhTrang);
				
				
				return nv;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public DefaultTableModel getAllNV() throws SQLException {
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","Email","Địa Chỉ","Số Điện Thoại","CMND","Ngày Vào Làm","GioiTinh","TinhTrang"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT *from NhanVien\r\n"; 
	
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	public boolean themNV(NhanVien nv){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into nhanVien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getEmail());
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(5, nv.getSoDienThoai());
			stmt.setString(6, nv.getCmnd());
			stmt.setDate(7, (Date) nv.getNgayVaoLam());
			stmt.setBoolean(8, nv.isGioiTinh());
			stmt.setBoolean(9, nv.isTinhTrang());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean update(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement(
					"update nhanVien set tenNV=?,CMND=?,diaChi=?,email=?"
					+ ",soDT=?,ngayVaoLam=?,gioiTinh=?,tinhTrang=? where maNV=?");
			
			stmt.setString(1, nv.getTenNV());
			stmt.setString(5, nv.getCmnd());
			
			stmt.setString(4, nv.getDiaChi());
			stmt.setString(2, nv.getEmail());
			stmt.setString(3, nv.getSoDienThoai());
			
			stmt.setDate(6, (Date) nv.getNgayVaoLam());
			stmt.setBoolean(7, nv.isGioiTinh());
			stmt.setBoolean(8, nv.isTinhTrang());
			stmt.setString(9, nv.getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	
		}
		return n > 0;
	}
	public ArrayList<String> getListMaNV(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maNV from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String CMND;
				CMND = rs.getString(1);
				list_MaNV.add(CMND);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return list_MaNV;
	}

	public NhanVien getNhanVienbyHDId(String properties,String ma) {
		Connection con = ConnectDB.getConnection();
		String sql = "select * from NhanVien where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),rs.getString(6),rs.getString(3),rs.getString(5), rs.getString(4) ,rs.getBoolean(8),rs.getBoolean(9),rs.getDate(7));
				return nv;	
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	public NhanVien getNhanVienById(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
//	public DefaultTableModel getAllOrderById(  String maNV) throws SQLException {
//	
//		
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getCon();
//		String sql = "select *"
//				+ " from  NhanVien "
//				+ "where   maNV like '%" + maNV + "%' " ;
//				
//		Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//		
//			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9)};
//			
//		}
//		return null;
//		
//	}
	public DefaultTableModel timKiem(String cmnd,String ma) throws SQLException {
		String[] header=  {"Mã Nhân Viên","Tên Nhân Viên","CMND","Ngày Sinh","Giới Tính","Địa Chỉ","Email","Số Điện Thoại","Ngày Vào Làm","Tình Trạng"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * from NhanVien  where CMND like '"+cmnd+"' or maNV like '"+ma+"'";
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
}
