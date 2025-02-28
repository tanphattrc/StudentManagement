/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.DiemDAO;
import DAO.GiaoVuDAO;
import DAO.HocKyDAO;
import DAO.HocSinhDAO;
import DAO.LopDAO;
import DAO.MonDAO;
import Entity.Diem;
import Entity.HocKy;
import Entity.HocSinh;
import Entity.Lop;
import Entity.Mon;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author P
 */
public class BaoCaoTongKetMon extends javax.swing.JFrame {

    DefaultTableModel model=null;
    /**
     * Creates new form BaoCaoTongKetMon
     */
    public BaoCaoTongKetMon() {
        initComponents();
        setResizable(false); 
       LoadData();
    }
    
    void LoadData() {
        jcb_hocky.removeAllItems();
        List<HocKy> dshk = HocKyDAO.layDanhSachHocKy();
        for (int i = 0; i < dshk.size(); i++) {
            jcb_hocky.addItem(dshk.get(i).gettenhocky());
        }    
        
        jcb_monhoc.removeAllItems();
        List<Mon> dsMon = MonDAO.layDanhSachMon();
        for (int i = 0; i < dsMon.size(); i++) {
            jcb_monhoc.addItem(dsMon.get(i).getmamon());
        }  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_baocaomon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btninBangDiem = new javax.swing.JButton();
        jcb_hocky = new javax.swing.JComboBox();
        jcb_monhoc = new javax.swing.JComboBox<String>();
        jbtn_thoat = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Báo Cáo Tổng Kết Môn");

        jtb_baocaomon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Lớp", "Sỉ Số", "Số Lượng Đạt", "Tỷ Lệ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtb_baocaomon);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Môn");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Học Kỳ");

        btninBangDiem.setBackground(new java.awt.Color(255, 102, 0));
        btninBangDiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninBangDiem.setText("In Báo Cáo");
        btninBangDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninBangDiemActionPerformed(evt);
            }
        });

        jcb_hocky.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_hockyItemStateChanged(evt);
            }
        });
        jcb_hocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_hockyActionPerformed(evt);
            }
        });

        jcb_monhoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jbtn_thoat.setBackground(new java.awt.Color(255, 102, 0));
        jbtn_thoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_thoat.setText("Thoát");
        jbtn_thoat.setToolTipText("");
        jbtn_thoat.setMaximumSize(new java.awt.Dimension(95, 23));
        jbtn_thoat.setMinimumSize(new java.awt.Dimension(95, 23));
        jbtn_thoat.setPreferredSize(new java.awt.Dimension(95, 23));
        jbtn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_thoatActionPerformed(evt);
            }
        });

        btnTim.setBackground(new java.awt.Color(255, 102, 0));
        btnTim.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(49)
        			.addComponent(jLabel3)
        			.addGap(33)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jcb_monhoc, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(12)
        					.addComponent(btninBangDiem)
        					.addGap(60))
        				.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jLabel4)
        					.addGap(29)))
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jcb_hocky, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbtn_thoat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(11)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jcb_monhoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(3)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jcb_hocky, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel4))))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btninBangDiem)
        				.addComponent(btnTim)
        				.addComponent(jbtn_thoat, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("BÁO CÁO TỔNG KẾT MÔN HỌC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btninBangDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninBangDiemActionPerformed
        // TODO add your handling code here:
        if (model != null)
        {
              Document document = new Document();

            try {
            	String tenmon=jcb_monhoc.getSelectedItem().toString();
                    // khởi tạo một PdfWriter truyền vào document và FileOutputStream
                PdfWriter.getInstance(document, new FileOutputStream("report\\baocaomon\\baocaomon"+tenmon+".pdf"));

                // mở file để thực hiện viết
                document.open();
                 // thêm nội dung sử dụng add function
                Paragraph title1 = new Paragraph("Bang Tong Ket Mon Hoc",
                FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
                title1.setAlignment(Element.ALIGN_CENTER);
                document.add(title1);
                //Khai báo 2 paragraph              
                String jcbhocky = jcb_hocky.getSelectedItem().toString().trim();
                String hocky = "Hoc Ky "+ jcbhocky.substring(7) ;
                Paragraph hk = new Paragraph("Hoc Ky :  "+hocky);                                                   
                document.add(hk);
                Paragraph mon = new Paragraph("Mon :  "+jcb_monhoc.getSelectedItem().toString().trim());                                                  
                document.add(mon);
                //Khởi tạo một table có 3 cột
                PdfPTable t = new PdfPTable(5);
                t.setSpacingBefore(25);
                t.setSpacingAfter(25);

                PdfPCell c2 = new PdfPCell(new Phrase(" STT "));
                t.addCell(c2);
                PdfPCell c3 = new PdfPCell(new Phrase(" Lop "));
                t.addCell(c3);
                PdfPCell c4 = new PdfPCell(new Phrase(" Si So  "));
                t.addCell(c4);
                PdfPCell c5 = new PdfPCell(new Phrase(" So Luong Dat"));
                t.addCell(c5);
                PdfPCell c6 = new PdfPCell(new Phrase(" Ti Le "));
                t.addCell(c6);
                for(int count = 0; count < model.getRowCount(); count++)
                {              
                    t.addCell(model.getValueAt(count, 0).toString());
                    t.addCell(model.getValueAt(count, 1).toString());
                    t.addCell(model.getValueAt(count, 2).toString());
                    t.addCell(model.getValueAt(count, 3).toString());
                    t.addCell(model.getValueAt(count, 4).toString());    
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
      
    }//GEN-LAST:event_btninBangDiemActionPerformed

    private void jbtn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_thoatActionPerformed
        // TODO add your handling code here:
        setVisible(false); //you can't see me!
        dispose();
    }//GEN-LAST:event_jbtn_thoatActionPerformed

    private void jcb_hockyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_hockyItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jcb_hockyItemStateChanged

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        String jcbhocky = jcb_hocky.getSelectedItem().toString().trim();
        String hocky1 = jcbhocky.substring(9, 13)+"_" ;
        String hocky2 = jcbhocky.substring(16, 20);

        String hocky = hocky1.concat(hocky2);
        String hk1 = hocky+"_HK2";
        if( jcbhocky.substring(7, 8).equals("1"))
        hk1 = hocky+"_HK1";

        List<HocSinh> listResultSV;
        String[] columns = new String [] {
            "STT",
            "Lớp",
            "Sỉ Số",
            "Số Lượng Đạt",
            "Tỉ Lệ"
        };
        model = new DefaultTableModel(null , columns);

        List<Lop> listlop;
        listlop  = LopDAO.layDanhSachLop();
        float diemchuan= GiaoVuDAO.layDanhSachGiaoVu().get(0).getdiemchuandatmon();
        for(int  i =0; i<listlop.size() ;i++)
        {
            Lop lop = (Lop) listlop.get(i);
            //tim diem hs
            listResultSV = HocSinhDAO.LopCoBaoNhieuHocSinh(lop.getmalop());

            int sohsdat = 0;
            for (int j = 0; j < listResultSV.size(); j++) {
                HocSinh hs = (HocSinh) listResultSV.get(j);                
                float tdhk1 = 0;
                boolean monkt = true;
       
                List<Diem> DiemHS1  = DiemDAO.DiemCuaHocSinh(hs.getmahocsinh(),hk1,jcb_monhoc.getSelectedItem().toString().trim());
                if(DiemHS1.size() > 0)
                {
                    for(int m = 0; m < DiemHS1.size(); m++ )
                    {                       
                        Diem diem = (Diem) DiemHS1.get(m);
                        tdhk1 += diem.getDiemtbmon();
                        
                    }
                }else monkt = false;                             
                if (tdhk1 >= diemchuan && monkt == true)
                  sohsdat++;
            }

            int stt = i;
            Object[] items = null;
            if(lop.getsiso() == 0)
            {
                items = new Object[] {
                    ++stt,
                    lop.gettenlop(),
                    lop.getsiso(),
                    "",
                    ""
                };
            }
            else
            {
                DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                String tile = String.valueOf( decimalFormat.format( (float)sohsdat/lop.getsiso()*100)) +" %";
                items = new Object[] {
                    ++stt,
                    lop.gettenlop(),
                    lop.getsiso(),
                    sohsdat,
                    tile
                };
            }

            model.addRow(items);
        }

        jtb_baocaomon.setModel(model);
        jtb_baocaomon.setRowHeight(30);
        jtb_baocaomon.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtb_baocaomon.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtb_baocaomon.getColumnModel().getColumn(2).setPreferredWidth(150);
        jtb_baocaomon.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtb_baocaomon.getColumnModel().getColumn(4).setPreferredWidth(100);
    }//GEN-LAST:event_btnTimActionPerformed

    private void jcb_hockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_hockyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_hockyActionPerformed

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
            java.util.logging.Logger.getLogger(BaoCaoTongKetMon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoCaoTongKetMon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoCaoTongKetMon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoCaoTongKetMon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BaoCaoTongKetMon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btninBangDiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_thoat;
    private javax.swing.JComboBox jcb_hocky;
    private javax.swing.JComboBox<String> jcb_monhoc;
    private javax.swing.JTable jtb_baocaomon;
    // End of variables declaration//GEN-END:variables
}
