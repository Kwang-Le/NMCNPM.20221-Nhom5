/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers.QuanLyCovidController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import view.ThongKeCachLyJPanel;
import view.ThongKeNhanKhauJPanel;
import view.ThongKeTestJPanel;

/**
 *
 * @author quang
 */
public class ThongKeController {
    
    public static String chosenThongKe = null;
    private JButton btnThongKeCachLy;
    private JButton btnThongKeKiemTra;
    private JButton btnThongKeNhanKhau;

    public ThongKeController(JButton btnThongKeCachLy, JButton btnThongKeKiemTra, JButton btnThongKeNhanKhau) {
        this.btnThongKeCachLy = btnThongKeCachLy;
        this.btnThongKeKiemTra = btnThongKeKiemTra;
        this.btnThongKeNhanKhau = btnThongKeNhanKhau;
    }
    
    public void setEvent(JPanel root){
        btnThongKeCachLy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeCachLy";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeCachLyJPanel());
                root.validate();
                root.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btnThongKeCachLy.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btnThongKeCachLy.setBackground(new Color(100, 221, 23));

            }  
        });
        
        btnThongKeKiemTra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeKiemTra";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeTestJPanel());
                root.validate();
                root.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btnThongKeKiemTra.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btnThongKeKiemTra.setBackground(new Color(100, 221, 23));

            }  
        });
        
        btnThongKeNhanKhau.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chosenThongKe = "ThongKeNhanKhau";
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(new ThongKeNhanKhauJPanel());
                root.validate();
                root.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btnThongKeNhanKhau.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btnThongKeNhanKhau.setBackground(new Color(100, 221, 23));

            }  
        });
    }
}
