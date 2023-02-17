
package SQL;
import java.util.List;
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
public class NhanKhauSQLImpl implements NhanKhauSQL{

    @Override
    public List<NhanKhau> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM nhankhau";
            List<NhanKhau> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanKhau nhanKhau = new NhanKhau();
                nhanKhau.setID(rs.getInt("ID"));
                nhanKhau.setHoTen(rs.getString("HoTen"));
                nhanKhau.setNgaySinh(rs.getDate("NgaySinh"));
                nhanKhau.setGioiTinh(rs.getString("GioiTinh"));
                nhanKhau.setNoiSinh(rs.getString("NoiSinh"));
                nhanKhau.setDiaChi(rs.getString("DiaChi"));
                
                list.add(nhanKhau);
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
    
    public int createOrUpdate(NhanKhau nhanKhau) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO NhanKhau(ID, HoTen, NgaySinh, GioiTinh, NoiSinh, DiaChi) VALUES(?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE HoTen = VALUES(HoTen), NgaySinh = VALUES(NgaySinh), GioiTinh = VALUES(GioiTinh), NoiSinh = VALUES(NoiSinh), DiaChi = VALUES(DiaChi);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, nhanKhau.getID());
            ps.setString(2, nhanKhau.getHoTen());
            ps.setDate(3, (Date) new Date(nhanKhau.getNgaySinh().getTime()));
            ps.setString(4, nhanKhau.getGioiTinh());
            ps.setString(5, nhanKhau.getNoiSinh());
            ps.setString(6, nhanKhau.getDiaChi());
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
        NhanKhauSQL nhanKhauSQL = new NhanKhauSQLImpl();
        System.out.println(nhanKhauSQL.getList());
    }
    
}
