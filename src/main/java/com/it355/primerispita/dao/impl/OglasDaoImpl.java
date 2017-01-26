/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao.impl;

import com.it355.primerispita.dao.OglasDao;
import com.it355.primerispita.entity.Mesto;
import com.it355.primerispita.entity.Oglas;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vasic
 */
@Repository("oglasDao")
@Service
public class OglasDaoImpl implements OglasDao {

    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(getClass());

    //Instanciramo sesiju
    @Autowired
    private SessionFactory sessionFactory;

    //kreiramo seter za sesiju
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //kreiramo geter za sesiju
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Oglas> getListaOglasa() {
        return getSession().createCriteria(Oglas.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Oglas dodajOglas(Oglas mesto) {
        return (Oglas) getSession().merge(mesto);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Oglas getOglasById(Integer id) {
        return (Oglas) getSession().createCriteria(Oglas.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteOglas(Oglas oglas) {
        try {
            getSession().delete(oglas);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
