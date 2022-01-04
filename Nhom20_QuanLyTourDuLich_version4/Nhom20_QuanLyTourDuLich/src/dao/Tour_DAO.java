package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.swing.JOptionPane;

import UI.NhapSuaThongTinTour;
import connectDB.ConnectDB;
import entity.Tour;
import entity.DiaDanh;
import entity.HuongDanVien;
import entity.LoaiTour;

public class Tour_DAO {
	public ArrayList<Tour> getalltbTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour ";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, maTour1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				DiaDanh diaDanh = new DiaDanh(rs.getString(10));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,diaDanh);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	public ArrayList<Tour> getTourTheoMa(String maTour1){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour1);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				DiaDanh diaDanh = new DiaDanh(rs.getString(10));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,diaDanh);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	public ArrayList<Tour> getTourTheoMaDiaDanh(String maDiaDanh){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maDiaDanh = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maDiaDanh);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				DiaDanh diaDanh = new DiaDanh(rs.getString(10));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,diaDanh);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
	public ArrayList<Tour> DSTCoTheDatVe(LocalDate ngayHienTai){ // Hàm này dùng để lấy danh sách tour có ngày khởi hành trước ngày hiện tại
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		DiaDanh diaDanh;
		diaDanh = new DiaDanh();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour t where t.ngayKhoiHanh > ? order by ngayKhoiHanh desc";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, ngayHienTai.toString());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour =(float) rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				HuongDanVien huongDanVien = new HuongDanVien(rs.getString(10));
				diaDanh = new DiaDanh(rs.getString(11));
				LoaiTour loaiTour = new LoaiTour(rs.getString(12));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,huongDanVien,diaDanh, loaiTour);
				dsTour.add(tour);

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
	}
		//Vinh
	public ArrayList<Tour> LayHetTour(){
		ArrayList<Tour> dsTour = new ArrayList<Tour>();
		DiaDanh diaDanh;
		diaDanh = new DiaDanh();
		 
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour order by ngayKhoiHanh desc";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				HuongDanVien huongDanVien = new HuongDanVien(rs.getString(10));
				diaDanh = new DiaDanh(rs.getString(11));
				LoaiTour loaiTour = new LoaiTour(rs.getString(12));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,huongDanVien,diaDanh, loaiTour);
				dsTour.add(tour);

			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return dsTour;
		
	}
public boolean ThemTour(Tour tour) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "insert into Tour values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, tour.getMaTour());
			preparedStatement.setString(2, tour.getTenTour());
			preparedStatement.setFloat(3, tour.getGiaTour());
			preparedStatement.setInt(4, tour.getSoLuongNguoi());
			preparedStatement.setDate(5, tour.getNgayKhoiHanh());
			preparedStatement.setDate(6, tour.getNgayKetThuc());
			preparedStatement.setString(7, tour.getMoTa());
			preparedStatement.setBoolean(8,false);
			preparedStatement.setString(9, tour.getHinhAnh());
			preparedStatement.setString(10, tour.getHuongDanVien().getMaHuongDanVien());
			preparedStatement.setString(11, tour.getDiaDanh().getMaDiaDanh());
			preparedStatement.setString(12, tour.getLoaiTour().getMaLoaiTour());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0;
	}
	public boolean SuaTour(Tour tour) {
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		String sql = "update Tour "
				+ "set tenTour=?, giaTour=?,soLuongNguoi=?, ngayKhoiHanh=?, ngayKetThuc=?,"
				+ "moTa=?, tinhTrang=?, hinhAnh=?, maHuongDanVien=?, maDiaDanh=?, maLoaiTour=?"
				+ " where maTour = ?";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			preparedStatement.setString(1, tour.getTenTour());
			preparedStatement.setFloat(2, tour.getGiaTour());
			preparedStatement.setInt(3, tour.getSoLuongNguoi());
			preparedStatement.setDate(4, tour.getNgayKhoiHanh());
			preparedStatement.setDate(5, tour.getNgayKetThuc());
			preparedStatement.setString(6, tour.getMoTa());
			preparedStatement.setBoolean(7,false);
			preparedStatement.setString(8, tour.getHinhAnh());
			preparedStatement.setString(9, tour.getHuongDanVien().getMaHuongDanVien());
			preparedStatement.setString(10, tour.getDiaDanh().getMaDiaDanh());
			preparedStatement.setString(11, tour.getLoaiTour().getMaLoaiTour());
			preparedStatement.setString(12, tour.getMaTour());
			k = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return k>0; 
	}
	public int LayMaTourLonNhat() {
		int mtln=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			//preparedStatement.setString(1, "hshs");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1).substring(3);
				if(mtln<Integer.parseInt(maTour)) {
					mtln=Integer.parseInt(maTour);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mtln;
	}
	public Tour KiemTraCoTheChoHuongDanVien(String maTourMoi,String maHDV, Date ngayKH, Date ngayKT) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maHuongDanVien = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHDV);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//Xét xem đây có bị trùng mã k, nếu có bỏ qua
				if(!maTourMoi.substring(3).equals(rs.getString(1).toString().substring(3))) {
					//Ngày khởi hành (ngày mới tạo) nằm trong khoảng ngày khởi hành và ngày kết thúc
					if(ngayKH.compareTo(rs.getDate(6))<=0&&ngayKH.compareTo(rs.getDate(5))>=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
					//Ngày khởi hành (mới tạo) và ngày kết thúc (mới tạo) bao cả ngày khởi hành và ngày kết thúc cũ
					if(ngayKH.compareTo(rs.getDate(5))<=0&&ngayKT.compareTo(rs.getDate(6))>=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
					//Ngày kết thúc (ngày mới tạo) nằm trong khoảng ngày khởi hành và ngày kết thúc cũ
					if(ngayKT.compareTo(rs.getDate(5))>=0&&ngayKT.compareTo(rs.getDate(6))<=0) {
						Tour tour = LayTourTheoMaTour(rs.getString(1));
						return tour;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public Tour LayTourTheoMaTour(String mt) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, mt);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String maTour = rs.getString(1);
				String tenTour = rs.getString(2);
				float giaTour = rs.getFloat(3);
				int soLuongNguoi = rs.getInt(4);
				Date ngayKhoiHanh = rs.getDate(5);
				Date ngayKetThuc = rs.getDate(6);
				String moTa = rs.getString(7);
				boolean tinhTrang = rs.getBoolean(8);
				String hinhAnh = rs.getString(9);
				HuongDanVien huongDanVien = new HuongDanVien(rs.getString(10));
				DiaDanh diaDanh = new DiaDanh(rs.getString(11));
				LoaiTour loaiTour = new LoaiTour(rs.getString(12));
				Tour tour = new Tour(maTour,tenTour,giaTour,soLuongNguoi,ngayKhoiHanh,ngayKetThuc,moTa,tinhTrang,hinhAnh,huongDanVien,diaDanh, loaiTour);
				return tour;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public boolean XoaTour(String maTour) {
		int k=0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from Tour where maTour = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maTour);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	private ArrayList<String> tachChuoiTim(String chuoiTim){
		ArrayList<String> chuoiTach = new ArrayList<String>();
		String chuoi = chuoiTim.trim();
		int t=0;
		for(int i =0;i<chuoi.length();i++) {
			if(i==chuoi.length()-1) {
				chuoiTach.add(chuoi.substring(t,i+1));
				break;
			}
			if(chuoi.codePointAt(i)==32) {		
				if(chuoi.substring(t,i).codePointAt(0)!=32)
				{				
					chuoiTach.add(chuoi.substring(t,i));
					t=i+1;
				}	
			}
		}
		
		return chuoiTach;
	}
	public ArrayList<Tour> TimTour(String nhapTour, boolean loai){
		//nếu loại là true thì tìm kiếm cho quản lý tour, false là tìm kiếm cho quản lý vé
		ArrayList<Tour> tourTimDuoc = new ArrayList<Tour>();
		ArrayList<Tour> danhSachTour; 
		if(loai==true)
			danhSachTour=LayHetTour();
		else
			danhSachTour = DSTCoTheDatVe(LocalDate.now());
		if(nhapTour.trim().length()==0)
			return danhSachTour;
		else {
			//Tìm tour theo tên và trả về danh sách tên thôi
			String nhap = nhapTour;
			ArrayList<String> chuoiTach = new ArrayList<String>();
			chuoiTach = tachChuoiTim(nhap);
			ArrayList<String> danhSach = new ArrayList<String>();
			for (Tour tour : danhSachTour) {
				danhSach.add(tour.getTenTour());
			}
			
			ArrayList<String> danhSachTam = new ArrayList<String>();
			for(int i=0;i<chuoiTach.size();i++) {
				String pattern = ".*"+chuoiTach.get(i)+".*";

				danhSachTam = new ArrayList<String>();
				for(String a : danhSach) {
					if(a.toLowerCase().matches(pattern.toLowerCase())) {
						danhSachTam.add(a);
					}
				}
				danhSach = danhSachTam;
			}
			
			//Kiểm tra và đưa vào Array list tour tìm được
			for (String tenTour : danhSach) {
				
				 for(Tour tour : danhSachTour) { 
					 if(tour.getTenTour().toLowerCase().equals(tenTour.toLowerCase())) {
						 tourTimDuoc.add(tour); 
					 }
					 
				 }
			}
			return tourTimDuoc;
		}
	}	
	public void GuiEmail(Tour tour, String diaDanh, String loaiTour) {
		try {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.port", "587");
			Session session = Session.getDefaultInstance(properties,
				new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("lntvinh27122000@gmail.com","vinhhe2011");
					}
				
			});
			Message message = new MimeMessage(session);
			message.setSubject("Một Tour du lịch vừa mới ra mắt !");
			MimeBodyPart imgAttachment = new MimeBodyPart();
			imgAttachment.attachFile(tour.getHinhAnh());
			MimeBodyPart tinNhan = new MimeBodyPart();
			
			tinNhan.setContent("<h1>Thông báo một Tour du lịch sắp ra mắt !</h1><br>","text/html; charset=UTF-8");
			
			MimeBodyPart diaDiem = new MimeBodyPart();
			//String dd= tour.getDiaDanh().getTenDiaDanh();
			diaDiem.setContent("<b>Địa điểm: </b>"+diaDanh+"<br>","text/html; charset=UTF-8");
			MimeBodyPart loaiT = new MimeBodyPart();
			//String lt = tour.getLoaiTour().getTenLoaiTour();
			loaiT.setContent("<b>Loại tour: </b>"+loaiTour+"<br>","text/html; charset=UTF-8");
			MimeBodyPart ngayKhoiHanh = new MimeBodyPart();
			ngayKhoiHanh.setContent("<b>Ngày khởi hành: </b>"+tour.getNgayKhoiHanh().toString()+"<br>","text/html; charset=UTF-8");
			MimeBodyPart ngayKetThuc = new MimeBodyPart();
			ngayKetThuc.setContent("<b>Ngày kết thúc : </b>"+tour.getNgayKetThuc().toString()+"<br>","text/html; charset=UTF-8");
			MimeBodyPart diaChi = new MimeBodyPart();
			diaChi.setContent("<b>Địa chỉ: </b>"+" Số 12 Nguyễn Văn Bảo, Phường 4,Quận Gò Vấp, Thành phố Hồ Chí Minh"+"<br>","text/html; charset=UTF-8");
			MimeBodyPart soDT = new MimeBodyPart();
			soDT.setContent("<b>Điện thoại: </b>"+"0327364753"+"<br>","text/html; charset=UTF-8");
			MimeBodyPart email = new MimeBodyPart();
			email.setContent("<b>Email: </b>"+"lntvinh27122000@gmail.com"+"<br>","text/html; charset=UTF-8");			
			
			DecimalFormat formatter = new DecimalFormat("###,###,###");
			MimeBodyPart giaVe = new MimeBodyPart();
			giaVe.setContent("<b>Giá vé: </b>"+formatter.format(tour.getGiaTour())+" VNĐ"+"<br>","text/html; charset=UTF-8");
			
			
			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(tinNhan);
			multipart.addBodyPart(diaDiem);
			multipart.addBodyPart(loaiT);
			multipart.addBodyPart(ngayKhoiHanh);
			multipart.addBodyPart(ngayKetThuc);
			multipart.addBodyPart(giaVe);
			multipart.addBodyPart(diaChi);
			multipart.addBodyPart(soDT);
			multipart.addBodyPart(email);
			multipart.addBodyPart(imgAttachment);
			message.setContent(multipart);
			message.setFrom(new InternetAddress("lntvinh27122000@gmail.com"));
			message.setRecipient(RecipientType.TO, new InternetAddress("vinhmasxibua@gmail.com"));
			message.setSentDate(new java.util.Date());
			
			Transport.send(message);
		} catch (Exception e2) {
			
		}
	}

}
