/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.dao.impl;

import com.it355.primerispita.dao.MestoDao;
import com.it355.primerispita.entity.Mesto;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
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
@Repository("mestoDao")
@Service
public class MestoDaoImpl implements MestoDao {

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
    public List<Mesto> getListaMesta() {
        return getSession().createCriteria(Mesto.class).list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Mesto dodajMesto(Mesto mesto) {
        return (Mesto) getSession().merge(mesto);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Mesto getMestoById(Integer id) {
        return (Mesto) getSession().createCriteria(Mesto.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Transactional
    @Override
    public boolean deleteMesto(Mesto mesto) {
        try {
            getSession().delete(mesto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
