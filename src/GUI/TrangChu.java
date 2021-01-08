/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.TaiKhoanDAO;
import Entity.TaiKhoan;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author P
 */
public class TrangChu extends javax.swing.JFrame {
    
//    public static String  TenTK =null;
    public static String TenTK =null;
    /**
     * Creates new form TrangChu
     */
  
    public TrangChu(String TenTaiKhoan) {
        TenTK = TenTaiKhoan;
        initComponents();
        setResizable(false); 
        Loaddata();
    }
    
    public void Loaddata(){
        
        if(TenTK != null){
            List<TaiKhoan> tk  = TaiKhoanDAO.layThongTinTaiKhoan(TenTK);
            String chucvu = "Giáo Viên";
            jbtn_hosohocsinh.setEnabled(false);
            jbtn_danhsachlop.setEnabled(false);
            jbtn_giaovu.setEnabled(false);
            jbtn_themtaikhoan.setEnabled(false);
            jbt_monhoc.setEnabled(false);
            jbt_lophoc.setEnabled(false);
            if(tk.get(0).getchucvu() == 2)
            {
                 chucvu = "Giáo Vụ";
                jbtn_hosohocsinh.setEnabled(true);
                jbtn_danhsachlop.setEnabled(true);
                jbtn_giaovu.setEnabled(true);
                jbtn_themtaikhoan.setEnabled(true);
                jbt_monhoc.setEnabled(true);
                jbt_lophoc.setEnabled(true);
            }
                   
            jtb_tentaikhoan.setText("Tên : "+tk.get(0).gettentaikhoan()+", Chức vụ : "+ chucvu);
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

        TRANGCHU = new javax.swing.JPanel();
        jbtn_hosohocsinh = new javax.swing.JButton();
        jbtn_danhsachlop = new javax.swing.JButton();
        jbtn_danhsachhocsinh = new javax.swing.JButton();
        jbtn_bangdiemmonhoc = new javax.swing.JButton();
        jbtn_themtaikhoan = new javax.swing.JButton();
        jbtn_baocaotongkethocky = new javax.swing.JButton();
        jbtn_baocaotongketmon1 = new javax.swing.JButton();
        jbt_monhoc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtb_thoat = new javax.swing.JButton();
        jtb_dangxuat = new javax.swing.JButton();
        jtb_tentaikhoan = new javax.swing.JButton();
        jbtn_giaovu = new javax.swing.JButton();
        jbt_lophoc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });

        TRANGCHU.setBackground(new java.awt.Color(247, 244, 244));
        TRANGCHU.setToolTipText("TRANG CHỦ");

        jbtn_hosohocsinh.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_hosohocsinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_hosohocsinh.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_hosohocsinh.setText("HỒ SƠ HỌC SINH");
        jbtn_hosohocsinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_hosohocsinhActionPerformed(evt);
            }
        });

        jbtn_danhsachlop.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_danhsachlop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_danhsachlop.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_danhsachlop.setText("DANH SÁCH LỚP");
        jbtn_danhsachlop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_danhsachlopActionPerformed(evt);
            }
        });

        jbtn_danhsachhocsinh.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_danhsachhocsinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_danhsachhocsinh.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_danhsachhocsinh.setText("DANH SÁCH HỌC SINH");
        jbtn_danhsachhocsinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_danhsachhocsinhActionPerformed(evt);
            }
        });

        jbtn_bangdiemmonhoc.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_bangdiemmonhoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_bangdiemmonhoc.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_bangdiemmonhoc.setText("BẢNG ĐIỂM MÔN HỌC");
        jbtn_bangdiemmonhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_bangdiemmonhocActionPerformed(evt);
            }
        });

        jbtn_themtaikhoan.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_themtaikhoan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_themtaikhoan.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_themtaikhoan.setText("+");
        jbtn_themtaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_themtaikhoanActionPerformed(evt);
            }
        });

        jbtn_baocaotongkethocky.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_baocaotongkethocky.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_baocaotongkethocky.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_baocaotongkethocky.setText("BÁO CÁO NĂM HỌC");
        jbtn_baocaotongkethocky.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_baocaotongkethockyActionPerformed(evt);
            }
        });

        jbtn_baocaotongketmon1.setBackground(new java.awt.Color(255, 255, 255));
        jbtn_baocaotongketmon1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_baocaotongketmon1.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_baocaotongketmon1.setText("BÁO CÁO TỔNG KẾT MÔN");
        jbtn_baocaotongketmon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_baocaotongketmon1ActionPerformed(evt);
            }
        });

        jbt_monhoc.setBackground(new java.awt.Color(255, 255, 255));
        jbt_monhoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbt_monhoc.setForeground(new java.awt.Color(0, 153, 204));
        jbt_monhoc.setText("MÔN HỌC");
        jbt_monhoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_monhocActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Trang Chủ");

        jtb_thoat.setBackground(new java.awt.Color(255, 51, 0));
        jtb_thoat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtb_thoat.setText("Thoát");
        jtb_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtb_thoatActionPerformed(evt);
            }
        });

        jtb_dangxuat.setBackground(new java.awt.Color(255, 0, 0));
        jtb_dangxuat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtb_dangxuat.setText("Đăng Xuất");
        jtb_dangxuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtb_dangxuatActionPerformed(evt);
            }
        });

        jtb_tentaikhoan.setBackground(new java.awt.Color(204, 255, 204));
        jtb_tentaikhoan.setText("Tên Tài Khoàn");
        jtb_tentaikhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtb_tentaikhoanActionPerformed(evt);
            }
        });

        jbtn_giaovu.setBackground(new java.awt.Color(204, 51, 0));
        jbtn_giaovu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn_giaovu.setForeground(new java.awt.Color(0, 153, 204));
        jbtn_giaovu.setText("Giáo Vụ");
        jbtn_giaovu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_giaovuActionPerformed(evt);
            }
        });

        jbt_lophoc.setBackground(new java.awt.Color(255, 255, 255));
        jbt_lophoc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbt_lophoc.setForeground(new java.awt.Color(0, 153, 204));
        jbt_lophoc.setText("LỚP HỌC");
        jbt_lophoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_lophocActionPerformed(evt);
            }
        });
        
        JButton jbtn_xeploai = new JButton();
        jbtn_xeploai.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		 XepLoai xl = new XepLoai();
        	        xl.setLocationRelativeTo(null);
        	        xl.setVisible(true);
        	}
        });
        jbtn_xeploai.setText("Xếp loại");
        jbtn_xeploai.setForeground(new Color(0, 153, 204));
        jbtn_xeploai.setFont(new Font("Tahoma", Font.BOLD, 12));
        jbtn_xeploai.setBackground(Color.WHITE);

        javax.swing.GroupLayout TRANGCHULayout = new javax.swing.GroupLayout(TRANGCHU);
        TRANGCHULayout.setHorizontalGroup(
        	TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(TRANGCHULayout.createSequentialGroup()
        			.addGap(35)
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(TRANGCHULayout.createSequentialGroup()
        					.addComponent(jtb_tentaikhoan, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jbtn_themtaikhoan, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        					.addGap(53)
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE))
        				.addGroup(TRANGCHULayout.createSequentialGroup()
        					.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(jbtn_hosohocsinh, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        						.addComponent(jbt_monhoc, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        						.addComponent(jbtn_danhsachlop, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
        					.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(TRANGCHULayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(jbtn_danhsachhocsinh, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        							.addComponent(jbt_lophoc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addComponent(jbtn_xeploai, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE))
        					.addGap(75)))
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(TRANGCHULayout.createSequentialGroup()
        					.addComponent(jbtn_giaovu)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jtb_thoat)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jtb_dangxuat))
        				.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(jbtn_bangdiemmonhoc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jbtn_baocaotongketmon1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        					.addComponent(jbtn_baocaotongkethocky, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        			.addGap(21))
        );
        TRANGCHULayout.setVerticalGroup(
        	TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(TRANGCHULayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtb_thoat, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtb_dangxuat, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbtn_giaovu, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        				.addGroup(TRANGCHULayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(jtb_tentaikhoan, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jbtn_themtaikhoan, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jbtn_hosohocsinh, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbtn_danhsachhocsinh, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbtn_bangdiemmonhoc, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(TRANGCHULayout.createParallelGroup(Alignment.TRAILING)
        					.addComponent(jbtn_baocaotongkethocky, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        					.addComponent(jbtn_danhsachlop, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jbtn_xeploai, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(TRANGCHULayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jbtn_baocaotongketmon1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbt_monhoc, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jbt_lophoc, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        			.addGap(31))
        );
        TRANGCHU.setLayout(TRANGCHULayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TRANGCHU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TRANGCHU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        TRANGCHU.getAccessibleContext().setAccessibleParent(TRANGCHU);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_hosohocsinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_hosohocsinhActionPerformed
        // TODO add your handling code here:
        HoSoHocSinh ct;
        try {
            ct = new HoSoHocSinh();
            ct.setLocationRelativeTo(null);
            ct.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jbtn_hosohocsinhActionPerformed

    private void jbtn_bangdiemmonhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_bangdiemmonhocActionPerformed
        // TODO add your handling code here:
        BangDiemMonHoc ct = new BangDiemMonHoc();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
    }//GEN-LAST:event_jbtn_bangdiemmonhocActionPerformed

    private void jbtn_themtaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_themtaikhoanActionPerformed
        // TODO add your handling code here:
        ThemTaiKhoan ct = new ThemTaiKhoan();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
    }//GEN-LAST:event_jbtn_themtaikhoanActionPerformed

    private void jbtn_danhsachlopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_danhsachlopActionPerformed
        // TODO add your handling code here:
        DanhSachLop ct = new DanhSachLop();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
    }//GEN-LAST:event_jbtn_danhsachlopActionPerformed

    private void jbtn_danhsachhocsinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_danhsachhocsinhActionPerformed
        // TODO add your handling code here:
         DanhSachHocSinh dshs = new DanhSachHocSinh();
        dshs.setLocationRelativeTo(null);
        dshs.setVisible(true);
    }//GEN-LAST:event_jbtn_danhsachhocsinhActionPerformed

    private void jbtn_baocaotongkethockyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_baocaotongkethockyActionPerformed
        // TODO add your handling code here:
        BaoCaoTongKetNamHoc ct = new BaoCaoTongKetNamHoc();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
    }//GEN-LAST:event_jbtn_baocaotongkethockyActionPerformed

    private void jbtn_baocaotongketmon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_baocaotongketmon1ActionPerformed
        // TODO add your handling code here:
        BaoCaoTongKetMon ct = new BaoCaoTongKetMon();
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
    }//GEN-LAST:event_jbtn_baocaotongketmon1ActionPerformed

    private void jtb_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtb_thoatActionPerformed
        // TODO add your handling code here:
        setVisible(false); //you can't see me!
        dispose();
    }//GEN-LAST:event_jtb_thoatActionPerformed

    private void jtb_dangxuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtb_dangxuatActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        this.dispose();
        this.setEnabled(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               DangNhap lg = new DangNhap();
               
               lg.setVisible(true);
       
                   
            }
        });     
        this.setVisible(false); //you can't see me!
        this.dispose();
    }//GEN-LAST:event_jtb_dangxuatActionPerformed

    private void jbt_monhocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_monhocActionPerformed
        // TODO add your handling code here:
        MonHoc mh = new MonHoc();
        mh.setLocationRelativeTo(null);
        mh.setVisible(true);
    }//GEN-LAST:event_jbt_monhocActionPerformed

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowDeiconified

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowClosing

    private void jbtn_giaovuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_giaovuActionPerformed
        // TODO add your handling code here:
        GiaoVuCP gv = new GiaoVuCP();
        gv.setLocationRelativeTo(null);
        gv.setVisible(true);
    }//GEN-LAST:event_jbtn_giaovuActionPerformed

    private void jtb_tentaikhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtb_tentaikhoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtb_tentaikhoanActionPerformed

    private void jbt_lophocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_lophocActionPerformed
        // TODO add your handling code here:
        LopHoc lh = new LopHoc();
        lh.setLocationRelativeTo(null);
        lh.setVisible(true);
    }//GEN-LAST:event_jbt_lophocActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String huy = TenTK;
                new TrangChu(huy).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TRANGCHU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbt_lophoc;
    private javax.swing.JButton jbt_monhoc;
    private javax.swing.JButton jbtn_bangdiemmonhoc;
    private javax.swing.JButton jbtn_baocaotongkethocky;
    private javax.swing.JButton jbtn_baocaotongketmon1;
    private javax.swing.JButton jbtn_danhsachhocsinh;
    private javax.swing.JButton jbtn_danhsachlop;
    private javax.swing.JButton jbtn_giaovu;
    private javax.swing.JButton jbtn_hosohocsinh;
    private javax.swing.JButton jbtn_themtaikhoan;
    private javax.swing.JButton jtb_dangxuat;
    private javax.swing.JButton jtb_tentaikhoan;
    private javax.swing.JButton jtb_thoat;
}
