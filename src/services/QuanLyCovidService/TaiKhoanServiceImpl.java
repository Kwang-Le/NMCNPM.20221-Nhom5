/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.QuanLyCovidService;

import SQL.UserModelSQL;
import SQL.TaiKhoanSQLImpl;
import models.UserMoldel;

/**
 *
 * @author admin
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private UserMoldelSQL UserModelSQL = null;
    public TaiKhoanServiceImpl(){
        taiKhoanSQL = new TaiKhoanSQLImpl();
    }

    @Override
    public UserMoldel login(String userName, String passwd) {
        return taiKhoanSQL.login(userName, passwd);
    }
    
}
