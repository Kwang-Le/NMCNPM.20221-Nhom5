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
import models.KiemTra;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class KiemTraSQLImpl implements KiemTraSQL{
    @Override
    public List<KiemTra> getList() {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "SELECT * FROM kiem_tra";
            List<KiemTra> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KiemTra kiemTra = new KiemTra();
                kiemTra.setIDTest(rs.getInt("idTest"));
                kiemTra.setIDNhanKhau(rs.getInt("idNhanKhau"));
                kiemTra.setHoTen(rs.getString("hoTen"));
                kiemTra.setThoiDiemTest(rs.getDate("thoiDiemTest"));
                kiemTra.setHinhThucTest(rs.getString("hinhThucTest"));
                kiemTra.setKetQua(rs.getString("ketQua"));
                
                list.add(kiemTra);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KiemTraSQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int delete(int IDTest) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "DELETE FROM kiem_tra WHERE idTest=?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, IDTest);
            int deletedRows = ps.executeUpdate();
            ps.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KiemTraSQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int createOrUpdate(KiemTra kiemTra) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "INSERT INTO kiem_tra(idTest, idNhanKhau, hoTen, thoiDiemTest, hinhThucTest, ketQua) VALUES(?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE idTest = VALUES(idTest), idNhanKhau = VALUES(idNhanKhau), hoTen = VALUES(hoTen), thoiDiemTest = VALUES(thoiDiemTest), "
                    + "hinhThucTest = VALUES(hinhThucTest), ketQua = VALUES(ketQua);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, kiemTra.getIDTest());
            ps.setInt(2, kiemTra.getIDNhanKhau());
            ps.setString(3, kiemTra.getHoTen());
            ps.setDate(4, (java.sql.Date) new Date(kiemTra.getThoiDiemTest().getTime()));
            ps.setString(5, kiemTra.getHinhThucTest());
            ps.setString(6, kiemTra.getKetQua());
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
        KiemTraSQL kiemTraSQL = new KiemTraSQLImpl();
        System.out.println(kiemTraSQL.getList());
    }
    
}
