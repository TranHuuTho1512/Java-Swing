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

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class QuanLiNhanVien extends JPanel  implements ActionListener{
	DefaultTableModel modeltable;
	JTable table;
	JTextField txtTim;
	JButton btnTim, btnThem, btnSua, btnXoa, btnThoat;
	public QuanLiNhanVien() {
		
		setLayout(new BorderLayout());
		
		
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Nhân Viên");
		Font font =new Font("Arial",Font.BOLD,25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		//pnNorth.setBackground(Color.WHITE);
		pnNorth.add(lblTieuDe);
		add(pnNorth,BorderLayout.NORTH);
		
		
		String[] chuoi = {"Mã nhân viên","Tên nhân viên","Số điện thoại","Email","CMND","Địa chỉ","Ngày vào làm","UserName"};
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
		
			//LEFT
		txtTim = new JTextField(10);
		btnTim = new JButton("Tìm kiếm");
		pnLeft.add(txtTim);
		pnLeft.add(btnTim);
			//RIGHT
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon("Icon/add.png"));
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon("Icon/sua.png"));
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("Icon/remove.png"));
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon("Icon/thoat.png"));
		pnRight.add(btnThem);
		pnRight.add(btnSua);
		pnRight.add(btnXoa);
		pnRight.add(btnThoat);
		pnSouth.add(sp);
		
		btnThem.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			new ThongTinNhanVien().setVisible(true);
		}
	}
}
