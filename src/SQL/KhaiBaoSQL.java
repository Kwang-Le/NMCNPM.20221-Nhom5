package SQL;

import models.KhaiBao;

import java.util.List;

/**
 *
 * @author admin
 */
public interface KhaiBaoSQL {
    public List<KhaiBao> getList();
    public int createOrUpdate(KhaiBao khaiBao);
}
