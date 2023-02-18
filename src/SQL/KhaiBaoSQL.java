package SQL;

import java.util.List;

import models.KhaiBao;
import models.KiemTra;

/**
 *
 * @author admin
 */
public interface KhaiBaoSQL {
    public List<KhaiBao> getList();
    public int createOrUpdate(KhaiBao khaiBao);
}
