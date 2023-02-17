/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import model.TaiKhoan;
import models.UserMoldel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class TaiKhoanSQLImpl implements TaiKhoanSQL{

    @Override
    public UserMoldel login(String tdn, String mk) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM taikhoan WHERE TenDangNhap LIKE ?  AND MatKhau LIKE ?";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setIDTaiKhoan(rs.getInt("IDTaiKhoan"));
                taiKhoan.setTenDangNhap(rs.getString("TenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("MatKhau"));
                taiKhoan.setTinhTrang(rs.getBoolean("TinhTrang"));
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
