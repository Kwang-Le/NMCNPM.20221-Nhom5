package SQL;

import java.util.List;

import models.KhaiBao;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.MysqlConnection;

/**
 *
 * @author admin
 */
public class KhaiBaoSQLImpl implements KhaiBaoSQL {

    @Override
    public List<KhaiBao> getList() {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "SELECT * FROM khai_bao";
            List<KhaiBao> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                KhaiBao khaiBao = new KhaiBao();
                khaiBao.setIDKhaiBao(rs.getInt("idKhaiBao"));
                khaiBao.setIDNhanKhau(rs.getInt("idNhanKhau"));
                khaiBao.setVungDich(rs.getString("vungDich"));
                khaiBao.setBieuHien(rs.getString("bieuHien"));
                khaiBao.setNgayKhaiBao(rs.getDate("ngayKhaiBao"));

                list.add(khaiBao);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhaiBaoSQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public int delete(int id) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "DELETE FROM khai_bao WHERE idKhaiBao = ?";
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            cons.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhaiBaoSQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int createOrUpdate(KhaiBao khaiBao) {
        try {
            Connection cons = MysqlConnection.getMysqlConnection();
            String sql = "INSERT INTO khai_bao(idKhaiBao, idNhanKhau, vungDich, bieuHien, ngayKhaiBao) VALUES(?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE idKhaiBao = VALUES(idKhaiBao), idNhanKhau = VALUES(idNhanKhau), vungDich = VALUES(vungDich), bieuHien = VALUES(bieuHien), ngayKhaiBao = VALUES(ngayKhaiBao);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, khaiBao.getIDKhaiBao());
            ps.setInt(2, khaiBao.getIDNhanKhau());
            ps.setString(3, khaiBao.getVungDich());
            ps.setString(4, khaiBao.getBieuHien());
            ps.setDate(5, (java.sql.Date) new Date(khaiBao.getNgayKhaiBao().getTime()));
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
