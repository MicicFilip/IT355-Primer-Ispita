/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.converter;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.entity.Mesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author vasic
 */
@Component
final class IntegerToMesto implements Converter<String , Mesto> {

    @Autowired
    MestoDao mestoDao;

    @Override
    public Mesto convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Mesto cat = mestoDao.getMestoById(valeu);
        return cat;
    }
}
