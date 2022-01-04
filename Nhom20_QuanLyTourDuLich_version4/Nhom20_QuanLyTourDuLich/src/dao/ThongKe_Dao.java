package dao;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.DiaDanh;
import entity.KhachHang;
import entity.Tour;
import entity.Ve;

public class ThongKe_Dao {
	
	

	public ArrayList<Ve> getallTbVe(){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();	
			String sql = "select * from Ve v join Tour t on v.maTour = t.maTour "
					+ "join KhachHang kh on kh.maKH = v.maKH "
					+ "join NhanVien nv on nv.maNV = v.maNV";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, tuNgay); 
			//preparedStatement.setString(2, denNgay);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maVe = rs.getString(1);
				Date ngayDatVe = rs.getDate(2);
				Ve ve = new Ve(maVe,(java.sql.Date) ngayDatVe,new Tour(rs.getString(5), rs.getString(7), rs.getDouble(8)), new KhachHang(rs.getString(19)));
				dsVe.add(ve);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVe;	
	}     
	public ArrayList<Ve> thongKeTheoNgay(String tuNgay,String denNgay){
		ArrayList<Ve> dsVe = new ArrayList<Ve>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();	
			String sql = "Select *"
					+ " from Ve a join Tour b on a.maTour = b.maTour "
					+ "join KhachHang c on a.maKH = c.maKH "	
					+ "join NhanVien d on a.maNV = d.maNV "
					+ "where ngayDatVe > ? and ngayDatVe < ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tuNgay); 
			preparedStatement.setString(2, denNgay);
			ResultSet rs = preparedStatement.executeQuery();	
			while (rs.next()) {
				String maVe = rs.getString(1);
				Date ngayDatVe = rs.getDate(2);
				Ve ve = new Ve(maVe,(java.sql.Date) ngayDatVe,new Tour(rs.getString(5), rs.getString(7), rs.getDouble(8)), new KhachHang(rs.getString(19)));
				dsVe.add(ve);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsVe;	
	}
	//Thống kê số lượng vé
	public int SoLuongVeTheoNgayChon(String tuNgay, String denNgay) {
		int count = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select count(maVe) from Ve where ngayDatVe > ? and ngayDatVe < ? ";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,tuNgay);
			pst.setString(2, denNgay);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				count=Integer.valueOf(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	// Thống kê doanh thu
	public int TongDTtheoNgayChon(String tuNgay, String denNgay) {
		int sum = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection(); 
			String sql = "Select SUM(giaTour)"
					+ " from Ve a join Tour b on a.maTour = b.maTour "
					+ "where ngayDatVe > ? and ngayDatVe < ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,tuNgay);
			pst.setString(2,denNgay);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				sum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;
	}

	 
}
