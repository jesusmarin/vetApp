/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "sistemascardiovascular")
@NamedQueries({
    @NamedQuery(name = "SistemaCardioVascular.findAll", query = "SELECT s FROM SistemaCardioVascular s")})
public class SistemaCardioVascular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSistemasCardiovascular")
    private Integer idSistemasCardiovascular;
    @Column(name = "valor")
    private Integer valor;
    @Size(max = 45)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public SistemaCardioVascular() {
    }

    public SistemaCardioVascular(Integer idSistemasCardiovascular) {
        this.idSistemasCardiovascular = idSistemasCardiovascular;
    }

    public Integer getIdSistemasCardiovascular() {
        return idSistemasCardiovascular;
    }

    public void setIdSistemasCardiovascular(Integer idSistemasCardiovascular) {
        this.idSistemasCardiovascular = idSistemasCardiovascular;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ConstantesFisiologicas getIdConstantesFisiologicas() {
        return idConstantesFisiologicas;
    }

    public void setIdConstantesFisiologicas(ConstantesFisiologicas idConstantesFisiologicas) {
        this.idConstantesFisiologicas = idConstantesFisiologicas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSistemasCardiovascular != null ? idSistemasCardiovascular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaCardioVascular)) {
            return false;
        }
        SistemaCardioVascular other = (SistemaCardioVascular) object;
        if ((this.idSistemasCardiovascular == null && other.idSistemasCardiovascular != null) || (this.idSistemasCardiovascular != null && !this.idSistemasCardiovascular.equals(other.idSistemasCardiovascular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.SistemaCardioVascular[ idSistemasCardiovascular=" + idSistemasCardiovascular + " ]";
    }
    
}
