package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import connectDB.ConnectDB;
import dao.DiaDanh_DAO;
import dao.Tour_DAO;
import dao.Ve_DAO;
import entity.DiaDanh;
import entity.Tour;
import entity.Ve;

public class QuanLiTour extends JPanel implements ActionListener{
	public static QuanLiTour qlTour;
	private DiaDanh_DAO dd_dao;
	private Tour_DAO tour_dao;
	private Ve_DAO ve_dao;
	
	ArrayList<DiaDanh> listDiaDanh;
	ArrayList<Tour> listTour;
	ArrayList<Ve> listVe;
	JPanel pnCenter;
	private JButton btnThemTour;
	private JTextField txtTim;
	private JButton btnTim;
	
	public QuanLiTour() {
		try {
			ConnectDB.getInstance().connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 qlTour = this;

		dd_dao = new DiaDanh_DAO();
		tour_dao = new Tour_DAO();
		ve_dao = new Ve_DAO();
		
		setLayout(new BorderLayout());
		JTextField txtNhap = new JTextField(15);
		pnCenter = new JPanel();
		pnCenter.setLayout(new WrapLayout());
		pnCenter.setBackground(new Color(230, 247, 255));
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		JPanel pnTim = new JPanel();
		pnTim.setBackground(new Color(230, 247, 255));
		JLabel lblTim = new JLabel("Tìm kiếm");
		lblTim.setIcon(new ImageIcon("Icon/find1.png"));
		txtTim = new JTextField(25);
		btnTim = new JButton("Tìm kiếm");
		pnTim.add(lblTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);
		//Vinh - 2-6
		JPanel pnThem = new JPanel();
		pnThem.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnThem.setBackground(new Color(230, 247, 255));
		btnThemTour = new JButton("Thêm Tour");
		pnThem.add(btnThemTour);
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnTim,BorderLayout.CENTER);
		pnNorth.add(pnThem,BorderLayout.EAST);
		pnTab1.add(pnNorth,BorderLayout.NORTH);
		JScrollPane jsc1 = new JScrollPane(pnTab1);
		pnTab1.add(pnCenter,BorderLayout.CENTER);
		add(jsc1,BorderLayout.CENTER);
		//
		TaiTourLen();
		
		btnThemTour.addActionListener(this);
		btnTim.addActionListener(this);
	}
	
	public void TaiTourLen() {
		pnCenter.removeAll();
		pnCenter.revalidate();
		try {  
			listTour = tour_dao.LayHetTour(); 
			for(Tour tour : listTour) { 
				JPanel pnItem = new TourTrongQuanLyTour(tour); 
				pnCenter.add(pnItem); 

			}
			pnCenter.revalidate();		 
		 } catch (Exception e2) { // TODO: handle exception
		 JOptionPane.showMessageDialog(this, e2); }
	}
	
	//Vinh -28-5
		private void TaiTourTimKiem(ArrayList<Tour> tourTimDuoc) {
			pnCenter.removeAll();
			 pnCenter.revalidate();
			for (Tour tour : tourTimDuoc) {
				JPanel pnItem = new TourTrongQuanLyTour(tour); 
				pnCenter.add(pnItem);  
				pnCenter.revalidate();
			}
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btnThemTour)) {
			new NhapSuaThongTinTour(new Tour(), 1);
		}
		else if(obj.equals(btnTim)) {
			ArrayList<Tour> tourTimDuoc = tour_dao.TimTour(txtTim.getText().toString().trim().toLowerCase(),true);
			if(tourTimDuoc.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Không tìm thấy!");
			}
			else {
				TaiTourTimKiem(tourTimDuoc);
			}	
		}
	}
}
