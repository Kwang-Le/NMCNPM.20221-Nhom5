package SQL;

import java.util.List;

import model.KhaiBao;
import model.NhanKhau;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class KhaiBaoSQLImpl implements KhaiBaoSQL {

    @Override
    public List<KhaiBao> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM khaibao";
            List<KhaiBao> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KhaiBao khaiBao = new KhaiBao();
                khaiBao.setIDKhaiBao(rs.getInt("IDKhaiBao"));
                khaiBao.setIDNhanKhau(rs.getInt("IDNhanKhau"));
                khaiBao.setVungDich(rs.getString("VungDich"));
                khaiBao.setBieuHien(rs.getString("BieuHien"));
                khaiBao.setNgayKhaiBao(rs.getDate("NgayKhaiBao"));

                list.add(khaiBao);
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

    @Override
    public int createOrUpdate(KhaiBao khaiBao) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO KhaiBao(IDKhaiBao, IDNhanKhau, VungDich, BieuHien, NgayKhaiBao) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE IDKhaiBao = VALUES(IDKhaiBao), IDNhanKhau = VALUES(IDNhanKhau), VungDich = VALUES(VungDich), BieuHien = VALUES(BieuHien), NgayKhaiBao = VALUES(NgayKhaiBao);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khaiBao.getIDKhaiBao());
            ps.setInt(2, khaiBao.getIDNhanKhau());
            ps.setString(3, khaiBao.getVungDich());
            ps.setString(4, khaiBao.getBieuHien());
            ps.setDate(5, (Date) new Date(khaiBao.getNgayKhaiBao().getTime()));
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
        KhaiBaoSQL khaiBaoSQL = new KhaiBaoSQLImpl();
        System.out.println(khaiBaoSQL.getList());
    }
}
