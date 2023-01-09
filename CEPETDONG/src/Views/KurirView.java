/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.KurirController;
import Controllers.PaketController;
import Models.Paket;
import javax.swing.DefaultListModel;

/**
 *
 * @author goody
 */
public class KurirView extends javax.swing.JFrame {
    private KurirController cont;
    private PaketController ctrl;
    final String nama;
    /**
     * Creates new form KurirView
     */
    public KurirView(String name) {
        initComponents();
        this.nama = name;
        this.ctrl = new PaketController();
        this.cont = new KurirController();
        
        nama_kurir.setText(name);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Paket paket : ctrl.PAKET){
            listModel.addElement(paket.getNamaPaket());
        }
        listpaket.setModel(listModel);
        show_paket.setVisible(true);
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
        nama_kurir = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listpaket = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        show_alamat = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        stat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        show_paket = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        show_kuantitas = new javax.swing.JLabel();
        show_berat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(433, 459));
        jPanel1.setLayout(null);

        nama_kurir.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        nama_kurir.setText("Kurir");
        jPanel1.add(nama_kurir);
        nama_kurir.setBounds(70, 40, 130, 32);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel3.setText("Hi, ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 40, 40, 32);

        listpaket.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        listpaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listpaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listpaket);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 110, 140, 270);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Status Pengiriman :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 250, 140, 19);

        show_alamat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        show_alamat.setText("D");
        jPanel1.add(show_alamat);
        show_alamat.setBounds(270, 220, 100, 19);

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Berat            : ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(170, 160, 90, 19);

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Kuantitas      : ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(170, 190, 100, 19);

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setText("Alamat          : ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 220, 100, 19);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(250, 400, 110, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(70, 400, 110, 40);

        stat.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jPanel1.add(stat);
        stat.setBounds(300, 250, 100, 24);

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Nama Paket  : ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(170, 130, 100, 19);

        show_paket.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        show_paket.setText("A");
        jPanel1.add(show_paket);
        show_paket.setBounds(270, 130, 100, 19);

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setText("Kg");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(370, 160, 20, 19);

        show_kuantitas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        show_kuantitas.setText("C");
        jPanel1.add(show_kuantitas);
        show_kuantitas.setBounds(270, 190, 100, 19);

        show_berat.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        show_berat.setText("B");
        jPanel1.add(show_berat);
        show_berat.setBounds(270, 160, 100, 19);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Kurir View.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 433, 459);

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String selected = listpaket.getSelectedValue();
        PaketController pkg = new PaketController();
        if(pkg.findPaket(selected)){
            Paket p = pkg.searchPaket(selected);
            String stats = stat.getText();
            System.out.println(p.getNamaPaket());
            System.out.println(stats);
            cont.updateStatus(p.getNamaPaket(), stats);
        };
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        landingView landView = new landingView();
        landView.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void listpaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listpaketMouseClicked
        // TODO add your handling code here:
        String selected = listpaket.getSelectedValue();
        PaketController pkg = new PaketController();
        if(pkg.findPaket(selected)){
            Paket p = pkg.searchPaket(selected);
            show_paket.setText(p.getNamaPaket());
            show_berat.setText(String.valueOf(p.getBeratPaket()));
            show_kuantitas.setText(String.valueOf(p.getKuantitas()));
            show_alamat.setText(p.getAlamatTujuan());
        };
    }//GEN-LAST:event_listpaketMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listpaket;
    private javax.swing.JLabel nama_kurir;
    private javax.swing.JLabel show_alamat;
    private javax.swing.JLabel show_berat;
    private javax.swing.JLabel show_kuantitas;
    private javax.swing.JLabel show_paket;
    private javax.swing.JTextField stat;
    // End of variables declaration//GEN-END:variables
}