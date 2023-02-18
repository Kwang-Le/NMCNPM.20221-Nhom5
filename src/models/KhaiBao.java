package models;

import java.util.Date;

public class KhaiBao {
    private int IDKhaiBao;
    private int IDNhanKhau;
    private String VungDich;
    private String BieuHien;
    private Date NgayKhaiBao;

    public int getIDKhaiBao() {
        return IDKhaiBao;
    }

    public void setIDKhaiBao(int IDKhaiBao) {
        this.IDKhaiBao = IDKhaiBao;
    }

    public int getIDNhanKhau() {
        return IDNhanKhau;
    }

    public void setIDNhanKhau(int IDNhanKhau) {
        this.IDNhanKhau = IDNhanKhau;
    }

    public String getVungDich() {
        return VungDich;
    }

    public void setVungDich(String VungDich) {
        this.VungDich = VungDich;
    }

    public String getBieuHien() {
        return BieuHien;
    }

    public void setBieuHien(String BieuHien) {
        this.BieuHien = BieuHien;
    }

    public Date getNgayKhaiBao() {
        return NgayKhaiBao;
    }

    public void setNgayKhaiBao(Date NgayKhaiBao) {
        this.NgayKhaiBao = NgayKhaiBao;
    }


    @Override
    public String toString() {
        return "KhaiBao{" + "idTest=" + IDKhaiBao + ", idNhanKhau=" + IDNhanKhau + ", vungDich=" + VungDich + ", bieuHien=" + BieuHien + ", ngayKhaiBao=" + NgayKhaiBao + '}';
    }
}