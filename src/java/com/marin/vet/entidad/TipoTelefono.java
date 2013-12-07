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
@Table(name = "tipotelefono")
@NamedQueries({
    @NamedQuery(name = "TipoTelefono.findAll", query = "SELECT t FROM TipoTelefono t")})
public class TipoTelefono implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoTelefono")
    private Integer idTipoTelefono;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idTipoTelefono", fetch = FetchType.LAZY)
    private List<Telefono> telefonoList;

    public TipoTelefono() {
    }

    public TipoTelefono(Integer idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public Integer getIdTipoTelefono() {
        return idTipoTelefono;
    }

    public void setIdTipoTelefono(Integer idTipoTelefono) {
        this.idTipoTelefono = idTipoTelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTelefono != null ? idTipoTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTelefono)) {
            return false;
        }
        TipoTelefono other = (TipoTelefono) object;
        if ((this.idTipoTelefono == null && other.idTipoTelefono != null) || (this.idTipoTelefono != null && !this.idTipoTelefono.equals(other.idTipoTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.TipoTelefono[ idTipoTelefono=" + idTipoTelefono + " ]";
    }
    
}
