/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.converter;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.dao.ZivotinjaDao;
import com.it355.primerispita.entity.Zivotinja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 *
 * @author vasic
 */
@Component
final class IntegerToZivotinja implements Converter<String , Zivotinja> {

    @Autowired
    ZivotinjaDao zivotinjaDao;

    @Override
    public Zivotinja convert(String  s) {
        if(s.isEmpty()){
            return null;
        }
        Integer valeu = Integer.valueOf(s);
        Zivotinja cat = zivotinjaDao.getZivotinjaById(valeu);
        return cat;
    }
}
