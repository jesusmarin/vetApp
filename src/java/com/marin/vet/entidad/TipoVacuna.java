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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tipovacuna")
@NamedQueries({
    @NamedQuery(name = "TipoVacuna.findAll", query = "SELECT t FROM TipoVacuna t")})
public class TipoVacuna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoVacuna")
    private Integer idTipoVacuna;
    @Size(max = 145)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idEspecie", referencedColumnName = "idEspecie")
    @ManyToOne(fetch = FetchType.LAZY)
    private Especie idEspecie;
    @OneToMany(mappedBy = "idTipoVacuna", fetch = FetchType.LAZY)
    private List<Vacuna> vacunaList;

    public TipoVacuna() {
    }

    public TipoVacuna(Integer idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public Integer getIdTipoVacuna() {
        return idTipoVacuna;
    }

    public void setIdTipoVacuna(Integer idTipoVacuna) {
        this.idTipoVacuna = idTipoVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Especie idEspecie) {
        this.idEspecie = idEspecie;
    }

    public List<Vacuna> getVacunaList() {
        return vacunaList;
    }

    public void setVacunaList(List<Vacuna> vacunaList) {
        this.vacunaList = vacunaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVacuna != null ? idTipoVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVacuna)) {
            return false;
        }
        TipoVacuna other = (TipoVacuna) object;
        if ((this.idTipoVacuna == null && other.idTipoVacuna != null) || (this.idTipoVacuna != null && !this.idTipoVacuna.equals(other.idTipoVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marin.vet.entidad.TipoVacuna[ idTipoVacuna=" + idTipoVacuna + " ]";
    }
    
}
