package utility.QuanLyCovid;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import model.HoKhau;

public class ClassTableModel3 {
    public DefaultTableModel setTableHoKhau(List<HoKhau> listItem, String[] listColumn){
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
                HoKhau hoKhau = listItem.get(i);
                o = new Object[columns];
                o[0] = hoKhau.getID();
                o[1] = hoKhau.getMaHoKhau();
                o[2] = hoKhau.getIdChuHo();
                o[3] = hoKhau.getMaKhuVuc();
                o[4] = hoKhau.getDiaChi();
                o[5] = hoKhau.getNgayLap();
                o[6] = hoKhau.getNgayChuyenDi();
                o[7] = hoKhau.getLyDoChuyen();
                o[8] = hoKhau.getNguoiThucHien();
                dtm.addRow(o);
            }
        }
        return dtm;

    }
}
