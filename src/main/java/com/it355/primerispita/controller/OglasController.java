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
import com.it355.primerispita.entity.Oglas;
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
public class OglasController {

    @Autowired
    OglasDao oglasDao;

    @Autowired
    RasaDao rasaDao;

    @Autowired
    MestoDao mestoDao;

    @Autowired
    ZivotinjaDao zivotinjaDao;

    @RequestMapping(value = "/add_oglas", method = RequestMethod.GET)
    public String addOglas(Model model) {
        model.addAttribute("oglas", new Oglas());
        List mesta = mestoDao.getListaMesta();
        model.addAttribute("mesta", mesta);
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addAttribute("zivotinje", zivotinje);
        List rase = rasaDao.getListaRasa();
        model.addAttribute("rase", rase);
        List oglasi = oglasDao.getListaOglasa();
        model.addAttribute("oglasi", oglasi);
        return "add_oglas";
    }

    @RequestMapping(value = "/add_oglas", method = RequestMethod.POST)
    public ModelAndView addOglasPost(@ModelAttribute("oglas") Oglas oglas, ModelAndView model) {
        oglas = oglasDao.dodajOglas(oglas);
        List mesta = mestoDao.getListaMesta();
        model.addObject("mesta", mesta);
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addObject("zivotinje", zivotinje);
        List rase = rasaDao.getListaRasa();
        model.addObject("rase", rase);
        List oglasi = oglasDao.getListaOglasa();
        model.addObject("oglasi", oglasi);
        model.addObject("successMsg", "Oglas uspešno dodat");
        model.addObject("oglas", new Oglas());
        return model;
    }

    @RequestMapping(value = "/edit_oglas/{id}", method = RequestMethod.GET)
    public String editOglas(@PathVariable("id") int id, Model model) {
        Oglas oglas = oglasDao.getOglasById(id);
        model.addAttribute("oglas", oglas);
        List mesta = mestoDao.getListaMesta();
        model.addAttribute("mesta", mesta);
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addAttribute("zivotinje", zivotinje);
        List rase = rasaDao.getListaRasa();
        model.addAttribute("rase", rase);
        List oglasi = oglasDao.getListaOglasa();
        model.addAttribute("oglasi", oglasi);
        return "add_oglas";
    }

    @RequestMapping(value = "/delete_oglas/{id}", method = RequestMethod.GET)
    public String deleteOglas(@PathVariable("id") int id, HttpServletRequest request) {
        Oglas oglas = oglasDao.getOglasById(id);
        if (oglas == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        oglasDao.deleteOglas(oglas);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }
}
