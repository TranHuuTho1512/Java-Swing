package dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;
public class DAO_TaiKhoan {
	private ArrayList<TaiKhoan> listTaiKhoan;
	TaiKhoan tk;

//	public ArrayList<TaiKhoan> docTuBang(){
//		try {
//			ConnectDB.getInstance();
//			Connection con = ConnectDB.getCon();
//			String sql = "Select * from TaiKhoan";
//			Statement statement = con.createStatement();
//			ResultSet rs = statement.executeQuery(sql);
//			while (rs.next()) {
//				NhanVien nhanVien;
//				String matKhau;
//				String quyen;
//				String chuThich;
//				
//				nhanVien = new NhanVien(rs.getString(1));
//				matKhau = rs.getString(2);
//				quyen = rs.getString(3);
//				chuThich = rs.getString(4);
//				
//				TaiKhoan tk = new TaiKhoan(nhanVien, matKhau, quyen, chuThich);
//				listTaiKhoan.add(tk);
//			}
//		}catch (SQLException e) { 
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return listTaiKhoan;
//	}
	public ArrayList<TaiKhoan> docTuBang(){
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				
				NhanVien maNV = null;
				String matKhau;
				
				matKhau = rs.getString(2);		
				TaiKhoan tk = new TaiKhoan(maNV, matKhau);
				listTaiKhoan.add(tk);
			}
		}catch (SQLException e) { 
			// TODO: handle exception
			e.printStackTrace();
		}
		return listTaiKhoan;
}
//	public DefaultTableModel getAllAccount(String[] header, DefaultTableModel tableModel) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getCon();
//		String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNV), TaiKhoan.*, tenNV"
//				+ " from TaiKhoan"
//				+ " where maNV = NhanVien.maNV";
//		Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
//			tableModel.addRow(o);
//		}
//		return tableModel;
//	}
	public TaiKhoan Login(String username, String password) {
		Connection con = ConnectDB.getConnection();
		String sql = "select * from TaiKhoan where maNV = ? and matKhau = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				TaiKhoan tk = new TaiKhoan(new NhanVien(rs.getString(1)), rs.getString(2));
				return tk;
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1);
			e1.printStackTrace();
		}
		return null;
	}
	public boolean create (TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt = con.prepareStatement("insert into TaiKhoan values (?,?)");
			stmt.setString(1, tk.getNhanVien().getMaNV());
			stmt.setString(2, tk.getMatKhau());
			
			n=stmt.executeUpdate();
		}catch(SQLException e) {
			//e.printStackTrace();
		}
				return n > 0;
	}
	public boolean delete(String ID){
	       ConnectDB.getInstance();
	       Connection con= ConnectDB.getConnection();
	       PreparedStatement stmt = null;
	       int n=0;
	       try{
	           stmt = con.prepareStatement("delete from TaiKhoan where maNV = ?");
	           stmt.setString(1, ID);
	           n = stmt.executeUpdate();
	       }catch(SQLException e){
	           e.printStackTrace();
	       }
	       return n>0;
	   }
	public boolean Update (String maNV) {
		ConnectDB.getInstance();
		Connection con= ConnectDB.getConnection();
	    PreparedStatement stmt = null;
	    int n = 0;
	    try {
	    	stmt = con.prepareStatement("update TaiKhoan set matKhau = '123456' where maNV = ?");
	    	stmt.setString(1, maNV);
	    	n = stmt.executeUpdate();
	    } catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    return n>0;
	}
//	public DefaultTableModel getAccountByName(String[] header, DefaultTableModel tableModel, String tenNV) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getCon();
//		String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNV), TaiKhoan.*, tenNV from TaiKhoan, NhanVien  where TaiKhoan.maNV = NhanVien.maNV and NhanVien.tenNV like N'%"+tenNV+"%'";
//		Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
//			tableModel.addRow(o);
//		}
//		return tableModel;
//	}
//	public DefaultTableModel getAccountById(String[] header, DefaultTableModel tableModel, String maNV) throws SQLException {
//		ConnectDB.getInstance();
//		Connection con = ConnectDB.getCon();
//		String sql = "select ROW_NUMBER() OVER (ORDER BY TaiKhoan.maNV), TaiKhoan.*, tenNV"
//				+ " from TaiKhoan, NhanVien"
//				+ " where TaiKhoan.maNV = NhanVien.maNV and TaiKhoan.maNV like '%"+maNV+"%'";
//		Statement statement = con.createStatement();
//		ResultSet rs = statement.executeQuery(sql);
//		while (rs.next()) {
//			Object[] o = {rs.getString(1), rs.getString(2), rs.getString(6), rs.getString(3), rs.getString(4), rs.getString(5)};
//			tableModel.addRow(o);
//		}
//		return tableModel;
//	}
	
}
