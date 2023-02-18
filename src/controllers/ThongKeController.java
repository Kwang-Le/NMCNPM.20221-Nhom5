/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.ThongKeCachLyJPanel;
import views.ThongKePanel; // Thống kê nhân khẩu JPanel
import views.ThongKeTestJPanel;

/**
 *
 * @author quang
 */
public class ThongKeController {
    
    public static String chosenThongKe = null;
    private JButton btnThongKeCachLy;
    private JButton btnThongKeKiemTra;
    private JButton btnThongKeNhanKhau;
    private JFrame parentFrame;

    public ThongKeController(JButton btnThongKeCachLy, JButton btnThongKeKiemTra, JButton btnThongKeNhanKhau, JFrame parentFrame) {
        this.btnThongKeCachLy = btnThongKeCachLy;
        this.btnThongKeKiemTra = btnThongKeKiemTra;
        this.btnThongKeNhanKhau = btnThongKeNhanKhau;
        this.parentFrame = parentFrame;
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
                root.add(new ThongKePanel());
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
