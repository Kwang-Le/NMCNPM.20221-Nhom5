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
public class CachLy {
    private int IDCachLy;
    private int IDNhanKhau;
    private String HoTen;
    private String NoiCachLy;
    private Date ThoiGianBatDau;
    private String MucDoCachLy;
    private String DaKiemTra;

    public int getIDCachLy() {
        return IDCachLy;
    }

    public void setIDCachLy(int IDCachLy) {
        this.IDCachLy = IDCachLy;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getIDNhanKhau() {
        return IDNhanKhau;
    }

    public void setIDNhanKhau(int IDNhanKhau) {
        this.IDNhanKhau = IDNhanKhau;
    }

    public String getNoiCachLy() {
        return NoiCachLy;
    }

    public void setNoiCachLy(String NoiCachLy) {
        this.NoiCachLy = NoiCachLy;
    }

    public Date getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(Date ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }

    public String getMucDoCachLy() {
        return MucDoCachLy;
    }

    public void setMucDoCachLy(String MucDoCachLy) {
        this.MucDoCachLy = MucDoCachLy;
    }

    public String getDaKiemTra() {
        return DaKiemTra;
    }

    public void setDaKiemTra(String DaKiemTra) {
        this.DaKiemTra = DaKiemTra;
    }

    @Override
    public String toString() {
        return "CachLy{" + "IDCachLy=" + IDCachLy + ", IDNhanKhau=" + IDNhanKhau + ", HoTen=" + HoTen + ", NoiCachLy=" + NoiCachLy + ", ThoiGianBatDau=" + ThoiGianBatDau + ", MucDoCachLy=" + MucDoCachLy + ", DaKiemTra=" + DaKiemTra + '}';
    }
    
    
}
