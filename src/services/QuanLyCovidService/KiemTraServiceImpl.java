/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.QuanLyCovidService;

import SQL.KiemTraSQL;
import SQL.KiemTraSQLImpl;
import models.KiemTra;

import java.util.List;

/**
 *
 * @author admin
 */
public class KiemTraServiceImpl implements KiemTraService{
    private KiemTraSQL kiemTraSQL = null;

    public KiemTraServiceImpl() {
        kiemTraSQL = new KiemTraSQLImpl();
    }
    

    @Override
    public List<KiemTra> getList() {
        return kiemTraSQL.getList();

    }

    @Override
    public int createOrUpdate(KiemTra kiemTra) {
        return kiemTraSQL.createOrUpdate(kiemTra);
    
    }
}
