package dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.HuongDanVien;
import entity.NhanVien;

public class DAO_HuongDanVien {
	@SuppressWarnings("unused")
	private int n;
	@SuppressWarnings("unused")
	private ArrayList<entity.HuongDanVien> listNhanVien;
	private ArrayList<String> list_MaHDV;
	public DAO_HuongDanVien() {
		list_MaHDV = new ArrayList<String>();
	}
	public ArrayList<HuongDanVien> LayToanBoHuongDanVien(){
		ArrayList<HuongDanVien> dsHuongDanVien = new ArrayList<HuongDanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HuongDanVien";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maHuongDanVien = rs.getString(1);
				String tenHuongDanVien = rs.getString(2);
				String email = rs.getString(3);
				String diaChi = rs.getString(4);
				String soDT = rs.getString(5);
				Date ngayVaoLam = rs.getDate(6);
				String cmnd = rs.getString(7);
				boolean gioiTinh = rs.getBoolean(8);
				boolean tinhTrang = rs.getBoolean(9);
				
				HuongDanVien hdv = new HuongDanVien(maHuongDanVien, tenHuongDanVien, email, diaChi,
						soDT,ngayVaoLam, cmnd, gioiTinh, tinhTrang);
				
				dsHuongDanVien.add(hdv);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsHuongDanVien;
	}
	public DefaultTableModel getAllHDV() throws SQLException {
		String[] header=  {"Mã HDV","Tên HDV","Email","Địa Chỉ","Số Điện Thoại","Ngày Vào Làm","CMND","GioiTinh","TinhTrang"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		String sql = "SELECT *from HuongDanVien\r\n"; 
	
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	public boolean themHDV(HuongDanVien hdv){
		connectDB.ConnectDB.getInstance();
		Connection con = connectDB.ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into HuongDanVien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, hdv.getMaHuongDanVien());
			stmt.setString(2, hdv.getTenHuongDanVien());
			stmt.setString(3, hdv.getEmail());
			stmt.setString(4, hdv.getDiaChi());
			stmt.setString(5, hdv.getSoDT());
			stmt.setString(7, hdv.getCmnd());
			stmt.setDate(6, (Date) hdv.getNgayVaoLam());
			stmt.setBoolean(8, hdv.isGioiTinh());
			stmt.setBoolean(9, hdv.isTinhTrang());
			
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
	public boolean update(HuongDanVien hdv) {
		connectDB.ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			
			stmt = con.prepareStatement(
					"update huongDanVien set tenHuongDanVien=?,CMND=?,diaChi=?,email=?"
					+ ",soDT=?,ngayVaoLam=?,tinhTrang=?,gioiTinh=? where maHuongDanVien=?");
			
			stmt.setString(1, hdv.getMaHuongDanVien());
			stmt.setString(2, hdv.getTenHuongDanVien());
			stmt.setString(3, hdv.getEmail());
			stmt.setString(4, hdv.getDiaChi());
			stmt.setString(5, hdv.getSoDT());
			stmt.setString(7, hdv.getCmnd());
			stmt.setDate(6, (Date) hdv.getNgayVaoLam());
			stmt.setBoolean(8, hdv.isGioiTinh());
			stmt.setBoolean(9, hdv.isTinhTrang());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
	
		}
		return n > 0;
	}
	public ArrayList<String> getListHDNV(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select maNV from HuongDanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String CMND;
				CMND = rs.getString(1);
				list_MaHDV.add(CMND);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return list_MaHDV;
	}

	public HuongDanVien getHuongDanVienHDId(String properties,String ma) {
		Connection con = ConnectDB.getConnection();
		String sql = "select * from HuongDanVien where " + properties + " = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				HuongDanVien hdv= new HuongDanVien (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7),rs.getDate(6),rs.getBoolean(9),rs.getBoolean(8));
				return hdv;	
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	public HuongDanVien getHuongDanVienById(String string, String string2) {
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
		String[] header=   {"Mã HDV","Tên HDV","Email","Địa Chỉ","Số Điện Thoại","Ngày Vào Làm","CMND","GioiTinh","TinhTrang"};
		DefaultTableModel tableModel = new DefaultTableModel(header, 0);
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * from HuongDanVien  where CMND like '"+cmnd+"' or maHuongDanVien like '"+ma+"'";
                 
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		while (rs.next()) {
			Object[] o = { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)};
			tableModel.addRow(o);
		}
		return tableModel;
	}
	public boolean xoaNV(String maNV) throws SQLException {
		Connection a = ConnectDB.getConnection();// Tao Ket Noi
		String sql = "delete HuongDanVien where maHuongDanVien='" + maNV + "'";
		PreparedStatement pstm = a.prepareStatement(sql);
		if (pstm.executeUpdate() > 0) {
			JOptionPane.showMessageDialog(null, "Xóa thành công hướng dẫn viên " + maNV);
			return true;
		}
		return false;
	}

}
