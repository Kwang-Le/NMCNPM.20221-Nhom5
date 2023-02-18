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
import java.util.logging.Level;
import java.util.logging.Logger;
import models.CachLy;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class CachLySQLImpl implements CachLySQL{
    @Override
    public List<CachLy> getList() {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "SELECT * FROM cach_ly";
            List<CachLy> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CachLy cachLy = new CachLy();
                cachLy.setIDCachLy(rs.getInt("idCachLy"));
                cachLy.setIDNhanKhau(rs.getInt("idNhanKhau"));
                cachLy.setHoTen(rs.getString("hoTen"));
                cachLy.setThoiGianBatDau(rs.getDate("thoiGianbatDau"));
                cachLy.setNoiCachLy(rs.getString("noiCachLy"));
                cachLy.setMucDoCachLy(rs.getString("mucDoCachLy"));
                cachLy.setDaKiemTra(rs.getString("daKiemTra"));
                list.add(cachLy);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CachLySQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int createOrUpdate(CachLy cachLy) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "INSERT INTO cach_ly(idCachLy, idNhanKhau, hoTen, thoiGianBatDau, noiCachLy, mucDoCachLy, daKiemTra) VALUES(?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE idCachLy = VALUES(idCachLy), idNhanKhau = VALUES(idNhanKhau), hoTen = VALUES(hoTen), "
                    + "thoiGianBatDau = VALUES(thoiGianBatDau), mucDoCachLy = VALUES(mucDoCachLy), daKiemTra = VALUES(daKiemTra);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cachLy.getIDCachLy());
            ps.setInt(2, cachLy.getIDNhanKhau());
            ps.setString(3, cachLy.getHoTen());
            ps.setDate(4, (java.sql.Date) new Date(cachLy.getThoiGianBatDau().getTime()));
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
