/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao;

import com.it355.primerispita.entity.Oglas;
import com.it355.primerispita.entity.Rasa;
import java.util.List;

/**
 *
 * @author vasic
 */
public interface OglasDao {
    public List<Oglas> getListaOglasa();
    public Oglas dodajOglas(Oglas oglas);
    public Oglas getOglasById(Integer id);
    public boolean deleteOglas(Oglas oglas);
}
