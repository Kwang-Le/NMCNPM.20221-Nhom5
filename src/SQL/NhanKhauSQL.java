/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.util.List;
import model.NhanKhau;

/**
 *
 * @author admin
 */
public interface NhanKhauSQL {
    public List<NhanKhau> getList();
    public int createOrUpdate(NhanKhau nhanKhau);
}
