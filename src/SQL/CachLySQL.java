/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.util.List;
import models.CachLy;

/**
 *
 * @author admin
 */
public interface CachLySQL {
    public List<CachLy> getList();
    public int createOrUpdate(CachLy cachLy);
    int delete(int id);
    
}
