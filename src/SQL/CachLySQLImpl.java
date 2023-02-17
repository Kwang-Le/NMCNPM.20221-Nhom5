/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CachLy;
import models.CachLy;

/**
 *
 * @author admin
 */
public class CachLySQLImpl implements CachLySQL{
    @Override
    public List<CachLy> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM cachly";
            List<CachLy> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CachLy cachLy = new CachLy();
                cachLy.setIDCachLy(rs.getInt("IDCachLy"));
                cachLy.setIDNhanKhau(rs.getInt("IDNhanKhau"));
                cachLy.setHoTen(rs.getString("HoTen"));
                cachLy.setThoiGianBatDau(rs.getDate("ThoiGianbatDau"));
                cachLy.setNoiCachLy(rs.getString("NoiCachLy"));
                cachLy.setMucDoCachLy(rs.getString("MucDoCachLy"));
                cachLy.setDaKiemTra(rs.getString("DaKiemTra"));
                list.add(cachLy);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int createOrUpdate(CachLy cachLy) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO CachLy(IDCachLy, IDNhanKhau, HoTen, ThoiGianBatDau, NoiCachLy, MucDoCachLy, DaKiemTra) VALUES(?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE IDCachLy = VALUES(IDCachLy), IDNhanKhau = VALUES(IDNhanKhau), HoTen = VALUES(HoTen), "
                    + "ThoiGianBatDau = VALUES(ThoiGianBatDau), MucDoCachLy = VALUES(MucDoCachLy), DaKiemTra = VALUES(DaKiemTra);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cachLy.getIDCachLy());
            ps.setInt(2, cachLy.getIDNhanKhau());
            ps.setString(3, cachLy.getHoTen());
            ps.setDate(4, (Date) new Date(cachLy.getThoiGianBatDau().getTime()));
            ps.setString(5, cachLy.getNoiCachLy());
            ps.setString(6, cachLy.getMucDoCachLy());
            ps.setString(7, cachLy.getDaKiemTra());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        CachLySQL cachLySQL = new CachLySQLImpl();
        System.out.println(cachLySQL.getList());
    }
    
}
