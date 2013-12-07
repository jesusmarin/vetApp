/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.marin.vet.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author JesusMarin
 */
@Entity
@Table(name = "tipoprocedencia")
@NamedQueries({
    @NamedQuery(name = "TipoProcedencia.findAll", query = "SELECT t FROM TipoProcedencia t")})
public class TipoProcedencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoProcedencia")
    private Integer idTipoProcedencia;
    @Size(max = 145)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idTipoProcedencia", fetch = FetchType.LAZY)
    private List<Mascota> mascotaList;

    public TipoProcedencia() {
    }

    public TipoProcedencia(Integer idTipoProcedencia) {
        this.idTipoProcedencia = idTipoProcedencia;
    }

    public Integer getIdTipoProcedencia() {
        return idTipoProcedencia;
    }

    public void setIdTipoProcedencia(Integer idTipoProcedencia) {
        this.idTipoProcedencia = idTipoProcedencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mascota> getMascotaList() {
        return mascotaList;
    }

    public void setMascotaList(List<Mascota> mascotaList) {
        this.mascotaList = mascotaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProcedencia != null ? idTipoProcedencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProcedencia)) {
            return false;
        }
        TipoProcedencia other = (TipoProcedencia) object;
        if ((this.idTipoProcedencia == null && other.idTipoProcedencia != null) || (this.idTipoProcedencia != null && !this.idTipoProcedencia.equals(other.idTipoProcedencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.TipoProcedencia[ idTipoProcedencia=" + idTipoProcedencia + " ]";
    }
    
}
