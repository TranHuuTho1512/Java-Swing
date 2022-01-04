package UI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.ThongKe_Dao;
import dao.Tour_DAO;
import entity.Tour;
import entity.Ve;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class QuanLiThongKe extends JPanel implements ActionListener {
	private JDateChooser jdcKH;
	private JDateChooser jdcKT;
	private DefaultTableModel modeltable;
	private JTable table;
	JLabel lblKH, lblKT, lblThongKeVe, lblThongKeDT;
	JButton btnThongKe;
	private Tour_DAO tour_Dao;
	private ThongKe_Dao tk_dao;
	ArrayList<Ve> listVe;
	Tour tour;
	LocalDate tn;
	String tuNgay;
	String denNgay;
	public QuanLiThongKe() throws Exception {

		tk_dao = new ThongKe_Dao();
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		setLayout(new BorderLayout());
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("Quản Lý Thống kê");
		Font font = new Font("Arial", Font.BOLD, 25);
		lblTieuDe.setFont(font);
		lblTieuDe.setForeground(Color.RED);
		pnNorth.add(lblTieuDe);
		add(pnNorth, BorderLayout.NORTH);

		JTabbedPane tab = new JTabbedPane();
		JPanel pnTab2 = new JPanel();
		JPanel pnTab3 = new JPanel();
		add(tab, BorderLayout.CENTER);
		JPanel pnNorth1 = new JPanel();
		JPanel pnKH = new JPanel();
		JPanel pnKT = new JPanel();
		JPanel pnSouth = new JPanel();
		JPanel pnVe = new JPanel();
		JPanel pnDT = new JPanel();
		jdcKH = new JDateChooser();
		jdcKH.setDateFormatString("dd-MM-yyyy");
		// add(pnTab1,BorderLayout.NORTH);
		//tab.add(pnTab2, "Thống kê địa danh có nhiều tham quan nhất");
		//pnTab2.setBackground(Color.BLUE);

		//tab.add(pnTab3, "Thống kê Tour theo địa danh");
		//pnTab3.setBackground(Color.RED);
		
		// Phần North
		pnKH.add(lblKH = new JLabel("Từ ngày:"));
		lblKH.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKH.setForeground(Color.BLUE);
		pnKH.add(jdcKH = new JDateChooser());
		pnKH.setLayout(new FlowLayout(FlowLayout.LEFT));
		jdcKH.setPreferredSize(new Dimension(150, 20));
		pnKH.add(btnThongKe = new JButton("Thống kê"));
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThongKe.setForeground(Color.BLUE);
	
		pnKT.add(lblKT = new JLabel("Đến ngày:"));
		lblKT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKT.setForeground(Color.BLUE);
		pnKT.add(jdcKT = new JDateChooser());
		jdcKT.setPreferredSize(new Dimension(150, 20));
		pnKT.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblKH.setPreferredSize(lblKT.getPreferredSize());
		Box b = Box.createVerticalBox();
		b.add(pnKH);
		b.add(pnKT);
		pnNorth1.add(b);
		add(pnNorth1, BorderLayout.NORTH);
		
		// Phần South
		pnVe.add(lblThongKeVe = new JLabel("Tổng số vé là: "));
		lblThongKeVe.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThongKeVe.setForeground(Color.RED);
		pnDT.add(lblThongKeDT = new JLabel("Tổng doanh thu là:"));
		lblThongKeDT.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblThongKeDT.setForeground(Color.RED);
		lblThongKeVe.setPreferredSize(lblThongKeDT.getPreferredSize());
		Box b1 = Box.createVerticalBox();
		b1.add(pnVe);
		b1.add(pnDT);
		pnSouth.add(b1);
		add(pnSouth, BorderLayout.SOUTH);
		
		// Phần Center
		String[] cols = {"Mã vé", "Ngày đặt vé","Tên tour","Mã tour", "Giá tour","Tên khách hàng"};
		modeltable = new DefaultTableModel(cols, 0);
		table = new JTable(modeltable);
		JScrollPane sc = new JScrollPane(table);
		add(sc, BorderLayout.CENTER);
		
		btnThongKe.addActionListener(this);
		
		loadVe();
	}
	public void loadVe(){
		listVe	= tk_dao.getallTbVe();
		for(Ve ve : listVe) {
			modeltable.addRow(new Object[] {ve.getMaVe(),ve.getNgayDatVe(),ve.getTour().getTenTour(),ve.getTour().getMaTour(), 
					ve.getTour().getGiaTour(),ve.getKhachhang().getTenKH() // sá»­a hÃ ng nÃ y
			});		
		}

	}
	public void loadTK() throws SQLException {
		modeltable.setRowCount(0);
		table.removeAll();
		listVe	= tk_dao.thongKeTheoNgay(tuNgay,denNgay);
		for(Ve ve : listVe) {
			modeltable.addRow(new Object[] {ve.getMaVe(),ve.getNgayDatVe(),ve.getTour().getTenTour(),ve.getTour().getMaTour(),
					ve.getTour().getGiaTour(),ve.getKhachhang().getTenKH() // sá»­a hÃ ng nÃ y
			});
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThongKe)) {
			
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			tuNgay = "";
			denNgay = "";
			tuNgay = dcn.format(jdcKH.getDate());
			denNgay= dcn.format(jdcKT.getDate());
			lblThongKeVe.setText("Tống số vé là: " + String.valueOf(tk_dao.SoLuongVeTheoNgayChon(tuNgay,denNgay)) );
			lblThongKeDT.setText("Tổng doanh thu là: " + String.valueOf(tk_dao.TongDTtheoNgayChon(tuNgay,denNgay)) + " VND");
			try {
				loadTK();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
}
