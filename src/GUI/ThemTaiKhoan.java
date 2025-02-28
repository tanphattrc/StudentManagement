/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.TaiKhoanDAO;
import Entity.Mon;
import Entity.TaiKhoan;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

/**
 *
 * @author Lì
 */
public class ThemTaiKhoan extends javax.swing.JFrame {

    /**
     * Creates new form ThemTaiKhoan
     */
    public ThemTaiKhoan() {
    	setResizable(false);
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_taikhoan = new javax.swing.JTextField();
        jtf_matkhau = new javax.swing.JPasswordField();
        jtb_them = new javax.swing.JButton();
        jtb_huy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm Tài Khoản");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Tên Tài Khoản");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mật Khẩu");

        jtb_them.setBackground(new java.awt.Color(255, 51, 0));
        jtb_them.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtb_them.setText("THÊM");
        jtb_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtb_themActionPerformed(evt);
            }
        });

        jtb_huy.setBackground(new java.awt.Color(255, 0, 0));
        jtb_huy.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtb_huy.setText("HỦY");
        jtb_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtb_huyActionPerformed(evt);
            }
        });
        
        lblRemtKhu = new JLabel();
        lblRemtKhu.setText("Re-Mật Khẩu");
        lblRemtKhu.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        jtf_re_matkhau = new JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(77)
        			.addComponent(jtb_them, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
        			.addGap(69)
        			.addComponent(jtb_huy, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(95, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(45)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(lblRemtKhu))
        			.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jtf_re_matkhau, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_matkhau, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_taikhoan, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jtf_taikhoan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3)
        				.addComponent(jtf_matkhau, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblRemtKhu, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jtf_re_matkhau, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jtb_huy)
        				.addComponent(jtb_them))
        			.addGap(15))
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("THÊM TÀI KHOẢN CHO GIÁO VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtb_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtb_huyActionPerformed
        // TODO add your handling code here:
         setVisible(false); //you can't see me!
        dispose();
    }//GEN-LAST:event_jtb_huyActionPerformed

      void Moi() {
         jtf_taikhoan.setText(null);
        jtf_matkhau.setText(null);    
        jtf_re_matkhau.setText(null);   
     }
    
    private void jtb_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtb_themActionPerformed
        // TODO add your handling code here:
        String tentaikhoan = jtf_taikhoan.getText().trim();
        String matkhau = jtf_matkhau.getText().trim();
        String re_matkhau = jtf_re_matkhau.getText().trim();
        if (tentaikhoan.equals("") || matkhau.equals("") || re_matkhau.equals(""))
        {
        	JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin", "Thông báo", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
        	if (re_matkhau.equals(matkhau))
            {
            	TaiKhoan tk = new TaiKhoan(tentaikhoan, matkhau);
                String result = TaiKhoanDAO.themTaiKhoan(tk);
                if (result.equals("true")) { 
                	 JOptionPane.showMessageDialog(this, "Thêm thành công ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    Moi();
                } 
                else
                	if(result.equals("existed"))
                {
                	JOptionPane.showMessageDialog(this, "Thêm thất bại \n Tài khoản đã tồn tại", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
        	        else {
        	            JOptionPane.showMessageDialog(this, "Thêm thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
        	        }
            }
            else
            {
            	JOptionPane.showMessageDialog(this, "Nhập lại mật khẩu không đúng", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
        }
        
    
    }//GEN-LAST:event_jtb_themActionPerformed

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
            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemTaiKhoan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jtb_huy;
    private javax.swing.JButton jtb_them;
    private javax.swing.JPasswordField jtf_matkhau;
    private javax.swing.JTextField jtf_taikhoan;
    private JLabel lblRemtKhu;
    private JPasswordField jtf_re_matkhau;
}
