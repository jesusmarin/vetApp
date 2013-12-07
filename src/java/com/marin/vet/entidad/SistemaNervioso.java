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
@Table(name = "sistemanervioso")
@NamedQueries({
    @NamedQuery(name = "SistemaNervioso.findAll", query = "SELECT s FROM SistemaNervioso s")})
public class SistemaNervioso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSistemaNervioso")
    private Integer idSistemaNervioso;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public SistemaNervioso() {
    }

    public SistemaNervioso(Integer idSistemaNervioso) {
        this.idSistemaNervioso = idSistemaNervioso;
    }

    public Integer getIdSistemaNervioso() {
        return idSistemaNervioso;
    }

    public void setIdSistemaNervioso(Integer idSistemaNervioso) {
        this.idSistemaNervioso = idSistemaNervioso;
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
        hash += (idSistemaNervioso != null ? idSistemaNervioso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaNervioso)) {
            return false;
        }
        SistemaNervioso other = (SistemaNervioso) object;
        if ((this.idSistemaNervioso == null && other.idSistemaNervioso != null) || (this.idSistemaNervioso != null && !this.idSistemaNervioso.equals(other.idSistemaNervioso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.SistemaNervioso[ idSistemaNervioso=" + idSistemaNervioso + " ]";
    }
    
}
