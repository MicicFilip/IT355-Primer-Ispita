/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao;

import com.it355.primerispita.entity.Zivotinja;
import java.util.List;

/**
 *
 * @author vasic
 */
public interface ZivotinjaDao { 
    public List<Zivotinja> getListaZivotinja();
    public Zivotinja dodajZivotinju(Zivotinja zivotinja);
    public Zivotinja getZivotinjaById(Integer id);
    public boolean deleteZivotinja(Zivotinja zivotinja);
}
