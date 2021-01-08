/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DiemDAO;
import DAO.HocKyDAO;
import DAO.HocSinhDAO;
import DAO.LopDAO;
import DAO.MonDAO;
import Entity.Diem;
import Entity.HocKy;
import Entity.HocSinh;
import Entity.Lop;
import Entity.Mon;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;

/**
 *
 * @author Vinh
 */
public class BangDiemMonHoc extends javax.swing.JFrame {

	DefaultTableModel model = null;

	/**
	 * Creates new form BangDiemMonHoc
	 */
	public BangDiemMonHoc() {
		initComponents();
		setResizable(false);
		/*
		 * ButtonGroup bG = new ButtonGroup(); bG.add(jrb_mahocsinh); bG.add(jrb_lop);
		 * bG.add(jrb_monhoc); bG.add(jrb_hocky);
		 */
		LoadData();
	}

	private void LoadData() {

		jcb_loptk.removeAllItems();
		jcb_lop.removeAllItems();
		List<Lop> dsLop = LopDAO.layDanhSachLop();
		for (int i = 0; i < dsLop.size(); i++) {
			jcb_lop.addItem(dsLop.get(i).getmalop());
			jcb_loptk.addItem(dsLop.get(i).getmalop());
		}
		jcb_monhoctk.removeAllItems();
		jcb_monhoc.removeAllItems();
		List<Mon> dsMon = MonDAO.layDanhSachMon();
		for (int i = 0; i < dsMon.size(); i++) {
			jcb_monhoc.addItem(dsMon.get(i).getmamon());
			jcb_monhoctk.addItem(dsMon.get(i).getmamon());
		}
		jcb_hockytk.removeAllItems();
		jcb_hocky.removeAllItems();
		List<HocKy> dsHocKy = HocKyDAO.layDanhSachHocKy();
		for (int i = 0; i < dsHocKy.size(); i++) {
			jcb_hocky.addItem(dsHocKy.get(i).getmahocky());
			jcb_hockytk.addItem(dsHocKy.get(i).getmahocky());
		}
//        JOptionPane.showMessageDialog(this, jcb_lop.getSelectedItem().toString().trim()+ dsHocSinh.size(), "Thông báo", JOptionPane.WARNING_MESSAGE);
		List<Diem> listDiem;
		String[] columns = new String[] { "Lớp", "Môn Học ", "Học Kỳ", "Mã Học Sinh", "Điểm Miệng", "Điểm 15'",
				"Điểm 1 Tiêt", "Điểm Thi", };
		model = new DefaultTableModel(null, columns);

		listDiem = DiemDAO.layDanhSachDiem();

		for (int i = 0; i < listDiem.size(); i++) {
			Diem diem = (Diem) listDiem.get(i);
			String diemmieng="";
			if(diem.getDiemmieng1()!=null)
			{
				 diemmieng += String.valueOf(diem.getDiemmieng1()) + " ";
			}
			if(diem.getDiemmieng2()!=null)
			{
				 diemmieng += String.valueOf(diem.getDiemmieng2()) + " ";
			}
			if(diem.getDiemmieng3()!=null)
			{
				 diemmieng += String.valueOf(diem.getDiemmieng3());
			}
			String diem15ph="";
			if(diem.getDiem15ph1()!=null)
			{
				 diem15ph += String.valueOf(diem.getDiem15ph1()) + " " ;
			}
			if(diem.getDiem15ph2()!=null)
			{
				 diem15ph += String.valueOf(diem.getDiem15ph2()) + " " ;
			}
			if(diem.getDiem15ph3()!=null)
			{
				 diem15ph += String.valueOf(diem.getDiem15ph3()) + " " ;
			}
			String diem45ph="";
			if(diem.getDiem1tiet1()!=null)
			{
				diem45ph += String.valueOf(diem.getDiem1tiet1()) + " " ;
			}
			if(diem.getDiem1tiet2()!=null)
			{
				diem45ph += String.valueOf(diem.getDiem1tiet2()) + " " ;
			}
			if(diem.getDiem1tiet3()!=null)
			{
				diem45ph += String.valueOf(diem.getDiem1tiet3()) ;
			}
			

			
			

			Object[] items = new Object[] { diem.getMalop(), diem.getMamonhoc(), diem.getMahocky(), diem.getMahocsinh(),
					diemmieng, diem15ph, diem45ph, diem.getDiemhocky() };
			model.addRow(items);
		}
		jtb_diem.setModel(model);
		jtb_diem.setRowHeight(30);
		jtb_diem.getColumnModel().getColumn(0).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(4).setPreferredWidth(100);
		jtb_diem.getColumnModel().getColumn(5).setPreferredWidth(100);
		jtb_diem.getColumnModel().getColumn(6).setPreferredWidth(100);
		jtb_diem.getColumnModel().getColumn(7).setPreferredWidth(100);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jComboBox1 = new javax.swing.JComboBox<String>();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		txt_mahocsinhtk = new javax.swing.JTextField();
		jrb_lop = new javax.swing.JRadioButton();
		jrb_hocky = new javax.swing.JRadioButton();
		jcb_monhoctk = new javax.swing.JComboBox<String>();
		jrb_monhoc = new javax.swing.JRadioButton();
		jcb_hockytk = new javax.swing.JComboBox<String>();
		jcb_loptk = new javax.swing.JComboBox<String>();
		jrb_mahocsinh = new javax.swing.JRadioButton();
		jPanel6 = new javax.swing.JPanel();
		jbt_inbangdiem = new javax.swing.JButton();
		jbt_tim = new javax.swing.JButton();
		jbt_thoat = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jtb_diem = new javax.swing.JTable();
		jPanel2 = new javax.swing.JPanel();
		jPanel3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jtf_diemmieng1 = new javax.swing.JTextField();
		jLabel7 = new javax.swing.JLabel();
		jtf_diemmieng2 = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jtf_diemmieng3 = new javax.swing.JTextField();
		jcb_lop = new javax.swing.JComboBox<String>();
		jcb_monhoc = new javax.swing.JComboBox<String>();
		jcb_hocky = new javax.swing.JComboBox<String>();
		jtb_nhapdiem = new javax.swing.JButton();
		jLabel9 = new javax.swing.JLabel();
		jcb_mahocsinh = new javax.swing.JComboBox<String>();
		jbt_lammoi = new javax.swing.JButton();
		jbt_suadiem = new javax.swing.JButton();
		jLabel10 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();

		jComboBox1.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Bảng Điểm Môn Học");
		setBackground(new java.awt.Color(255, 255, 255));

		jPanel1.setBackground(new java.awt.Color(255, 255, 255));

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel2.setText("Tìm Kiếm");

		txt_mahocsinhtk.setText(" ");

		jrb_lop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jrb_lop.setText("Lớp");
		jrb_lop.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jrb_lopActionPerformed(evt);
			}
		});
		jrb_lop.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jrb_lopFocusGained(evt);
			}
		});

		jrb_hocky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jrb_hocky.setText("Học Kỳ");
		jrb_hocky.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jrb_hockyActionPerformed(evt);
			}
		});
		jrb_hocky.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jrb_hockyFocusGained(evt);
			}
		});

		jcb_monhoctk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jcb_monhoctk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb_monhoctkActionPerformed(evt);
			}
		});

		jrb_monhoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jrb_monhoc.setText("Môn Học");
		jrb_monhoc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jrb_monhocActionPerformed(evt);
			}
		});
		jrb_monhoc.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jrb_monhocFocusGained(evt);
			}
		});

		jcb_hockytk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jcb_hockytk.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jcb_hockytkActionPerformed(evt);
			}
		});

		jcb_loptk.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		jrb_mahocsinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jrb_mahocsinh.setText("Mã Học Sinh");
		jrb_mahocsinh.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jrb_mahocsinhMouseClicked(evt);
			}
		});
		jrb_mahocsinh.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jrb_mahocsinhItemStateChanged(evt);
			}
		});
		jrb_mahocsinh.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				jrb_mahocsinhFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				jrb_mahocsinhFocusLost(evt);
			}
		});

		jPanel6.setBackground(new java.awt.Color(255, 255, 255));

		javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
		jPanel6.setLayout(jPanel6Layout);
		jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));
		jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE));

		jbt_inbangdiem.setBackground(new java.awt.Color(255, 102, 0));
		jbt_inbangdiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jbt_inbangdiem.setText("In Bảng Điểm");
		jbt_inbangdiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbt_inbangdiemActionPerformed(evt);
			}
		});

		jbt_tim.setBackground(new java.awt.Color(255, 102, 0));
		jbt_tim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jbt_tim.setText("Tìm");
		jbt_tim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbt_timActionPerformed(evt);
			}
		});

		jbt_thoat.setBackground(new java.awt.Color(255, 102, 0));
		jbt_thoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jbt_thoat.setText("Thoát");
		jbt_thoat.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbt_thoatActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2).addGap(0, 0,
						Short.MAX_VALUE))
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(45, 45, 45)
						.addComponent(jbt_tim, javax.swing.GroupLayout.PREFERRED_SIZE, 105,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jbt_inbangdiem).addGap(199, 199, 199))
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jrb_hocky)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jcb_loptk, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jcb_hockytk, javax.swing.GroupLayout.PREFERRED_SIZE, 170,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addComponent(jrb_lop)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(jrb_monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 101,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(jcb_monhoctk, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jrb_mahocsinh)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jbt_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 115,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_mahocsinhtk, javax.swing.GroupLayout.PREFERRED_SIZE,
														85, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(25, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(11, 11, 11)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jrb_hocky)
								.addComponent(jcb_hockytk, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jrb_monhoc)
								.addComponent(jcb_monhoctk, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(32, 32, 32)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jrb_lop)
								.addComponent(jcb_loptk, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jrb_mahocsinh).addComponent(txt_mahocsinhtk,
										javax.swing.GroupLayout.PREFERRED_SIZE, 23,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jbt_tim).addComponent(jbt_inbangdiem).addComponent(jbt_thoat))
						.addContainerGap()));

		jtb_diem.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null } },
				new String[] { "STT", "Họ Tên", "Điểm Miệng", "Điểm 15'", "Điểm 1 Tiết", "Điểm Cuối HK" }) {
			Class[] types = new Class[] { java.lang.Integer.class, java.lang.String.class, java.lang.Float.class,
					java.lang.Float.class, java.lang.Float.class };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}
		});
		jtb_diem.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jtb_diemMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(jtb_diem);

		jPanel2.setBackground(new java.awt.Color(153, 255, 204));
		jPanel2.setLayout(new java.awt.GridBagLayout());

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel3.setText("Tên Lớp");

		jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel4.setText("Môn Học");

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel5.setText("Học Kỳ");

		jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel6.setText("Điểm miệng 1");

		jtf_diemmieng1.setText(" ");
		jtf_diemmieng1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jtf_diemmieng1KeyTyped(evt);
			}
		});

		jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel7.setText("Điểm miệng 2");

		jtf_diemmieng2.setText(" ");
		jtf_diemmieng2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtf_diemmieng2ActionPerformed(evt);
			}
		});
		jtf_diemmieng2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jtf_diemmieng2KeyTyped(evt);
			}
		});

		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel8.setText("Điểm miệng 3");

		jtf_diemmieng3.setText(" ");
		jtf_diemmieng3.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				jtf_diemmieng3KeyTyped(evt);
			}
		});

		jcb_lop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jcb_lop.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jcb_lopMouseClicked(evt);
			}
		});
		jcb_lop.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				jcb_lopItemStateChanged(evt);
			}
		});

		jcb_monhoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		jcb_hocky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		jtb_nhapdiem.setBackground(new java.awt.Color(255, 102, 0));
		jtb_nhapdiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jtb_nhapdiem.setText("Nhập Điểm");
		jtb_nhapdiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jtb_nhapdiemActionPerformed(evt);
			}
		});

		jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel9.setText("Mã Học Sinh");

		jcb_mahocsinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		jbt_lammoi.setBackground(new java.awt.Color(255, 102, 0));
		jbt_lammoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jbt_lammoi.setText("Làm Mới");
		jbt_lammoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbt_lammoiActionPerformed(evt);
			}
		});

		jbt_suadiem.setBackground(new java.awt.Color(255, 102, 0));
		jbt_suadiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jbt_suadiem.setText("Sửa Điểm");
		jbt_suadiem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jbt_suadiemActionPerformed(evt);
			}
		});

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		jLabel10.setText("Nhập điểm môn học");

		jLabel6_1 = new JLabel();
		jLabel6_1.setText("Điểm 15' 1");
		jLabel6_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem15ph1 = new JTextField();
		jtf_diem15ph1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem15ph1.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem15ph1.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem15ph1.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diem15ph1.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem15ph1.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem15ph1.setText(" ");

		jLabel7_1 = new JLabel();
		jLabel7_1.setText("Điểm 15' 2");
		jLabel7_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem15ph2 = new JTextField();
		jtf_diem15ph2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem15ph2.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem15ph2.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem15ph2.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diem15ph2.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem15ph2.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem15ph2.setText(" ");

		jLabel8_1 = new JLabel();
		jLabel8_1.setText("Điểm 15' 3");
		jLabel8_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem15ph3 = new JTextField();
		jtf_diem15ph3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem15ph3.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem15ph3.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem15ph3.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diem15ph3.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem15ph3.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem15ph3.setText(" ");

		jLabel6_2 = new JLabel();
		jLabel6_2.setText("Điểm 45' 1");
		jLabel6_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem1tiet1 = new JTextField();
		jtf_diem1tiet1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem1tiet1.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem1tiet1.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem1tiet1.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diem1tiet1.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem1tiet1.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem1tiet1.setText(" ");

		jLabel7_2 = new JLabel();
		jLabel7_2.setText("Điểm 45' 2");
		jLabel7_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem1tiet2 = new JTextField();
		jtf_diem1tiet2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem1tiet2.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem1tiet2.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem1tiet2.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diemmieng1.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem1tiet2.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem1tiet2.setText(" ");

		jLabel8_2 = new JLabel();
		jLabel8_2.setText("Điểm 45' 3");
		jLabel8_2.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diem1tiet3 = new JTextField();
		jtf_diem1tiet3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diem1tiet3.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diem1tiet3.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diem1tiet3.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diem1tiet3.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diem1tiet3.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diem1tiet3.setText(" ");

		jLabel6_3 = new JLabel();
		jLabel6_3.setText("Điểm thi");
		jLabel6_3.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 12));

		jtf_diemhocky = new JTextField();
		jtf_diemhocky.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();

		        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
		            evt.consume();
		        if (jtf_diemhocky.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		        if (jtf_diemhocky.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
		        {
		        	
		     		   evt.consume();
		     	   
		        }
		       if (jtf_diemhocky.getText().length()>=1)
		       {
		    	   if (Double.parseDouble(jtf_diemhocky.getText()+c) > 10)
		    	   {
		    		   evt.consume();
		    	   }
		       }
		        if (jtf_diemhocky.getText().length() >= 3 ) // limit textfield to 3 characters
		            evt.consume(); 
			}
		});
		jtf_diemhocky.setText(" ");

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout
				.createParallelGroup(
						Alignment.LEADING)
				.addGroup(
						jPanel3Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(
										jPanel3Layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
														.addGroup(jPanel3Layout.createSequentialGroup().addGap(11)
																.addComponent(jLabel5))
														.addComponent(jLabel3))
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addGroup(jPanel3Layout
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(jLabel6_2, Alignment.LEADING, 0, 0,
																		Short.MAX_VALUE)
																.addComponent(
																		jLabel6_1, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(29)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout
										.createSequentialGroup()
										.addComponent(
												jcb_hocky, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
										.addGap(17)
										.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel9)
														.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
																.addGroup(jPanel3Layout.createSequentialGroup()
																		.addGap(10).addComponent(jcb_monhoc,
																				GroupLayout.PREFERRED_SIZE, 170,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel3Layout
																		.createSequentialGroup()
																		.addPreferredGap(ComponentPlacement.UNRELATED)
																		.addComponent(
																				jcb_mahocsinh,
																				GroupLayout.PREFERRED_SIZE, 85,
																				GroupLayout.PREFERRED_SIZE))))
												.addComponent(jLabel4))
										.addContainerGap(56, Short.MAX_VALUE))
										.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
												.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
														.createParallelGroup(Alignment.LEADING, false)
														.addGroup(jPanel3Layout
																.createSequentialGroup()
																.addComponent(jcb_lop, GroupLayout.PREFERRED_SIZE, 85,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(114))
														.addGroup(
																jPanel3Layout.createSequentialGroup().addGap(18)
																		.addGroup(jPanel3Layout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(jtf_diemmieng1,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtf_diem15ph1,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtf_diem1tiet1,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtf_diemhocky,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(jPanel3Layout
																				.createParallelGroup(Alignment.LEADING)
																				.addComponent(jLabel7)
																				.addGroup(jPanel3Layout
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addComponent(jLabel7_2,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(jLabel7_1,
																								Alignment.LEADING,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)))
																		.addGap(18)))
														.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
																.addComponent(jtf_diem15ph2, GroupLayout.PREFERRED_SIZE,
																		60, GroupLayout.PREFERRED_SIZE)
																.addComponent(
																		jtf_diem1tiet2, GroupLayout.PREFERRED_SIZE, 60,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jtf_diemmieng2,
																		GroupLayout.PREFERRED_SIZE, 60,
																		GroupLayout.PREFERRED_SIZE)))
												.addComponent(
														jbt_lammoi, GroupLayout.PREFERRED_SIZE, 105,
														GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
												.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
														.addComponent(
																jbt_suadiem, GroupLayout.PREFERRED_SIZE, 105,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(jPanel3Layout.createParallelGroup(
																Alignment.LEADING, false)
																.addGroup(
																		jPanel3Layout.createSequentialGroup()
																				.addComponent(jLabel8_2)
																				.addPreferredGap(
																						ComponentPlacement.RELATED,
																						GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jtf_diem1tiet3,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel3Layout.createSequentialGroup()
																		.addGroup(jPanel3Layout
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(jLabel8,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGap(18))
																				.addGroup(jPanel3Layout
																						.createSequentialGroup()
																						.addComponent(jLabel8_1)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)))
																		.addGroup(jPanel3Layout
																				.createParallelGroup(Alignment.TRAILING)
																				.addComponent(jtf_diemmieng3,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE)
																				.addComponent(jtf_diem15ph3,
																						GroupLayout.PREFERRED_SIZE, 60,
																						GroupLayout.PREFERRED_SIZE)))))
												.addGap(21))))
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addComponent(jLabel6)
								.addComponent(jLabel10))
						.addContainerGap(472, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup().addGap(90)
						.addComponent(jtb_nhapdiem, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(410, Short.MAX_VALUE))
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel6_3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(540, Short.MAX_VALUE)));
		jPanel3Layout
				.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel5)
										.addComponent(jcb_hocky, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel4).addComponent(jcb_monhoc, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jcb_mahocsinh, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel9)
										.addComponent(jcb_lop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel3))
								.addGap(12)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout
										.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
										.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING, false)
												.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel6).addComponent(jtf_diemmieng1,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(jtf_diemmieng2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel8, GroupLayout.DEFAULT_SIZE,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
												.addGroup(jPanel3Layout.createSequentialGroup()
														.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
																.addComponent(jLabel6_1, GroupLayout.PREFERRED_SIZE, 15,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(jtf_diem15ph1, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE))
														.addGap(5))
												.addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout
														.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel7_1, GroupLayout.PREFERRED_SIZE, 22,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jtf_diem15ph2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel8_1, GroupLayout.PREFERRED_SIZE, 22,
																GroupLayout.PREFERRED_SIZE))
														.addGap(7))))
										.addGroup(jPanel3Layout.createSequentialGroup()
												.addComponent(jtf_diemmieng3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jtf_diem15ph3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(13)))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout
										.createSequentialGroup()
										.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
												.addComponent(jtf_diem1tiet1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(jLabel7_2, GroupLayout.PREFERRED_SIZE, 22,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(jtf_diem1tiet2, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel3Layout.createSequentialGroup().addGap(2).addComponent(
														jLabel6_2, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
												.addComponent(jLabel6_3, GroupLayout.PREFERRED_SIZE, 15,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jtf_diemhocky, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addComponent(jtf_diem1tiet3, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel8_2, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE))
								.addGap(13)
								.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jtb_nhapdiem, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jbt_suadiem, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jbt_lammoi, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE))));
		jPanel3.setLayout(jPanel3Layout);

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setText("BẢNG ĐIỂM MÔN HỌC");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addComponent(
								jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(381, 381, 381).addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2)))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void LoadTimKiem(String malop, String mahocsinh, String mamon, String mahocky) {

		List<Diem> listDiem;
		String[] columns = new String[] { "Lớp", "Môn Học ", "Học Kỳ", "Mã Học Sinh","Điệm miệng", "Điểm 15'", "Điểm 1 Tiêt",
				"Điểm Thi", };
		model = new DefaultTableModel(null, columns);

		listDiem = DiemDAO.TimKiem(malop, mahocsinh, mamon, mahocky);

		for (int i = 0; i < listDiem.size(); i++) {
			Diem diem = (Diem) listDiem.get(i);

			String diemmieng = String.valueOf(diem.getDiemmieng1()) + " " + String.valueOf(diem.getDiemmieng3()) + " "
					+ String.valueOf(diem.getDiemmieng3());

			String diem15ph = String.valueOf(diem.getDiem15ph1()) + " " + String.valueOf(diem.getDiem15ph2()) + " "
					+ String.valueOf(diem.getDiem15ph3());
			String diem45ph = String.valueOf(diem.getDiem1tiet1()) + " " + String.valueOf(diem.getDiem1tiet2()) + " "
					+ String.valueOf(diem.getDiem1tiet3());

			Object[] items = new Object[] { diem.getMalop(), diem.getMamonhoc(), diem.getMahocky(), diem.getMahocsinh(),
					diemmieng, diem15ph, diem45ph, diem.getDiemhocky() };
			model.addRow(items);
		}
		jtb_diem.setModel(model);
		jtb_diem.setRowHeight(30);
		jtb_diem.getColumnModel().getColumn(0).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(1).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(2).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(3).setPreferredWidth(200);
		jtb_diem.getColumnModel().getColumn(4).setPreferredWidth(100);
		jtb_diem.getColumnModel().getColumn(5).setPreferredWidth(100);
		jtb_diem.getColumnModel().getColumn(6).setPreferredWidth(100);
	}

	private void jbt_timActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbt_timActionPerformed
		// TODO add your handling code here:
		String mahocsinh = null;
		String mamon = null;
		String malop = null;
		String mahocky = null;
		if (jrb_mahocsinh.isSelected() == true) {
			mahocsinh = txt_mahocsinhtk.getText().trim();
		}
		if (jrb_lop.isSelected() == true) {
			malop = jcb_loptk.getSelectedItem().toString().trim();
		}
		if (jrb_monhoc.isSelected() == true) {
			mamon = jcb_monhoctk.getSelectedItem().toString().trim();
		} 
		if (jrb_hocky.isSelected() == true){
			mahocky = jcb_hockytk.getSelectedItem().toString().trim();
		}
		LoadTimKiem(malop, mahocsinh, mamon, mahocky);
	}// GEN-LAST:event_jbt_timActionPerformed

	private void jrb_monhocActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrb_monhocActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jrb_monhocActionPerformed

	private void jtf_diemmieng2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtf_diemmieng2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jtf_diemmieng2ActionPerformed

	private void jtb_nhapdiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtb_nhapdiemActionPerformed
		// TODO add your handling code here:
		// TODO add your handling code here:
		String malop = jcb_lop.getSelectedItem().toString();
		String mamonhoc = jcb_monhoc.getSelectedItem().toString();
		String mahocky = jcb_hocky.getSelectedItem().toString();
		String mahocsinh = jcb_mahocsinh.getSelectedItem().toString();


		
			float diemheso1 = 0;
			float flag = 0;
			Float diemmieng1=null;
			if (!jtf_diemmieng1.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng1.getText());
				diemmieng1 = Float.parseFloat(jtf_diemmieng1.getText());
				flag++;
			}
			Float diemmieng2=null ;
			if (!jtf_diemmieng2.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng2.getText());
				diemmieng2 = Float.parseFloat(jtf_diemmieng2.getText());
				flag++;
			}
			Float diemmieng3=null;
			if (!jtf_diemmieng3.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng3.getText());
				diemmieng3 = Float.parseFloat(jtf_diemmieng3.getText());
				flag++;
			}
			Float diem15ph1=null ;
			if (!jtf_diem15ph1.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph1.getText());
				diem15ph1 = Float.parseFloat(jtf_diem15ph1.getText());
				flag++;
			}
			Float diem15ph2=null ;
			if (!jtf_diem15ph2.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph2.getText());
				diem15ph2 = Float.parseFloat(jtf_diem15ph2.getText());
				flag++;
			}
			Float diem15ph3=null ;
			if (!jtf_diem15ph3.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph3.getText());
				diem15ph3 = Float.parseFloat(jtf_diem15ph3.getText());
				flag++;
			}
			float diemheso2 = 0;
			Float diem1tiet1 = null;
			if (!jtf_diem1tiet1.getText().trim().equals("")) {

				diemheso2 += (Float.parseFloat(jtf_diem1tiet1.getText()) * 2);
				diem1tiet1 = Float.parseFloat(jtf_diem1tiet1.getText());
				flag += 2;
			}
			Float diem1tiet2 = null;
			if (!jtf_diem1tiet2.getText().trim().equals("")) {
				diemheso2 += Float.parseFloat(jtf_diem1tiet2.getText()) * 2;
				diem1tiet2 = Float.parseFloat(jtf_diem1tiet2.getText());
				flag += 2;
			}
			Float diem1tiet3 = null;
			if (!jtf_diem1tiet3.getText().trim().equals("")) {
				diemheso2 += Float.parseFloat(jtf_diem1tiet3.getText()) * 2;
				diem1tiet3 = Float.parseFloat(jtf_diem1tiet3.getText());
				flag += 2;
			}
			float diemheso3 = 0;
			Float diemhocky = null;
			if (!jtf_diemhocky.getText().trim().equals("")) {
				diemheso3 = Float.parseFloat(jtf_diemhocky.getText()) * 3;
				diemhocky = Float.parseFloat(jtf_diemhocky.getText());
				flag += 3;
			}
			float diemtbmon = (diemheso1 + diemheso2 + diemheso3) / flag;
			Diem diem = new Diem(mahocsinh, mamonhoc, mahocky, malop, diemtbmon, diemmieng1, diemmieng2, diemmieng3,
					diem15ph1, diem15ph2, diem15ph3, diem1tiet1, diem1tiet2, diem1tiet3, diemhocky);
			String result = DiemDAO.themDiem(diem);
			if (result.equals("true")) {
				JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				LoadData();
				lamMoi();
				
				
			} else {
				if (result.equals("existed"))
				{
					JOptionPane.showMessageDialog(this, "Điểm môn "+mamonhoc+ " đã được thêm vào, vui lòng kiểm tra lại", "Thông báo", JOptionPane.WARNING_MESSAGE);

				}
				else
				JOptionPane.showMessageDialog(this, "Nhập điểm thất bại !", "Thông báo", JOptionPane.WARNING_MESSAGE);
			}
		

	}// GEN-LAST:event_jtb_nhapdiemActionPerformed

	boolean kiemtra() {
		boolean flag = true;
		if (jtf_diemmieng1.getText().trim().equals(""))
			flag = false;
		if (jtf_diemmieng2.getText().trim().equals(""))
			flag = false;
		if (jtf_diemmieng2.getText().trim().equals(""))
			flag = false;
		return flag;

	};

	private void jbt_suadiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbt_suadiemActionPerformed
		// TODO add your handling code here:
		/* if (kiemtra()) { */
			String malop = jcb_lop.getSelectedItem().toString();
			String mamonhoc = jcb_monhoc.getSelectedItem().toString();
			String mahocky = jcb_hocky.getSelectedItem().toString();
			String mahocsinh = jcb_mahocsinh.getSelectedItem().toString();


			

			float diemheso1 = 0;
			float flag = 0;
			Float diemmieng1=null;
			if (!jtf_diemmieng1.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng1.getText());
				diemmieng1 = Float.parseFloat(jtf_diemmieng1.getText());
				flag++;
			}
			Float diemmieng2=null ;
			if (!jtf_diemmieng2.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng2.getText());
				diemmieng2 = Float.parseFloat(jtf_diemmieng2.getText());
				flag++;
			}
			Float diemmieng3=null;
			if (!jtf_diemmieng3.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diemmieng3.getText());
				diemmieng3 = Float.parseFloat(jtf_diemmieng3.getText());
				flag++;
			}
			Float diem15ph1=null ;
			if (!jtf_diem15ph1.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph1.getText());
				diem15ph1 = Float.parseFloat(jtf_diem15ph1.getText());
				flag++;
			}
			Float diem15ph2=null ;
			if (!jtf_diem15ph2.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph2.getText());
				diem15ph2 = Float.parseFloat(jtf_diem15ph2.getText());
				flag++;
			}
			Float diem15ph3=null ;
			if (!jtf_diem15ph3.getText().trim().equals("")) {
				diemheso1 += Float.parseFloat(jtf_diem15ph3.getText());
				diem15ph3 = Float.parseFloat(jtf_diem15ph3.getText());
				flag++;
			}
			float diemheso2 = 0;
			Float diem1tiet1 = null;
			if (!jtf_diem1tiet1.getText().trim().equals("")) {

				diemheso2 += (Float.parseFloat(jtf_diem1tiet1.getText()) * 2);
				diem1tiet1 = Float.parseFloat(jtf_diem1tiet1.getText());
				flag += 2;
			}
			Float diem1tiet2 = null;
			if (!jtf_diem1tiet2.getText().trim().equals("")) {
				diemheso2 += Float.parseFloat(jtf_diem1tiet2.getText()) * 2;
				diem1tiet2 = Float.parseFloat(jtf_diem1tiet2.getText());
				flag += 2;
			}
			Float diem1tiet3 = null;
			if (!jtf_diem1tiet3.getText().trim().equals("")) {
				diemheso2 += Float.parseFloat(jtf_diem1tiet3.getText()) * 2;
				diem1tiet3 = Float.parseFloat(jtf_diem1tiet3.getText());
				flag += 2;
			}
			float diemheso3 = 0;
			Float diemhocky = null;
			if (!jtf_diemhocky.getText().trim().equals("")) {
				diemheso3 = Float.parseFloat(jtf_diemhocky.getText()) * 3;
				diemhocky = Float.parseFloat(jtf_diemhocky.getText());
				flag += 3;
			}
			float diemtbmon = (diemheso1 + diemheso2 + diemheso3) / flag;
			Diem diem = new Diem(mahocsinh, mamonhoc, mahocky, malop, diemtbmon, diemmieng1, diemmieng2, diemmieng3,
					diem15ph1, diem15ph2, diem15ph3, diem1tiet1, diem1tiet2, diem1tiet3, diemhocky);
				boolean result = DiemDAO.capNhatDiem(diem);
				if (result) {
					JOptionPane.showMessageDialog(this, "Cập nhật thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
					LoadData();
					lamMoi();
				} else {
					JOptionPane.showMessageDialog(this, "Sửa thất bại !", "Thông báo", JOptionPane.WARNING_MESSAGE);
				}
			
		
		/*
		 * else JOptionPane.showMessageDialog(this,
		 * "Bạn Cần Nhập Đầy Đủ Thông Tin Điểm !", "Thông báo",
		 * JOptionPane.WARNING_MESSAGE);
		 */

	}// GEN-LAST:event_jbt_suadiemActionPerformed

	private void jrb_mahocsinhMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jrb_mahocsinhMouseClicked
		// TODO add your handling code here:

	}// GEN-LAST:event_jrb_mahocsinhMouseClicked

	private void jrb_mahocsinhItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jrb_mahocsinhItemStateChanged
		// TODO add your handling code here:

	}// GEN-LAST:event_jrb_mahocsinhItemStateChanged

	private void jcb_lopMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jcb_lopMouseClicked
		// TODO add your handling code here:

	}// GEN-LAST:event_jcb_lopMouseClicked

	private void jcb_lopItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_jcb_lopItemStateChanged
		// TODO add your handling code here:
		if (jcb_lop.getSelectedItem() != null) {
			jcb_mahocsinh.removeAllItems();

			List<HocSinh> dsHocSinh = HocSinhDAO.LopCoBaoNhieuHocSinh(jcb_lop.getSelectedItem().toString().trim());
			for (int i = 0; i < dsHocSinh.size(); i++) {
				jcb_mahocsinh.addItem(String.valueOf(dsHocSinh.get(i).getmahocsinh()));
			}
		}
	}// GEN-LAST:event_jcb_lopItemStateChanged

	private void jbt_inbangdiemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbt_inbangdiemActionPerformed
		// TODO add your handling code here:
		// tạo một document
		Document document = new Document();

		try {
			// khởi tạo một PdfWriter truyền vào document và FileOutputStream
			String tenfile="BangDiem";
			if (jrb_mahocsinh.isSelected() == true) {
				tenfile += txt_mahocsinhtk.getText().trim();
			}
			if (jrb_lop.isSelected() == true) {
				tenfile += ("_" +jcb_loptk.getSelectedItem().toString().trim());
			}
			if (jrb_monhoc.isSelected() == true) {
				tenfile += ("_" + jcb_monhoctk.getSelectedItem().toString().trim());
			} 
			if (jrb_hocky.isSelected() == true){
				tenfile += ( "_" + jcb_hockytk.getSelectedItem().toString().trim());
			}
			PdfWriter.getInstance(document, new FileOutputStream("report\\bangdiem\\"+tenfile+".pdf"));

			// mở file để thực hiện viết
			document.open();
			// thêm nội dung sử dụng add function
			Paragraph title1 = new Paragraph("Student Scoreboard",
					FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
			title1.setAlignment(Element.ALIGN_CENTER);
			document.add(title1);

			for (int count = 0; count < model.getRowCount(); count++) {
				// Khai báo 2 paragraph
				String ten = "";
				if (count == 0)
					ten = model.getValueAt(count, 3).toString();
				String tenequal = model.getValueAt(count, 3).toString().trim();
				if (count == 0 || !ten.equals(tenequal)) {
					Paragraph lop = new Paragraph("Class :  " + model.getValueAt(count, 0).toString());
					Paragraph hocky = new Paragraph("Semester:  " + model.getValueAt(count, 2).toString());
					Paragraph hoten = new Paragraph("Name:  " + model.getValueAt(count, 3).toString());
					hocky.setAlignment(Element.ALIGN_LEFT);
					hoten.setAlignment(Element.ALIGN_LEFT);
					document.add(lop);
					document.add(hocky);
					document.add(hoten);
				}

				Paragraph mon = new Paragraph("Subjects:  " + model.getValueAt(count, 1).toString());
				// Định dạng đoạn văn bản thứ nhất
//                paragraph1.setIndentationLeft(80);
//                paragraph1.setIndentationRight(80);

				mon.setAlignment(Element.ALIGN_LEFT);

//                paragraph1.setSpacingAfter(15);
				// Đinh dạng đoạn văn bản thứ 2
//                paragraph2.setSpacingBefore(15);

				document.add(mon);

				// Khởi tạo một table có 3 cột
				PdfPTable t = new PdfPTable(4);
				t.setSpacingBefore(25);
				t.setSpacingAfter(25);
				PdfPCell c1 = new PdfPCell(new Phrase(" Diem Mieng' "));
				t.addCell(c1);
				PdfPCell c2 = new PdfPCell(new Phrase(" Diem 15' "));
				t.addCell(c2);
				PdfPCell c3 = new PdfPCell(new Phrase(" Diem 1Tiet "));
				t.addCell(c3);
				PdfPCell c4 = new PdfPCell(new Phrase(" Diem Thi "));
				t.addCell(c4);
				if(model.getValueAt(count, 4)!=null)
				{
					t.addCell(model.getValueAt(count, 4).toString());
				}
				else
				{
					t.addCell("");
				}
				if(model.getValueAt(count, 5)!=null)
				{
					t.addCell(model.getValueAt(count, 5).toString());
				}
				else
				{
					t.addCell("");
				}
				if(model.getValueAt(count, 6)!=null)
				{
					t.addCell(model.getValueAt(count, 6).toString());
				}
				else
				{
					t.addCell("");
				}
				if(model.getValueAt(count, 7)!=null)
				{
					t.addCell(model.getValueAt(count, 7).toString());
				}
				else
				{
					t.addCell("");
				}
				document.add(t);
				// đóng file
			}

			document.close();
			JOptionPane.showMessageDialog(this, "In Hoàn Tất", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}// GEN-LAST:event_jbt_inbangdiemActionPerformed

	private void jtb_diemMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jtb_diemMouseClicked
		// TODO add your handling code here:
		lamMoi();
		jcb_monhoc.setEnabled(false);
		int index = jtb_diem.getSelectedRow();
		jcb_lop.setSelectedItem((String) (model.getValueAt(index, 0)));
		jcb_monhoc.setSelectedItem((String) (model.getValueAt(index, 1)));
		jcb_hocky.setSelectedItem((String) (model.getValueAt(index, 2)));
		jcb_mahocsinh.setSelectedItem((String) (model.getValueAt(index, 3)));
//      diem 15ph split
		String[] diemmieng = ((String) model.getValueAt(index, 4)).split("\\s");
		if (diemmieng.length>=1)
		jtf_diemmieng1.setText(diemmieng[0]);
		if (diemmieng.length>=2)
		jtf_diemmieng2.setText(diemmieng[1]);
		if (diemmieng.length>=3)
		jtf_diemmieng3.setText(diemmieng[2]);
//
//        diem 15ph split
		String[] diem15ph = ((String) model.getValueAt(index, 5)).split("\\s");
		if (diem15ph.length>=1)
		jtf_diem15ph1.setText(diem15ph[0]);
		if (diem15ph.length>=2)
		jtf_diem15ph2.setText(diem15ph[1]);
		if (diem15ph.length>=3)
		jtf_diem15ph3.setText(diem15ph[2]);
//

//      diem 45ph split
		String[] diem45ph = ((String) model.getValueAt(index, 6)).split("\\s");
		if(diem45ph.length>=1)
		jtf_diem1tiet1.setText(diem45ph[0]);
		if(diem45ph.length>=2)
		jtf_diem1tiet2.setText(diem45ph[1]);
		if(diem45ph.length>=3)
		jtf_diem1tiet3.setText(diem45ph[2]);
//
		String s= (String) (String.valueOf(model.getValueAt(index, 7)));
		if(! s.equals("null"))
		{
			jtf_diemhocky.setText((String) (String.valueOf(model.getValueAt(index, 7))));
		}
			
		
	}// GEN-LAST:event_jtb_diemMouseClicked

	private void jbt_thoatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbt_thoatActionPerformed
		// TODO add your handling code here:
		setVisible(false); // you can't see me!
		dispose();
	}// GEN-LAST:event_jbt_thoatActionPerformed

	private void lamMoi() {
		jtf_diemmieng1.setText(null);
		jtf_diemmieng2.setText(null);
		jtf_diemmieng3.setText(null);
		jtf_diem15ph1.setText(null);
		jtf_diem15ph2.setText(null);
		jtf_diem15ph3.setText(null);
		jtf_diem1tiet1.setText(null);
		jtf_diem1tiet2.setText(null);
		jtf_diem1tiet3.setText(null);
		jtf_diemhocky.setText(null);
		jcb_monhoc.setSelectedItem(null);
		jcb_monhoc.setEnabled(true);
		jcb_hocky.setSelectedItem(null);
		jcb_mahocsinh.setSelectedItem(null);
	}

	private void jbt_lammoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbt_lammoiActionPerformed
		// TODO add your handling code here:
		lamMoi();
	}// GEN-LAST:event_jbt_lammoiActionPerformed

	private void jrb_mahocsinhFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jrb_mahocsinhFocusGained
		// TODO add your handling code here:
		/*
		 * if (jrb_mahocsinh.isEnabled() == true) jbt_inbangdiem.setEnabled(true);
		 */
	}// GEN-LAST:event_jrb_mahocsinhFocusGained

	private void jrb_mahocsinhFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jrb_mahocsinhFocusLost
		// TODO add your handling code here:
		/*
		 * if (jrb_mahocsinh.isEnabled() == false) jbt_inbangdiem.setEnabled(false);
		 */
	}// GEN-LAST:event_jrb_mahocsinhFocusLost

	private void jrb_lopFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jrb_lopFocusGained
		// TODO add your handling code here:
		/* jbt_inbangdiem.setEnabled(false); */ 
	}// GEN-LAST:event_jrb_lopFocusGained

	private void jrb_monhocFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jrb_monhocFocusGained
		// TODO add your handling code here:
		/* jbt_inbangdiem.setEnabled(false); */
	}// GEN-LAST:event_jrb_monhocFocusGained

	private void jrb_hockyFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jrb_hockyFocusGained
		// TODO add your handling code here:
		/* jbt_inbangdiem.setEnabled(false); */
	}// GEN-LAST:event_jrb_hockyFocusGained

	private void jtf_diemmieng1KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtf_diemmieng1KeyTyped
		// TODO add your handling code here:
		char c = evt.getKeyChar();

        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
            evt.consume();
        if (jtf_diemmieng1.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
        if (jtf_diemmieng1.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
       if (jtf_diemmieng1.getText().length()>=1)
       {
    	   if (Double.parseDouble(jtf_diemmieng1.getText()+c) > 10)
    	   {
    		   evt.consume();
    	   }
       }
        if (jtf_diemmieng1.getText().length() >= 3 ) // limit textfield to 3 characters
            evt.consume(); 
//     
	}// GEN-LAST:event_jtf_diemmieng1KeyTyped

	private void jtf_diemmieng2KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtf_diemmieng2KeyTyped
		// TODO add your handling code here:
		char c = evt.getKeyChar();

        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
            evt.consume();
        if (jtf_diemmieng2.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
        if (jtf_diemmieng2.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
       if (jtf_diemmieng2.getText().length()>=1)
       {
    	   if (Double.parseDouble(jtf_diemmieng2.getText()+c) > 10)
    	   {
    		   evt.consume();
    	   }
       }
        if (jtf_diemmieng2.getText().length() >= 3 ) // limit textfield to 3 characters
            evt.consume(); 
	}// GEN-LAST:event_jtf_diemmieng2KeyTyped

	private void jtf_diemmieng3KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtf_diemmieng3KeyTyped
		// TODO add your handling code here:
		char c = evt.getKeyChar();

        if(!(Character.isDigit(c)  || (c== KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE ||c== KeyEvent.VK_PERIOD ))
            evt.consume();
        if (jtf_diemmieng3.getText().length()==0 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
        if (jtf_diemmieng3.getText().length()>1 &&c==KeyEvent.VK_PERIOD)
        {
        	
     		   evt.consume();
     	   
        }
       if (jtf_diemmieng3.getText().length()>=1)
       {
    	   if (Double.parseDouble(jtf_diemmieng3.getText()+c) > 10)
    	   {
    		   evt.consume();
    	   }
       }
        if (jtf_diemmieng3.getText().length() >= 3 ) // limit textfield to 3 characters
            evt.consume(); 
	}// GEN-LAST:event_jtf_diemmieng3KeyTyped

	private void jrb_hockyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrb_hockyActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jrb_hockyActionPerformed

	private void jcb_hockytkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcb_hockytkActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jcb_hockytkActionPerformed

	private void jcb_monhoctkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcb_monhoctkActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jcb_monhoctkActionPerformed

	private void jrb_lopActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jrb_lopActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jrb_lopActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(BangDiemMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BangDiemMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BangDiemMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BangDiemMonHoc.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BangDiemMonHoc().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel6;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JButton jbt_inbangdiem;
	private javax.swing.JButton jbt_lammoi;
	private javax.swing.JButton jbt_suadiem;
	private javax.swing.JButton jbt_thoat;
	private javax.swing.JButton jbt_tim;
	private javax.swing.JComboBox<String> jcb_hocky;
	private javax.swing.JComboBox<String> jcb_hockytk;
	private javax.swing.JComboBox<String> jcb_lop;
	private javax.swing.JComboBox<String> jcb_loptk;
	private javax.swing.JComboBox<String> jcb_mahocsinh;
	private javax.swing.JComboBox<String> jcb_monhoc;
	private javax.swing.JComboBox<String> jcb_monhoctk;
	private javax.swing.JRadioButton jrb_hocky;
	private javax.swing.JRadioButton jrb_lop;
	private javax.swing.JRadioButton jrb_mahocsinh;
	private javax.swing.JRadioButton jrb_monhoc;
	private javax.swing.JTable jtb_diem;
	private javax.swing.JButton jtb_nhapdiem;
	private javax.swing.JTextField jtf_diemmieng1;
	private javax.swing.JTextField jtf_diemmieng2;
	private javax.swing.JTextField jtf_diemmieng3;
	private javax.swing.JTextField txt_mahocsinhtk;
	private JLabel jLabel6_1;
	private JTextField jtf_diem15ph1;
	private JLabel jLabel7_1;
	private JTextField jtf_diem15ph2;
	private JLabel jLabel8_1;
	private JTextField jtf_diem15ph3;
	private JLabel jLabel6_2;
	private JTextField jtf_diem1tiet1;
	private JLabel jLabel7_2;
	private JTextField jtf_diem1tiet2;
	private JLabel jLabel8_2;
	private JTextField jtf_diem1tiet3;
	private JLabel jLabel6_3;
	private JTextField jtf_diemhocky;
	// End of variables declaration//GEN-END:variables
}