package UI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
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
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import connectDB.ConnectDB;
import dao.DiaDanh_DAO;
import dao.DAO_HuongDanVien;
import dao.LoaiTour_DAO;
import dao.Tour_DAO;
import dao.Ve_DAO;
import entity.DiaDanh;
import entity.HuongDanVien;
import entity.LoaiTour;
import entity.Tour;
import entity.Ve;

import com.toedter.calendar.JDateChooser;

public class NhapSuaThongTinTour extends JFrame implements ActionListener, ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Tour t;
	JLabel lblHinhAnh;
	private Ve_DAO ve_dao;
	private DiaDanh_DAO diaDanh_dao;
	private LoaiTour_DAO loaiTour_dao;
	private Tour_DAO tour_dao;
	private DAO_HuongDanVien hdv_dao;
	private JButton btnChonAnh;
	private JComboBox cboDiaDanh;
	private JComboBox cboLoaiTour;
	private JTextField txtMaTour;
	private JTextField txtTenTour;
	private JTextField txtSoNguoi;
	private JTextField txtGiaVe;
	private ArrayList<DiaDanh> lstDiaDanh;
	private ArrayList<LoaiTour> lstLoaiTour;
	private ArrayList<Ve> listVe;
	private ArrayList<Tour> lstTour;
	private ArrayList<HuongDanVien> lstHuongDanVien;
	private String hinhAnh="";
	private JButton btnLuu;
	private JComboBox cboHuongDanVien;
	private int l;//????? x??t coi m??? giao di???n n??o
	private JRadioButton radTrue;
	private JRadioButton radFalse;
	private JTextArea taMoTa;
	private JDateChooser dcNgayKH;
	private JDateChooser dcNgayKT;
	private JLabel lblTB;
	public NhapSuaThongTinTour(Tour tour, int loai) { // N???u 1 th?? m??? giao di???n th??m, 0 th?? giao di???n s???a
		t= tour;
		l=loai;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		setSize(700,700);
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ve_dao = new Ve_DAO();
		diaDanh_dao = new DiaDanh_DAO();
		loaiTour_dao = new LoaiTour_DAO();
		tour_dao = new Tour_DAO();
		hdv_dao = new DAO_HuongDanVien();
		lstDiaDanh = new ArrayList<DiaDanh>();
		lstLoaiTour = new ArrayList<LoaiTour>();
		listVe = ve_dao.DanhSachVeTheoMaTour(t.getMaTour());
		lstTour = new ArrayList<Tour>();
		lstHuongDanVien = new ArrayList<HuongDanVien>();
		
		JLabel lblTieuDe = new JLabel("TH??NG TIN TOUR");
		lblTieuDe.setFont(new Font("Time New Roman",Font.BOLD,20));
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.add(lblTieuDe);
		add(pnTieuDe,BorderLayout.NORTH);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		JPanel pnHinhAnh = new JPanel();
		pnHinhAnh.setPreferredSize(new Dimension(320,210));
		pnHinhAnh.setLayout(new WrapLayout());
		btnChonAnh = new JButton("Ch???n ???nh");
		btnLuu = new JButton("L??u");
		pnHinhAnh.add(lblHinhAnh);
		JPanel pnChonAnhVaTB = new JPanel();
		pnChonAnhVaTB.setLayout(new GridLayout(2,1));
		pnHinhAnh.add(pnChonAnhVaTB);
		lblTB = new JLabel("");
		lblTB.setForeground(Color.RED);
		JPanel pnCA = new JPanel();
		pnCA.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnCA.add(btnChonAnh);
		pnChonAnhVaTB.add(pnCA);
		JPanel pnTB = new JPanel();
		pnTB.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnTB.add(lblTB);
		pnChonAnhVaTB.add(pnTB);
		
		lblHinhAnh.setPreferredSize(new Dimension(300,180));
		String path = t.getHinhAnh();
		lblHinhAnh.setIcon(DoiKichThuocAnh(path));
		add(pnHinhAnh, BorderLayout.EAST);
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BorderLayout());
		add(pnCenter, BorderLayout.CENTER);
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new GridLayout(10,1));
		pnCenter.add(pnThongTin, BorderLayout.CENTER);
		
		JPanel pnMoTa = new JPanel();
		pnMoTa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnMT = new JPanel();
		pnMT.setLayout(new BorderLayout());
		JLabel lblTDMoTa = new JLabel("M?? t??? tour:");
		pnMT.add(lblTDMoTa, BorderLayout.NORTH);
		taMoTa = new JTextArea(8,27);
		taMoTa.setLineWrap(true);
		taMoTa.setWrapStyleWord(true);
		JScrollPane scrMoTa = new JScrollPane(taMoTa);
		pnMT.add(scrMoTa, BorderLayout.CENTER);
		pnMoTa.add(pnMT);
		pnCenter.add(pnMoTa, BorderLayout.SOUTH);
		
		JPanel pnDiaDanh = new JPanel();
		pnDiaDanh.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnLoaiTour = new JPanel();
		pnLoaiTour.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnMaTour = new JPanel();
		pnMaTour.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnTenTour = new JPanel();
		pnTenTour.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnHDV = new JPanel();
		pnHDV.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnNgayKH = new JPanel();
		pnNgayKH.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnNgayKT = new JPanel();
		pnNgayKT.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnSoNguoi = new JPanel();
		pnSoNguoi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnGiaVe = new JPanel();
		pnGiaVe.setLayout(new FlowLayout(FlowLayout.LEFT));
		JPanel pnTinhTrang = new JPanel();
		pnTinhTrang.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		JLabel lblTDDiaDanh = new JLabel("?????a danh:");
		JLabel lblTDLoaiTour = new JLabel("Lo???i tour:");
		JLabel lblTDMaTour = new JLabel("M?? tour:");
		JLabel lblTDTenTour = new JLabel("T??n tour:");
		JLabel lblTDHuongDanVien = new JLabel("H?????ng d???n vi??n:");
		JLabel lblTDNgayKH = new JLabel("Ng??y kh???i h??nh:");
		JLabel lblTDNgayKT = new JLabel("Ng??y k???t th??c:");
		JLabel lblTDSoNguoi = new JLabel("S??? ng?????i:");
		JLabel lblTDGiaVe = new JLabel("Gi?? v??:");
		JLabel lblTDTinhTrang = new JLabel("T??nh tr???ng:");
		
		lblTDDiaDanh.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDLoaiTour.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDMaTour.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDTenTour.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDNgayKH.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDNgayKT.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDSoNguoi.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDGiaVe.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDTinhTrang.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		//lblTDMoTa.setPreferredSize(lblTDHuongDanVien.getPreferredSize());
		lblTDMoTa.setBounds(lblTDHuongDanVien.getBounds());
		
		cboDiaDanh = new JComboBox();
		cboLoaiTour = new JComboBox();
		txtMaTour = new JTextField(18);
		txtMaTour.setEditable(false);
		txtTenTour = new JTextField(18);
		cboHuongDanVien = new JComboBox();
		radTrue = new JRadioButton("C?? th??? ??i",true); 
		radFalse = new JRadioButton("Kh??ng th??? ??i");
		ButtonGroup group = new ButtonGroup();
		group.add(radTrue);group.add(radFalse);
		
		cboDiaDanh.setPreferredSize(txtMaTour.getPreferredSize());
		cboLoaiTour.setPreferredSize(txtMaTour.getPreferredSize());
		cboHuongDanVien.setPreferredSize(txtMaTour.getPreferredSize());
		
		
		dcNgayKH= new JDateChooser();
		dcNgayKH.setDateFormatString("dd-MM-yyyy");
		Date dkh = t.getNgayKhoiHanh();
		  if (dkh == null) {
		    try { 
				dkh = new SimpleDateFormat("dd-MM-yyyy").parse("30-05-2021");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  dcNgayKH.setDate(dkh);
		dcNgayKH.setPreferredSize(txtMaTour.getPreferredSize());
		dcNgayKT = new JDateChooser();
		dcNgayKT.setDateFormatString("dd-MM-yyyy");
		Date dkt = t.getNgayKetThuc();
		if (dkt == null) {
		    try {
				dkt = new SimpleDateFormat("dd-MM-yyyy").parse("10-06-2021");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		dcNgayKT.setDate(dkt);
		dcNgayKT.setPreferredSize(txtMaTour.getPreferredSize());
		txtSoNguoi = new JTextField(18);
		txtGiaVe = new JTextField(18);
		
		pnDiaDanh.add(lblTDDiaDanh);
		pnDiaDanh.add(cboDiaDanh);
		pnLoaiTour.add(lblTDLoaiTour);
		pnLoaiTour.add(cboLoaiTour);
		pnMaTour.add(lblTDMaTour);
		pnMaTour.add(txtMaTour);
		pnTenTour.add(lblTDTenTour);
		pnTenTour.add(txtTenTour);
		pnHDV.add(lblTDHuongDanVien);
		pnHDV.add(cboHuongDanVien);
		pnNgayKH.add(lblTDNgayKH);
		pnNgayKH.add(dcNgayKH);
		pnNgayKT.add(lblTDNgayKT);
		pnNgayKT.add(dcNgayKT);
		pnSoNguoi.add(lblTDSoNguoi);
		pnSoNguoi.add(txtSoNguoi);
		pnGiaVe.add(lblTDGiaVe);
		pnGiaVe.add(txtGiaVe);
		pnTinhTrang.add(lblTDTinhTrang);
		pnTinhTrang.add(radTrue);
		pnTinhTrang.add(radFalse);
				
		pnThongTin.add(pnDiaDanh);
		pnThongTin.add(pnLoaiTour);
		pnThongTin.add(pnMaTour);
		pnThongTin.add(pnTenTour);
		pnThongTin.add(pnHDV);
		pnThongTin.add(pnNgayKH);
		pnThongTin.add(pnNgayKT);
		pnThongTin.add(pnSoNguoi);
		pnThongTin.add(pnGiaVe);
		pnThongTin.add(pnTinhTrang);
		pnThongTin.revalidate();
		pnCenter.revalidate();
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.add(btnLuu);
		add(pnChucNang, BorderLayout.SOUTH);
		
		LayDanhSachDiaDanh();
		ThemVaoCboDiaDanh();
		LayDanhSachLoaiTour();
		ThemVaoCboLoaiTour();
		LayDanhSachTour();
		LayDanhSachHuongDanVien();
		ThemVaoCboHDV();
		ThietLapThongBao();
		
		btnChonAnh.addActionListener(this);
		btnLuu.addActionListener(this);
		cboLoaiTour.addItemListener(this);
		cboDiaDanh.addItemListener(this);
		
		if(l==0)
		{
			DuaThongTinTourVaoComponent();
			btnLuu.setVisible(true);
		}
		else if(l==2)
		{
			DuaThongTinTourVaoComponent();
			btnLuu.setVisible(false);
		}
		else
		{
			btnLuu.setVisible(true);
			DinhDangMaTour();
			DinhDangTenTour();
		}
			
	}

	public static void main(String[] args) {
		
	}
	public ImageIcon DoiKichThuocAnh(String ImagePath)
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(290, 150, Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
	     return image;
	 }
	
	private void LayDanhSachDiaDanh() {
		lstDiaDanh = diaDanh_dao.getalltbDiaDanh();
	}
	
	private void ThemVaoCboDiaDanh()
	{
		for (DiaDanh d : diaDanh_dao.getalltbDiaDanh()) {
			cboDiaDanh.addItem(d.getMaDiaDanh()+"-"+d.getTenDiaDanh());
		}
	}
	
	private void LayDanhSachLoaiTour() {
		lstLoaiTour = loaiTour_dao.layHetLoaiTour();
	}
	private void ThemVaoCboLoaiTour() {
		for (LoaiTour loaiTour : lstLoaiTour) {
			cboLoaiTour.addItem(loaiTour.getMaLoaiTour()+"-"+loaiTour.getTenLoaiTour());
		}
	}
	private void LayDanhSachHuongDanVien() {
		lstHuongDanVien = hdv_dao.LayToanBoHuongDanVien();
	}
	private void ThemVaoCboHDV() {
		lstHuongDanVien = hdv_dao.LayToanBoHuongDanVien();
		for (HuongDanVien danVien : lstHuongDanVien) {
			if(danVien.isTinhTrang())
				cboHuongDanVien.addItem(danVien.getMaHuongDanVien()+"-"+danVien.getTenHuongDanVien());
		}
	}
	
	private void LayDanhSachTour() {
		// TODO Auto-generated method stub
		lstTour = tour_dao.LayHetTour();
	}
	
	 
	private String DinhDanhLaiNguonAnh(String a) {
		 String b= "";
		 for(int i =0;i<a.length();i++)
		 {
			 char c = a.charAt(i);
			 b+=c;
			 if(c=='\\'){
				 b+="\\";
			 }
		 }
		 
		 return b;
	 }
	 
	private String XuLyLayTenAnh(String nguon) {
		 StringBuilder str = new StringBuilder(nguon);
		 str = str.reverse();
		 String tenAnh="";
		 for(int i =0;i<str.length();i++) {
			 if(str.charAt(i)=='\\')
				 break;
			 else
				 tenAnh+=str.charAt(i);
		 }
		 str=new StringBuilder(tenAnh);
		 return str.reverse().toString();
	 }
	 
	private void LuuAnh() {
		 FileInputStream in;
			try {
				in = new FileInputStream(DinhDanhLaiNguonAnh(hinhAnh));
				System.out.println(XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)));
				FileOutputStream ou = new FileOutputStream("HinhAnhTour\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)));
				BufferedInputStream bin = new BufferedInputStream(in);
				BufferedOutputStream bou = new BufferedOutputStream(ou);
				int b= 0;
				while(b!=-1) {
					try {
						b = bin.read();
						bou.write(b);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				try {
					bin.close();
					bou.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("Copy th??nh c??ng");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	 }
	 
	private void DinhDangMaTour() {

		String maT="";
		maT+="T";
		
		maT+=cboLoaiTour.getSelectedItem().toString().substring(0,2);
		if(String.valueOf(tour_dao.LayMaTourLonNhat()).length()==2)
			maT+="0";
		maT+=String.valueOf(tour_dao.LayMaTourLonNhat()+1);
		txtMaTour.setText(maT);
	}
	private void DinhDangMaTourDeSua() {
		String maT="";
		maT+="T";
		
		maT+=cboLoaiTour.getSelectedItem().toString().substring(0,2);
		
		maT+=String.valueOf(t.getMaTour().substring(3));
		txtMaTour.setText(maT);
	}
	private void DinhDangTenTour() {
		String tenT="";
		tenT+="Tour ";
		tenT+=cboLoaiTour.getSelectedItem().toString().substring(3)+" ";
		tenT+=cboDiaDanh.getSelectedItem().toString().substring(7)+" ";
		if(String.valueOf(tour_dao.LayMaTourLonNhat()).length()==2)
			tenT+="0";
		tenT+=String.valueOf(tour_dao.LayMaTourLonNhat()+1);
		txtTenTour.setText(tenT);
	}
	private void DinhDangTenTourDeSua() {
		String tenT="";
		tenT+="Tour ";
		tenT+=cboLoaiTour.getSelectedItem().toString().substring(3)+" ";
		tenT+=cboDiaDanh.getSelectedItem().toString().substring(7)+" ";
		tenT+=String.valueOf(t.getMaTour().substring(3));
		txtTenTour.setText(tenT);
	}
	private void DuaThongTinTourVaoComponent() {
		for (DiaDanh dd : lstDiaDanh) {
			if(t.getDiaDanh().getMaDiaDanh().equals(dd.getMaDiaDanh())) {
				cboDiaDanh.setSelectedItem(dd.getMaDiaDanh()+"-"+dd.getTenDiaDanh());
			}
		}
		for(LoaiTour lt : lstLoaiTour)
		{
			if(t.getLoaiTour().getMaLoaiTour().equals(lt.getMaLoaiTour())) {
				cboLoaiTour.setSelectedItem(lt.getMaLoaiTour()+"-"+lt.getTenLoaiTour());
			}
		}
		for (HuongDanVien hdv : lstHuongDanVien) {
			if(t.getHuongDanVien().getMaHuongDanVien().equals(hdv.getMaHuongDanVien())) {
				cboHuongDanVien.setSelectedItem(hdv.getMaHuongDanVien()+"-"+hdv.getTenHuongDanVien());
			}
		}
		txtMaTour.setText(t.getMaTour());
		txtTenTour.setText(t.getTenTour());
		txtSoNguoi.setText(String.valueOf(t.getSoLuongNguoi()) );
		txtGiaVe.setText(String.valueOf(t.getGiaTour()));
		taMoTa.setText(t.getMoTa());
		hinhAnh = t.getHinhAnh();
	}
	private void ThietLapThongBao() {
		listVe = ve_dao.DanhSachVeTheoMaTour(t.getMaTour());
		if(listVe.size()>0) {
			lblTB.setText("Tour n??y ???? ?????t v??, kh??ng th??? s???a lo???i tour v?? ?????a danh");
			cboDiaDanh.setEnabled(false);
			cboLoaiTour.setEnabled(false);
		}
		else
		{
			lblTB.setText("");
			cboDiaDanh.setEnabled(true);
			cboLoaiTour.setEnabled(true);
		}
			
	}
	private boolean KiemTraNhapSoNguyen(String nhap) {
		try {
			int a = Integer.parseInt(nhap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	private boolean KiemTraNhapSoThuc(String nhap) {
		try {
			float  a = Float.parseFloat(nhap);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private boolean KiemTraNhapLieu() {
		if(txtTenTour.getText().trim().length()==0) {
			txtTenTour.requestFocus();
			JOptionPane.showMessageDialog(this, "T??n tour kh??ng ??c tr???ng");
			return false;
		}
		else if(txtTenTour.getText().length()>50) {
			txtTenTour.requestFocus();
			txtTenTour.selectAll();
			JOptionPane.showMessageDialog(this, "T??n tour qu?? d??i !");
			return false;
		}
		
		
		try {
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			String ngayKH= "", ngayKT="";
			ngayKH = dcn.format(dcNgayKH.getDate() );
			ngayKT = dcn.format(dcNgayKT.getDate());
			LocalDate ngayHienTai = LocalDate.now();
			LocalDate nkh = LocalDate.parse(ngayKH);
			LocalDate nkt = LocalDate.parse(ngayKT);
			
			if(ngayHienTai.compareTo(nkh)>0) {
				JOptionPane.showMessageDialog(this, "Ng??y kh???i h??nh ph???i sau ng??y hi???n t???i !");
				return false;
			}
			if(nkh.compareTo(nkt)>0) {
				JOptionPane.showMessageDialog(this, "Ng??y kh???i h??nh ph???i tr?????c ng??y k???t th??c !");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "L???i ng??y, vui l??ng ch???n ng??y ch??nh x??c !");
			return false;
		}
	    //ki???m tra ng??y c???a h?????ng d???n vi??n
		try {
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			String ngayKH = dcn.format(dcNgayKH.getDate());
			java.sql.Date nkh =java.sql.Date.valueOf(ngayKH);
			String ngayKT = dcn.format(dcNgayKT.getDate());
			java.sql.Date nkt = java.sql.Date.valueOf(ngayKT);
			Tour tourTrung = new Tour();
			
			long khoangCach = nkt.getTime() - nkh.getTime();

			long khoangCachNgay = khoangCach / (24 * 60 * 60 * 1000);
			
			if(khoangCachNgay>100)
			{
				JOptionPane.showMessageDialog(this, "Ng??y kh???i h??nh v?? ng??y k???t th??c c??ch nhau "+khoangCachNgay+" ng??y ! Qu?? l???n !");
				return false;
			}
			
			tourTrung = tour_dao.KiemTraCoTheChoHuongDanVien(txtMaTour.getText(),cboHuongDanVien.getSelectedItem().toString().substring(0,6),nkh,nkt);
			if(tourTrung!=null) {
				JOptionPane.showMessageDialog(this, "H?????ng d???n vi??n n??y s??? b??? tr??ng l???ch !"
						+"\n"+"T??n tour tr??ng l??: "+tourTrung.getTenTour()
						+"\n"+"C?? m?? tour l??: "+tourTrung.getMaTour()
						+"\n"+"C?? ng??y kh???i h??nh: "+tourTrung.getNgayKhoiHanh().toString()
						+"\n"+"C?? ng??y k???t th??c: "+tourTrung.getNgayKetThuc().toString());
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "L???i ng??y nha");
			return false;
		}
		
		
		if(txtSoNguoi.getText().trim().length()==0) {
			txtSoNguoi.requestFocus();
			txtSoNguoi.selectAll();
			JOptionPane.showMessageDialog(this,"S??? ng?????i kh??ng ???????c ????? tr???ng !");
			return false;
		}
		else if(!KiemTraNhapSoNguyen(txtSoNguoi.getText()) ) {
			txtSoNguoi.requestFocus();
			txtSoNguoi.selectAll();
			JOptionPane.showMessageDialog(this,"S??? ng?????i ph???i l?? s??? nguy??n !");
			return false;
		}
		else if(Integer.parseInt(txtSoNguoi.getText())>100&& txtSoNguoi.getText().length()>=3)
		{
			txtSoNguoi.requestFocus();
			txtSoNguoi.selectAll();
			JOptionPane.showMessageDialog(this,"S??? ng?????i qu?? l???n");
			return false;
		}
		else if(Integer.parseInt(txtSoNguoi.getText())<0) {
			txtSoNguoi.requestFocus();
			txtSoNguoi.selectAll();
			JOptionPane.showMessageDialog(this,"S??? ng?????i ph???i l???n h??n 0");
			return false;
		}
		else if(ve_dao.DanhSachVeTheoMaTour(t.getMaTour()).size()>Integer.parseInt(txtSoNguoi.getText())) {
			txtSoNguoi.requestFocus();
			txtSoNguoi.selectAll();
			JOptionPane.showMessageDialog(this,"S??? v?? ???? ?????t l???n h??n s??? ng?????i t???i ??a m?? b???n ??ang s???a !");
			return false;
		}
		
		else if(txtGiaVe.getText().trim().length()==0) {
			txtGiaVe.requestFocus();
			txtGiaVe.selectAll();
			JOptionPane.showMessageDialog(this,"Gi?? v?? kh??ng ???????c ????? tr???ng");
			return false;
		}
		else if(!KiemTraNhapSoThuc(txtGiaVe.getText())) {
			txtGiaVe.requestFocus();
			txtGiaVe.selectAll();
			JOptionPane.showMessageDialog(this,"Gi?? v?? ph???i l?? s??? th???c");
			return false;
		}
		else if(Float.parseFloat(txtGiaVe.getText())<0) {
			txtGiaVe.requestFocus();
			txtGiaVe.selectAll();
			JOptionPane.showMessageDialog(this,"Gi?? v?? ph???i l?? s??? th???c > 0");
			return false;
		}
		else if(txtGiaVe.getText().length()>9&&Float.parseFloat(txtGiaVe.getText())>999999999) {
			txtGiaVe.requestFocus();
			txtGiaVe.selectAll();
			JOptionPane.showMessageDialog(this,"Gi?? v?? qu?? l???n !");
			return false;
		}
		
		if(taMoTa.getText().length()==0)
			taMoTa.setText("Ch??a c?? m?? t??? !");
		if(hinhAnh.length()==0) {
			JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ???nh !");
			return false;
		}
		return true;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnChonAnh)) {
			try {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
				file.addChoosableFileFilter(filter);
				file.setFileFilter(filter);
				int result = file.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					hinhAnh = selectedFile.getAbsolutePath();
					lblHinhAnh.setIcon(DoiKichThuocAnh(hinhAnh));

				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "Vui l??ng ch???n ???nh !");
			}
			
		}
		else if(obj.equals(btnLuu)) {
			if(l==1) { // 1 l?? th??m
				if(KiemTraNhapLieu()) {
					java.sql.Date nkh = null ;
					java.sql.Date nkt = null ;
					try {
						SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
					    String ngayKH = dcn.format(dcNgayKH.getDate() );
						String ngayKT = dcn.format(dcNgayKT.getDate());
						nkh = java.sql.Date.valueOf(ngayKH);
						nkt =java.sql.Date.valueOf(ngayKT);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "L???i ng??y, vui l??ng ch???n l???i ch??nh x??c!");
					}
					
					
					
					HuongDanVien hdv= new HuongDanVien(cboHuongDanVien.getSelectedItem().toString().substring(0,6));
					DiaDanh diaD = new DiaDanh(cboDiaDanh.getSelectedItem().toString().substring(0,6));
					LoaiTour lTour = new LoaiTour(cboLoaiTour.getSelectedItem().toString().substring(0,2));
					Tour tourThem =null;
					try {
						tourThem = new Tour(txtMaTour.getText(), txtTenTour.getText(),Float.parseFloat(txtGiaVe.getText()) ,
								Integer.parseInt(txtSoNguoi.getText()), nkh, nkt, taMoTa.getText(), true,
								"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)), hdv, diaD, lTour);	
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "Kh??ng th??? t???o tour");
					}
					
					try {
						tour_dao.ThemTour(tourThem);
						LuuAnh();
						JOptionPane.showMessageDialog(this, "Th??m tour th??nh c??ng !");
						tour_dao.GuiEmail(tourThem,cboDiaDanh.getSelectedItem().toString().substring(7),
								cboLoaiTour.getSelectedItem().toString().substring(3));
						JOptionPane.showMessageDialog(this, "???? g???i mail !");
						QuanLiTour.qlTour.TaiTourLen();
						QuanLiVe.qlVe.TaiTourLen();
						this.dispose();
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(this, "L???i, kh??ng th??? th??m tour!");
					}
				}
			}
			else if(l==0) { // S???a th??ng tin
				if(KiemTraNhapLieu()) {
					if(!t.getMaTour().equals(txtMaTour.getText())) { // N???u kh??c th?? ph???i new 1 tour m???i, r x??a tour c??
						try {
							
							java.sql.Date nkh = null ;
							java.sql.Date nkt = null ;
							try {
								SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
							    String ngayKH = dcn.format(dcNgayKH.getDate() );
								String ngayKT = dcn.format(dcNgayKT.getDate());
								nkh = java.sql.Date.valueOf(ngayKH);
								nkt =java.sql.Date.valueOf(ngayKT);
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(this, "L???i ng??y, vui l??ng ch???n l???i ch??nh x??c!");
							}
							
							
							
							HuongDanVien hdv= new HuongDanVien(cboHuongDanVien.getSelectedItem().toString().substring(0,6));
							DiaDanh diaD = new DiaDanh(cboDiaDanh.getSelectedItem().toString().substring(0,6));
							LoaiTour lTour = new LoaiTour(cboLoaiTour.getSelectedItem().toString().substring(0,2));
							Tour tourThem =null;
							try {
								if(t.getHinhAnh().equals("HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)))) // Vinh - 2-6
								{
									JOptionPane.showMessageDialog(this,DinhDanhLaiNguonAnh("HinhAnhTour\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(t.getHinhAnh()))+"VINH"));
									tourThem = new Tour(txtMaTour.getText(), txtTenTour.getText(),Float.parseFloat(txtGiaVe.getText()) ,
											Integer.parseInt(txtSoNguoi.getText()), nkh, nkt, taMoTa.getText(), true,
											"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(t.getHinhAnh())), hdv, diaD, lTour);	
								}
								else
								{
									JOptionPane.showMessageDialog(this,DinhDanhLaiNguonAnh( t.getHinhAnh())+"TH??NH"+"\n"+"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)));
									tourThem = new Tour(txtMaTour.getText(), txtTenTour.getText(),Float.parseFloat(txtGiaVe.getText()) ,
											Integer.parseInt(txtSoNguoi.getText()), nkh, nkt, taMoTa.getText(), true,
											"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)), hdv, diaD, lTour);	
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(this, "Kh??ng th??? t???o tour");
							}
							
							try {
								tour_dao.ThemTour(tourThem);
								
								try {
									tour_dao.XoaTour(t.getMaTour());
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(this, "L???i trong khi x??a tour c?? !");
								}
								if(!tourThem.getHinhAnh().equals(t.getHinhAnh()))
									LuuAnh();
								JOptionPane.showMessageDialog(this, "S???a tour th??nh c??ng !");
								QuanLiTour.qlTour.TaiTourLen();
								QuanLiVe.qlVe.TaiTourLen();
								this.dispose();// Vinh - 2-6
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(this, "L???i, kh??ng th??? s???a tour!");
							}
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "L???i! kh??ng th??? s???a tour.");
						}
					}
					
					else {//N???u gi???ng th?? s???a b??nh th?????ng
						java.sql.Date nkh = null ;
						java.sql.Date nkt = null ;
						try {
							SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
						    String ngayKH = dcn.format(dcNgayKH.getDate() );
							String ngayKT = dcn.format(dcNgayKT.getDate());
							nkh = java.sql.Date.valueOf(ngayKH);
							nkt =java.sql.Date.valueOf(ngayKT);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "L???i ng??y, vui l??ng ch???n l???i ch??nh x??c!");
						}
									
						HuongDanVien hdv= new HuongDanVien(cboHuongDanVien.getSelectedItem().toString().substring(0,6));
						DiaDanh diaD = new DiaDanh(cboDiaDanh.getSelectedItem().toString().substring(0,6));
						LoaiTour lTour = new LoaiTour(cboLoaiTour.getSelectedItem().toString().substring(0,2));
						Tour tourSua =null;
						try {
							if(DinhDanhLaiNguonAnh(t.getHinhAnh()).equals("HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh))))
							{
								tourSua = new Tour(txtMaTour.getText(), txtTenTour.getText(),Float.parseFloat(txtGiaVe.getText()) ,
										Integer.parseInt(txtSoNguoi.getText()), nkh, nkt, taMoTa.getText(), true,
										"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(t.getHinhAnh())), hdv, diaD, lTour);	
								
							}
							else
							{
								tourSua = new Tour(txtMaTour.getText(), txtTenTour.getText(),Float.parseFloat(txtGiaVe.getText()) ,
										Integer.parseInt(txtSoNguoi.getText()), nkh, nkt, taMoTa.getText(), true,
										"HinhAnhTour\\\\"+XuLyLayTenAnh(DinhDanhLaiNguonAnh(hinhAnh)), hdv, diaD, lTour);	
							}
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "Kh??ng th??? t???o tour ????? s???a !");
						}
						
						try {
							tour_dao.SuaTour(tourSua);
							if(!tourSua.getHinhAnh().equals(t.getHinhAnh()))
								LuuAnh();
							JOptionPane.showMessageDialog(this, "S???a tour th??nh c??ng !");
							QuanLiTour.qlTour.TaiTourLen();
							QuanLiVe.qlVe.TaiTourLen();
							this.dispose();
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(this, "L???i, kh??ng th??? s???a tour!");
						}
					}
				}
			}
		}
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(l==1) {//1 l?? th??m
			if(obj.equals(cboLoaiTour)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangMaTour();
				DinhDangTenTour();
			}
			else if(obj.equals(cboDiaDanh)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangTenTour();
			}
		}
		
		else if(l==0) {// 0 l?? s???a
			if(obj.equals(cboLoaiTour)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangMaTourDeSua();
				DinhDangTenTourDeSua();
			}
			else if(obj.equals(cboDiaDanh)&&e.getStateChange()==ItemEvent.SELECTED) {
				DinhDangTenTourDeSua();
			}
		}
	}
}
