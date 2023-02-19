/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.KiemTra;

/**
 *
 * @author admin
 */
public interface KiemTraService {
    public List<KiemTra> getList();
        public int createOrUpdate(KiemTra kiemTra);
        public int delete(int id);
}
