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
import models.CachLy;
import services.CachLyService;
import services.CachLyServiceImpl;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class CachLyController {

    private JTextField jtfIDCachLy;
    private JTextField jtfIDNhanKhau;
    private JTextField jtfHoTen;
    private JButton btnSubmit;
    private JTextArea jtaNoiCachLy;
    private JTextField jtfDaKiemTra;
    private JTextField jtfMucDoCachLy;
    private JDateChooser jdcThoiGianBatDau;
    private JLabel jlbMsg;
    private CachLy cachLy = null;
    private CachLyService cachLyService = null;

    public CachLyController(JTextField jtfIDCachLy, JTextField jtfIDNhanKhau, JTextField jtfHoTen, JButton btnSubmit,
            JTextField jtfDaKiemTra, JTextArea jtaNoiCachLy, JTextField jtfMucDoCachLy,
            JDateChooser jdcThoiGianBatDau, JLabel jlbMsg) {
        this.jtfIDCachLy = jtfIDCachLy;
        this.jtfIDNhanKhau = jtfIDNhanKhau;
        this.jtfHoTen = jtfHoTen;
        this.btnSubmit = btnSubmit;
        this.jtfDaKiemTra = jtfDaKiemTra;
        this.jtfMucDoCachLy = jtfMucDoCachLy;
        this.jtaNoiCachLy = jtaNoiCachLy;
        this.jdcThoiGianBatDau = jdcThoiGianBatDau;
        this.jlbMsg = jlbMsg;
        this.cachLyService = new CachLyServiceImpl();
    }

    public void setView(CachLy cachLy) {
        this.cachLy = cachLy;
        jtfIDCachLy.setText(Integer.toString(cachLy.getIDCachLy()));
        jtfIDNhanKhau.setText(Integer.toString(cachLy.getIDNhanKhau()));
        jtfHoTen.setText(cachLy.getHoTen());
        jdcThoiGianBatDau.setDate(cachLy.getThoiGianBatDau()); // vấn đề về thư viện j-calendar?
        jtfMucDoCachLy.setText(cachLy.getMucDoCachLy());
        jtaNoiCachLy.setText(cachLy.getNoiCachLy());
        jtfDaKiemTra.setText(cachLy.getDaKiemTra());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfHoTen.getText().length() == 0 || jtaNoiCachLy.getText() == null) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                } else {
                    System.out.println(jtfIDNhanKhau.getText());
                    if (checkIDNhanKhau(jtfIDNhanKhau.getText()) == -1) {
                        jlbMsg.setText("ID nhân khẩu không khớp");
                    } else {
                        cachLy.setIDNhanKhau(Integer.parseInt(jtfIDNhanKhau.getText()));
                        cachLy.setHoTen(jtfHoTen.getText());
                        cachLy.setThoiGianBatDau((java.sql.Date) new Date(jdcThoiGianBatDau.getDate().getTime()));
                        cachLy.setMucDoCachLy(jtfMucDoCachLy.getText());
                        cachLy.setNoiCachLy(jtaNoiCachLy.getText());
                        cachLy.setDaKiemTra(jtfDaKiemTra.getText());
                        int lastID = cachLyService.createOrUpdate(cachLy);
                        if (lastID > 0) {
//                          cachLy.setIDCachLy(lastID);
                            jtfIDCachLy.setText("" + lastID);
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
