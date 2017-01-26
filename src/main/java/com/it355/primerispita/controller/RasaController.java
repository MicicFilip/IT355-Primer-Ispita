/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.controller;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.dao.RasaDao;
import com.it355.primerispita.dao.ZivotinjaDao;
import com.it355.primerispita.entity.Mesto;
import com.it355.primerispita.entity.Rasa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vasic
 */
@Controller
public class RasaController {

    @Autowired
    RasaDao rasaDao;

    @Autowired
    ZivotinjaDao zivotinjaDao;

    @RequestMapping(value = "/add_rasa", method = RequestMethod.GET)
    public String addRasa(Model model) {
        model.addAttribute("rasa", new Rasa());
        model.addAttribute("rase", rasaDao.getListaRasa());
        model.addAttribute("zivotinje", zivotinjaDao.getListaZivotinja());
        return "add_rasa";
    }
    
    
    @RequestMapping(value = "/add_rasa", method = RequestMethod.POST)
    public ModelAndView addRasaPost(@ModelAttribute("rasa") Rasa rasa, ModelAndView model) {
        rasa = rasaDao.dodajRasu(rasa);
        model.addObject("zivotinje", zivotinjaDao.getListaZivotinja());
        model.addObject("successMsg", "Rasa uspešno dodata");
        model.addObject("rase", rasaDao.getListaRasa());
        model.addObject("rasa", new Rasa());
        return model;
    }


    @RequestMapping(value = "/delete_rasa/{id}", method = RequestMethod.GET)
    public String deleteRasa(@PathVariable("id") int id, HttpServletRequest request) {
        Rasa rasa = rasaDao.getRasaById(id);
        if (rasa == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        rasaDao.deleteRasa(rasa);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/edit_rasa/{id}", method = RequestMethod.GET)
    public String editRasa(@PathVariable("id") int id, Model model) {
        Rasa rasa = rasaDao.getRasaById(id);
        model.addAttribute("rasa", rasa);
        model.addAttribute("zivotinje", zivotinjaDao.getListaZivotinja());
        List rase = rasaDao.getListaRasa();
        model.addAttribute("rase", rase);
        return "add_rasa";
    }

}
