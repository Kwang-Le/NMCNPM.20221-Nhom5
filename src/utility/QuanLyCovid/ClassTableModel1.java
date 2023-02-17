/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility.QuanLyCovid;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.KiemTra;

/**
 *
 * @author admin
 */
public class ClassTableModel1 {
        public DefaultTableModel setTableKiemTra(List<KiemTra> listItem, String[] listColumn){
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] ob = null;
        int rows = listItem.size();
        if (rows > 0){
            for(int i = 0; i< rows; i++){
                KiemTra kiemTra = listItem.get(i);
                ob = new Object[columns];
                ob[0] = kiemTra.getIDTest();
                ob[1] = kiemTra.getIDNhanKhau();
                ob[2] = kiemTra.getHoTen();
                ob[3] = kiemTra.getThoiDiemTest();
                ob[4] = kiemTra.getHinhThucTest();
                ob[5] = kiemTra.getKetQua();
                dtm.addRow(ob);
            }
        }
        return dtm;
        
    }
    
}
