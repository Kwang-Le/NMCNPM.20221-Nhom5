package SQL;

import java.util.List;
import model.HoKhau;

/**
 *
 * @author admin
 */
public interface HoKhauSQL {
    public List<HoKhau> getList();
    public int createOrUpdate(HoKhau hoKhau);
}
