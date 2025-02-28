/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ChiTietHanhKiemDAO;
import DAO.DiemDAO;
import DAO.HanhKiemDAO;
import DAO.HocKyDAO;
import DAO.HocSinhDAO;
import DAO.TongKetDAO;
import Entity.ChiTietHanhKiem;
import Entity.Diem;
import Entity.HocKy;
import Entity.HocSinh;
import Entity.TongKet;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 *
 * @author L
 */
public class DanhSachHocSinh extends javax.swing.JFrame {

     DefaultTableModel model=null;
    /**
     * Creates new form DanhSachHocSinh
     */
    public DanhSachHocSinh() {
        initComponents();
        setResizable(false); 
        List<HocKy> dshk = HocKyDAO.layDanhSachHocKy();
        for (int i = 0; i < dshk.size(); i=i+2) {
            jcb_hocky.addItem(dshk.get(i).getNamhoc().toString());
            
        } 
        LoadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_dshocsinh = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbt_timkiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtf_lop = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcb_hocky = new javax.swing.JComboBox();
        jbtn_thoat2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Danh Sách Học Sinh");
        setPreferredSize(new java.awt.Dimension(840, 490));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("DANH SÁCH HỌC SINH");

        jtb_dshocsinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null,null, null, null, null, null,null, null, null, null,null,null},
                {null, null,null, null, null, null, null, null, null,null,null,null},
                {null, null, null,null, null, null, null, null, null,null,null,null},
                {null, null, null, null,null, null, null, null, null,null,null,null}
            },
            new String [] {
            		"STT","Mã", "Họ Tên", "Lớp", "TB Học Kỳ 1","Hạnh Kiểm HK1","Xếp Loại", "TB Học Kỳ 2","Hạnh Kiểm HK2","Xếp Loại","TBCN","HKCN","Xếp Loại"            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtb_dshocsinh);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jbt_timkiem.setBackground(new java.awt.Color(255, 51, 0));
        jbt_timkiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbt_timkiem.setText("Tìm Kiếm");
        jbt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_timkiemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nhập thông tin: tên lớp cần tìm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Lớp");

        jcb_hocky.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_hockyItemStateChanged(evt);
            }
        });

        jbtn_thoat2.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_thoat2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_thoat2.setText("Thoát");
        jbtn_thoat2.setToolTipText("");
        jbtn_thoat2.setMaximumSize(new java.awt.Dimension(95, 23));
        jbtn_thoat2.setMinimumSize(new java.awt.Dimension(95, 23));
        jbtn_thoat2.setPreferredSize(new java.awt.Dimension(95, 23));
        jbtn_thoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_thoat2ActionPerformed(evt);
            }
        });
        
        JLabel lblNmHc = new JLabel();
        lblNmHc.setText("Năm học");
        lblNmHc.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        JButton jbt_TongKet = new JButton();
        jbt_TongKet.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		jbt_TongKetActionPerformed(arg0);
        	}
        });
   
        jbt_TongKet.setText("Tổng kết");
        jbt_TongKet.setFont(new Font("Tahoma", Font.BOLD, 12));
        jbt_TongKet.setBackground(Color.RED);
        
        JButton jbt_InBaoCao = new JButton();
        jbt_InBaoCao.setText("In Báo Cáo");
        jbt_InBaoCao.setFont(new Font("Tahoma", Font.BOLD, 12));
        jbt_InBaoCao.setBackground(Color.RED);
        jbt_InBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jbt_InBaoCaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel2Layout.createSequentialGroup()
        			.addGap(57)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(jbt_TongKet, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(jLabel3)
        							.addGap(18)
        							.addComponent(jtf_lop, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
        							.addGap(34)
        							.addComponent(jbt_timkiem)
        							.addGap(51)
        							.addComponent(lblNmHc)
        							.addGap(18)
        							.addComponent(jcb_hocky, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
        					.addGap(41)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jbt_InBaoCao, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(jbtn_thoat2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel2)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGap(2)
        					.addComponent(jLabel3))
        				.addComponent(jbt_timkiem, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jtf_lop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jcb_hocky, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jbtn_thoat2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblNmHc, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jbt_TongKet, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbt_InBaoCao, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(332, Short.MAX_VALUE)
        			.addComponent(jLabel1)
        			.addGap(366))
        		.addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        		.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addComponent(jLabel1)
        			.addGap(1)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_InBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninBangDiemActionPerformed
    	
    	 if (model != null)
         {
               Document document = new Document();

             try {
            	 String lop= jtf_lop.getText().toString().trim()+"_";
             	String namhoc=jcb_hocky.getSelectedItem().toString().trim();
             	String tenfile= lop+namhoc;
                     // khởi tạo một PdfWriter truyền vào document và FileOutputStream
                 PdfWriter.getInstance(document, new FileOutputStream("report\\baocaotongketnamhoc\\baocao_"+tenfile+".pdf"));

                 // mở file để thực hiện viết
                 document.open();
                  // thêm nội dung sử dụng add function
                 Paragraph title1 = new Paragraph("Bang Tong Ket Nam Hoc"+namhoc,
                 FontFactory.getFont(FontFactory.HELVETICA, 18, Font.ITALIC, new CMYKColor(0, 255, 255, 17)));
                 title1.setAlignment(Element.ALIGN_CENTER);
                 document.add(title1);
                 //Khai báo 2 paragraph              
            
				/*
				 * Paragraph hk = new Paragraph("Hoc Ky :  "+hocky); document.add(hk); Paragraph
				 * mon = new
				 * Paragraph("Mon :  "+jcb_monhoc.getSelectedItem().toString().trim());
				 * document.add(mon);
				 */
                 //Khởi tạo một table có 13 cột
                 PdfPTable t = new PdfPTable(13);
                 t.setSpacingBefore(25);
                 t.setSpacingAfter(25);

                 PdfPCell c2 = new PdfPCell(new Phrase("STT"));
                 t.addCell(c2);
                 PdfPCell c3 = new PdfPCell(new Phrase("Ma"));
                 t.addCell(c3);
                 PdfPCell c4 = new PdfPCell(new Phrase("Ho Ten"));
                 t.addCell(c4);
                 PdfPCell c5 = new PdfPCell(new Phrase("Lop"));
                 t.addCell(c5);
                 PdfPCell c6 = new PdfPCell(new Phrase("TBHK1"));
                 t.addCell(c6);
                 PdfPCell c7 = new PdfPCell(new Phrase("HKHK1"));
                 t.addCell(c7);
                 PdfPCell c8 = new PdfPCell(new Phrase("XL1"));
                 t.addCell(c8);
                 PdfPCell c9 = new PdfPCell(new Phrase("TBHK2"));
                 t.addCell(c9);
                 PdfPCell c10 = new PdfPCell(new Phrase("HKHK2"));
                 t.addCell(c10);
                 PdfPCell c11 = new PdfPCell(new Phrase("XL2"));
                 t.addCell(c11);
                 PdfPCell c12 = new PdfPCell(new Phrase("TBCN"));
                 t.addCell(c12);
                 PdfPCell c13 = new PdfPCell(new Phrase("HKCN"));
                 t.addCell(c13);
                 PdfPCell c14 = new PdfPCell(new Phrase("XL"));
                 t.addCell(c14);
                 for(int count = 0; count < model.getRowCount(); count++)
                 {              
                	 for(int j=0;j<model.getColumnCount();j++)
                	 {
                		 t.addCell(model.getValueAt(count, j).toString());
                	 }
                   
                 }
                 document.add(t);
                 document.close();
                 // đóng file

             } catch (DocumentException e) {
                 e.printStackTrace();
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(BaoCaoTongKetMon.class.getName()).log(Level.SEVERE, null, ex);
             }
             JOptionPane.showMessageDialog(this, "In Hoàn Tất", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
         }
         else 
              JOptionPane.showMessageDialog(this, "Vui Lòng Tìm Dữ Liệu", "Thông báo", JOptionPane.WARNING_MESSAGE);
    	
    }
       void LoadData() {
        
        String hocky = jcb_hocky.getSelectedItem().toString().trim();
     
        List<HocSinh> listResultSV;
        String[] columns = new String [] {
        		"STT","Mã", "Họ Tên", "Lớp", "TB Học Kỳ 1","Hạnh Kiểm HK1","Xếp Loại", "TB Học Kỳ 2","Hạnh Kiểm HK2","Xếp Loại","TBCN","HKCN","Xếp Loại"
        };
        model = new DefaultTableModel(null , columns);
        
        listResultSV = HocSinhDAO.layDanhSachHocSinh();
        for (int i = 0; i < listResultSV.size(); i++) {
            HocSinh hs = (HocSinh) listResultSV.get(i);
            int stt = i+1;
            
            String hk1 = hocky+"_HK1";
            String nienkhoa=hs.getNienkhoa();
            String lop="";
            String namhoc=hocky.substring(0,4);
          int kc=  Integer.valueOf(namhoc)-Integer.valueOf(nienkhoa);
            if ( kc==0)
            {
            	lop="10"+hs.getlop().substring(2, hs.getlop().length());
            }
            else
            {
            	if ( kc==1)
                {
                	
                	if (hs.getlop().substring(0,2).equals("10"))
                	{
                		lop="10"+hs.getlop().substring(2, hs.getlop().length());
                	}
                	else
                	{
                		lop="11"+hs.getlop().substring(2, hs.getlop().length());
                	}
                }
            	else
            		if (kc==2)
            		{
            			if (hs.getlop().substring(0,2).equals("10"))
                    	{
                    		lop="10"+hs.getlop().substring(2, hs.getlop().length());
                    	}
            			else
                    	{	
            				if (hs.getlop().substring(0,2).equals("11"))
            				{
            					lop="11"+hs.getlop().substring(2, hs.getlop().length());
            				}
            				else
            				{
            					lop="12"+hs.getlop().substring(2, hs.getlop().length());
            				}
                    		
                    	}
                        
            		}
            }
            List<Diem> DiemHS1  = DiemDAO.findBy3Ma(hs.getmahocsinh(),lop,hk1);
            float tdhk1 = 0;
            float dtbhk1 = 0 ;
            if(DiemHS1.size() > 0)
            {
                 for(int j = 0; j < DiemHS1.size(); j++ )
                {
                    Diem diem = (Diem) DiemHS1.get(j);
                    tdhk1 += diem.getDiemtbmon();
                }

                if(DiemHS1.size()>0)
                    dtbhk1 = tdhk1/DiemHS1.size();
            }
        	List<ChiTietHanhKiem> hanhkiem1 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk1);
			String tenhanhkiem1 = "";
			String xeploai1 = "";
			int mahanhkiem1 = 0;
			if (hanhkiem1.size() > 0) {
				mahanhkiem1 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk1).get(0).getMahanhkiem();
				tenhanhkiem1 = HanhKiemDAO.findByID(mahanhkiem1).get(0).gettenhanhkiem();
				xeploai1 = DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk1, mahanhkiem1);
			}
           
            
            String hk2 = hocky+"_HK2";
            List<Diem> DiemHS2  = DiemDAO.findBy3Ma(hs.getmahocsinh(),lop,hk2);
            float tdhk2 = 0;          
            float dtbhk2 = 0 ;
            if(DiemHS2.size() > 0)
            {
                 for(int j = 0; j < DiemHS2.size(); j++ )
                {
                    Diem diem = (Diem) DiemHS2.get(j);
                    tdhk2 += diem.getDiemtbmon();
                }
                 dtbhk2 = tdhk2/DiemHS2.size();
            }
          	List<ChiTietHanhKiem> hanhkiem2 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk2);
        			String tenhanhkiem2 = "";
        			String xeploai2 = "";
        			int mahanhkiem2 = 0;
        			float dtbcn=0;
        			String xeploaiCN="";
        			if (hanhkiem2.size() > 0) {
        				mahanhkiem2 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk2).get(0).getMahanhkiem();
        				tenhanhkiem2 = HanhKiemDAO.findByID(mahanhkiem2).get(0).gettenhanhkiem();
        				xeploai2 = DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk2, mahanhkiem2);
        				dtbcn= (dtbhk2*2 + dtbhk1)/3;
        				xeploaiCN=DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk2, mahanhkiem2);
        				xeploaiCN=DiemDAO.BaoCaoCuoiNam(hs.getmahocsinh(), hk1, hk2, mahanhkiem2, dtbcn);
       
        			}
        			
            
            Object[] items = new Object[] {
                stt++,
                hs.getmahocsinh(),
                hs.getten(),
                lop,              
                dtbhk1,
                tenhanhkiem1,
                xeploai1,
                dtbhk2,
                tenhanhkiem2,
                xeploai2,
                dtbcn,
                tenhanhkiem2,
                xeploaiCN
            };
            model.addRow(items);  
        }
        jtb_dshocsinh.setModel(model);
        jtb_dshocsinh.setRowHeight(30);
       
    }
       private void jbt_TongKetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_timkiemActionPerformed
    	   String result="true";
    	   for (int count = 0; count < model.getRowCount(); count++) {
    		   for(int j=0;j<model.getColumnCount();j++)
    		   {
    			   if ( model.getValueAt(count, j).toString().trim().equals(""))
        		   {
        			   JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để tổng kết năm học", "Thông báo", JOptionPane.WARNING_MESSAGE);
        			   return;
        		   }
    		   }
    		 
    	   }
    	   for (int count = 0; count < model.getRowCount(); count++) {
    		   
    		   TongKet tk= new TongKet();
    		   tk.setManamhoc(jcb_hocky.getSelectedItem().toString());
    		   tk.setMahocsinh(model.getValueAt(count, 1).toString().trim());
    		   tk.setHoten(model.getValueAt(count, 2).toString().trim());
    		   tk.setLop(model.getValueAt(count, 3).toString().trim());
    		   tk.setTbhk1(model.getValueAt(count, 4).toString().trim());
    		   tk.setHk1(model.getValueAt(count, 5).toString().trim());
    		   tk.setXeploai1(model.getValueAt(count, 6).toString().trim());
    		   tk.setTbhk2(model.getValueAt(count, 7).toString().trim());
    		   tk.setHk2(model.getValueAt(count, 8).toString().trim());
    		   tk.setXeploai2(model.getValueAt(count, 9).toString().trim());
    		   tk.setTbcn(model.getValueAt(count, 10).toString().trim());
    		   tk.setHkcn(model.getValueAt(count, 11).toString().trim());
    		   tk.setXeploaicn(model.getValueAt(count, 12).toString().trim());
    		    result =TongKetDAO.themTongKet(tk);
    		   if (!result.equals("true"))
    		   {
    			   JOptionPane.showMessageDialog(this, "Thêm Tổng kết của "+ tk.getHoten()+"không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
    			   
    		   }
    		   
    	
    		  String s= model.getValueAt(count, 12).toString().trim();
    		  if (s.equals("KÉM") || s.equals("YẾU"))
    		  {
    			  
    		  }
    		  else
    		  {
    			   HocSinh hs = HocSinhDAO.layThongTinHocSinh(model.getValueAt(count, 1).toString().trim()).get(0);
        		   String lopcu= hs.getlop().substring(0, 2);
        		   String lopmoi="";
        		   if (lopcu.equals("10"))
        		   {
        			   lopmoi="11"+hs.getlop().substring(2, hs.getlop().length());
        		   }
        		   else
        		   {
        			   if (lopcu.equals("11"))
            		   {
            			   lopmoi="12"+hs.getlop().substring(2, hs.getlop().length());
            		   }
        			   else
        			   {
        				   lopmoi="totnghiep";
        			   }
        		   }
        		   if (!lopmoi.equals(""))
        		   {
        			  	hs.setlop(lopmoi);
        			  boolean bool=	HocSinhDAO.capNhatHocSinh(hs);
        			    if (bool==false)
        	    		   {
        	    			   JOptionPane.showMessageDialog(this, "Cập nhật học sinh: "+hs.getten()+"không thành công", "Thông báo", JOptionPane.WARNING_MESSAGE);
        	    			   
        	    		   } 	
        		   }
        		 
    		  }
    		  if (count == model.getRowCount()-1)
    		  {
   			   JOptionPane.showMessageDialog(this, "Tổng kết thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    		  }
    	   }
//    	   LoadData();
       }
    private void jbt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_timkiemActionPerformed
        // TODO add your handling code here:
        if(jtf_lop.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Thông Tin Tìm Kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            String hocky = jcb_hocky.getSelectedItem().toString().trim();
            List<HocSinh> listResultSV;
            String[] columns = new String [] {
            		"STT","Mã", "Họ Tên", "Lớp", "TB Học Kỳ 1","Hạnh Kiểm HK1","Xếp Loại", "TB Học Kỳ 2","Hạnh Kiểm HK2","Xếp Loại","TBCN","HKCN","Xếp Loại"
            };
            model = new DefaultTableModel(null , columns);
            
            listResultSV = HocSinhDAO.Timhocsinhcualop(jtf_lop.getText().trim());
            
            for (int i = 0; i < listResultSV.size(); i++) {
                HocSinh hs = (HocSinh) listResultSV.get(i);
                int stt = i+1;
                
                String hk1 = hocky+"_HK1";
                String nienkhoa=hs.getNienkhoa();
                String lop="";
                String namhoc=hocky.substring(0,4);
              int kc=  Integer.valueOf(namhoc)-Integer.valueOf(nienkhoa);
                if ( kc==0)
                {
                	lop="10"+hs.getlop().substring(2, hs.getlop().length());
                }
                else
                {
                	if ( kc==1)
                    {
                    	lop="11"+hs.getlop().substring(2, hs.getlop().length());
                    }
                	else
                		if (kc==2)
                		{
                			
                            	lop="12"+hs.getlop().substring(2, hs.getlop().length());
                            
                		}
                }
                List<Diem> DiemHS1  = DiemDAO.findBy3Ma(hs.getmahocsinh(),hs.getlop(),hk1);
                float tdhk1 = 0;
                float dtbhk1 = 0 ;
                if(DiemHS1.size() > 0)
                {
                     for(int j = 0; j < DiemHS1.size(); j++ )
                    {
                        Diem diem = (Diem) DiemHS1.get(j);
                        tdhk1 += diem.getDiemtbmon();
                    }

                    if(DiemHS1.size()>0)
                        dtbhk1 = tdhk1/DiemHS1.size();
                }
            	List<ChiTietHanhKiem> hanhkiem1 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk1);
    			String tenhanhkiem1 = "";
    			String xeploai1 = "";
    			int mahanhkiem1 = 0;
    			if (hanhkiem1.size() > 0) {
    				mahanhkiem1 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk1).get(0).getMahanhkiem();
    				tenhanhkiem1 = HanhKiemDAO.findByID(mahanhkiem1).get(0).gettenhanhkiem();
    				xeploai1 = DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk1, mahanhkiem1);
    			}
               
                
                String hk2 = hocky+"_HK2";
                List<Diem> DiemHS2  = DiemDAO.findBy3Ma(hs.getmahocsinh(),lop,hk2);
                float tdhk2 = 0;          
                float dtbhk2 = 0 ;
                if(DiemHS2.size() > 0)
                {
                     for(int j = 0; j < DiemHS2.size(); j++ )
                    {
                        Diem diem = (Diem) DiemHS2.get(j);
                        tdhk2 += diem.getDiemtbmon();
                    }
                     dtbhk2 = tdhk2/DiemHS2.size();
                }
              	List<ChiTietHanhKiem> hanhkiem2 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk2);
            			String tenhanhkiem2 = "";
            			String xeploai2 = "";
            			int mahanhkiem2 = 0;
            			float dtbcn=0;
            			String xeploaiCN="";
            			if (hanhkiem2.size() > 0) {
            				mahanhkiem2 = ChiTietHanhKiemDAO.layDanhSachChiTietHanhKiem(hs.getmahocsinh(),lop,hk2).get(0).getMahanhkiem();
            				tenhanhkiem2 = HanhKiemDAO.findByID(mahanhkiem2).get(0).gettenhanhkiem();
            				xeploai2 = DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk2, mahanhkiem2);
            				dtbcn= (dtbhk2*2 + dtbhk1)/3;
            				xeploaiCN=DiemDAO.BaoCaoHocKy(hs.getmahocsinh(), hk2, mahanhkiem2);
            			}
            			
                
                Object[] items = new Object[] {
                    stt++,
                    hs.getmahocsinh(),
                    hs.getten(),
                   lop,              
                    dtbhk1,
                    tenhanhkiem1,
                    xeploai1,
                    dtbhk2,
                    tenhanhkiem2,
                    xeploai2,
                    dtbcn,
                    tenhanhkiem2,
                    xeploaiCN
                };
                model.addRow(items);
            }
            jtb_dshocsinh.setModel(model);
            jtb_dshocsinh.setRowHeight(30);
         
        }
      
        
    }//GEN-LAST:event_jbt_timkiemActionPerformed
  
    private void jcb_hockyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_hockyItemStateChanged
        // TODO add your handling code here:
       LoadData();
    }//GEN-LAST:event_jcb_hockyItemStateChanged

    private void jbtn_thoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_thoat2ActionPerformed
        // TODO add your handling code here:
        setVisible(false); //you can't see me!
        dispose();
    }//GEN-LAST:event_jbtn_thoat2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachHocSinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachHocSinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbt_timkiem;
    private javax.swing.JButton jbtn_thoat2;
    private javax.swing.JComboBox jcb_hocky;
    private javax.swing.JTable jtb_dshocsinh;
    private javax.swing.JTextField jtf_lop;
}
