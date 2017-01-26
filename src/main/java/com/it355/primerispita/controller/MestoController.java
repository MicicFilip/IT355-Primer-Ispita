/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.controller;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.dao.OglasDao;
import com.it355.primerispita.dao.RasaDao;
import com.it355.primerispita.dao.ZivotinjaDao;
import com.it355.primerispita.entity.Mesto;
import com.it355.primerispita.entity.Rasa;
import com.it355.primerispita.entity.Zivotinja;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vasic
 */
@Controller
public class MestoController {

    @Autowired
    OglasDao oglasDao;

    @Autowired
    RasaDao rasaDao;

    @Autowired
    MestoDao mestoDao;

    @Autowired
    ZivotinjaDao zivotinjaDao;


    @RequestMapping(value = "/add_mesto", method = RequestMethod.GET)
    public String addMesto(Model model) {
        model.addAttribute("mesto", new Mesto());
        List mesta = mestoDao.getListaMesta();
        model.addAttribute("mesta", mesta);
        return "add_mesto";
    }

    @RequestMapping(value = "/add_mesto", method = RequestMethod.POST)
    public ModelAndView addMestoPost(@ModelAttribute("mesto") Mesto mesto, ModelAndView model) {
        mesto = mestoDao.dodajMesto(mesto);
        model.addObject("mesta", mestoDao.getListaMesta());
        model.addObject("successMsg", "Mesto uspešno dodato");
        model.addObject("mesto", new Mesto());
        return model;
    }

    @RequestMapping(value = "/edit_mesto/{id}", method = RequestMethod.GET)
    public String editMesto(@PathVariable("id") int id, Model model) {
        Mesto mesto = mestoDao.getMestoById(id);
        model.addAttribute("mesto", mesto);
        List mesta = mestoDao.getListaMesta();
        model.addAttribute("mesta", mesta);
        return "add_mesto";
    }


 
    @RequestMapping(value = "/delete_mesto/{id}", method = RequestMethod.GET)
    public String deleteMesto(@PathVariable("id") int id, HttpServletRequest request) {
        System.out.println("Fetching & Deleting product with id " + id);
        Mesto mesto = mestoDao.getMestoById(id);
        if (mesto == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        mestoDao.deleteMesto(mesto);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
