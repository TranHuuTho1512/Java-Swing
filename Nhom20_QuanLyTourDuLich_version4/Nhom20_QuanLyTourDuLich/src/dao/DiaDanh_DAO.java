package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.DiaDanh;

public class DiaDanh_DAO {
	
	public ArrayList<DiaDanh> getalltbDiaDanh(){
		ArrayList<DiaDanh> dsDiaDanh = new ArrayList<DiaDanh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DiaDanh";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDD = rs.getString(1);
				String tenDD = rs.getString(2);
				String moTa = rs.getString(3);
				String tinhThanh = rs.getString(4);
				DiaDanh diadanh = new DiaDanh(maDD,tenDD,moTa,tinhThanh);
				dsDiaDanh.add(diadanh);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsDiaDanh;
		
	}
	public int layMaDiaDanhLonNhat() {
		int mddln = 0;
		try {
			ConnectDB.getInstance();
			Connection con=ConnectDB.getConnection();
			String sql = "select * from DiaDanh";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDD = rs.getString(1).substring(2);
				if(mddln < Integer.parseInt(maDD)) {
					mddln  = Integer.parseInt(maDD);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mddln;
	}
	public boolean themDiaDanh(DiaDanh diadanh){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			String sql = "insert into DiaDanh values(?,?,?,?)";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, diadanh.getMaDiaDanh());
			preparedStatement.setString(2, diadanh.getTenDiaDanh());
			preparedStatement.setString(3, diadanh.getMoTa());
			preparedStatement.setString(4, diadanh.getTinhThanh());
			int n= preparedStatement.executeUpdate();
			if(n> 0)
				return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(DiaDanh diadanh) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement st=null;
		try {
			st=con.prepareStatement("update DiaDanh set tenDiaDanh=?,moTa=?,tinhThanh=? where maDiaDanh=?");
			st.setString(1, diadanh.getTenDiaDanh());
			st.setString(2, diadanh.getMoTa());
			st.setString(3,diadanh.getTinhThanh());
			st.setString(4,diadanh.getMaDiaDanh());
			int n=st.executeUpdate();
			if(n> 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<DiaDanh> timKiem(String maTinhThanh){
		ArrayList<DiaDanh> dsDiaDanh = new ArrayList<DiaDanh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			//String sql = "select * from DiaDanh where tinhThanh = ?";
			String sql = "select * from DiaDanh where tinhThanh LIKE CONCAT('%', ?, '%')";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTinhThanh);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				String maDD = rs.getString(1);
				String tenDD = rs.getString(2);
				String moTa = rs.getString(3);
				String tinhThanh = rs.getString(4);
				DiaDanh diadanh = new DiaDanh(maDD,tenDD,moTa,tinhThanh);
				dsDiaDanh.add(diadanh);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsDiaDanh;	
	}
}
