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
import model.KiemTra;

/**
 *
 * @author admin
 */
public class KiemTraSQLImpl implements KiemTraSQL{
    @Override
    public List<KiemTra> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM kiemtra";
            List<KiemTra> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KiemTra kiemTra = new KiemTra();
                kiemTra.setIDTest(rs.getInt("IDTest"));
                kiemTra.setIDNhanKhau(rs.getInt("IDNhanKhau"));
                kiemTra.setHoTen(rs.getString("HoTen"));
                kiemTra.setThoiDiemTest(rs.getDate("ThoiDiemTest"));
                kiemTra.setHinhThucTest(rs.getString("HinhThucTest"));
                kiemTra.setKetQua(rs.getString("KetQua"));
                
                list.add(kiemTra);
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
    
    public int createOrUpdate(KiemTra kiemTra) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO KiemTra(IDTest, IDNhanKhau, HoTen, ThoiDiemTest, HinhThucTest, KetQua) VALUES(?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE IDTest = VALUES(IDTest), IDNhanKhau = VALUES(IDNhanKhau), HoTen = VALUES(HoTen), ThoiDiemTest = VALUES(ThoiDiemTest), "
                    + "HinhThucTest = VALUES(HinhThucTest), KetQua = VALUES(KetQua);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, kiemTra.getIDTest());
            ps.setInt(2, kiemTra.getIDNhanKhau());
            ps.setString(3, kiemTra.getHoTen());
            ps.setDate(4, (Date) new Date(kiemTra.getThoiDiemTest().getTime()));
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
