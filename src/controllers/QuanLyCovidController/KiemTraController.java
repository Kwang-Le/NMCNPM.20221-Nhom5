/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.QuanLyCovidController;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import model.KiemTra;
import service.KiemTraService;
import service.KiemTraServiceImpl;

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


    public void setView(KiemTra kiemTra){
        this.kiemTra = kiemTra;
        jtfIDTest.setText("#" + kiemTra.getIDTest());
        jtfIDNhanKhau.setText("#" + kiemTra.getIDNhanKhau());
        jtfHoTen.setText(kiemTra.getHoTen());
        jdcThoiDiemTest.setDate(kiemTra.getThoiDiemTest());
        jtfHinhThucTest.setText(kiemTra.getHinhThucTest());
        jtaKetQua.setText(kiemTra.getKetQua());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length() == 0 || jtaKetQua.getText() == null){
                    jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc");
                }
                else{
                    kiemTra.setIDNhanKhau(Integer.parseInt(jtfIDNhanKhau.getText()));
                    kiemTra.setHoTen(jtfHoTen.getText());
                    kiemTra.setThoiDiemTest((Date) new Date(jdcThoiDiemTest.getDate().getTime()));
                    kiemTra.setHinhThucTest(jtfHinhThucTest.getText());
                    kiemTra.setKetQua(jtaKetQua.getText());
                    int lastID = kiemTraService.createOrUpdate(kiemTra);
                    if (lastID > 0){
//                    kiemTra.setIDTest(lastID);
                    jtfIDTest.setText("#" + lastID);
                    jlbMsg.setText("Thêm Mới Dữ Liệu Thành Công");
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
    
}
