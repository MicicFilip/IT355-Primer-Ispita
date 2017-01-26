/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao;

import com.it355.primerispita.entity.Rasa;
import java.util.List;

/**
 *
 * @author vasic
 */
public interface RasaDao {
    public List<Rasa> getListaRasa();
    public Rasa dodajRasu(Rasa rasa);
    public Rasa getRasaById(Integer id);
    public boolean deleteRasa(Rasa rasa);
    public List<Rasa> rasePoIdZivotinje(Integer id);
}
