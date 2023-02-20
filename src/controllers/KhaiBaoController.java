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
import models.KhaiBao;
import services.KhaiBaoService;
import services.KhaiBaoServiceImpl;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class KhaiBaoController {

    private JTextField jtfIDKhaiBao;
    private JTextField jtfIDNhanKhau;
    private JTextField jtfVungDich;
    private JTextArea jtaBieuHien;
    private JDateChooser jdcNgayKhaiBao;
    private JButton btnSubmit;
    private JLabel jlbMsg;
    private KhaiBao khaiBao = null;
    private KhaiBaoService khaiBaoService = null;

    public KhaiBaoController(JTextField jtfIDKhaiBao, JTextField jtfIDNhanKhau, JTextField jtfVungDich, JTextArea jtaBieuHien, JDateChooser jdcNgayKhaiBao, JButton btnSubmit, JLabel jlbMsg) {
        this.jtfIDKhaiBao = jtfIDKhaiBao;
        this.jtfIDNhanKhau = jtfIDNhanKhau;
        this.jtfVungDich = jtfVungDich;
        this.jtaBieuHien = jtaBieuHien;
        this.jdcNgayKhaiBao = jdcNgayKhaiBao;
        this.btnSubmit = btnSubmit;
        this.jlbMsg = jlbMsg;
        this.khaiBaoService = new KhaiBaoServiceImpl();
    }

    public void setView(KhaiBao khaiBao) {
        this.khaiBao = khaiBao;
        jtfIDKhaiBao.setText("" + khaiBao.getIDKhaiBao());
        jtfIDNhanKhau.setText("" + khaiBao.getIDNhanKhau());
        jtfVungDich.setText(khaiBao.getVungDich());
        jtaBieuHien.setText(khaiBao.getBieuHien());
        jdcNgayKhaiBao.setDate(khaiBao.getNgayKhaiBao());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfVungDich.getText().length() == 0 || jtaBieuHien.getText() == null) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                } else {
                    if (checkIDNhanKhau(jtfIDNhanKhau.getText()) == -1) {
                        jlbMsg.setText("ID nhân khẩu không khớp");
                    } else {
                        khaiBao.setIDNhanKhau(Integer.parseInt(jtfIDNhanKhau.getText()));
                        khaiBao.setNgayKhaiBao((java.sql.Date) new Date(jdcNgayKhaiBao.getDate().getTime()));
                        khaiBao.setVungDich(jtfVungDich.getText());
                        khaiBao.setBieuHien(jtaBieuHien.getText());
                        int lastID = khaiBaoService.createOrUpdate(khaiBao);
                        if (lastID > 0) {
//                    khaiBao.setIDKhaiBao(lastID);
                            jtfIDKhaiBao.setText("" + lastID);
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
