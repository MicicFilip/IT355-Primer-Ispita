/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.controller;

import com.it355.primerispita.dao.ZivotinjaDao;
import com.it355.primerispita.entity.Rasa;
import com.it355.primerispita.entity.Zivotinja;
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
public class ZivotinjaController {
    
    @Autowired
    ZivotinjaDao zivotinjaDao;
    
    @RequestMapping(value = "/add_zivotinja", method = RequestMethod.GET)
    public String addZivotinja(Model model) {
        model.addAttribute("zivotinja", new Zivotinja());
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addAttribute("zivotinje", zivotinje);
        return "add_zivotinja";
    }

    @RequestMapping(value = "/add_zivotinja", method = RequestMethod.POST)
    public ModelAndView addZivotinjaPost(@ModelAttribute("zivotinja") Zivotinja zivotinja, ModelAndView model) {
        zivotinja = zivotinjaDao.dodajZivotinju(zivotinja);
        model.addObject("successMsg", "Zivotinja uspešno dodata");
        model.addObject("zivotinja", new Zivotinja());
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addObject("zivotinje", zivotinje);
        return model;
    }
    
     @RequestMapping(value = "/delete_zivotinja/{id}", method = RequestMethod.GET)
    public String deleteZivotinja(@PathVariable("id") int id, HttpServletRequest request) {
        Zivotinja zivotinja = zivotinjaDao.getZivotinjaById(id);
        if (zivotinja == null) {
            String referer = request.getHeader("Referer");
            return "redirect:" + referer;
        }
        zivotinjaDao.deleteZivotinja(zivotinja);
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
    }

    @RequestMapping(value = "/edit_zivotinja/{id}", method = RequestMethod.GET)
    public String editRasa(@PathVariable("id") int id, Model model) {
        Zivotinja zivotinja = zivotinjaDao.getZivotinjaById(id);
        model.addAttribute("zivotinja", zivotinja);
        List zivotinje = zivotinjaDao.getListaZivotinja();
        model.addAttribute("zivotinje", zivotinje);
        return "add_zivotinja";
    }
}
