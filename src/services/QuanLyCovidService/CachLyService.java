/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.QuanLyCovidService;

import models.CachLy;

import java.util.List;

/**
 *
 * @author admin
 */
public interface CachLyService {
    public List<CachLy> getList();
        public int createOrUpdate(CachLy cachLy);
    
}
