/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.ThongKeController;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hoang
 */
public class ThongKeJFrame extends javax.swing.JFrame {
    private JFrame parentFrame;
    /**
     * Creates new form ThongKeJFrame
     */
    public ThongKeJFrame(JPanel root, JFrame parentFrame) {
        this.parentFrame = parentFrame;
        initComponents();
        ThongKeController controller = new ThongKeController(btnThongKeCachLy, btnThongKeKiemTra, btnThongKeNhanKhau, this.parentFrame);
        controller.setEvent(root);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnThongKeNhanKhau = new javax.swing.JButton();
        btnThongKeKiemTra = new javax.swing.JButton();
        btnThongKeCachLy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(167, 199, 231));

        jPanel2.setBackground(new java.awt.Color(167, 199, 231));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lựa chọn thống kê", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 20), new java.awt.Color(59, 61, 161))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lựa chọn thống kê mong muốn");

        btnThongKeNhanKhau.setBackground(new java.awt.Color(130, 180, 203));
        btnThongKeNhanKhau.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        btnThongKeNhanKhau.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKeNhanKhau.setText("Thống kê nhân khẩu");

        btnThongKeKiemTra.setBackground(new java.awt.Color(130, 180, 203));
        btnThongKeKiemTra.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        btnThongKeKiemTra.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKeKiemTra.setText("Thống kê test Covid-19");
        btnThongKeKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeKiemTraActionPerformed(evt);
            }
        });

        btnThongKeCachLy.setBackground(new java.awt.Color(130, 180, 203));
        btnThongKeCachLy.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        btnThongKeCachLy.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKeCachLy.setText("Thống kê cách ly");
        btnThongKeCachLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeCachLyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThongKeCachLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKeKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKeNhanKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(283, 283, 283))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKeNhanKhau)
                .addGap(13, 13, 13)
                .addComponent(btnThongKeKiemTra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThongKeCachLy)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeKiemTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeKiemTraActionPerformed

    private void btnThongKeCachLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeCachLyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeCachLyActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongKeCachLy;
    private javax.swing.JButton btnThongKeKiemTra;
    private javax.swing.JButton btnThongKeNhanKhau;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
