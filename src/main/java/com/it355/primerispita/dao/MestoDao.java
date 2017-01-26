/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao;

import com.it355.primerispita.entity.Mesto;
import java.util.List;

/**
 *
 * @author vasic
 */
public interface MestoDao {
    public List<Mesto> getListaMesta();
    public Mesto dodajMesto(Mesto mesto);
    public Mesto getMestoById(Integer id);
    public boolean deleteMesto(Mesto mesto);
}
