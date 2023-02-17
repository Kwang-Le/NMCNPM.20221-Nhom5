/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.QuanLyCovidService;

import models.KhaiBao;

import java.util.List;

/**
 *
 * @author admin
 */
public interface KhaiBaoService {
    public List<KhaiBao> getList();
        public int createOrUpdate(KhaiBao khaiBao);
    
}
