/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;
import Controllers.AdminController;
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author goody
 */
public class LoginViewAdmin extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public LoginViewAdmin() {
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
        jLabel4 = new javax.swing.JLabel();
        input_id = new javax.swing.JTextField();
        input_user_login = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btn_to_reg = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(414, 468));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel2.setText("LOGIN ADMIN PAGE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(85, 40, 240, 32);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 220, 36, 19);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Nama");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 160, 36, 19);

        input_id.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jPanel1.add(input_id);
        input_id.setBounds(110, 220, 250, 25);

        input_user_login.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        input_user_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_user_loginActionPerformed(evt);
            }
        });
        jPanel1.add(input_user_login);
        input_user_login.setBounds(110, 160, 250, 25);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tidak Punya Akun?");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 420, 110, 16);

        btn_to_reg.setBackground(new java.awt.Color(255, 255, 255));
        btn_to_reg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_to_reg.setText("Daftar");
        btn_to_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_to_regActionPerformed(evt);
            }
        });
        jPanel1.add(btn_to_reg);
        btn_to_reg.setBounds(311, 410, 80, 40);

        btn_login.setBackground(new java.awt.Color(255, 255, 255));
        btn_login.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_login);
        btn_login.setBounds(300, 300, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Login View Admin.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 414, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
        try {
            String nama = input_user_login.getText();
            String ID = input_id.getText();
            
            ctrl.loginUserAdmin(nama, ID);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    private void input_user_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_user_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_input_user_loginActionPerformed

    private void btn_to_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_to_regActionPerformed
        // TODO add your handling code here:
        dispose();
        RegisterViewAdmin regView = new RegisterViewAdmin();
        regView.show();
    }//GEN-LAST:event_btn_to_regActionPerformed

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
            java.util.logging.Logger.getLogger(LoginViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginViewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginViewAdmin().setVisible(true);
            }
        });
    }
    
    private AdminController ctrl = new AdminController();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_to_reg;
    private javax.swing.JTextField input_id;
    private javax.swing.JTextField input_user_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
