/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.HocSinhDAO;
import DAO.LopDAO;
import Entity.HocSinh;
import Entity.Lop;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phat
 */
public class DanhSachLop extends javax.swing.JFrame {

    DefaultTableModel model=null;
    /**
     * Creates new form DanhSachLop
     */
    public DanhSachLop() {
        initComponents();
        setResizable(false); 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_dslop = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtf_tenlop = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtf_siso = new javax.swing.JTextField();
        jtf_siso.setEnabled(false);
        btnInDanhSach1 = new javax.swing.JButton();
        jcb_lop = new javax.swing.JComboBox();
        jbtn_thoat2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh Sách Lớp");

        jtb_dslop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtb_dslop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Họ Tên", "Giới Tính", "Năm Sinh", "Địa Chỉ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtb_dslop);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Lớp");

        btnTimKiem.setBackground(new java.awt.Color(255, 102, 0));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setMaximumSize(new java.awt.Dimension(95, 23));
        btnTimKiem.setMinimumSize(new java.awt.Dimension(95, 23));
        btnTimKiem.setPreferredSize(new java.awt.Dimension(95, 23));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên Lớp");

        jtf_tenlop.setText(" ");
        jtf_tenlop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_tenlopActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Sỉ Số");

        jtf_siso.setText(" ");
        jtf_siso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_sisoActionPerformed(evt);
            }
        });

        btnInDanhSach1.setBackground(new java.awt.Color(255, 102, 0));
        btnInDanhSach1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInDanhSach1.setText("IN DANH SÁCH");
        btnInDanhSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInDanhSach1ActionPerformed(evt);
            }
        });

        jcb_lop.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcb_lopItemStateChanged(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf_tenlop)
                    .addComponent(jcb_lop, 0, 104, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtf_siso))
                .addGap(71, 71, 71)
                .addComponent(btnInDanhSach1)
                .addGap(69, 69, 69)
                .addComponent(jbtn_thoat2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_tenlop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jtf_siso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInDanhSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtn_thoat2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH LỚP");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(385, 385, 385))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

      void LoadData() {
        List<Lop> dsLop = LopDAO.layDanhSachLop();
        for (int i = 0; i < dsLop.size(); i++) {
            jcb_lop.addItem(dsLop.get(i).getmalop());
        }        
      }
    private void jtf_tenlopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_tenlopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_tenlopActionPerformed

    private void jtf_sisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_sisoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_sisoActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        jtf_siso.setText("");
         if(jtf_tenlop.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Vui Lòng Nhập Thông Tin Tìm Kiếm", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            
            List<HocSinh> listResultSV;
            String[] columns = new String [] {
                "STT",
                "Tên Học Sinh",
                "Năm sinh",
                "Giới Tính",
                "Email",
                "Địa chỉ"
            };
            model = new DefaultTableModel(null , columns);

            listResultSV = HocSinhDAO.Timhocsinhcualop(jtf_tenlop.getText().trim());

            jtf_siso.setText(String.valueOf(listResultSV.size()));
            for (int i = 0; i < listResultSV.size(); i++) {
                HocSinh hs = (HocSinh) listResultSV.get(i);
                int stt = i;
                Object[] items = new Object[] {
                    ++stt,
                    hs.getten(),
                    hs.getngaysinh(),
                    hs.getgioitinh(),
                    hs.getemail(),
                    hs.getdiachi()
                };
                model.addRow(items);  
            }
            jtb_dslop.setModel(model);
            jtb_dslop.setRowHeight(30);
            jtb_dslop.getColumnModel().getColumn(0).setPreferredWidth(100);
            jtb_dslop.getColumnModel().getColumn(1).setPreferredWidth(200);
            jtb_dslop.getColumnModel().getColumn(2).setPreferredWidth(150);
            jtb_dslop.getColumnModel().getColumn(3).setPreferredWidth(100);
            jtb_dslop.getColumnModel().getColumn(4).setPreferredWidth(150);
            jtb_dslop.getColumnModel().getColumn(4).setPreferredWidth(300);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jcb_lopItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcb_lopItemStateChanged
        // TODO add your handling code here:
        
        jtf_tenlop.setText("");
        List<HocSinh> listResultSV;
        String[] columns = new String [] {
            "STT",
            "Tên Học Sinh",
            "Năm sinh",
            "Giới Tính",
            "Email",
            "Địa chỉ"
        };
        model = new DefaultTableModel(null , columns);
        
        listResultSV = HocSinhDAO.LopCoBaoNhieuHocSinh(jcb_lop.getSelectedItem().toString().trim());
        jtf_siso.setText(String.valueOf(listResultSV.size()));
        for (int i = 0; i < listResultSV.size(); i++) {
            HocSinh hs = (HocSinh) listResultSV.get(i);
            int stt = i;
            Object[] items = new Object[] {
                ++stt,
                hs.getten(),
                hs.getngaysinh(),
                hs.getgioitinh(),
                hs.getemail(),
                hs.getdiachi()
            };
            model.addRow(items);  
        }
        jtb_dslop.setModel(model);
        jtb_dslop.setRowHeight(30);
        jtb_dslop.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtb_dslop.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtb_dslop.getColumnModel().getColumn(2).setPreferredWidth(150);
        jtb_dslop.getColumnModel().getColumn(3).setPreferredWidth(100);
        jtb_dslop.getColumnModel().getColumn(4).setPreferredWidth(150);
        jtb_dslop.getColumnModel().getColumn(4).setPreferredWidth(300);
    }//GEN-LAST:event_jcb_lopItemStateChanged

    private void btnInDanhSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInDanhSach1ActionPerformed
        // TODO add your handling code here:
         Document document = new Document();

        try {
        	// khởi tạo một PdfWriter truyền vào document và FileOutputStream
          
            Paragraph lop;
            if (jtf_tenlop.getText().trim().length()>0)
            {
            	  PdfWriter.getInstance(document, new FileOutputStream("report\\danhsachlop\\Class Search:"+jtf_tenlop.getText().trim()+".pdf" ));
            	  lop = new Paragraph("Class Search:"+jtf_tenlop.getText().trim()); 
            }
            else
            {
            	  PdfWriter.getInstance(document, new FileOutputStream("report\\danhsachlop\\"+jcb_lop.getSelectedItem().toString().trim()+".pdf" ));
            	 lop = new Paragraph("Class:"+jcb_lop.getSelectedItem().toString().trim());    
            }
            // mở file để thực hiện viết
            document.open();
             // thêm nội dung sử dụng add function
            Paragraph title1 = new Paragraph("Class List",
            FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));
            title1.setAlignment(Element.ALIGN_CENTER);
            document.add(title1);
            //Khai báo 2 paragraph    
            
            Paragraph siso = new Paragraph("Number of students:"+model.getRowCount());                                   
            document.add(lop);
            document.add(siso);
            //Khởi tạo một table có 5 cột
            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(25);
            t.setSpacingAfter(25);

            PdfPCell c2 = new PdfPCell(new Phrase(" STT "));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase(" Full name "));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase(" Brith Day "));
            t.addCell(c4);
            PdfPCell c5 = new PdfPCell(new Phrase(" Sex"));
            t.addCell(c5);
            PdfPCell c6 = new PdfPCell(new Phrase(" Address"));
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "In Hoàn Tất", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnInDanhSach1ActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachLop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachLop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInDanhSach1;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtn_thoat2;
    private javax.swing.JComboBox jcb_lop;
    private javax.swing.JTable jtb_dslop;
    private javax.swing.JTextField jtf_siso;
    private javax.swing.JTextField jtf_tenlop;
    // End of variables declaration//GEN-END:variables
}
