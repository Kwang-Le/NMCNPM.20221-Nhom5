/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author admin
 */
public class KiemTra {
    private int IDTest;
    private int IDNhanKhau;
    private String HoTen;
    private Date ThoiDiemTest;
    private String HinhThucTest;
    private String KetQua;

    public int getIDTest() {
        return IDTest;
    }

    public void setIDTest(int IDTest) {
        this.IDTest = IDTest;
    }

    public int getIDNhanKhau() {
        return IDNhanKhau;
    }

    public void setIDNhanKhau(int IDNhanKhau) {
        this.IDNhanKhau = IDNhanKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getThoiDiemTest() {
        return ThoiDiemTest;
    }

    public void setThoiDiemTest(Date ThoiDiemTest) {
        this.ThoiDiemTest = ThoiDiemTest;
    }

    public String getHinhThucTest() {
        return HinhThucTest;
    }

    public void setHinhThucTest(String HinhThucTest) {
        this.HinhThucTest = HinhThucTest;
    }

    public String getKetQua() {
        return KetQua;
    }

    public void setKetQua(String KetQua) {
        this.KetQua = KetQua;
    }

    @Override
    public String toString() {
        return "KiemTra{" + "IDTest=" + IDTest + ", IDNhanKhau=" + IDNhanKhau + ", HoTen=" + HoTen + ", ThoiDiemTest=" + ThoiDiemTest + ", HinhThucTest=" + HinhThucTest + ", KetQua=" + KetQua + '}';
    }


    
}
