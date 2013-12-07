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
@Table(name = "sistemadigestivo")
@NamedQueries({
    @NamedQuery(name = "SistemaDigestivo.findAll", query = "SELECT s FROM SistemaDigestivo s")})
public class SistemaDigestivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSistemaDigestivo")
    private Integer idSistemaDigestivo;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public SistemaDigestivo() {
    }

    public SistemaDigestivo(Integer idSistemaDigestivo) {
        this.idSistemaDigestivo = idSistemaDigestivo;
    }

    public Integer getIdSistemaDigestivo() {
        return idSistemaDigestivo;
    }

    public void setIdSistemaDigestivo(Integer idSistemaDigestivo) {
        this.idSistemaDigestivo = idSistemaDigestivo;
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
        hash += (idSistemaDigestivo != null ? idSistemaDigestivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaDigestivo)) {
            return false;
        }
        SistemaDigestivo other = (SistemaDigestivo) object;
        if ((this.idSistemaDigestivo == null && other.idSistemaDigestivo != null) || (this.idSistemaDigestivo != null && !this.idSistemaDigestivo.equals(other.idSistemaDigestivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.SistemaDigestivo[ idSistemaDigestivo=" + idSistemaDigestivo + " ]";
    }
    
}
