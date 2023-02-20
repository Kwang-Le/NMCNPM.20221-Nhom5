/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import models.KiemTra;
import services.KiemTraService;
import services.KiemTraServiceImpl;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class KiemTraController {

    private JTextField jtfIDTest;
    private JTextField jtfIDNhanKhau;
    private JTextField jtfHoTen;
    private JButton btnSubmit;
    private JTextArea jtaKetQua;
    private JTextField jtfHinhThucTest;
    private JDateChooser jdcThoiDiemTest;
    private JLabel jlbMsg;
    private KiemTra kiemTra = null;
    private KiemTraService kiemTraService = null;

    public KiemTraController(JTextField jtfIDTest, JTextField jtfIDNhanKhau, JTextField jtfHoTen, JButton btnSubmit,
            JTextArea jtaKetQua, JTextField jtfHinhThucTest,
            JDateChooser jdcThoiDiemTest, JLabel jlbMsg) {
        this.jtfIDTest = jtfIDTest;
        this.jtfIDNhanKhau = jtfIDNhanKhau;
        this.jtfHoTen = jtfHoTen;
        this.btnSubmit = btnSubmit;
        this.jtaKetQua = jtaKetQua;
        this.jtfHinhThucTest = jtfHinhThucTest;
        this.jdcThoiDiemTest = jdcThoiDiemTest;
        this.jlbMsg = jlbMsg;
        this.kiemTraService = new KiemTraServiceImpl();
    }

    public void setView(KiemTra kiemTra) {
        this.kiemTra = kiemTra;
        jtfIDTest.setText("#" + kiemTra.getIDTest());
        jtfIDNhanKhau.setText("#" + kiemTra.getIDNhanKhau());
        jtfHoTen.setText(kiemTra.getHoTen());
        jdcThoiDiemTest.setDate(kiemTra.getThoiDiemTest());
        jtfHinhThucTest.setText(kiemTra.getHinhThucTest());
        jtaKetQua.setText(kiemTra.getKetQua());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length() == 0 || jtaKetQua.getText() == null) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                } else {
                    if (checkIDNhanKhau(jtfIDNhanKhau.getText()) == -1) {
                        jlbMsg.setText("ID nhân khẩu không khớp");
                    } else {
                        kiemTra.setIDNhanKhau(Integer.parseInt(jtfIDNhanKhau.getText()));
                        kiemTra.setHoTen(jtfHoTen.getText());
                        kiemTra.setThoiDiemTest((java.sql.Date) new Date(jdcThoiDiemTest.getDate().getTime()));
                        kiemTra.setHinhThucTest(jtfHinhThucTest.getText());
                        kiemTra.setKetQua(jtaKetQua.getText());
                        int lastID = kiemTraService.createOrUpdate(kiemTra);
                        if (lastID > 0) {
//                      kiemTra.setIDTest(lastID);
                        jtfIDTest.setText("#" + lastID);
                        jlbMsg.setText("Thêm Mới Dữ Liệu Thành Công");
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));

            }

        });
    }

    public int checkIDNhanKhau(String id) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM nhan_khau WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

}
