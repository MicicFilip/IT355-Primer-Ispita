/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao.impl;

import com.it355.primerispita.dao.RasaDao;
import com.it355.primerispita.entity.Oglas;
import com.it355.primerispita.entity.Rasa;
import com.it355.primerispita.entity.Zivotinja;
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
@Repository("rasaDao")
@Service
public class RasaDaoImpl implements RasaDao {

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
    public List<Rasa> getListaRasa() {
        return getSession().createCriteria(Rasa.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Rasa dodajRasu(Rasa mesto) {
        return (Rasa) getSession().merge(mesto);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Rasa getRasaById(Integer id) {
        return (Rasa) getSession().createCriteria(Rasa.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteRasa(Rasa rasa) {
        try {
            getSession().delete(rasa);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Rasa> rasePoIdZivotinje(Integer id) {
        try {
            Zivotinja ziv = (Zivotinja) getSession().createCriteria(Zivotinja.class).add(Restrictions.eq("id", id)).uniqueResult();
            List rase = getSession().createCriteria(Rasa.class).add(Restrictions.eq("zivotinjaId", ziv)).list();
            return rase;
        } catch (Exception ex) {
            return null;
        }
    }

}
