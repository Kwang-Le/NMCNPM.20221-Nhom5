/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.QuanLyCovid;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.CachLy;

/**
 *
 * @author admin
 */
public class ClassTableModel2 {
    public DefaultTableModel setTableCachLy(List<CachLy> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] o = null;
        int rows = listItem.size();
        if (rows > 0){
            for(int i = 0; i< rows; i++){
                CachLy cachLy = listItem.get(i);
                o = new Object[columns];
                o[0] = cachLy.getIDCachLy();
                o[1] = cachLy.getIDNhanKhau();
                o[2] = cachLy.getHoTen();
                o[3] = cachLy.getNoiCachLy();
                o[4] = cachLy.getThoiGianBatDau();
                o[5] = cachLy.getMucDoCachLy();
                o[6] = cachLy.getDaKiemTra();
                dtm.addRow(o);
            }
        }
        return dtm;
        
    }
    
}
