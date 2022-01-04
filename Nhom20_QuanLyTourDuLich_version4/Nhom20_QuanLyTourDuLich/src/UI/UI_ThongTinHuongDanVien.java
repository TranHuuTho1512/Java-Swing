package UI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.DAO_HuongDanVien;
import dao.DAO_KhachHang;
import entity.DiaDanh;
import entity.HuongDanVien;
import connectDB.ConnectDB;

public class UI_ThongTinHuongDanVien extends JPanel implements ActionListener{
	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim;
	JButton btnTim, btnThem, btnSua, btnLoad, btnThoat;
	DAO_HuongDanVien dao_hdv = new DAO_HuongDanVien();
	ArrayList<HuongDanVien> listHDV;

	public UI_ThongTinHuongDanVien() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//setBackground(Color.YELLOW);
		setLayout(new BorderLayout());
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Hướng Dẫn Viên");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		
		String[] chuoi = {"Mã khách hàng","Tên khách hàng","Email","Địa Chỉ","Số điện thoại ","CMND","Giới tính"};
		modeltable = new DefaultTableModel(chuoi,0);
		table = new JTable(modeltable);
		JScrollPane sc = new JScrollPane(table);
		add(sc,BorderLayout.CENTER);
		
		//SOUTH
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		add(pnSouth,BorderLayout.SOUTH);
	
		JPanel pnLeft = new JPanel();
		JPanel pnRight = new JPanel();
		pnRight.setPreferredSize(new Dimension(400,0));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		

			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/add.png"));
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnLoad = new JButton("Load");
		btnLoad.setIcon(new ImageIcon("Icon/open1.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnLoad);
		pnRight.add(btnThoat);
		pnSouth.add(sp);
		
		//LEFT
		//Nam 2-6
		JLabel lblTim = new JLabel("Tìm kiếm");
		pnLeft.add(lblTim);
		txtTim = new JTextField(10);
		//btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLoad.addActionListener(this);
		
	try {
		loadHDV();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	txtTim.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(txtTim.getText().length()==0) {
				try {
					loadHDV();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(txtTim.getText().length()>0) {
				try {
					timHDV();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
	});

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			new UI_HuongDanVien().setVisible(true);
		}
		else if(o.equals(btnSua)) {
			new UI_HuongDanVien().setVisible(true);
			
		}
		else if(o.equals(btnThoat)) {
			setVisible(false);
			dispose();
		}
	else if(o.equals(btnLoad)) {
		DAO_HuongDanVien dao_hdv = new DAO_HuongDanVien();
		try {
			modeltable= dao_hdv.getAllHDV();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(modeltable);
		
	}
		}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	private void timHDV() throws SQLException{
		DAO_HuongDanVien dao_kh= new DAO_HuongDanVien();
		modeltable = dao_kh.timKiem("%"+txtTim.getText()+"%", "%"+txtTim.getText()+"%");
		table.setModel(modeltable);
	}
	private void loadHDV() throws SQLException {
		DAO_HuongDanVien dao_hdv = new DAO_HuongDanVien();
		modeltable= dao_hdv.getAllHDV();
		table.setModel(modeltable);
	}
//	//Hàm Xóa
//	private boolean xoaNV() throws SQLException {
//		
//		return dao_hdv.xoaNV(null);
//			
//	//	loadNV();
//	}

public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				UI_ThongTinHuongDanVien frame = new UI_ThongTinHuongDanVien();
				frame.setVisible(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
protected void setExtendedState(int maximizedBoth) {
	// TODO Auto-generated method stub
	
}
}	
