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
@Table(name = "sistemagenitourinario")
@NamedQueries({
    @NamedQuery(name = "SistemaGenitoUrinario.findAll", query = "SELECT s FROM SistemaGenitoUrinario s")})
public class SistemaGenitoUrinario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSistemaGenitourinario")
    private Integer idSistemaGenitourinario;
    @Column(name = "valor")
    private Integer valor;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idConstantesFisiologicas", referencedColumnName = "idConstantesFisiologicas")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConstantesFisiologicas idConstantesFisiologicas;

    public SistemaGenitoUrinario() {
    }

    public SistemaGenitoUrinario(Integer idSistemaGenitourinario) {
        this.idSistemaGenitourinario = idSistemaGenitourinario;
    }

    public Integer getIdSistemaGenitourinario() {
        return idSistemaGenitourinario;
    }

    public void setIdSistemaGenitourinario(Integer idSistemaGenitourinario) {
        this.idSistemaGenitourinario = idSistemaGenitourinario;
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
        hash += (idSistemaGenitourinario != null ? idSistemaGenitourinario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaGenitoUrinario)) {
            return false;
        }
        SistemaGenitoUrinario other = (SistemaGenitoUrinario) object;
        if ((this.idSistemaGenitourinario == null && other.idSistemaGenitourinario != null) || (this.idSistemaGenitourinario != null && !this.idSistemaGenitourinario.equals(other.idSistemaGenitourinario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.SistemaGenitoUrinario[ idSistemaGenitourinario=" + idSistemaGenitourinario + " ]";
    }
    
}
