/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.rest;

import com.it355.primerispita.dao.RasaDao;
import com.it355.primerispita.entity.Rasa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vasic
 */
@RestController
public class MainRestController {

    @Autowired
    RasaDao rasaDao;

    @RequestMapping(value = "/rase/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rasa>> getRase(@PathVariable("id") int id) {
        System.out.println("Fetching product with id " + id);
        List<Rasa> rase = rasaDao.rasePoIdZivotinje(id);
        if (rase == null) {
            return new ResponseEntity<List<Rasa>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity< List<Rasa>>(rase, HttpStatus.OK);
    }
}
