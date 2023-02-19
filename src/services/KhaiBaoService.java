/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.KhaiBao;

/**
 *
 * @author admin
 */
public interface KhaiBaoService {
    public List<KhaiBao> getList();
        public int createOrUpdate(KhaiBao khaiBao);
        public int delete(int id);
}
