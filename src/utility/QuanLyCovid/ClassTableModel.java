/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.QuanLyCovid;

import models.NhanKhauModel;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author admin
 */
public class ClassTableModel {
    public DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if (rows > 0){
            for(int i = 0; i< rows; i++){
                NhanKhauModel nhanKhau = listItem.get(i);
                obj = new Object[columns];
                obj[0] = nhanKhau.getID();
                obj[1] = nhanKhau.getHoTen();
                obj[2] = nhanKhau.getNamSinh();
                obj[3] = nhanKhau.getGioiTinh();
                obj[4] = nhanKhau.getNoiSinh();
                obj[5] = nhanKhau.getNoiThuongTru();
                dtm.addRow(obj);
            }
        }
        return dtm;
        
    }
}
