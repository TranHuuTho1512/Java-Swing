package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ThongTinKhachHang extends JFrame{
	JLabel lblMaKH, lblTenKH, lblEmail, lblDiaChi, lblSDT, lblCMND, lblGioiTinh;
	JTextField txtMaKH, txtTenKH, txtEmail, txtDiaChi, txtSDT, txtCMND;
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu;
	JButton btnLamMoi, btnLuu, btnThoat;
	public ThongTinKhachHang() {
		setTitle("TTKH");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);			
		setSize(500,400);
		setLocationRelativeTo(null);
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Thông Tin Khách Hàng");
		Font font =new Font("Arial",Font.BOLD,15);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnThongTin = new JPanel();
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		pnCenter.add(pnThongTin);
		pnCenter.add(pnChucNang);
		add(pnCenter,BorderLayout.CENTER);
			//Ma
		JPanel pnMaKH = new JPanel();
		lblMaKH = new JLabel("Mã khách hàng");
		txtMaKH = new JTextField(18);
		pnMaKH.add(lblMaKH);
		pnMaKH.add(txtMaKH);
		pnThongTin.add(pnMaKH);
		
			//Ten
		JPanel pnTenKH = new JPanel();
		lblTenKH = new JLabel("Tên Khách Hàng");
		txtTenKH = new JTextField(18);
		pnTenKH.add(lblTenKH);
		pnTenKH.add(txtTenKH);
		pnThongTin.add(pnTenKH);				
			//DiaChi
		JPanel pnDiaCHi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ");
		txtDiaChi = new JTextField(18);
		pnDiaCHi.add(lblDiaChi);
		pnDiaCHi.add(txtDiaChi);
		pnThongTin.add(pnDiaCHi);
			//CMND
		JPanel pnCMND = new JPanel();
		lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(18);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);
			//SDT
		JPanel pnSDT = new JPanel();
		lblSDT = new JLabel("Số Điện Thoại");
		txtSDT = new JTextField(18);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSDT);
		pnThongTin.add(pnSDT);
			//Email
		JPanel pnEmail = new JPanel();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField(18);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
			//GioiTinh
		JPanel pnGioiTinh = new JPanel();
		lblGioiTinh = new JLabel("Giới Tính:");
		radNam = new JRadioButton("Nam");
		radNu = new JRadioButton("Nữ");
		ButtonGroup groupGioitinh = new ButtonGroup();
		groupGioitinh.add(radNam);
		groupGioitinh.add(radNu);
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(radNam);pnGioiTinh.add(radNu);
		pnThongTin.add(pnGioiTinh);		
		
		lblGioiTinh.setPreferredSize(lblTenKH.getPreferredSize());
		radNam.setPreferredSize(lblTenKH.getPreferredSize());
		radNu.setPreferredSize(lblTenKH.getPreferredSize());
		lblMaKH.setPreferredSize(lblTenKH.getPreferredSize());
		lblEmail.setPreferredSize(lblTenKH.getPreferredSize());
		lblSDT.setPreferredSize(lblTenKH.getPreferredSize());
		lblCMND.setPreferredSize(lblTenKH.getPreferredSize());
		lblDiaChi.setPreferredSize(lblTenKH.getPreferredSize());
		
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnLuu);
		
		pnChucNang.add(btnThoat);
		
	}
	public static void main(String[] args) {
		new ThongTinKhachHang().setVisible(true);

	}

}
