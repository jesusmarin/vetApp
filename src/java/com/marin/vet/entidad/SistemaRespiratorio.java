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
@Table(name = "sistemasrespiratorio")
@NamedQueries({
    @NamedQuery(name = "SistemaRespiratorio.findAll", query = "SELECT s FROM SistemaRespiratorio s")})
public class SistemaRespiratorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSistemasRespiratorio")
    private Integer idSistemasRespiratorio;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public SistemaRespiratorio() {
    }

    public SistemaRespiratorio(Integer idSistemasRespiratorio) {
        this.idSistemasRespiratorio = idSistemasRespiratorio;
    }

    public Integer getIdSistemasRespiratorio() {
        return idSistemasRespiratorio;
    }

    public void setIdSistemasRespiratorio(Integer idSistemasRespiratorio) {
        this.idSistemasRespiratorio = idSistemasRespiratorio;
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
        hash += (idSistemasRespiratorio != null ? idSistemasRespiratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaRespiratorio)) {
            return false;
        }
        SistemaRespiratorio other = (SistemaRespiratorio) object;
        if ((this.idSistemasRespiratorio == null && other.idSistemasRespiratorio != null) || (this.idSistemasRespiratorio != null && !this.idSistemasRespiratorio.equals(other.idSistemasRespiratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.SistemaRespiratorio[ idSistemasRespiratorio=" + idSistemasRespiratorio + " ]";
    }
    
}
