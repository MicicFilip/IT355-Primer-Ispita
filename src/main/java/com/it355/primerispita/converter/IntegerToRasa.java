/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.converter;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.dao.RasaDao;
import com.it355.primerispita.entity.Rasa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author vasic
 */
@Component
final class IntegerToRasa implements Converter<String , Rasa> {

    @Autowired
    RasaDao rasaDao;

    @Override
    public Rasa convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Rasa cat = rasaDao.getRasaById(valeu);
        return cat;
    }
}
