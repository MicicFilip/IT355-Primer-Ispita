/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.it355.primerispita.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasic
 */
@Entity
@Table(name = "oglas")
public class Oglas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NASLOV")
    private String naslov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "OPIS")
    private String opis;
    @Column(name = "CENA")
    private BigDecimal cena;
    
    @JoinColumn(name = "ZIVOTINJA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Zivotinja zivotinjaId;
    @JoinColumn(name = "RASA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Rasa rasaId;
    @JoinColumn(name = "MESTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Mesto mestoId;

    public Oglas() {
    }

    public Oglas(Integer id) {
        this.id = id;
    }

    public Oglas(Integer id, String naslov, String opis) {
        this.id = id;
        this.naslov = naslov;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zivotinja getZivotinjaId() {
        return zivotinjaId;
    }

    public void setZivotinjaId(Zivotinja zivotinjaId) {
        this.zivotinjaId = zivotinjaId;
    }

    public Rasa getRasaId() {
        return rasaId;
    }

    public void setRasaId(Rasa rasaId) {
        this.rasaId = rasaId;
    }

    public Mesto getMestoId() {
        return mestoId;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
    
    

    public void setMestoId(Mesto mestoId) {
        this.mestoId = mestoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oglas)) {
            return false;
        }
        Oglas other = (Oglas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naslov;
    }
    
}
