package UI;

import javax.swing.JFrame;

import javax.swing.table.DefaultTableModel;

import dao.DAO_KhachHang;
import dao.DAO_NhanVien;
import entity.KhachHang;
import entity.NhanVien;

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
import java.time.LocalDate;

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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class UI_KhachHang extends JFrame  implements ActionListener {
	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim,txtTenKH,txtMaKH,txtDiaChi,txtEmail,txtSoDT,txtCMND;
	JButton btnTim, btnThem, btnSua, btnXoaRong, btnThoat;
	JLabel lblMaKH,lblTenKH,lblDiaChi,lblEmail,lblSoDT,lblCMND,lblGioiTinh;
	JRadioButton radNam, radNu;
	JComboBox<KhachHang>cbGioiTinh;
	private DAO_KhachHang dao_kh = new DAO_KhachHang();	
	private UI_ThongTinKhachHang ttkh = new UI_ThongTinKhachHang();
	public UI_KhachHang() {
		//setBackground(Color.YELLOW);
		setLayout(new BorderLayout());
		setTitle("TTKH");
		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);	
		setSize(550,600);
		setLocationRelativeTo(null);
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Khách Hàng");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		 pnNorth = new JPanel() { };
			JLabel lblTieuDeJLabel = new JLabel("Thông Tin Khách Hàng");
			Font font2 =new Font("Arial",Font.BOLD,15);
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
			lblTenKH = new JLabel("Tên khách hàng");
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
			lblSoDT = new JLabel("Số Điện Thoại");
			txtSoDT = new JTextField(18);
			pnSDT.add(lblSoDT);
			pnSDT.add(txtSoDT);
			pnThongTin.add(pnSDT);
				//Email
			JPanel pnEmail = new JPanel();
			lblEmail = new JLabel("Email");
			txtEmail = new JTextField(18);
			pnEmail.add(lblEmail);
			pnEmail.add(txtEmail);
			pnThongTin.add(pnEmail);
				//NgayVaoLam

				//User
//			JPanel pnUser = new JPanel();
//			lblUser = new JLabel("Tài khoản");
//			txtUser = new JTextField(18);
//			pnUser.add(lblUser);
//			pnUser.add(txtUser);
//			pnThongTin.add(pnUser);	
//				//User
//			JPanel pnPass = new JPanel();
//			lblPass = new JLabel("Mật khẩu");
//			txtPass = new JTextField(18);
//			pnPass.add(lblPass);
//			pnPass.add(txtPass);
//			pnThongTin.add(pnPass);	

// Giới tính
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

			
			lblGioiTinh.setPreferredSize(lblSoDT.getPreferredSize());
			radNam.setPreferredSize(lblSoDT.getPreferredSize());
			radNu.setPreferredSize(lblSoDT.getPreferredSize());
			lblMaKH.setPreferredSize(lblSoDT.getPreferredSize());
			lblEmail.setPreferredSize(lblSoDT.getPreferredSize());
			lblSoDT.setPreferredSize(lblSoDT.getPreferredSize());
			lblCMND.setPreferredSize(lblSoDT.getPreferredSize());
			lblDiaChi.setPreferredSize(lblSoDT.getPreferredSize());
		//	cbGioiTinh.setPreferredSize(txtCMND.getPreferredSize());
		
		
//		
//		String[] chuoi = {"Mã khách hàng","Tên khách hàng","Số điện thoại","Email","CMND","Địa chỉ","Giới tính"};
//		modeltable = new DefaultTableModel(chuoi,0);
//		table = new JTable(modeltable);
//		JScrollPane sc = new JScrollPane(table);
//		add(sc,BorderLayout.CENTER);
		
		//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(400,0));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
		//	LEFT
		txtTim = new JTextField(10);
		btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		pnLeft.add(btnTim);
			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/add.png"));
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnXoaRong = new JButton("Xóa Rỗng");
		btnXoaRong.setIcon(new ImageIcon("Icon/remove.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnXoaRong);
		pnRight.add(btnThoat);
		pnSouth.add(sp);
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThoat.addActionListener(this);
		
		txtMaKH.addKeyListener(new KeyAdapter() {
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
		        
			KhachHang nv = dao_kh.getKhachHangbyHDId("maKH", txtMaKH.getText());
			if(nv!=null) {
			
				txtTenKH.setText(nv.getTenKH());
				txtEmail.setText(nv.getEmail());
				txtCMND.setText(nv.getCmnd());
				txtDiaChi.setText(nv.getDiaChi());
			
				txtSoDT.setText(nv.getSoDT());
				
			}
			else {
		
				txtTenKH.setText("");
				txtEmail.setText("");
				txtCMND.setText("");
				txtDiaChi.setText("");
			
				txtSoDT.setText("");
				
			}
			
			}
		});
		
		
	}
	public static void main(String[] args) {
		UI_KhachHang ttkh = new UI_KhachHang();
		//ttnv.setBackground(new ImageIcon("Icon/1767.jpg"));
		ttkh.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(validData()) {
			int row = ttkh.table.getSelectedRow();
			String maKH= txtMaKH.getText();
			String ten= txtTenKH.getText();
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String soDT = txtSoDT.getText();
			String cmnd = txtCMND.getText();
			boolean gioiTinh = false;
			if(radNam.isSelected())
				gioiTinh = true;
			KhachHang kh = new KhachHang(maKH, ten,cmnd, email, soDT, diaChi,gioiTinh);
			ttkh.modeltable.addRow(new Object [] {kh.getMaKH(),kh.getTenKH(),kh.getSoDT(),kh.getEmail(),kh.getCmnd(),kh.getDiaChi(),kh.isGioiTinh()});
			dao_kh.themKH(kh) ;
			JOptionPane.showMessageDialog(this, "Thêm thành công");
			//new UI_KhachHang().setVisible(true);
			}
		}
		else if(o.equals(btnSua)) {
			//int row=ttnv.table.getSelectedRow();
			try {
				
				if(validData()) {
					JFrame f= new JFrame();
					int hoi=JOptionPane.showConfirmDialog(f, "Khách hàng này sẽ được cập nhật","Chú ý",JOptionPane.YES_NO_OPTION);
					if(hoi==JOptionPane.YES_OPTION) {
						String ma= txtMaKH.getText();
						String cmnd = txtCMND.getText();
						String ten=txtTenKH.getText();
						String diachi=txtDiaChi.getText();
						String email= txtEmail.getText();
						String sodt= txtSoDT.getText();
					
						boolean gioiTinh = false;
						if(radNam.isSelected())
							gioiTinh = true;
						KhachHang nv= new KhachHang(ma, ten, email, diachi, sodt, cmnd, gioiTinh);
						dao_kh.update(nv);
						JOptionPane.showMessageDialog(null, "Cập nhật khách hàng thành công");
					}
				}
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		else if(o.equals(btnXoaRong)) {
			txtTenKH.setText("");
			txtEmail.setText("");
			txtCMND.setText("");
			txtDiaChi.setText("");
			txtMaKH.setText("");
			txtSoDT.setText("");
			
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}
	}
	private boolean validData() {
		String tenNV = txtTenKH.getText();
		String cmnd = txtCMND.getText();
		String diaChi = txtDiaChi.getText();
		String email = txtEmail.getText();
		String sdt = txtSoDT.getText();
		if(!(tenNV.length()>0)){

			JOptionPane.showMessageDialog(null, "Tên khách hàng không trống " );
		
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
