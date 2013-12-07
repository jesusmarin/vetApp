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
import javax.persistence.Lob;
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
@Table(name = "noduloslinfaticos")
@NamedQueries({
    @NamedQuery(name = "NodulosLinfaticos.findAll", query = "SELECT n FROM NodulosLinfaticos n")})
public class NodulosLinfaticos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNodulosLinfaticos")
    private Integer idNodulosLinfaticos;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public NodulosLinfaticos() {
    }

    public NodulosLinfaticos(Integer idNodulosLinfaticos) {
        this.idNodulosLinfaticos = idNodulosLinfaticos;
    }

    public Integer getIdNodulosLinfaticos() {
        return idNodulosLinfaticos;
    }

    public void setIdNodulosLinfaticos(Integer idNodulosLinfaticos) {
        this.idNodulosLinfaticos = idNodulosLinfaticos;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        hash += (idNodulosLinfaticos != null ? idNodulosLinfaticos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NodulosLinfaticos)) {
            return false;
        }
        NodulosLinfaticos other = (NodulosLinfaticos) object;
        if ((this.idNodulosLinfaticos == null && other.idNodulosLinfaticos != null) || (this.idNodulosLinfaticos != null && !this.idNodulosLinfaticos.equals(other.idNodulosLinfaticos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.NodulosLinfaticos[ idNodulosLinfaticos=" + idNodulosLinfaticos + " ]";
    }
    
}
