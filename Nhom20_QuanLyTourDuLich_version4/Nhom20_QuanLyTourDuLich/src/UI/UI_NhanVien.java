package UI;
import java.awt.BorderLayout;



import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO_NhanVien;
import entity.NhanVien;
public class UI_NhanVien extends JFrame implements ActionListener{
	//sao m bảo nhập đại chưa set
	JLabel lblMaNV, lblTenNV, lblEmail, lblDiaChi, lblSDT, lblCMND, lblNVL, lblUser, lblPass, lblGioiTinh, lblTinhTrang,lblChuThich1,lblChuThich2;
	JTextField txtMaNV, txtTenNV, txtEmail, txtDiaChi, txtSDT, txtCMND,txtNVL;
	ButtonGroup btnGroup;
	JRadioButton radNam, radNu,radDangLam,radNghi;
	JButton btnThem, btnXoa, btnUpdate,btnThoat;
	JPanel pnNorth;
	JPanel pnMain;
	JComboBox<NhanVien> cbxTinhTrang,cbGioiTinh;
	ImageIcon background;
	private DAO_NhanVien dao_nv = new DAO_NhanVien();	
	private UI_ThongTinNhanVien ttnv = new UI_ThongTinNhanVien();
	//private JDateChooser dateNgayVaoLam;
	/*
	@Override
	public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(new ImageIcon("Icon/1767.jpg").getImage(), 0, 30, getWidth(), getHeight(), null);
	}
	public void setBackground(ImageIcon img)
	{
		this.background=img;
	}*/
	public UI_NhanVien()  {
		setTitle("TTKH");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(500,500);
		setLocationRelativeTo(null);
		List<String> list_MaNV = dao_nv.getListMaNV();
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
		JLabel lblTieuDe = new JLabel("Thông Tin Nhân Viên");
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
		lblMaNV = new JLabel("Mã nhân viên");
		txtMaNV = new JTextField(18);
		pnMaNV.add(lblMaNV);
		pnMaNV.add(txtMaNV);
		pnThongTin.add(pnMaNV);
		
			//Ten
		JPanel pnTenNV = new JPanel();
		lblTenNV = new JLabel("Tên nhân viên");
		txtTenNV = new JTextField(18);
		pnTenNV.add(lblTenNV);
		pnTenNV.add(txtTenNV);
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
		lblSDT = new JLabel("Số Điện Thoại");
		txtSDT = new JTextField(18);
		pnSDT.add(lblSDT);
		pnSDT.add(txtSDT);
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
		lblNVL = new JLabel("Ngày vào làm");
		txtNVL = new JTextField(18);
		pnNVL.add(lblNVL);
		pnNVL.add(txtNVL);
		pnThongTin.add(pnNVL);
		//GioiTinh
	

//			//GioiTinh
//		String GT[] = {"Nam","Nữ"};
//		JPanel pnGioiTinh = new JPanel();
//		lblGioiTinh = new JLabel("Giới Tính:");
//		cbGioiTinh = new JComboBox(GT);
//
//		pnGioiTinh.add(lblGioiTinh);
//		pnGioiTinh.add(cbGioiTinh);
//		pnThongTin.add(pnGioiTinh);
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
		
		
		
//		//TinhTrang
//		String TT[] = {"Đang làm","Nghỉ"};
//		JPanel pnTinhTrang = new JPanel();
//		lblTinhTrang = new JLabel("Tình Trạng:");
//		cbxTinhTrang = new JComboBox(TT);
//		pnTinhTrang.add(lblTinhTrang);
//		pnTinhTrang.add(cbxTinhTrang);
//		pnThongTin.add(pnTinhTrang);

		


		
//		
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		radNam.setPreferredSize(lblSDT.getPreferredSize());
		radNu.setPreferredSize(lblSDT.getPreferredSize());
		
		lblMaNV.setPreferredSize(lblSDT.getPreferredSize());
		lblEmail.setPreferredSize(lblSDT.getPreferredSize());
		lblSDT.setPreferredSize(lblSDT.getPreferredSize());
		lblCMND.setPreferredSize(lblSDT.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSDT.getPreferredSize());
		lblNVL.setPreferredSize(lblSDT.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSDT.getPreferredSize());
		
		lblTinhTrang.setPreferredSize(lblSDT.getPreferredSize());
		radDangLam.setPreferredSize(lblSDT.getPreferredSize());
		radNghi.setPreferredSize(lblCMND.getPreferredSize());
		
		
		btnThem = new JButton("Them");
		btnThem.setIcon(new ImageIcon("Icon/them.png"));
		btnXoa = new JButton("Xoa Rong");
		btnXoa.setIcon(new ImageIcon("Icon/xoa.png"));
		btnUpdate = new JButton("Sua");
		btnUpdate.setIcon(new ImageIcon("Icon/save.png"));
		btnThoat = new JButton("Thoat");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		
		
		pnChucNang.add(btnThem);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnUpdate);
		pnChucNang.add(btnThoat);
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnThoat.addActionListener(this);

		txtMaNV.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				

		        
			NhanVien nv = dao_nv.getNhanVienbyHDId("maNV", txtMaNV.getText());
			if(nv!=null) {
			
				txtTenNV.setText(nv.getTenNV());
				txtEmail.setText(nv.getEmail());
				txtCMND.setText(nv.getCmnd());
				txtDiaChi.setText(nv.getDiaChi());
				txtNVL.setText(nv.getNgayVaoLam().toString());
				txtSDT.setText(nv.getSoDienThoai());
			
			}
			else {
		
				txtTenNV.setText("");
				txtEmail.setText("");
				txtCMND.setText("");
				txtDiaChi.setText("");
				txtNVL.setText("");
				txtSDT.setText("");
			
			}
			
			}
		});
	


	}

	public static void main(String[] args) {
		UI_NhanVien ttnv = new UI_NhanVien();
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
			String maNV= txtMaNV.getText();
			String tenNV= txtTenNV.getText();
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String soDT = txtSDT.getText();
			String cmnd = txtCMND.getText();
			Date ngayVaoLam =Date.valueOf(LocalDate.now());
			boolean tinhTrang =false;
			if(radDangLam.isSelected())
				tinhTrang =true;
			
			boolean gioiTinh = false;
			if(radNam.isSelected())
				gioiTinh = true;
			

			
			NhanVien nv = new NhanVien(maNV, tenNV,cmnd, email, soDT, diaChi,gioiTinh,tinhTrang, ngayVaoLam);
	
			dao_nv.themNV(nv);
			ttnv.modeltable.addRow(new Object [] {nv.getMaNV(),nv.getTenNV(),nv.getEmail(),nv.getDiaChi(),nv.getCmnd(),nv.getSoDienThoai(),nv.getNgayVaoLam(),nv.isGioiTinh(),nv.isTinhTrang()});
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			}		
		
		//	}		
		}
		else if(o.equals(btnUpdate)) {
			
			try {
				
			
				if(validData()) {
					JFrame f= new JFrame();
					int hoi=JOptionPane.showConfirmDialog(f, "Nhân viên này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_OPTION) {
						String ma= txtMaNV.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenNV.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSDT.getText();
						Date ngayVaoLam = Date.valueOf(txtNVL.getText());
						boolean tinhTrang =false;
						if(radDangLam.isSelected())
							tinhTrang =true;
						
						boolean gioiTinh = false;
						if(radNam.isSelected())
							gioiTinh = true;
						NhanVien nv= new NhanVien(ma, ten,cmnd, email, sodt, diachi,gioiTinh,tinhTrang, ngayVaoLam);
						dao_nv.update(nv);
						JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công");
					}
				}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(o.equals(btnXoa)) {
			txtMaNV.setText("");
			txtTenNV.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtNVL.setText("");
			txtSDT.setText("");
			radNam.setSelected(true);
			
			
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}
		
		
		
	}
	private boolean validData() {
		String tenNV = txtTenNV.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSDT.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên nhân viên không trống " );
		
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

	public void SearchNV(String properties) throws SQLException {
		DAO_NhanVien dao_nv = new DAO_NhanVien();
		UI_NhanVien nv1 = new UI_NhanVien();
		

	}
}
