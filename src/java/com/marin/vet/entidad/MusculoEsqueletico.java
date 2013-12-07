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
@Table(name = "musculoesqueletico")
@NamedQueries({
    @NamedQuery(name = "MusculoEsqueletico.findAll", query = "SELECT m FROM MusculoEsqueletico m")})
public class MusculoEsqueletico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMusculoEsqueletico")
    private Integer idMusculoEsqueletico;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public MusculoEsqueletico() {
    }

    public MusculoEsqueletico(Integer idMusculoEsqueletico) {
        this.idMusculoEsqueletico = idMusculoEsqueletico;
    }

    public Integer getIdMusculoEsqueletico() {
        return idMusculoEsqueletico;
    }

    public void setIdMusculoEsqueletico(Integer idMusculoEsqueletico) {
        this.idMusculoEsqueletico = idMusculoEsqueletico;
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
        hash += (idMusculoEsqueletico != null ? idMusculoEsqueletico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MusculoEsqueletico)) {
            return false;
        }
        MusculoEsqueletico other = (MusculoEsqueletico) object;
        if ((this.idMusculoEsqueletico == null && other.idMusculoEsqueletico != null) || (this.idMusculoEsqueletico != null && !this.idMusculoEsqueletico.equals(other.idMusculoEsqueletico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.MusculoEsqueletico[ idMusculoEsqueletico=" + idMusculoEsqueletico + " ]";
    }
    
}
