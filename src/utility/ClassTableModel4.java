package utility;

import models.KhaiBao;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ClassTableModel4 {
    public DefaultTableModel setTableKhaiBao(List<KhaiBao> listItem, String[] listColumn){
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
                KhaiBao khaiBao = listItem.get(i);
                o = new Object[columns];
                o[0] = khaiBao.getIDKhaiBao();
                o[1] = khaiBao.getIDNhanKhau();
                o[2] = khaiBao.getVungDich();
                o[3] = khaiBao.getBieuHien();
                o[4] = khaiBao.getNgayKhaiBao();
                dtm.addRow(o);
            }
        }
        return dtm;

    }
}
