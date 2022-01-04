package UI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.DAO_HuongDanVien;
import entity.HuongDanVien;
import entity.NhanVien;

public class UI_HuongDanVien extends JFrame implements ActionListener  {
	private JLabel lblTenHDV,lblMaHDV,lblEmail,lblDiaChi,lblSoDT,lblGioiTinh,lblNgayVaoLam,lblCMND,lblChuThich1,lblChuThich2,lblTinhTrang;
	private JTextField txtTenHDV,txtMaHDV,txtEmail,txtSoDT,txtNgayVaoLam,txtCMND,txtDiaChi;
	private JComboBox<HuongDanVien> cbGioiTinh,cbxTinhTrang;
	private JButton btnThem,btnSua,btnXoaRong,btnThoat;
	JPanel pnNorth;
	JPanel pnMain;
	private UI_ThongTinHuongDanVien ttnv = new UI_ThongTinHuongDanVien();
	private DAO_HuongDanVien dao_hdv = new DAO_HuongDanVien();
	private JRadioButton radNam,radNu,radDangLam,radNghi;
	
	public UI_HuongDanVien() {
		setTitle("TTKH");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(500,500);
		setLocationRelativeTo(null);
	//	List<String> list_MaNV = dao_n.getListMaNV();
		/*
		//Container con = getContentPane();
		//background=null;
		pnMain = new JPanel()
		{
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if(background!=null)
				{
					g.drawImage(background.getImage(),
							0,0,getWidth(),getHeight(),null);
				}
			}
		};
		pnMain.setLayout(new BorderLayout());
		add(pnMain,BorderLayout.CENTER);*/
		
		
		
		
		
		 pnNorth = new JPanel() { };
		JLabel lblTieuDe = new JLabel("Thông Tin Hướng Dẫn Viên");
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
		JPanel pnMaNV = new JPanel();
		lblMaHDV = new JLabel("Mã HDV");
		txtMaHDV = new JTextField(18);
		pnMaNV.add(lblMaHDV);
		pnMaNV.add(txtMaHDV);
		pnThongTin.add(pnMaNV);
		
			//Ten
		JPanel pnTenNV = new JPanel();
		lblTenHDV = new JLabel("Tên HDV");
		txtTenHDV = new JTextField(18);
		pnTenNV.add(lblTenHDV);
		pnTenNV.add(txtTenHDV);
		pnThongTin.add(pnTenNV);
		//Email
		JPanel pnEmail = new JPanel();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField(18);
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		pnThongTin.add(pnEmail);
		//DiaChi
		JPanel pnDiaCHi = new JPanel();
		lblDiaChi = new JLabel("Địa Chỉ");
		txtDiaChi = new JTextField(18);
		pnDiaCHi.add(lblDiaChi);
		pnDiaCHi.add(txtDiaChi);
		pnThongTin.add(pnDiaCHi);
		
		//SDT
		JPanel pnSDT = new JPanel();
		lblSoDT = new JLabel("Số Điện Thoại");
		txtSoDT = new JTextField(18);
		pnSDT.add(lblSoDT);
		pnSDT.add(txtSoDT);
		pnThongTin.add(pnSDT);
		
		//CMND
		JPanel pnCMND = new JPanel();
		lblCMND = new JLabel("CMND");
		txtCMND = new JTextField(18);
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		pnThongTin.add(pnCMND);

		
			//NgayVaoLam
		JPanel pnNVL = new JPanel();
		lblNgayVaoLam = new JLabel("Ngày vào làm");
		txtNgayVaoLam = new JTextField(18);
		pnNVL.add(lblNgayVaoLam);
		pnNVL.add(txtNgayVaoLam);
		pnThongTin.add(pnNVL);
		//GioiTinh
	
		
			//User
//		JPanel pnUser = new JPanel();
//		lblUser = new JLabel("Tài khoản");
//		txtUser = new JTextField(18);
//		pnUser.add(lblUser);
//		pnUser.add(txtUser);
//		pnThongTin.add(pnUser);	
//			//User
//		JPanel pnPass = new JPanel();
//		lblPass = new JLabel("Mật khẩu");
//		txtPass = new JTextField(18);
//		pnPass.add(lblPass);
//		pnPass.add(txtPass);
//		pnThongTin.add(pnPass);	

			//TinhTrang
//		JPanel pnTinhTrang = new JPanel();
//		lblTinhTrang = new JLabel("Tình trạng");
//		cbxTinhTrang = new JComboBox();
//		cbxTinhTrang.addItem("Vắng");
//		cbxTinhTrang.addItem("Nghỉ");
//		cbxTinhTrang.setPreferredSize(new Dimension(190, 25));
//		pnTinhTrang.add(lblTinhTrang);
//		pnTinhTrang.add(cbxTinhTrang);
//		pnThongTin.add(pnTinhTrang);	
//			//GioiTinh
//		String GT[] = {"Nam","Nữ"};
//		JPanel pnGioiTinh = new JPanel();
//		lblGioiTinh = new JLabel("Giới Tính:");
//		cbGioiTinh = new JComboBox(GT);
//		pnGioiTinh.add(lblGioiTinh);
//		pnGioiTinh.add(cbGioiTinh);
//		pnThongTin.add(pnGioiTinh);
//		
//
//		
//		//TinhTrang
//		String TT[] = {"Đang làm","Nghỉ"};
//		JPanel pnTinhTrang = new JPanel();
//		lblTinhTrang = new JLabel("Tình Trạng:");
//		cbxTinhTrang = new JComboBox(TT);
//		pnTinhTrang.add(lblTinhTrang);
//		pnTinhTrang.add(cbxTinhTrang);
//		pnThongTin.add(pnTinhTrang);
//		//Chú Thích
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
		
		
		JPanel pnTinhTrang = new JPanel();
		lblTinhTrang = new JLabel("TinhTrang:");
		radDangLam = new JRadioButton("Đang Làm");
		radNghi = new JRadioButton("Nghỉ");
		ButtonGroup groupTinhTrang = new ButtonGroup();
		groupTinhTrang.add(radDangLam);
		groupTinhTrang.add(radNghi);
		pnTinhTrang.add(lblTinhTrang);
		pnTinhTrang.add(radDangLam);
		pnTinhTrang.add(radNghi);
		pnThongTin.add(pnTinhTrang);	

		


		
//		lblTinhTrang.setPreferredSize(lblSDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDT.getPreferredSize());
		radNam.setPreferredSize(lblSoDT.getPreferredSize());
		radNu.setPreferredSize(lblSoDT.getPreferredSize());
	//	lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		lblMaHDV.setPreferredSize(lblSoDT.getPreferredSize());
		lblEmail.setPreferredSize(lblSoDT.getPreferredSize());
		lblTenHDV.setPreferredSize(lblSoDT.getPreferredSize());
		lblCMND.setPreferredSize(lblSoDT.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSoDT.getPreferredSize());
		lblNgayVaoLam.setPreferredSize(lblSoDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDT.getPreferredSize());
		lblTinhTrang.setPreferredSize(lblSoDT.getPreferredSize());
		radDangLam.setPreferredSize(lblSoDT.getPreferredSize());
		radNghi.setPreferredSize(lblSoDT.getPreferredSize());
		//lblUser.setPreferredSize(lblSDT.getPreferredSize());
		//lblPass.setPreferredSize(lblSDT.getPreferredSize());
		
		btnThem = new JButton("Them");
		btnThem.setIcon(new ImageIcon("Icon/xoarong.png"));
		btnXoaRong = new JButton("Xoa");
		btnXoaRong.setIcon(new ImageIcon("Icon/save.png"));
		btnSua = new JButton("Update");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnThoat = new JButton("Thoat");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoaRong);
		pnChucNang.add(btnSua);
		
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		txtMaHDV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
//				 String to_check=txtMaNV.getText();
//		            int to_check_len=to_check.length();
//		            for(String data:list_MaNV)
//		            {
//		                String check_from_data="";
//		                for(int i=0;i<to_check_len;i++)
//		                {
//		                    if(to_check_len<=data.length())
//		                    {
//		                        check_from_data = check_from_data+data.charAt(i);
//		                    }
//		                }
//		                //System.out.print(check_from_data);
//		                if(check_from_data.equals(to_check))
//		                {
//		                    //System.out.print("Found");
//		                    txtMaNV.setText(data);
//		                    txtMaNV.setSelectionStart(to_check_len);
//		                    txtMaNV.setSelectionEnd(data.length());
//		                    break;
//		                }
//		            }
		        
			HuongDanVien hdv = dao_hdv.getHuongDanVienHDId("maHuongDanVien", txtMaHDV.getText());
			if(hdv!=null) {
			
				txtTenHDV.setText(hdv.getTenHuongDanVien());
				txtEmail.setText(hdv.getEmail());
				txtCMND.setText(hdv.getCmnd());
				txtDiaChi.setText(hdv.getDiaChi());
				txtNgayVaoLam.setText(hdv.getNgayVaoLam().toString());
				txtSoDT.setText(hdv.getSoDT());
			
			}
			else {
		
				txtTenHDV.setText("");
				txtEmail.setText("");
				txtCMND.setText("");
				txtDiaChi.setText("");
				txtNgayVaoLam.setText("");
				txtSoDT.setText("");
			
			}
			
			}
		});
		
	}
	public static void main(String[] args) {
		UI_HuongDanVien ttnv = new UI_HuongDanVien();
		//ttnv.setBackground(new ImageIcon("Icon/1767.jpg"));
		ttnv.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(validData()) {
			int row = ttnv.table.getSelectedRow();
			String maNV= txtMaHDV.getText();
			String tenNV= txtTenHDV.getText();
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String soDT = txtSoDT.getText();
			String cmnd = txtCMND.getText();
			
			Date ngayVaoLam =Date.valueOf(LocalDate.now());
			boolean tinhTrang =false;
			if(radDangLam.isSelected())
				tinhTrang =true;
			
			boolean gioiTinh = false;
			if(radNam.isSelected())
				gioiTinh = true;
			
			HuongDanVien nv = new HuongDanVien(maNV, tenNV, email, diaChi, soDT, cmnd, ngayVaoLam, tinhTrang, gioiTinh);
	
			dao_hdv.themHDV(nv);
			ttnv.modeltable.addRow(new Object [] {nv.getMaHuongDanVien(),nv.getTenHuongDanVien(),nv.getEmail(),nv.getDiaChi(),nv.getCmnd(),nv.getSoDT(),nv.getNgayVaoLam(),nv.isGioiTinh(),nv.isTinhTrang()});
			JOptionPane.showMessageDialog(this, "Thêm thành công");		
			}		
		}
		else if(o.equals(btnSua)) {
			//int row=ttnv.table.getSelectedRow();
			try {
				
				if(validData()) {
				if(validData()) {
					JFrame f= new JFrame();
					int hoi=JOptionPane.showConfirmDialog(f, "Hướng dẫn viên này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_OPTION) {
						String ma= txtMaHDV.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenHDV.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSoDT.getText();
						Date ngayVaoLam = Date.valueOf(txtNgayVaoLam.getText());
						boolean tinhTrang =false;
						if(radDangLam.isSelected())
							tinhTrang =true;
						
						boolean gioiTinh = false;
						if(radNam.isSelected())
							gioiTinh = true;
						HuongDanVien nv = new HuongDanVien(ma, ten, email, diachi, sodt, cmnd, ngayVaoLam, tinhTrang, gioiTinh);
						dao_hdv.update(nv);
						JOptionPane.showMessageDialog(null, "Cập nhật hướng dẫn viên thành công");
					}
				}
				}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(o.equals(btnXoaRong)) {
			txtMaHDV.setText("");
			txtTenHDV.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtNgayVaoLam.setText("");
			txtSoDT.setText("");
		
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}
		
	}
	private boolean validData() {
		String tenNV = txtTenHDV.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSoDT.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên hướng dẫn viên không trống " );
		
			return false;
		}
//		}
		if(!(cmnd.length()>0 && cmnd.matches("\\d{9}"))) {
			JOptionPane.showMessageDialog(null, "Chứng minh nhân dân gồm  9 số");
			return false;
		}
		if(!(diaChi.length()>0)) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống " );
			return false;
		}
		if(! diaChi.matches("^[0-9a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\" +\r\n" + 
				"	            \"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\" +\r\n" + 
				"	            \"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s/\\\\.,]+$")){
			JOptionPane.showMessageDialog(null, "Địa chỉ không hợp lệ " );
			return false;
	            }
		if(!(email.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Email không được để trống");
			return false;
		}
		if( !email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			JOptionPane.showMessageDialog(null, "Email sai cú pháp");
			return false;
		}
		if(!(sdt.length()>0 )) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống");
			return false;
		}
		if(!(sdt.matches("^[0][1-9][0-9]{8}$"))) {
			JOptionPane.showMessageDialog(null, "Số điện thoại gồm 10 kí tự số và bắt đầu từ kí tự 0");
			return false;
		}
		return rootPaneCheckingEnabled;
		
	}

}
